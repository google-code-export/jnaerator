/* This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * <p/>
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.  
 */
package com.sun.jna;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * An abstraction for a native function pointer.  An instance of 
 * <code>Function</code> represents a pointer to some native function.  
 * {@link #invoke(Class,Object[],Map)} is the primary means to call
 * the function. 
 *
 * @author Sheng Liang, originator
 * @author Todd Fast, suitability modifications
 * @see Pointer
 */
public class Function extends Pointer {
    /** Any argument which implements this interface will have the
     * {@link #read} method called immediately after function invocation.
     */
    public interface PostCallRead {
        /** Perform any necessary post-call synchronization.  Normally this
         * just means reading from native memory any changes made by
         * the native function call.
         */
        void read();
    }
    
    /** Maximum number of arguments supported by a JNA function call. */
    public static final int MAX_NARGS = 256;

    /** Standard C calling convention. */
    public static final int C_CONVENTION = 0;
    /** First alternate convention (currently used only for w32 stdcall). */
    public static final int ALT_CONVENTION = 1;

    static final Integer INTEGER_TRUE = new Integer(-1);
    static final Integer INTEGER_FALSE = new Integer(0);

    /** 
     * Obtain a <code>Function</code> representing a native 
     * function that follows the standard "C" calling convention.
     * 
     * <p>The allocated instance represents a pointer to the named native 
     * function from the named library, called with the standard "C" calling
     * convention.
     *
     * @param   libraryName
     *                  Library in which to find the native function
     * @param   functionName
     *                  Name of the native function to be linked with
     * @throws {@link UnsatisfiedLinkError} if the library is not found or
     * the given function name is not found within the library.
     */
    public static Function getFunction(String libraryName, String functionName) {
        return NativeLibrary.getInstance(libraryName).getFunction(functionName);
    }
    
    /**
     * Obtain a <code>Function</code> representing a native 
     * function that follows a given calling convention.
     * 
     * <p>The allocated instance represents a pointer to the named native 
     * function from the named library, called with the named calling 
     * convention.
     *
     * @param   libraryName
     *                  Library in which to find the function
     * @param   functionName
     *                  Name of the native function to be linked with
     * @param   callConvention
     *                  Call convention used by the native function
     * @throws {@link UnsatisfiedLinkError} if the library is not found or
     * the given function name is not found within the library.
     */
    public static Function getFunction(String libraryName, String functionName, int callConvention) {
        return NativeLibrary.getInstance(libraryName).getFunction(functionName, callConvention);
    }
    
    // Keep a reference to the NativeLibrary so it does not get garbage collected
    // until the function is
    private NativeLibrary library;
    private String functionName;
    private int callingConvention;

    /** For internal JNA use. */
    static final String OPTION_INVOKING_METHOD = "invoking-method";

    /**
     * Create a new <code>Function</code> that is linked with a native 
     * function that follows the given calling convention.
     * 
     * <p>The allocated instance represents a pointer to the named native 
     * function from the supplied library, called with the given calling 
     * convention.
     *
     * @param  library
     *                 {@link NativeLibrary} in which to find the function
     * @param  functionName
     *                 Name of the native function to be linked with
     * @param  callingConvention
     *                 Calling convention used by the native function
     * @throws {@link UnsatisfiedLinkError} if the given function name is
     * not found within the library.
     */
    Function(NativeLibrary library, String functionName, int callingConvention) {
        checkCallingConvention(callingConvention);
        if (functionName == null)
            throw new NullPointerException("Function name must not be null");
        this.library = library;
        this.functionName = functionName;
        this.callingConvention = callingConvention;
        try {
            this.peer = library.getSymbolAddress(functionName);
        }
        catch(UnsatisfiedLinkError e) {
            throw new UnsatisfiedLinkError("Error looking up function '" 
                                           + functionName + "': " 
                                           + e.getMessage());
        }
    }
    
    /**
     * Create a new <code>Function</code> that is linked with a native 
     * function that follows the given calling convention.
     * 
     * <p>The allocated instance represents a pointer to the given 
     * function address, called with the given calling 
     * convention.
     *
     * @param  functionAddress
     *                 Address of the native function 
     * @param  callingConvention
     *                 Calling convention used by the native function
     */
    Function(Pointer functionAddress, int callingConvention) {
        checkCallingConvention(callingConvention);
        if (functionAddress == null
            || functionAddress.peer == 0) {
            throw new NullPointerException("Function address may not be null");
        }
        this.functionName = functionAddress.toString();
        this.callingConvention = callingConvention;
        this.peer = functionAddress.peer;
    }
    
    private void checkCallingConvention(int convention)
        throws IllegalArgumentException {
        switch(convention) {
        case C_CONVENTION:
        case ALT_CONVENTION:
            break;
        default:
            throw new IllegalArgumentException("Unrecognized calling convention: " 
                                               + convention);
        }
    }

    public String getName() {
        return functionName;
    }


    public int getCallingConvention() {
        return callingConvention;
    }

    /** Invoke the native function with the given arguments, returning the
     * native result as an Object.
     */
    public Object invoke(Class returnType, Object[] inArgs) {
        return invoke(returnType, inArgs, Collections.EMPTY_MAP);
    }    
    
    /** Invoke the native function with the given arguments, returning the
     * native result as an Object.
     */
    public Object invoke(Class returnType, Object[] inArgs, Map options) {
        // Clone the argument array to obtain a scratch space for modified
        // types/values
        Object[] args = { };
        if (inArgs != null) {
            if (inArgs.length > MAX_NARGS) {
                throw new UnsupportedOperationException("Maximum argument count is " + MAX_NARGS);
            }
            args = new Object[inArgs.length];
            System.arraycopy(inArgs, 0, args, 0, args.length);
        }

        TypeMapper mapper = 
            (TypeMapper)options.get(Library.OPTION_TYPE_MAPPER);
        Method invokingMethod = (Method)options.get(OPTION_INVOKING_METHOD);
        for (int i=0; i < args.length; i++) {
            args[i] = convertArgument(args, i, invokingMethod, mapper);
        }
        
        Class nativeType = returnType;
        FromNativeConverter resultConverter = null;
        if (NativeMapped.class.isAssignableFrom(returnType)) {
            NativeMappedConverter tc = NativeMappedConverter.getInstance(returnType);
            resultConverter = tc;
            nativeType = tc.nativeType();
        }
        else if (mapper != null) {
            resultConverter = mapper.getFromNativeConverter(returnType);
            if (resultConverter != null) {
                nativeType = resultConverter.nativeType();
            }
        }

        Object result = invoke(args, nativeType);

        // Convert the result to a custom value/type if appropriate
        if (resultConverter != null) {
            FromNativeContext context;
            
            if (invokingMethod != null) {
                context = new MethodResultContext(returnType, this, inArgs, invokingMethod);
            } else {
                context = new FunctionResultContext(returnType, this, inArgs);
            }
            result = resultConverter.fromNative(result, context);
        }

        // Sync all memory which might have been modified by the native call
        if (inArgs != null) {
            for (int i=0; i < inArgs.length; i++) {
                Object inArg = inArgs[i];
                if (inArg == null)
                    continue;
                if (inArg instanceof Structure) {
                    if (!(inArg instanceof Structure.ByValue)) {
                        if (((Structure)inArg).getAutoRead()) {
                            ((Structure)inArg).read();
                        }
                    }
                }
                else if (args[i] instanceof PostCallRead) {
                    ((PostCallRead)args[i]).read();
                    if (args[i] instanceof PointerArray) {
                        PointerArray array = (PointerArray)args[i];
                        if (Structure.ByReference[].class.isAssignableFrom(inArg.getClass())) {
                            Class type = inArg.getClass().getComponentType();
                            Structure[] ss = (Structure[])inArg;
                            for (int si=0;si < ss.length;si++) {
                                Pointer p = array.getPointer(Pointer.SIZE * si);
                                ss[si] = Structure.updateStructureByReference(type, ss[si], p);
                            }
                        }
                    }
                }
                else if (Structure[].class.isAssignableFrom(inArg.getClass())) {
                    Structure[] ss = (Structure[])inArg;
                    for (int si=0;si < ss.length;si++) {
                        if (ss[si].getAutoRead()) {
                            ss[si].read();
                        }
                    }
                }
            }
        }
                        
        return result;
    }

    /** @see NativeLibrary#NativeLibrary(String,String,long) implementation */
    Object invoke(Object[] args, Class returnType) {
        Object result = null;
        if (returnType == null || returnType==void.class || returnType==Void.class) {
            invokeVoid(callingConvention, args);
            result = null;
        }
        else if (returnType==boolean.class || returnType==Boolean.class) {
            result = valueOf(invokeInt(callingConvention, args) != 0);
        }
        else if (returnType==byte.class || returnType==Byte.class) {
            result = new Byte((byte)invokeInt(callingConvention, args));
        }
        else if (returnType==short.class || returnType==Short.class) {
            result = new Short((short)invokeInt(callingConvention, args));
        }
        else if (returnType==char.class || returnType==Character.class) {
            result = new Character((char)invokeInt(callingConvention, args));
        }
        else if (returnType==int.class || returnType==Integer.class) {
            result = new Integer(invokeInt(callingConvention, args));
        }
        else if (returnType==long.class || returnType==Long.class) {
            result = new Long(invokeLong(callingConvention, args));
        }
        else if (returnType==float.class || returnType==Float.class) {
            result = new Float(invokeFloat(callingConvention, args));
        }
        else if (returnType==double.class || returnType==Double.class) {
            result = new Double(invokeDouble(callingConvention, args));
        }
        else if (returnType==String.class) {
            result = invokeString(callingConvention, args, false);
        }
        else if (returnType==WString.class) {
            String s = invokeString(callingConvention, args, true);
            if (s != null) {
                result = new WString(s);
            }
        }
        else if (Pointer.class.isAssignableFrom(returnType)) {
            result = invokePointer(callingConvention, args);
		  if (!Pointer.class.equals(returnType)) {
			  try {
				  result = returnType.getConstructor(new Class[] {Pointer.class}).newInstance(new Object[] {result});
			  } catch (Exception ex) {
				  throw new RuntimeException("Failed to instantiate pointer of type " + returnType.getName() + ". It must have a public constructor with a " + Pointer.class.getName() + " argument.", ex);
			  }
		  }
        }
        else if (Structure.class.isAssignableFrom(returnType)) {
            if (Structure.ByValue.class.isAssignableFrom(returnType)) {
                Structure s = 
                    invokeStructure(callingConvention, args, 
                                    Structure.newInstance(returnType));
                if (s.getAutoRead()) {
                    s.read();
                }
                result = s;
            }
            else {
                result = invokePointer(callingConvention, args);
                if (result != null) {
                    Structure s = Structure.newInstance(returnType);
                    s.useMemory((Pointer)result);
                    if (s.getAutoRead()) {
                        s.read();
                    }
                    result = s;
                }
            }
        }
        else if (Callback.class.isAssignableFrom(returnType)) {
            result = invokePointer(callingConvention, args);
            if (result != null) {
                result = CallbackReference.getCallback(returnType, (Pointer)result);
            }
        }
        else if (returnType==String[].class) {
            Pointer p = invokePointer(callingConvention, args);
            if (p != null) {
                result = p.getStringArray(0);
            }
        }
        else if (returnType==WString[].class) {
            Pointer p = invokePointer(callingConvention, args);
            if (p != null) {
                String[] arr = p.getStringArray(0, true);
                WString[] warr = new WString[arr.length];
                for (int i=0;i < arr.length;i++) {
                    warr[i] = new WString(arr[i]);
                }
                result = warr;
            }
        }
        else if (returnType==Pointer[].class) {
            Pointer p = invokePointer(callingConvention, args);
            if (p != null) {
                result = p.getPointerArray(0);
            }
        }
        else {
            throw new IllegalArgumentException("Unsupported return type "
                                               + returnType
                                               + " in function " + getName());
        }
        return result;
    }
    
    private Object convertArgument(Object[] args, int index, Method invokingMethod, TypeMapper mapper) { 
        Object arg = args[index];
        if (arg != null) {
            Class type = arg.getClass();
            ToNativeConverter converter = null;
            if (NativeMapped.class.isAssignableFrom(type)) {
                converter = NativeMappedConverter.getInstance(type);
            }
            else if (mapper != null) {
                converter = mapper.getToNativeConverter(type);
            }
            if (converter != null) {
                ToNativeContext context;
                if (invokingMethod != null) {
                    context = new MethodParameterContext(this, args, index, invokingMethod) ;
                }
                else {
                    context = new FunctionParameterContext(this, args, index);
                }
                arg = converter.toNative(arg, context);
            }
        }
        if (arg == null || isPrimitiveArray(arg.getClass())) { 
            return arg;
        }
        Class argClass = arg.getClass();
        // Convert Structures to native pointers 
        if (arg instanceof Structure) {
            Structure struct = (Structure)arg;
            if (struct.getAutoWrite()) {
                struct.write();
            }
            if (struct instanceof Structure.ByValue) {
            	// Double-check against the method signature, if available
                Class ptype = struct.getClass();
            	if (invokingMethod != null) {
                    Class[] ptypes = invokingMethod.getParameterTypes();
                    if (isVarArgs(invokingMethod)) {
                        if (index < ptypes.length-1) {
                            ptype = ptypes[index];
                        }
                        else {
                            Class etype = ptypes[ptypes.length-1].getComponentType();
                            if (etype != Object.class) {
                                ptype = etype;
                            }
                        }
                    }
                    else {
                        ptype = ptypes[index];
                    }
                }
                if (Structure.ByValue.class.isAssignableFrom(ptype)) {
                    return struct;
                }
            }
            return struct.getPointer();
        }
        // Convert Callback to Pointer
        else if (arg instanceof Callback) {
            return CallbackReference.getFunctionPointer((Callback)arg);
        }
        // String arguments are converted to native pointers here rather
        // than in native code so that the values will be valid until
        // this method returns.  
        // Convert String to native pointer (const)
        else if (arg instanceof String) {
            return new NativeString((String)arg, false).getPointer();
        }
        // Convert WString to native pointer (const)
        else if (arg instanceof WString) {
            return new NativeString(arg.toString(), true).getPointer();
        }
        // Default conversion of boolean to int; if you want something
        // different, use a ToNativeConverter
        else if (arg instanceof Boolean) {
            return Boolean.TRUE.equals(arg) ? INTEGER_TRUE : INTEGER_FALSE;
        }
        else if (String[].class == argClass) {
            return new StringArray((String[])arg);
        }
        else if (WString[].class == argClass) {
            return new StringArray((WString[])arg);
        }
        else if (Pointer[].class == argClass) {
            return new PointerArray((Pointer[])arg);
        }
        else if (Structure[].class.isAssignableFrom(argClass)) {
            Structure[] ss = (Structure[])arg;
            Class type = argClass.getComponentType();
            boolean byRef = Structure.ByReference.class.isAssignableFrom(type);
            if (byRef) {
                Pointer[] pointers = new Pointer[ss.length + 1];
                for (int i=0;i < ss.length;i++) {
                	pointers[i] = ss[i] != null ? ss[i].getPointer() : null;
                }
                return new PointerArray(pointers);
            }
            else if (ss.length == 0) {
                throw new IllegalArgumentException("Structure array must have non-zero length");
            }
            else if (ss[0] == null) {
                // Initialize uninitialized arrays of Structure to point
                // to a single block of memory
                Structure struct = Structure.newInstance(type);
                int size = struct.size();
                Memory m = new Memory(size * ss.length);
                struct.useMemory(m);
                Structure[] tmp = struct.toArray(ss.length);
                for (int si=0;si < ss.length;si++) {
                    ss[si] = tmp[si];
                }
                return ss[0].getPointer();
            }
            else {
                Pointer base = ss[0].getPointer();
                int size = ss[0].size();
                if (ss[0].getAutoWrite()) {
                    ss[0].write();
                }
                for (int si=1;si < ss.length;si++) {
                    if (ss[si].getPointer().peer != base.peer + size*si) {
                        String msg = "Structure array elements must use"
                            + " contiguous memory (at element index " + si + ")";     
                        throw new IllegalArgumentException(msg);
                    }
                    if (ss[si].getAutoWrite()) {
                        ss[si].write();
                    }
                }
                return base;
            }
        }
        else if (argClass.isArray()){
            throw new IllegalArgumentException("Unsupported array argument type: " 
                                               + argClass.getComponentType());
        }
        if (arg != null && !Native.isSupportedNativeType(arg.getClass())) {
            throw new IllegalArgumentException("Unsupported argument type "
                                               + arg.getClass().getName()
                                               + " at parameter " + index
                                               + " of function " + getName());
        }
        return arg;
    }

    private boolean isPrimitiveArray(Class argClass) {
        return argClass.isArray() 
            && argClass.getComponentType().isPrimitive();
    }
    
    /**
     * Call the native function being represented by this object
     *
     * @param   callingConvention calling convention to be used
     * @param	args
     *			Arguments to pass to the native function
     * @return	The value returned by the target native function
     */
    native int invokeInt(int callingConvention, Object[] args);

    /**
     * Call the native function being represented by this object
     *
     * @param   callingConvention calling convention to be used
     * @param	args
     *			Arguments to pass to the native function
     * @return	The value returned by the target native function
     */
    native long invokeLong(int callingConvention, Object[] args);

    /**
     * Call the native function being represented by this object
     *
     * @param	args
     *			Arguments to pass to the native function
     */
    public void invoke(Object[] args) {
        invoke(Void.class, args);
    }


    /**
     * Call the native function being represented by this object
     *
     * @param   callingConvention calling convention to be used
     * @param	args
     *			Arguments to pass to the native function
     */
    native void invokeVoid(int callingConvention, Object[] args);

    /**
     * Call the native function being represented by this object
     *
     * @param   callingConvention calling convention to be used
     * @param	args
     *			Arguments to pass to the native function
     * @return	The value returned by the target native function
     */
    native float invokeFloat(int callingConvention, Object[] args);

    /**
     * Call the native function being represented by this object
     *
     * @param   callingConvention calling convention to be used
     * @param	args
     *			Arguments to pass to the native function
     * @return	The value returned by the target native function
     */
    native double invokeDouble(int callingConvention, Object[] args);

    /**
     * Call the native function being represented by this object
     *
     * @param   callingConvention calling convention to be used
     * @param	args
     *			Arguments to pass to the native function
     * @param   wide whether the native string uses <code>wchar_t</code>;
     * if false, <code>char</code> is assumed
     * @return	The value returned by the target native function, as a String
     */
    String invokeString(int callingConvention, Object[] args, boolean wide) {
        Pointer ptr = invokePointer(callingConvention, args);
        String s = null;
        if (ptr != null) {
            if (wide)
                s = ptr.getString(0, wide);
            else
                s = ptr.getString(0);
        }
        return s;
    }

    /**
     * Call the native function being represented by this object
     *
     * @param   callingConvention calling convention to be used
     * @param	args
     *			Arguments to pass to the native function
     * @return	The native pointer returned by the target native function
     */
    native Pointer invokePointer(int callingConvention, Object[] args);
    
    /**
     * Call the native function being represented by this object
     *
     * @param   callingConvention calling convention to be used
     * @param   args
     *          Arguments to pass to the native function
     * @param   result Pre-allocated structure to hold the result
     * @return  The passed-in struct argument
     */
    native Structure invokeStructure(int callingConvention, Object[] args,
                                             Structure result);

    /** Provide a human-readable representation of this object. */
    public String toString() {
        if (library != null) {
            return "native function " + functionName + "(" + library.getName()
                + ")@0x" + Long.toHexString(peer);
        }
        return "native function@0x" + Long.toHexString(peer);
    }

    /** Convenience method for 
     * {@link #invoke(Class,Object[]) invoke(Pointer.class, args)}.
     */
    public Pointer invokePointer(Object[] args) {
        return (Pointer)invoke(Pointer.class, args);
    }
    
    /** Convenience method for
     * {@link #invoke(Class,Object[]) invoke(String.class, args)}
     * or {@link #invoke(Class,Object[]) invoke(WString.class, args)}
     * @param args Arguments passed to native function
     * @param wide Whether the return value is of type <code>wchar_t*</code>;
     * if false, the return value is of type <code>char*</code>.
     */
    public String invokeString(Object[] args, boolean wide) {
        Object o = invoke(wide ? WString.class : String.class, args);
        return o != null ? o.toString() : null;
    }

    /** Convenience method for 
     * {@link #invoke(Class,Object[]) invoke(Integer.class, args)}.
     */
    public int invokeInt(Object[] args) {
        return ((Integer)invoke(Integer.class, args)).intValue();
    }
    /** Convenience method for 
     * {@link #invoke(Class,Object[]) invoke(Long.class, args)}.
     */
    public long invokeLong(Object[] args) {
        return ((Long)invoke(Long.class, args)).longValue();
    }
    /** Convenience method for 
     * {@link #invoke(Class,Object[]) invoke(Float.class, args)}.
     */
    public float invokeFloat(Object[] args) {
        return ((Float)invoke(Float.class, args)).floatValue();
    }
    /** Convenience method for 
     * {@link #invoke(Class,Object[]) invoke(Double.class, args)}.
     */
    public double invokeDouble(Object[] args) {
        return ((Double)invoke(Double.class, args)).doubleValue();
    }
    /** Convenience method for 
     * {@link #invoke(Class,Object[]) invoke(Void.class, args)}.
     */
    public void invokeVoid(Object[] args) {
        invoke(Void.class, args);
    }
    
    /** Two function pointers are equal if they share the same peer address
     * and calling convention.
     */
    public boolean equals(Object o) {
        if (o instanceof Function) {
            Function other = (Function)o;
            return other.callingConvention == this.callingConvention
                && other.peer == this.peer;
        }
        return false;
    }

    /** Concatenate varargs with normal args to obtain a simple argument 
     * array. 
     */
    static Object[] concatenateVarArgs(Object[] inArgs) {
        // If the final argument is an array of something other than
        // primitives, Structure, or String, treat it as varargs and 
        // concatenate the previous arguments with the varargs elements.
        if (inArgs != null && inArgs.length > 0) {
            Object lastArg = inArgs[inArgs.length-1];
            Class argType = lastArg != null ? lastArg.getClass() : null;
            if (argType != null && argType.isArray()) {
                Object[] varArgs = (Object[])lastArg;
                Object[] fullArgs = new Object[inArgs.length+varArgs.length];
                System.arraycopy(inArgs, 0, fullArgs, 0, inArgs.length-1);
                System.arraycopy(varArgs, 0, fullArgs, inArgs.length-1, varArgs.length);
                // For convenience, always append a NULL argument to the end
                // of varargs, whether the called API requires it or not. If
                // it is not needed, it will be ignored, but if it *is* 
                // required, it avoids forcing the Java client to always
                // explicitly add it.
                fullArgs[fullArgs.length-1] = null;
                inArgs = fullArgs;
            }
        }
        return inArgs;
    }

    /** Varargs are only supported on 1.5+. */
    static boolean isVarArgs(Method m) {
        try {
            Method v = m.getClass().getMethod("isVarArgs", new Class[0]);
            return Boolean.TRUE.equals(v.invoke(m, new Object[0]));
        }
        catch (SecurityException e) {
        }
        catch (NoSuchMethodException e) {
        }
        catch (IllegalArgumentException e) {
        }
        catch (IllegalAccessException e) {
        }
        catch (InvocationTargetException e) {
        }
        return false;
    }
    
    private static class PointerArray extends Memory implements PostCallRead {
        private Pointer[] original;
        public PointerArray(Pointer[] arg) {
            super(Pointer.SIZE * (arg.length+1));
            this.original = arg;
            for (int i=0;i < arg.length;i++) {
                setPointer(i*Pointer.SIZE, arg[i]);
            }
            setPointer(Pointer.SIZE*arg.length, null);
        }
        public void read() {
            for (int i=0;i < original.length;i++) {
                original[i] = getPointer(i * Pointer.SIZE);
            }
        }
    }
    
    /** Implementation of Boolean.valueOf for older VMs. */
    static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
}

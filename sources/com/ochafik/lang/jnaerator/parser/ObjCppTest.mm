#	
#	Copyright (c) 2009 Olivier Chafik, All Rights Reserved
#	
#	This file is part of JNAerator (http://jnaerator.googlecode.com/).
#	
#	JNAerator is free software: you can redistribute it and/or modify
#	it under the terms of the GNU General Public License as published by
#	the Free Software Foundation, either version 3 of the License, or
#	(at your option) any later version.
#	
#	JNAerator is distributed in the hope that it will be useful,
#	but WITHOUT ANY WARRANTY; without even the implied warranty of
#	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#	GNU General Public License for more details.
#	
#	You should have received a copy of the GNU General Public License
#	along with JNAerator.  If not, see <http://www.gnu.org/licenses/>.
#	
#pragma reversible
--
void f(void (*g)());
--
int val = (1 << 16) - 2;
--
typedef void *__ptr64 PVOID64;
--
typedef CHAR *PCHAR, *LPCH, *PCH;
typedef CONST CHAR *LPCCH, *PCCH;
--
long value = (int)(__u.__u >> 31);
--
void f(struct s i);
--
extern long long int i;
--
extern long int llrint(double);
--
extern long long int llrint(double);
--
typedef int I; 
I register i; 
--
int register unsigned g;
--
/**
 * Need to see public final ByteByReference[] data = new ByteByReference[3]; in results<br>
 * https://jna.dev.java.net/servlets/ReadMsg?list=users&msgNo=2335
 */
typedef struct {
	int width;
	int height;
	int rowBytes;
	int columnBytes;
	unsigned char *data[3];
} ImageTransfer;
--
string name = "ok";
--
extern void **const GC_objfreelist_ptr;
--
typedef struct _NSSize {
	CGFloat width; /* width should never be negative */
	CGFloat height; /* height should never be negative */
} NSSize;
--
/// Struct comment
struct ParamBlockRec {
	int ok; // comment after ok
};
--
/// these are comments...
void *CreateHandle(int size);
--
void **ResizeHandle(void** h, int size);
--
BOOL (*isEqual)(NSMapTable* table, const void*, const void*);
--
const void *x;
--
extern volatile GC_thread GC_threads[THREAD_TABLE_SZ];
--
extern GC_bool GC_thr_initialized;
--
void const *x;
--
int *const a = (int*)10;
--
int *const *aa = (int**)10;
--
const void const *x;
--
const void x[];
--
const void const *&*x[];
--
#// Only comments here !
--
char *(*(**foo[][8])())[];
--
typedef struct {
	unsigned char *data[3];
} S;
--
int x[4];
--
bool (*)(const void* buffer, unsigned int length) x;
--
unsigned short x, *px, **ppx, **&rppx = a, *pa[4];
--
pair<int, map<long*, string> > x;
--
pair<int, map<long*, string>*> x;
--
enum {
	rAliasType = 'alis' /* Aliases are stored as resources of this type */
};
--
@class NSAppleEventDescriptor;
--
typedef const struct __NSAppleEventManagerSuspension *NSAppleEventManagerSuspensionID;
--
extern const double NSAppleEventTimeOutNone;
--
extern NSString *NSAppleEventManagerWillProcessFirstEventNotification;
--
int i = 10;
--
int i = [NSObject createWithTest:"ok" encoding:[NSEncoding ascii] length:10];
--
# see http://tigcc.ticalc.org/doc/keywords.html
typedef unsigned char byte;
--
typedef char str40[41];
--
union short_or_long_NOVAR {
	short i;
	long l2;
};
--
union short_or_long {
	short i;
	long l;
} a_number, *p_anumber = NULL;
--
/// Test of comments before
union ParamBlockRec {
	IOParam ioParam;
	FileParam fileParam;
	VolumeParam volumeParam;
	CntrlParam cntrlParam;
	SlotDevParam slotDevParam;
	MultiDevParam multiDevParam;
};
--
typedef SInt32 (__cdecl *AVLCompareItemsProcPtr)(AVLTreePtr tree, const void* i1, const void* i2, AVLNodeType nd_typ);
--
typedef struct {
	float *re;
	float im[4];
} complex;
--
typedef char *byteptr;
--
typedef int (*fncptr)(int);
--
extern volatile GC_thread GC_threads[];
--
#pragma parse

struct Test {__
	int i, j, k;
};
--
typedef __success(return >= 0) long HRESULT;
--
static __inline__  int __inline_signbit( long double __x ){ 
	union {
		long double __ld;
		struct { 
			unsigned long long __m;
			short __sexp;
		} __p;
	} __u = {__x}; 
	return (int) ((unsigned int) __u.__p.__sexp >> 15);
}
--
static __inline__  int __inline_isnormalf( float __x ) {
	float fabsf = __builtin_fabsf(__x); 
	if( __x != __x ) 
		return 0; 
	return fabsf < __builtin_inff() && fabsf >= __FLT_MIN__;
}
--
@interface NSLock : NSObject <NSLocking> {
@private
    void *_priv;
}

- (BOOL)tryLock;
- (BOOL)lockBeforeDate:(NSDate *)limit;

//- (void)setName:(NSString *)n ;
- (void)setName:(NSString *)n;
//- (NSString *)name ;
- (NSString *)name;

@end
--
typedef struct {
    NSUInteger	(*hash)(NSMapTable *table, const void *);
    BOOL	(*isEqual)(NSMapTable *table, const void *, const void *);
    void	(*retain)(NSMapTable *table, const void *);
    void	(*release)(NSMapTable *table, void *);
    NSString 	*(*describe)(NSMapTable *table, const void *);
    const void	*notAKeyMarker;
} NSMapTableKeyCallBacks;
--
@interface NSObject <NSObject> {
    Class	isa;
}

+ (void)load;

+ (void)initialize;
- (id)init;

+ (id)new;
+ (id)allocWithZone:(NSZone *)zone;
+ (id)alloc;
- (void)dealloc;

- (void)finalize ;

- (id)copy;
- (id)mutableCopy;

+ (id)copyWithZone:(NSZone *)zone;
+ (id)mutableCopyWithZone:(NSZone *)zone;

+ (Class)superclass;
+ (Class)class;
+ (BOOL)instancesRespondToSelector:(SEL)aSelector;
+ (BOOL)conformsToProtocol:(Protocol *)protocol;
- (IMP)methodForSelector:(SEL)aSelector;
+ (IMP)instanceMethodForSelector:(SEL)aSelector;
- (void)doesNotRecognizeSelector:(SEL)aSelector;

- (id)forwardingTargetForSelector:(SEL)aSelector;
- (void)forwardInvocation:(NSInvocation *)anInvocation;
- (NSMethodSignature *)methodSignatureForSelector:(SEL)aSelector;

+ (NSMethodSignature *)instanceMethodSignatureForSelector:(SEL)aSelector;

+ (NSString *)description;

+ (BOOL)isSubclassOfClass:(Class)aClass ;

+ (BOOL)resolveClassMethod:(SEL)sel ;
+ (BOOL)resolveInstanceMethod:(SEL)sel ;

@end
--
@interface NSObject (NSCoderMethods)

+ (NSInteger)version;
+ (void)setVersion:(NSInteger)aVersion;
- (Class)classForCoder;
- (id)replacementObjectForCoder:(NSCoder *)aCoder;
- (id)awakeAfterUsingCoder:(NSCoder *)aDecoder;

@end

--
extern TestMe();
--

#pragma fail
int[4] x;
--
bool (*test)(const void *buffer, unsigned int length) x;

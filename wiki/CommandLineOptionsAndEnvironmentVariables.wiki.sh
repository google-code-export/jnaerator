#!/bin/sh

OUTFILE=CommandLineOptionsAndEnvironmentVariables.wiki

rm $OUTFILE

echo "#summary JNAerator's command-line options & environment variables\n#sidebar sidebar

= Syntax =

{{{ java -jar jnaerator.jar options headerFiles dynamicLibrariesFiles }}}

= Options =
" >>$OUTFILE

echo "`java -jar ../trunk/bin/jnaerator.jar -wikiHelp`" >>$OUTFILE

echo '
= Environment Variables =

All of these variables may be overridden by setting the environment variable ({{{ set VAR=value }}} on Windows, {{{ export VAR=value }}} on most unices) or through Java properties ({{{ java -DVAR=value -jar jnaerator.jar ... }}}).

 * VISUAL_STUDIO_HOME = 
   {{{ 
C:\\Program Files\\Microsoft Visual Studio 9.0 
   }}}
 * WINDOWS_SDK_HOME
   {{{ 
C:\\Program Files\\Microsoft SDKs\\Windows\\v6.0A
   }}}
 * VISUAL_STUDIO_INCLUDES = VISUAL_STUDIO_HOME;WINDOWS_SDK_HOME
 * JNAERATOR_INCLUDE_PATH : has the following platform-dependent default values :
   * Windows : uses VISUAL_STUDIO_INCLUDES
   * Mac OS X : {{{ /Developer/SDKs/MacOSX10.4u.sdk/usr/include:. }}}
   * Current dir on any other platform

 * JNAERATOR_FRAMEWORKS_PATH is only set on Mac OS X : 
   {{{
/System/Library/Frameworks/CoreServices.framework/Versions/Current/Frameworks:\\
/System/Library/Frameworks/ApplicationServices.framework/Versions/Current/Frameworks:\\
/System/Library/Frameworks:\\
/Library/Frameworks:\\
~/Library/Frameworks 
   }}}
' >>$OUTFILE
@echo off
setlocal enabledelayedexpansion

rem TO LAUNCH FROM THE trunk DIRECTORY
set JNA_JAR=libraries\jna\dist\jna.jar
set ANARRES_JAR=libraries\anarres\build\tar\lib\anarres-cpp.jar

set BUILD_CP=sources;%ANARRES_JAR%;%JNA_JAR%

for %%F in (libraries\*.jar %ANARRES_JAR% %JNA_JAR%) do (
	set BUILD_CP=!BUILD_CP!;%%F
)

REM set BUILD_CP=%ANTLR_JAR%;%ANARRES_JAR%;%JNA_JAR%;%ROCOCOA_JAR%;%JUNIT_JAR%;sources

del /S /Q classes >NUL 2>NUL
mkdir classes >NUL 2>NUL

javac -target 1.5 -cp %BUILD_CP% -d classes sources\com\ochafik\lang\jnaerator\runtime\JNAeratorRuntime.java
javac -target 1.6 -cp classes;%BUILD_CP% -d classes sources\com\ochafik\lang\jnaerator\JNAerator.java

pushd classes
for %%F in (..\libraries\*.jar ..\%ANARRES_JAR% ..\%JNA_JAR%) do (
	echo Extracting %%~nF
	jar -xf %%F
)
mkdir com\ochafik\lang\jnaerator\tests
copy ..\sources\com\ochafik\lang\jnaerator\tests\*.test com\ochafik\lang\jnaerator\tests
copy ..\sources\com\ochafik\lang\jnaerator\parser\*.mm com\ochafik\lang\jnaerator\parser
copy ..\bin\VERSION.jnaerator VERSION

echo Main-Class: com.ochafik.lang.jnaerator.JNAerator> jnaerator.mf
jar cfm ..\bin\jnaerator.jar jnaerator.mf .
copy ..\bin\jnaerator.jar ..\jnaerator.zip

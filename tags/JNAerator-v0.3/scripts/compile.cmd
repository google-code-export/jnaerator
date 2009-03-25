rem TO LAUNCH FROM THE trunk DIRECTORY

mkdir classes 2>NUL

javac -target 1.5 -cp libraries\anarres-cpp.jar;libraries\antlr-runtime-3.1.jar;libraries\jna.jar;libraries\junit-4.4.jar;sources -d classes sources\com\ochafik\lang\jnaerator\JNAerator.java

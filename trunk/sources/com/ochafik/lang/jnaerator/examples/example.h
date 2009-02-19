/// This example file 

extern "C" {

enum TestEnum {
	First, // first comments
	Second,  // comments on second
	Last // not a real value
};

typedef int (__cdecl *RandIntFunc)(void);

struct TestStruct {
	TestEnum	 enumValue;
	char		 charValue;
	short	 shortValue;
	wchar_t	 wcharValue;	
	int		 intValue;
	bool		 boolValue;
	long		 longValue;
	size_t	 sizeValue;
	long long	 longLongValue;
	float	 floatValue;
	double	 doubleValue;
	char*	 cstringValue;
	char		 charArrayValue[255];
	void*	 voidPointerValue;
	int		 (*functionValue)(TestEnum e);
	
	struct { int first, second; } structValue;
	TestStruct *structPointerValue;
};

void Test(const char* name, TestStruct& values, RandIntFunc func);

}

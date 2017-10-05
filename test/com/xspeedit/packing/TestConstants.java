package com.xspeedit.packing;

public interface TestConstants {
	
	static final int BOX_CAPACITY = 10;
	static final String INPUTCHAIN_TEST_1 = "163841689525773";
	
	static final String INPUTCHAIN_TEST_2 = "234";
	static final String EXPECTED_OUTPUT_TEST_2 = "432";
	static final int NUMBER_OF_BOXES_TEST_2 = 1;
	
	static final String INPUTCHAIN_TEST_3 = "8888";
	static final String EXPECTED_OUTPUT_TEST_3 = "8/8/8/8";
	static final int NUMBER_OF_BOXES_TEST_3 = 4;
	
	static final String INPUTCHAIN_TEST_4 = "1234";
	static final String EXPECTED_OUTPUT_TEST_4 = "4321";
	static final int NUMBER_OF_BOXES_TEST_4 = 1;
	
	static final String INPUTCHAIN_TEST_5 = "9";
	static final String EXPECTED_OUTPUT_TEST_5 = "9";
	static final int NUMBER_OF_BOXES_TEST_5 = 1;
	
	static final String INPUTCHAIN_TEST_6 = "111111111111111";
	static final String EXPECTED_OUTPUT_TEST_6 = "1111111111/11111";
	static final int NUMBER_OF_BOXES_TEST_6 = 2;

}

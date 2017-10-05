package com.xspeedit.packing;

import java.util.logging.Logger;

import org.junit.Test;

import com.xspeedit.packing.types.InputChain;
import com.xspeedit.packing.types.OutputChain;
import com.xspeedit.packing.types.OutputChain.Box;

import junit.framework.*;

public class PackingOptimizerTest extends TestCase implements TestConstants{
	
	private static final Logger myLogger = Logger.getLogger(PackingOptimizerTest.class.getName());
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		System.out.println("\n\n***** New Test *****");
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void test1NominalCase () throws Exception{
		myLogger.info("Test input chain: " + INPUTCHAIN_TEST_1);
		InputChain anInputChain = new InputChain(INPUTCHAIN_TEST_1);
		OutputChain anOutput = PackingOptimizer.packInputChain(anInputChain, BOX_CAPACITY);
		myLogger.info("The output chain:" + anOutput.toString());
		assertTrue(isMaxBoxCapacityRespected(anOutput, BOX_CAPACITY));
		assertTrue(areInputAndOutputSizeEquals(INPUTCHAIN_TEST_1, anOutput.toString()));
	}
	
	@Test
	public void test2SizeOfInputSmallerThanCapacity () throws Exception{
		myLogger.info("Test input chain: " + INPUTCHAIN_TEST_2);
		InputChain anInputChain = new InputChain(INPUTCHAIN_TEST_2);
		OutputChain anOutput = PackingOptimizer.packInputChain(anInputChain, BOX_CAPACITY);
		myLogger.info("The output chain:" + anOutput.toString());
		assertTrue(isMaxBoxCapacityRespected(anOutput, BOX_CAPACITY));
		assertTrue(areInputAndOutputSizeEquals(INPUTCHAIN_TEST_2, anOutput.toString()));
		assertEquals(NUMBER_OF_BOXES_TEST_2, anOutput.getBoxes().size());
		assertEquals(EXPECTED_OUTPUT_TEST_2, anOutput.toString());
	}
	
	@Test
	public void test3OneObjectByBox () throws Exception{
		myLogger.info("Test input chain: " + INPUTCHAIN_TEST_3);
		InputChain anInputChain = new InputChain(INPUTCHAIN_TEST_3);
		OutputChain anOutput = PackingOptimizer.packInputChain(anInputChain, BOX_CAPACITY);
		myLogger.info("The output chain:" + anOutput.toString());
		assertTrue(isMaxBoxCapacityRespected(anOutput, BOX_CAPACITY));
		assertTrue(areInputAndOutputSizeEquals(INPUTCHAIN_TEST_3, anOutput.toString()));
		assertEquals(NUMBER_OF_BOXES_TEST_3, anOutput.getBoxes().size());
		assertEquals(EXPECTED_OUTPUT_TEST_3, anOutput.toString());
	}
	
	@Test
	public void test4SizeOfInputEqualToCapacity () throws Exception{
		myLogger.info("Test input chain: " + INPUTCHAIN_TEST_4);
		InputChain anInputChain = new InputChain(INPUTCHAIN_TEST_4);
		OutputChain anOutput = PackingOptimizer.packInputChain(anInputChain, BOX_CAPACITY);
		myLogger.info("The output chain:" + anOutput.toString());
		assertTrue(isMaxBoxCapacityRespected(anOutput, BOX_CAPACITY));
		assertTrue(areInputAndOutputSizeEquals(INPUTCHAIN_TEST_4, anOutput.toString()));
		assertEquals(NUMBER_OF_BOXES_TEST_4, anOutput.getBoxes().size());
		assertEquals(EXPECTED_OUTPUT_TEST_4, anOutput.toString());
	}
	
	@Test
	public void test5OneArticleInput () throws Exception{
		myLogger.info("Test input chain: " + INPUTCHAIN_TEST_5);
		InputChain anInputChain = new InputChain(INPUTCHAIN_TEST_5);
		OutputChain anOutput = PackingOptimizer.packInputChain(anInputChain, BOX_CAPACITY);
		myLogger.info("The output chain:" + anOutput.toString());
		assertTrue(isMaxBoxCapacityRespected(anOutput, BOX_CAPACITY));
		assertTrue(areInputAndOutputSizeEquals(INPUTCHAIN_TEST_5, anOutput.toString()));
		assertEquals(NUMBER_OF_BOXES_TEST_5, anOutput.getBoxes().size());
		assertEquals(EXPECTED_OUTPUT_TEST_5, anOutput.toString());
	}
	
	@Test
	public void test6ALotOfSameArticle () throws Exception{
		myLogger.info("Test input chain: " + INPUTCHAIN_TEST_6);
		InputChain anInputChain = new InputChain(INPUTCHAIN_TEST_6);
		OutputChain anOutput = PackingOptimizer.packInputChain(anInputChain, BOX_CAPACITY);
		myLogger.info("The output chain:" + anOutput.toString());
		assertTrue(isMaxBoxCapacityRespected(anOutput, BOX_CAPACITY));
		assertTrue(areInputAndOutputSizeEquals(INPUTCHAIN_TEST_6, anOutput.toString()));
		assertEquals(NUMBER_OF_BOXES_TEST_6, anOutput.getBoxes().size());
		assertEquals(EXPECTED_OUTPUT_TEST_6, anOutput.toString());
	}
	
	private boolean isMaxBoxCapacityRespected(OutputChain theOutputChain, int theBoxCapacity) {
		for (Box aBox : theOutputChain.getBoxes()) {
			if (aBox.getContentSize() > theBoxCapacity) {
				return false;
			}
		}
		return true;
	}
	
	private boolean areInputAndOutputSizeEquals (String theInputChain, String theOutputChain) {
		int anInputSize = 0;
		int anOutputSize = 0;
		for (int i=0 ; i< theInputChain.length(); i++) {
			anInputSize = anInputSize +Integer.valueOf(theInputChain.substring(i, i+1));
		}
		
		for (int i=0 ; i< theOutputChain.length(); i++) {
			if (!theOutputChain.substring(i, i+1).equals("/")) {
				anOutputSize = anOutputSize + Integer.valueOf(theOutputChain.substring(i, i+1));
			}
		}
		
		return anInputSize == anOutputSize;
	}

}

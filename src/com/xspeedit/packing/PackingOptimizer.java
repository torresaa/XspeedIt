package com.xspeedit.packing;

import com.xspeedit.packing.types.InputChain;
import com.xspeedit.packing.types.OutputChain;
import org.junit.runner.*;

public class PackingOptimizer {
	
    public static void main(String[] args) throws Exception {
    	if (args.length > 0) {
    		if (args[0].matches("\\d+")) {
        		//Is numeric
        		OutputChain anOut = packInputChain(new InputChain(args[0]), 10);
        		System.out.println("The input chain \"" + args[0] + "\" has been packed in " + anOut.getBoxes().size() + " boxes," 
        				+ " as you can find here:");
        		System.out.println(anOut.toString()); 
        	} else if (args[0].equals("tests")) {
    			JUnitCore junit = new JUnitCore();
    			Result result = junit.run(PackingOptimizerTest.class);
    			System.out.println("\n\nAll tests have " +(result.wasSuccessful() ? "" : "NOT ") + "been executed successfully.");
    			
    		} else {
    			System.out.println("Invalid argument, please respect the next instructions.");
    			System.out.println("Possible arguments:");
    			System.out.println("    <chain of integers>    Entry chain. Ex. 163841689525773");
    			System.out.println("    test                   Run JUnit test.");
        	}
    	} else {
    		String aConsoleInput = null;
			while (aConsoleInput == null || !aConsoleInput.matches("\\d+")) {
				System.out.println("Please, enter a valid input chain: ");
				aConsoleInput = System.console().readLine();
			}
			OutputChain anOut = packInputChain(new InputChain(aConsoleInput), 10);
    		System.out.println("The input chain \"" + aConsoleInput + "\" has been packed in " + anOut.getBoxes().size() + " boxes," 
    				+ " as you can find here:");
    		System.out.println(anOut.toString()); 
    	}
    }
	
	public static final OutputChain packInputChain (InputChain theInputChain, int theBoxCapacity) {
		OutputChain anOutputChain = new OutputChain(); 
		
		while (!theInputChain.isEmpty()) {
			BoundedKnapsackSolution aSolution = BoundedKnapsackSolver.solve(theInputChain.getRemainingArticlesAsArray(), 
					theInputChain.getRemainingArticlesAsArray(), 10);
			for (Integer anArticle : aSolution.getMyPacketItemsWeights()) {
				theInputChain.removeArticle(anArticle);
			}
			anOutputChain.addNewBox(aSolution.getMyPacketItemsWeights().toArray(new Integer[aSolution.getMyPacketItemsWeights().size()]));
		}
		
		return anOutputChain;
	
	}

}

package com.xspeedit.packing;

import java.util.ArrayList;
import java.util.List;

public class BoundedKnapsackSolver {
    
    public static BoundedKnapsackSolution solve (int someValues[], int someWeights[], int knapsackCapacity) {
    	int N = someWeights.length; // Get the total number of items. Could be wt.length or val.length. Doesn't matter
    	int[][] V = new int[N + 1][knapsackCapacity + 1]; //Create a matrix. Items are in rows and weight at in columns +1 on each side
        
    	//What if the knapsack's capacity is 0 - Set all columns at row 0 to be 0
        for (int col = 0; col <= knapsackCapacity; col++) {
            V[0][col] = 0;
        }
        //What if there are no items at home.  Fill the first row with 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        
        for (int item=1;item<=N;item++){
            //Let's fill the values row by row
            for (int weight=1;weight<=knapsackCapacity;weight++){
                //Is the current items weight less than or equal to running weight
                if (someWeights[item-1]<=weight){
                    //Given a weight, check if the value of the current item + value of the item that we could afford with the remaining weight
                    //is greater than the value without the current item itself
                    V[item][weight]=Math.max (someValues[item-1]+V[item-1][weight-someWeights[item-1]], V[item-1][weight]);
                }
                else {
                    //If the current item's weight is more than the running weight, just carry forward the value without the current item
                    V[item][weight]=V[item-1][weight];
                }
            }
        }
        
        int i = N; 
        int line = knapsackCapacity; 
        List<Integer> weightsInBag = new ArrayList<>();
        
        while (i > 0 && line > 0) {
        	if (line - someWeights[i-1] >= 0 && V[i][line] - V[i-1][line - someWeights[i-1]] == someWeights [i-1]) {
        		weightsInBag.add(someWeights [i-1]);
        		i--;
        		line = line - someWeights[i];
        	} else {
        		i--;
        	}
        }
        
        return new BoundedKnapsackSolution(V[N][knapsackCapacity], weightsInBag);    
    }

}
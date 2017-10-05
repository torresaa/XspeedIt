package com.xspeedit.packing;

import java.util.List;

public class BoundedKnapsackSolution {
	
	private int myTotalValue;
	private List<Integer> myPacketItemsWeights;
	
	public BoundedKnapsackSolution (int aTotalValue, List<Integer> aPacketItems) {
		myTotalValue = aTotalValue; 
		setMyPacketItemsWeights(aPacketItems);
	}

	public int getMyTotalValue() {
		return myTotalValue;
	}

	public void setMyTotalValue(int myTotalValue) {
		this.myTotalValue = myTotalValue;
	}

	public List<Integer> getMyPacketItemsWeights() {
		return myPacketItemsWeights;
	}

	public void setMyPacketItemsWeights(List<Integer> myPacketItemsWeights) {
		this.myPacketItemsWeights = myPacketItemsWeights;
	}

}

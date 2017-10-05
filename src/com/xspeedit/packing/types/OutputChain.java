package com.xspeedit.packing.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OutputChain {
	
	private static final String OUTPUT_STRING_BOXSEPARATOR = "/";
	
	public class Box {
		private Integer[] myContent;
		
		public Box (Integer[] theContent) {
			myContent = theContent;
		}
		
		public int getContentSize () {
			int aSize = 0;
			for (int i=0 ; i< myContent.length ; i++) {
				aSize= aSize + myContent[i];
			}
			return aSize;
		}
		
		@Override
		public String toString() {
			String aString = "";
			for (int i=0 ; i< myContent.length ; i++) {
				aString = aString + myContent[i];
			}
			return aString;
		}
	}
	
	private List<Box> myBoxes; 
	
	public OutputChain () {
		myBoxes = new ArrayList<>();
	}
	
	public void addNewBox (Integer [] theContent) {
		Box aBox = new Box (theContent);
		myBoxes.add(aBox);
	}
	
	@Override
	public String toString() {
		String aResult = "";
		Iterator<Box> anInterator = myBoxes.iterator();
		while (anInterator.hasNext()) {
			Box aBox = anInterator.next();
			aResult = aResult + aBox.toString() + (anInterator.hasNext() ? OUTPUT_STRING_BOXSEPARATOR : "");
		} 
		return aResult;
	}
	
	public List<Box> getBoxes() {
		return myBoxes;
	}
}

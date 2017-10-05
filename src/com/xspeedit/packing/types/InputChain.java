package com.xspeedit.packing.types;

import java.util.ArrayList;
import java.util.List;

public class InputChain {
	
	private List<Integer> myArticles;
	private List<Integer> myRemainArticles;
	
	public InputChain (String someInputArticles) {
		myArticles = new ArrayList<>();
		for (int i=0 ; i< someInputArticles.length(); i++) {
			myArticles.add(Integer.valueOf(someInputArticles.substring(i, i+1)));
		}
		myRemainArticles = new ArrayList<>(myArticles);
	}
	
	public void removeArticle (Integer theArticle) {
		if (myRemainArticles.contains(theArticle)) {
			myRemainArticles.remove(theArticle);
		}
	}
	
	public boolean isEmpty () {
		return myRemainArticles.isEmpty();
	}
	
	public List<Integer> getInitialsArticles () {
		return myArticles;
	}
	
	public List<Integer> getRemainingArticles () {
		return myRemainArticles;
	}
	
	public int[] getRemainingArticlesAsArray () {
		int[] someArticles = new int [myRemainArticles.size()];
		for (int i=0 ; i< someArticles.length ; i++) {
			someArticles[i] = myRemainArticles.get(i);
		}
		return someArticles;
	}

}

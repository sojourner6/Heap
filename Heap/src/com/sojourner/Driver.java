package com.sojourner;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] A = {4,3,10,5,6,11,50,90,0,55,30};
		Heap heap = new Heap(A);
		heap.BUILD_MAX_HEAP(A);
		Utility.DISPLAY_HEAP_ARRAY(A);
		
		int[] B = {4,3,10,5,6,11,50,90,0,55,30};
		Heap heap2 = new Heap(B);
		heap2.BUILD_MAX_HEAP_1(B);
		Utility.DISPLAY_HEAP_ARRAY(B);
		
		//int[] T = {9,16,3,2,4,8,5,14,12};
		int[] T = {9,16,3,2,4,8,5,14,12,10,36,55,7,16,0,-1};
		Tableau tableau = new Tableau(4, 4);
		for(int n : T){
			tableau.INSERT(n);
		}
		tableau.DISPLAY_TABLEAU();
		System.out.println("Min: " + tableau.EXTRACT_MIN());
		tableau.DISPLAY_TABLEAU();

	}

}

package com.sojourner;

public class Tableau {
	int m;
	int n;
	int[][] A;
	
	public Tableau(int x, int y){
		this.m = x;
		this.n = y;
		this.A = new int[m][n];
		for(int i = 1 ; i <= m ; i++){
			for(int j = 1 ; j <= n ; j++){
				A[index(i)][index(j)] = Integer.MAX_VALUE;
			}
		}
	}
	
	public int EXTRACT_MIN(){
		int min = A[index(1)][index(1)];
		A[index(1)][index(1)] = Integer.MAX_VALUE;
		MIN_TABLEAUFY(1, 1);
		return min;
	}
	
	private void MIN_TABLEAUFY(int x, int y){
		if(index(x) < 0 || index(y) < 0) return;
		if(x > this.m
				|| y > this.n){
			return;
		}
		int lesserX = x;
		int lesserY = y;
		if(x + 1 <= this.m
				&& A[index(x + 1)][index(y)] < A[index(lesserX)][index(lesserY)]){
			//Utility.swap(A, x, y, x + 1, y);
			lesserX = x + 1;
		}
		if(y + 1 <= this.n
				&& A[index(x)][index(y + 1)] < A[index(lesserX)][index(lesserY)]){
			lesserX = x;
			lesserY = y + 1;
		}
		if(lesserX != x
				|| lesserY != y){
			Utility.swap(A, index(x), index(y), index(lesserX), index(lesserY));
			MIN_TABLEAUFY(lesserX, lesserY);
		}
		
	}
	
	private int index(int i){
		return i-1;
	}
	
	private void INSERT_TABLEAU(int x, int y){
		int largerX = x;
		int largerY = y;
		int key = A[index(x)][index(y)];
		if(x - 1 >= 1
				&& A[index(x-1)][index(y)] > key){
			largerX = x - 1;
		}
		if(y - 1 >= 1
				&& A[index(x)][index(y - 1)] > A[index(largerX)][index(largerY)]){
			largerX = x;
			largerY = y - 1;
		}
		if(largerX != x
				|| largerY != y){
			A[index(x)][index(y)] = key;
			Utility.swap(A, index(x), index(y), index(largerX), index(largerY));
			INSERT_TABLEAU(largerX, largerY);
		}
	}
	
	public void INSERT(int key){
		if(A[index(m)][index(n)] == Integer.MAX_VALUE){
			A[index(m)][index(n)] = key;
			INSERT_TABLEAU(m, n);
		}
	}
	
	public void DISPLAY_TABLEAU(){
		Utility.DISPLAY_HEAP_ARRAY(A, m, n);
	}
}

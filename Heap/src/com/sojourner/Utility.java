package com.sojourner;

public class Utility {

	public static void swap(int[] A, int i, int j){
		A[i] += A[j];
		A[j] = A[i] - A[j];
		A[i] -= A[j];
	}
	
	public static void swap(int[][] A, int i, int j, int x, int y){
		A[i][j] += A[x][y];
		A[x][y] = A[i][j] - A[x][y];
		A[i][j] -= A[x][y];
	}
	
	public static void DISPLAY_HEAP(int[] A){
		int flag = 0;
		for(int i = 0; i < A.length; i++){
			int limit = (int)Math.pow(2.0, (double)flag);
			int max = ((i + limit) < A.length) ? (i + limit) : A.length;
			for(int j = i; j < max; j++){
				System.out.print(A[j] + ",");
				i++;
			}
			i--;
			flag++;
			System.out.println();
		}
	}

	public static void DISPLAY_HEAP_ARRAY(int[] A){
		System.out.println();
		for(int n : A){
			System.out.print(n + ",");
		}
		System.out.println();
	}
	
	public static void DISPLAY_HEAP_ARRAY(int[][] A, int m, int n){
		System.out.println();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				System.out.print(A[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println();
	}
}

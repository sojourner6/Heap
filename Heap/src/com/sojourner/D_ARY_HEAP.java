package com.sojourner;

public class D_ARY_HEAP {
	
	int heap_size;
	int d;
	
	public D_ARY_HEAP(int[] A){
		this.heap_size = A.length;
	}
	
	public int LEFT(int i){
		return d*i;
	}
	
	public int RIGHT(int i){
		return (d*i) + 1;
	}
	
	public int PARENT(int i){
		return i/d;
	}
	
	private void MAX_HEAPIFY(int[] A, int i){
		if(i > heap_size) return;
		int largest = i;
		if(LEFT(i) <= heap_size
				&& A[index(LEFT(i))] > A[index(largest)]){
			largest = LEFT(i);
		}
		if(RIGHT(i) <= heap_size
				&& A[index(RIGHT(i))] > A[index(largest)]){
			largest = RIGHT(i);
		}
		if(largest != i){
			Utility.swap(A, i, largest);
			MAX_HEAPIFY(A, largest);
		}
	}
	
	public int EXTRACT_MAX(int[] A){
		if(this.heap_size < 1){
			System.out.println("Error: Heap Underflow");
			return -9999;
		}
		int max = A[index(1)];
		A[index(1)] = A[index(heap_size)];
		this.heap_size -= 1;
		MAX_HEAPIFY(A, 1);
		return max;
	}
	
	private int index(int i){
		return i-1;
	}

}

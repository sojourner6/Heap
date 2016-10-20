package com.sojourner;

public class Heap {

	int length = 0;
	int heap_size = 0;
	
	public Heap(int[] A){
		length = A.length;
		heap_size = A.length;
	}
	
	int LEFT(int i){
		return 2*i;
	}
	
	int RIGHT(int i){
		return (2*i) + 1;
	}
	
	static int PARENT(int i){
		return i/2;
	}
	
	public void MIN_HEAPIFY(int[] A, int i){
		int lesser = i;
		int l = LEFT(i);
		int r = RIGHT(i);
		if(l <= heap_size && A[index(l)] < A[index(i)]){
			lesser = l;
		}
		if(r <= heap_size && A[index(r)] < A[index(lesser)]){
			lesser = r;
		}
		if(lesser != i){
			Utility.swap(A, index(i), index(lesser));
			MIN_HEAPIFY(A, lesser);
		}
	}
	
	public void MAX_HEAPIFY(int[] A, int i){
		int largest = i;
		int l = LEFT(i);
		int r = RIGHT(i);
		if(l <= heap_size && A[index(l)] > A[index(i)]){
			largest = l;
		}
		if(r <= heap_size && A[index(r)] > A[index(largest)]){
			largest = r;
		}
		if(largest != i){
			Utility.swap(A, index(i), index(largest));
			MAX_HEAPIFY(A, largest);
		}
	}
	
	public void BUILD_MAX_HEAP(int[] A){
		this.heap_size = A.length;
		for(int i = heap_size/2; i > 0; i--){
			MAX_HEAPIFY(A, i);
		}
	}
	
	public void BUILD_MIN_HEAP(int[] A){
		this.heap_size = A.length;
		for(int i = heap_size/2; i > 0; i--){
			MIN_HEAPIFY(A, i);
		}
	}
	
	public void HEAP_SORT_ASC(int[] A){
		BUILD_MAX_HEAP(A);
		while(heap_size > 0){
			Utility.swap(A, index(1), index(heap_size));
			heap_size -= 1;
			MAX_HEAPIFY(A, 1);
		}
	}
	
	public void HEAP_SORT_DESC(int[] A){
		BUILD_MIN_HEAP(A);
		while(heap_size > 0){
			Utility.swap(A, index(1), index(heap_size));
			heap_size -= 1;
			MIN_HEAPIFY(A, 1);
		}
	}

	/*
	 * CLRS Problem #6-1 Building a Heap using Insertion
	 */
	public void BUILD_MAX_HEAP_1(int[] A){
		PriorityQueue pq = new PriorityQueue();
		pq.setHeap_size(1);
		for(int i = 2; i < A.length; i++){
			pq.MAX_HEAP_INSERT(A, A[index(i)]);
		}
	}
	
	private int index(int i){
		return i-1;
	}
}

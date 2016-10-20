package com.sojourner;

public class PriorityQueue {

	int heap_size;
	
	public void setHeap_size(int heap_size) {
		this.heap_size = heap_size;
	}

	public PriorityQueue(){
		this.heap_size = 0;
	}
	
	public PriorityQueue(int[] A){
		this.heap_size = A.length;
	}
	
	public int MAXIMUM(int[] A){
		return A[0];
	}
	
	public int EXTRACT_MAX(int[] A){
		if(this.heap_size < 1){
			System.out.println("Error: Heap Underflow");
			return -9999;
		}
		int max = A[index(1)];
		A[index(1)] = A[index(heap_size)];
		this.heap_size -= 1;
		Heap h = new Heap(A);
		h.MAX_HEAPIFY(A, index(1));
		return max;
	}
	
	public void HEAP_INCREASE_KEY(int[] A, int location, int newKey){
		if(!(newKey > A[index(location)])) return;
		A[index(location)] = newKey;
		while(index(location) > 0 
				&& (A[index(Heap.PARENT(location))] < A[index(location)])){
			Utility.swap(A, index(location), index(Heap.PARENT(location)));
			location = Heap.PARENT(location);
		}
	}
	
	public void MAX_HEAP_INSERT(int[] A, int key){
		this.heap_size += 1;
		A[index(this.heap_size)] = -9999;
		HEAP_INCREASE_KEY(A, this.heap_size, key);
	}
	
	private int index(int i){
		return (i > 0)? i - 1 : null;
	}
}

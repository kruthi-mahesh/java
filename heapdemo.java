
import java.util.*;
abstract class Heap{
	protected int cap;
	protected int size;
	protected int[] arr;
	Heap(){
		this(10);
	}
	Heap(int capacity)
	{
		cap = capacity;
		size = 0;
		arr = new int[cap];
	}
	public int getLeftChildIndex(int par_ind){
		return par_ind*2 + 1;
	}
	public int getRightChildIndex(int par_ind){
		return par_ind*2 +2;
	}
	public int getParentIndex(int child_ind){
		return (child_ind-1)/2;
	}
	public boolean hasLeftChild(int par_ind){
		return getLeftChildIndex(par_ind) < size;
	}
	public boolean hasRightChild(int par_ind){
		return getRightChildIndex(par_ind) < size;
	}
	public boolean hasParent(int child_ind){
		return getParentIndex(child_ind) >= 0;
	}
	public int leftChild(int par_ind){
		return arr[getLeftChildIndex(par_ind)];
	}
	public int rightChild(int par_ind){
		return arr[getRightChildIndex(par_ind)];
	}
	public int parent(int child_ind){
		return arr[getParentIndex(child_ind)];
	}
	public void ensureCap(){
		if(size == cap){
			cap = cap*2;
			arr = Arrays.copyOf(arr,cap);
		}
	}
	public void isEmpty(String method){
		
			if(size == 0)
				throw  new IllegalStateException("You cannot call" + method + "on an empty heap");
		
	}
	public void swap(int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public int peek(){
		isEmpty("peek");
		return arr[0];
	}
	public int poll(){
		isEmpty("poll");
		int top = arr[0];
		swap(0,size-1);
		size--;
		heapifyDown();
		return top;
	}
	public void add(int item){
		ensureCap();
		arr[size] = item;
		size++;
		heapifyUp();
	}
	public abstract void heapifyUp();
	public abstract void heapifyDown();
}

class MinHeap extends Heap{
	public void heapifyUp(){
		int index = size-1;
		while(hasParent(index) && parent(index)>arr[index]){
			
			swap(getParentIndex(index),index);
			index = getParentIndex(index);
		}

	}
	public void heapifyDown(){
		int index = 0;
		while(hasLeftChild(index)){
			int smallerChildIndex = getLeftChildIndex(index);
		
		if(hasRightChild(index) && rightChild(index) < leftChild(index))
			smallerChildIndex = getRightChildIndex(index);
		if(arr[index] < arr[smallerChildIndex])
			break;
		else
		{
			swap(index,smallerChildIndex);
			index = smallerChildIndex;
		}

		}
	}
}

class MaxHeap extends Heap{
	public void heapifyUp(){
		int index = size-1;
		while(hasParent(index)){
			if(parent(index)>=arr[index])
				break;
			swap(getParentIndex(index),index);
			index = getParentIndex(index);
		}
	}
	public void heapifyDown(){
		int index = 0;
		while(hasLeftChild(index)){
			int largerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) &&  rightChild(index) > leftChild(index))
				largerChildIndex = getRightChildIndex(index);
			if(arr[index] > arr[largerChildIndex])
				break;
			swap(index,largerChildIndex);
			index = largerChildIndex;
		}
	}

}

class heapdemo{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        scanner.close();
        
        // Insert random values into heaps:
        Heap minHeap = new MinHeap();
        Heap maxHeap = new MaxHeap();
        System.out.println("Insert Number Sequence:");
        for(int i = 0; i < range; i++) {
            int value = (int) (Math.random() * 100);
            minHeap.add(value);
            maxHeap.add(value);
            System.out.print(+ value + " ");
        }
        
        // Remove values from heaps:
        System.out.println("\n\nPoll Values:\n------------\nMinHeap MaxHeap");
        for(int i = 0; i < range; i++) {
            System.out.format("  %-12d", minHeap.poll());
            System.out.format("%-6d\n", maxHeap.poll());
        }
        try {
            minHeap.peek();
        }
        catch(IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        try {
            maxHeap.poll();
        }
        catch(IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}


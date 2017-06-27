import java.util.*;
import java.io.*;
class Sorting{
	public void print(String s,int[] x){
		System.out.println(s+" Array: ");
		for (int a : x)
			System.out.print( a + " ");
		System.out.println();
	}
	public int[] bb(int[] x){
		print("Initial",x);
		int endPos = x.length - 1;
		int swapPos,swcount=0;
		while(endPos>0){
			System.out.println("endPos at beg: " + endPos);
			swapPos = 0;
			for(int i=0; i<endPos;i++){
				if(x[i]>x[i+1]){
					swcount++;
					int temp = x[i];
					x[i] = x[i+1];
					x[i+1] = temp;
					swapPos = i; 
				}
				print("current",x);
			}
			endPos = swapPos;
			System.out.println("endPos at end: " + endPos);
		}
		System.out.println("Swap count = " + swcount);
		return x;
	}
}
class BubbleSort{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n ;i++)
			arr[i] = sc.nextInt();
		sc.close();
		Sorting p = new Sorting();
		int[] sorted = p.bb(arr);
		p.print("Sorted Array: ",sorted );
	}
}

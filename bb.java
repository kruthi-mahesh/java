import java.io.*;
import java.util.*;
class bb{
	public int sort(int[] x,int n){
		int ct=0;
		for(int i=0;i<n;i++){
			int no_sw=0;
			for(int j=0; j<n-1-i; j++){
				if(x[j]>x[j+1]){
					no_sw ++;
					ct++;
					int temp = x[j];
					x[j] = x[j+1];
					x[j+1] = temp;
				}
				
			}
			if(no_sw == 0)
					break;
		}
		
		return ct;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x[] = new int[n];
		for(int i =0; i<n;i++)
			x[i] = sc.nextInt();
		bb obj = new bb();
		int ct = obj.sort(x,x.length);
		System.out.println("Array is sortred in " + ct + " swaps");
		System.out.println("Sorted Array is : ");
		for(int i=0; i<n; i++)
			System.out.println(x[i]+ " ");
	}
}
import java.util.*;
import java.io.*;
class test
{

	
	static int getInvCount(int n,int[] arr)
	{
	int inv_count = 0;
	for (int i = 0; i < n - 1; i++)
		for (int j = i+1; j < n; j++)
		if (arr[i] > arr[j])
			inv_count++;
	
	return inv_count;
	}

	// Driver method to test the above function
	public static void main(String[] args) 
	{
			Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		sc.close();
		System.out.println("Number of inversions are " + getInvCount(arr.length,arr));
	
	}
}

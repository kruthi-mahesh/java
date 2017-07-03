import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class merge_inv {
    public static long mergeSort(int[] a,int[] temp,int left,int right){
        if(right<=left)
            return 0;
        int mid = (left+right)/2;
        
        long inv = mergeSort(a,temp,left,mid);
        inv += mergeSort(a,temp,mid+1,right);
        inv += merge(a,temp,left,mid+1,right);
        return inv;
        
    }
    public static long merge(int[] a,int[] temp,int left,int mid,int right){
        int i = left,j = mid,k = left;
        long ct=0;
        while(i<= mid-1 && j<= right){
            if(a[i]<=a[j])
                temp[k++]=a[i++];
            
            else{
                temp[k++] = a[j++];
                ct += mid - i;
            }
            
        }
        while(i<mid)
            temp[k++] = a[i++];
        
         while(j<=right)
             temp[k++] = a[j++];
        for(int m = left; m<=right; m++)
            a[m] = temp[m];
        return ct;
    }

    public static long countInversions(int[] arr){
        int[] temp = new int[arr.length];
        return mergeSort(arr,temp,0,arr.length-1);
    }
  
    public static void print(int[] a){
        for(int i=0; i<a.length;i++)
            System.out.println(a[i]);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
      
        
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println("No of inversisons: " + countInversions(arr));
            System.out.println("Sorted Array: " );
            print(arr);
        
    }
    
    
}

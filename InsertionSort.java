import java.util.*;

public class InsertionSort {
    
    public static void insertionSort(int[] a){
        for(int i=1;i<a.length;i++){
            int k = i;
            int j = i-1;
            while(j>=0 && k>=0 && a[j]>a[k]){
                int temp = a[k];
                a[k] = a[j];
                a[j] = temp;
                k--;
                j--;
            }
        }
        
        
     
    }

    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr  = {2,9,5,1,3};
        insertionSort(arr);
        display(arr);

    }
}

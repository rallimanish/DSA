import java.util.*;


public class SortKSorted {
    
    public static void  sortKSortedArray(int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        int j=0;
        for(int i=k;i<arr.length;i++){
           pq.add(arr[i]);
           arr[j] = pq.remove();
           j++;
        }
        while(pq.size()>0){
            arr[j] = pq.remove();
            j++;
        }
        display(arr);
    }

    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    
    public static void main(String[] args)  {
       
        int[] arr = {3,2,4,1,6,5,7,9,8};
       
  
        int k = 3;
        // write your code here
        sortKSortedArray(arr,k);
     }
}

import java.util.*;

public class KLargest {
    
    public static void findKlargest(int[] arr , int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(arr[i]>=pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
           
        }
        while(pq.size()>0){
            System.out.println(pq.peek());
            pq.remove();
        }

    }
   public static void main(String[] args) throws Exception {
     int[] arr = {12,62,22,15,37,99,11,37,98,67,31,84,99};


      int k = 4;
      // write your code here
      findKlargest(arr,k);
    }
}

import java.util.*;

public class heap{

    public static void main(String[] args){
        int[] arr = {5,8,22,43,12,2,21,26};
        PriorityQueue<Integer> pq =  new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
       while(pq.size()>0){
           System.out.println(pq.peek());
           pq.remove();
       }
    }
}
import java.util.*;


public class PrintSubarray {
    
    
    public static void printSubarray(int[] arr){

    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr=  new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
       
        printSubarray(arr);
    }
}

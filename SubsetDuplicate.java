import java.util.*;

public class SubsetDuplicate {
    
    public static void printSubsetDuplicate(int[] arr , int start , String asf){

        if(start==arr.length){
            System.out.println(asf);
            return;
        }
        int a = arr[start];
        printSubsetDuplicate(arr,start+1,asf+a+" ");
        printSubsetDuplicate(arr,start+1,asf);

    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr=  new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        printSubsetDuplicate(arr,0,"");
    }
}

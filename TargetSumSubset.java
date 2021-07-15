import java.util.*;


public class TargetSumSubset {

    public static void printTargetSumSubsets(int[] arr, int start , String asf,int sum,int target){

        if(start==arr.length){
            if(sum==target){
                System.out.println(asf);
                return;
            }
            else{
                return;
            }
        }
         

        int a = arr[start];
        printTargetSumSubsets(arr,start+1,asf+" "+a,sum+a,target);
        printTargetSumSubsets(arr,start+1,asf,sum,target);

    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr=  new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        printTargetSumSubsets(arr,0,"",0,target);
    }
}

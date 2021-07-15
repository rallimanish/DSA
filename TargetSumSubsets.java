
import java.util.*;


public class TargetSumSubsets {
    
    public static void printSubset(int[] arr,int index,String asf,int sum,int target){
        if(index==arr.length){
            if(sum==target){
                System.out.println(asf);
                return;
            }
            return;
           
        }

        printSubset(arr, index+1, asf+arr[index]+" ",sum+arr[index],target);
        printSubset(arr, index+1, asf+"",sum,target);
    }

    //Recursion mtheod II 
    public static boolean checkTargetSumSubset(int[] arr, int index, int target){
        if(target==0){
            return true;
        }

        if(index==arr.length){   
            return false;
        }
        boolean res = false;
        //yes call
        if(target-arr[index]>=0){
             x = checkTargetSumSubset(arr, index+1, target-arr[index]);
            if(x==true){
                return true;
            }
       }
       //no call
       boolean y = checkTargetSumSubset(arr, index+1, target);
       if(y==true){
           return true;
       }
       return false;

       //no call
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int[] arr = {4,2,7,1,3};
        int target = 10;
        //printSubset(arr,0,"",0,target);
        boolean  ans = checkTargetSumSubset(arr,0,target);
        System.out.println(ans);
    }    
}

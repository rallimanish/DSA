import java .util.*;
 public class CoinChangePermutation{

    public static int findCoinChangePermutationRecursive(int[] coins,  int target,String psf){
        if(target==0){
            System.out.println(psf);
            return 1;
        }

        int count=0;
        for(int c : coins){
            if(target-c>=0){
                count  = count+findCoinChangePermutationRecursive(coins,target-c,psf+c+" ");
            }
        }
        return count;
    }
    public static void main(String[] args){

        int[] coins = {2,3,5,6};
        int target = 7;
        System.out.println("Total no. of ways:");
        System.out.println(findCoinChangePermutationRecursive(coins,target,""));
    }
 }
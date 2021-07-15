import java.util.*;


public class Fibonacci {
    //Recursive
    public static int fibRecursive(int n){
        if(n==0 || n==1){
            return n;
        }

        int m1 = fibRecursive(n-1);
        int m2 = fibRecursive(n-2);
        int x = m1 + m2;
        return x;

    }

    //Memoization
 public static int fibMem(int n , int[] dp){
    if(n==0 || n==1){
        return dp[n]= n;
    }
    if(dp[n]!=0){
        return dp[n];
    }
    int m1 = fibMem(n-1,dp);
    int m2 = fibMem(n-2,dp);
    int x = m1 + m2;
    return dp[n]=x;
}

//TABULATION
public static int fibTab(int n,int[] dp){
    dp[0]=0;
    dp[1] = 1;
    for(int i=2;i<n+1;i++){
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
}
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //System.out.println(fibRecursive(n));
        int[] dp  = new int[n+1];
        //System.out.println(fibMem(n,dp));

        System.out.println(fibTab(n,dp));
    }
}

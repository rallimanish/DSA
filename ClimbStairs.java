import java.util.*;

public class ClimbStairs {
    
    public static int findClimbStairsRecursive(int n ){
        if(n==0){
            return 1;
        }
        int count=0;
        for(int j=1;j<=3;j++){
            if(n-j>=0){
              count = count+findClimbStairsRecursive(n-j);
            }
        }
        return count;
    }

    public static int findClimbStairsMem(int n,int[] dp){
        if(n==0){
            return dp[n] = 1;
        }

        if(dp[n]!=0){
            return dp[n];
        }
        int count=0;
        for(int j=1;j<=3;j++){
            if(n-j>=0){
              count = count+findClimbStairsRecursive(n-j);
            }
        }
        return dp[n]=count;
    }

    public static int findClimbStairsTab(int n,int[] dp){
        dp[0]=1;
        for(int i=1;i<n+1;i++){
           if(i>=3){
               dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
           }
            else if(i>=2){
                dp[i] = dp[i-1] + dp[i-2];
            }
            else if(i>=1){
                dp[i] = dp[i-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        Scanner scn   = new Scanner(System.in);
        int n = scn.nextInt();
        
       //int ans =  findClimbStairsRecursive(n);
       int[] dp = new int[n+1];
      // int ans =  findClimbStairsMem(n,dp);
      int ans =  findClimbStairsTab(n,dp);
       System.out.println(ans);
    }
}

import java.util.*;


public class ClimbStairsMinJumps {

    public static int findClimbStairsMinJumpsRecursive(int i, int n , int[] jumps){
        if(i==n){
            return 0;
        }

        int min = (int)(1e9); // 1*10^9 i.e positive infinity
        for(int j=1;j<=jumps[i];j++){
            if(i+j<=n){
                min  = Math.min(min,findClimbStairsMinJumpsRecursive(i+j,n,jumps));
            }
        }
        return min+1;
    }
    public static int findClimbStairsMinJumpsMem(int i, int n , int[] jumps,int[] dp){
        if(i==n){
            return dp[i] = 0;
        }
        if(dp[i]!=0){
            return dp[i];
        }
        int min = (int)(1e9); // 1*10^9 i.e positive infinity
        for(int j=1;j<=jumps[i];j++){
            if(i+j<=n){
                min  = Math.min(min,findClimbStairsMinJumpsMem(i+j,n,jumps,dp));
            }
        }
        return dp[i] = min+1;
    }

    public static int findClimbStairsMinJumpsTab(int i, int n , int[] jumps,int[] dp){
        dp[n] = 0;
        for( i=n;i>=0;i--){
            if(i==n){
                dp[i] = 0;
                continue;
            }
           
            int min = (int)(1e9); // 1*10^9 i.e positive infinity
            for(int j=1;j<=jumps[i];j++){
                if(i+j<=n){
                    min  = Math.min(min,dp[i+j]); //findClimbStairsMinJumpsTab(i+j,n,jumps,dp));
                }
            }
             dp[i] = min+1;
        }
       return dp[0];
    }


    public static void main(String[] args){
        Scanner scn  = new Scanner(System.in);
        int n  =scn.nextInt();
        int[] jumps = new int[n];
        for(int i=0;i<jumps.length;i++){
            jumps[i] = scn.nextInt();
        }
        //int ans = findClimbStairsMinJumpsRecursive(0,n,jumps); 
        int[] dp =  new int[n+1];
        //int ans = findClimbStairsMinJumpsMem(0,n,jumps,dp); 
        int ans = findClimbStairsMinJumpsTab(0,n,jumps,dp); 
        System.out.println(ans);

    }    
}

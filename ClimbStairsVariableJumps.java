import java.util.*;


public class ClimbStairsVariableJumps {    
                                        //i->current stair  n->dst stair 
    public static int  findClimbStairsVariableJumpsRec(int i,int n,int[] jumpsArray){
        if(i==n){
            return 1;
        }

        int count=0;
        for(int j=1;j<=jumpsArray[i] ;j++){
            if(j+i<=n){
               count = count +  findClimbStairsVariableJumpsRec(i+j,n,jumpsArray);
            }
            
        }
        return count;
    }

    public static int  findClimbStairsVariableJumpsMem(int i, int n , int[] jumpsArray,int[] dp){
        if(i==n){
            return dp[i]= 1;
        }
        if(dp[i]!=0){
            return dp[i];
        }
        int count=0;
        for(int j=1;j<=jumpsArray[i] ;j++){
            if(j+i<=n){
               count = count +  findClimbStairsVariableJumpsMem(i+j,n,jumpsArray,dp);
            }
            
        }
        return dp[i]=count;
    }

    public static int findClimbStairsVariableJumpsTab(int i,int n,int[] jumpsArray,int[] dp){
        for( i=n;i>=0;i--){
            if(i==n){
                dp[i]= 1;
                continue;
            }
            int count=0;
            for(int j=1;j<=jumpsArray[i] ;j++){
                if(j+i<=n){
                   count = count + dp[i+j]; // findClimbStairsVariableJumpsMem(i+j,n,jumpsArray,dp);
                }
            }  
            dp[i]= count;
        }
        return dp[0];
    }

    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        //no. of stairs
        int n = scn.nextInt();

        int[] jumpsArray = new int[n];
        for(int i=0;i<jumpsArray.length;i++){
            // how far from the step you could jump to in a single move. 
            jumpsArray[i] = scn.nextInt();
        }
        int[] dp = new int[n+1];
       //int ans =  findClimbStairsVariableJumpsRec(0,n,jumpsArray);
       //int ans =  findClimbStairsVariableJumpsMem(0,n,jumpsArray,dp);
       int ans =  findClimbStairsVariableJumpsTab(0,n,jumpsArray,dp);
       System.out.println(ans);


    }
}

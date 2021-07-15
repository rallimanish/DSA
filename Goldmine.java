import java.util.*;


public class Goldmine {

    //Recursive 
    public static int findMaxGoldHelper(int[][] mine , int x , int y){
        if(y==mine[0].length-1){
            return mine[x][y];
        }
        //valid Right Up call 
        int maxGold = (int)(-1e9);
        if(x-1>=0 && y+1<mine[0].length){
            maxGold = Math.max(maxGold,findMaxGoldHelper(mine,x-1,y+1));
        }

        //valid Right call
         if(y+1<mine[0].length){
           maxGold = Math.max(maxGold,findMaxGoldHelper(mine,x,y+1));
        }
        //valid Right down call 
        if(x+1<mine.length && y+1<mine[0].length){
            maxGold = Math.max(maxGold,findMaxGoldHelper(mine,x+1,y+1));
        }

        return maxGold+mine[x][y];
    }

    public static int findMaxGold(int[][] mine){
        int max = (int)(-1e9);

        for(int i=0;i<mine.length;i++){
            max = Math.max(max,findMaxGoldHelper(mine,i,0));
        }
        return max;
    }

    //MEMOIZATION
    public static int findMaxGoldHelperMem(int[][] mine , int x , int y,int[][] dp){
        if(y==mine[0].length-1){
            return dp[x][y] = mine[x][y];
        }

        if(dp[x][y]!=0){
            return dp[x][y];
        }
        //valid Right Up call 
        int maxGold = (int)(-1e9);
        if(x-1>=0 && y+1<mine[0].length){
            maxGold = Math.max(maxGold,findMaxGoldHelperMem(mine,x-1,y+1,dp));
        }

        //valid Right call
         if(y+1<mine[0].length){
           maxGold = Math.max(maxGold,findMaxGoldHelperMem(mine,x,y+1,dp));
        }
        //valid Right down call 
        if(x+1<mine.length && y+1<mine[0].length){
            maxGold = Math.max(maxGold,findMaxGoldHelperMem(mine,x+1,y+1,dp));
        }

        return dp[x][y] = maxGold+mine[x][y];
    }

    public static int findMaxGoldMem(int[][] mine){
        int max = (int)(-1e9);
        int[][] dp = new int[mine.length][mine[0].length];
        for(int i=0;i<mine.length;i++){
            max = Math.max(max,findMaxGoldHelperMem(mine,i,0,dp));
        }
        return max;
    }

    //Tabulation
    public static int findMaxGoldTab(int[][] mine , int x , int y,int[][] dp){
        int profit  = -1;
        for(y=mine[0].length-1;y>=0;y--){
            for(x=0;x<mine.length;x++){
                if(y==mine[0].length-1){
                     dp[x][y] = mine[x][y];
                     profit = Math.max(profit,dp[x][y]);
                     continue;
                }
        
                //valid Right Up call 
                int maxGold = (int)(-1e9);
                if(x-1>=0 && y+1<mine[0].length){
                    maxGold = Math.max(maxGold,dp[x-1][y+1]); //findMaxGoldHelperMem(mine,x-1,y+1,dp));
                }
        
                //valid Right call
                 if(y+1<mine[0].length){
                   maxGold = Math.max(maxGold,dp[x][y+1]); //findMaxGoldHelperMem(mine,x,y+1,dp));
                }
                //valid Right down call 
                if(x+1<mine.length && y+1<mine[0].length){
                    maxGold = Math.max(maxGold,dp[x+1][y+1]); //findMaxGoldHelperMem(mine,x+1,y+1,dp));
                }
        
                dp[x][y] = maxGold+mine[x][y];
                profit = Math.max(dp[x][y], profit);
            }
        }
        return profit;
    }

   
    public static void main(String[] args){

        int[][] mine = {{0,1,4}, 
                        {1,3,2}, 
                        {4,2,3}};
        //int ans = findMaxGold(mine);
       
        //int ans = findMaxGoldMem(mine);
        int[][] dp =new int[mine.length][mine[0].length];
        int ans = findMaxGoldTab(mine,0,0,dp);
        System.out.println(ans);
        
    }
}

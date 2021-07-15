import java.util.*;


public class MinCostMazeTraversal {
    //Recursive
    public static int  findMinCostPath(int[][] maze, int x,int y){
        if(x==maze.length-1 && y==maze[0].length-1){
            return maze[x][y];
        }
        int min = (int)(1e9); // positoive infinfity
        int c1 = (int)(1e9);
        //make a valid right call if u can reach cell by moving 1 step right and are in inbound of maze
        if(y+1<maze[0].length){
             c1  = Math.min(c1, findMinCostPath(maze,x,y+1));
        } 
        
        //make valid down call if u can reach cell by moving 1 step down and are in inbound of maze
        int c2 = (int)(1e9);
        if(x+1<maze.length){
            c2 = Math.min(c2,findMinCostPath(maze, x+1, y));
        }
        return Math.min(c1,c2) + maze[x][y];
    }

    public static int findMinCostPathMem(int[][] maze,int x,int y,int[][] dp){
        if(x==maze.length-1 && y==maze[0].length-1){
            return dp[x][y] =  maze[x][y];
        }

        if(dp[x][y]!=0){
            return dp[x][y];
        }
        int min = (int)(1e9); // positoive infinfity
        int c1 = (int)(1e9);
        //make a valid right call if u can reach cell by moving 1 step right and are in inbound of maze
        if(y+1<maze[0].length){
             c1  = Math.min(c1, findMinCostPath(maze,x,y+1));
        } 
        
        //make valid down call if u can reach cell by moving 1 step down and are in inbound of maze
        int c2 = (int)(1e9);
        if(x+1<maze.length){
            c2 = Math.min(c2,findMinCostPath(maze, x+1, y));
        }
        return dp[x][y] = Math.min(c1,c2) + maze[x][y];
    }


    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        //enter rows
        // int n = scn.nextInt();
        // //enter columns
        // int m = scn.nextInt();
        // //input for 2D maze
        // int[][] maze = new int[n][m];
        // for(int i=0;i<maze.length;i++){
        //     for(int j=0;j<maze[0].length;j++){
        //         maze[i][j] = scn.nextInt();
        //     }
        // }

        int[][] maze = { {10,9,8},
                         {3,7,15}, 
                         {9,6,11} }; 
        
        //int ans = findMinCostPath(maze,0,0);
        int[][] dp = new int[maze.length][maze[0].length];
        int ans = findMinCostPathMem(maze,0,0,dp);
        System.out.println(ans);
    }    
}

import java.io.*;
import java.util.*;

public class KnightsTour {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int  n = scn.nextInt();
        int[][] chess = new int[n][n];
        int sr = scn.nextInt();
        int sc = scn.nextInt();
        

        int[] dr = {-2,-1,1,2,2,1,-1,-2};
        int[] dc = {1,2,2,1,-1,-2,-2,-1};
        printKnightsTour(chess,sr,sc,1,dr,dc);
       


    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove,int[] dr,int[] dc) {
      

        if(upcomingMove == (chess.length * chess[0].length)){
            chess[r][c] = upcomingMove;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }

        //jaise hi cell par aao place kar do move
        chess[r][c] = upcomingMove;
            for(int idx = 0;idx<dr.length;idx++){
                int nr = r + dr[idx];
                int nc = c+ dc[idx];
                if(nr>=0 && nr<chess.length && nc>=0 && nc<chess[0].length && chess[nr][nc]==0 ){
                    
                    printKnightsTour(chess,nr,nc,upcomingMove+1,dr,dc);
                   
                }
            }
        // wapas jaate hue unkmark bhi karna h 
        chess[r][c] = 0;


    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
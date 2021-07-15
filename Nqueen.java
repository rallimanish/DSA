import java.util.*;

public class Nqueen {


    public static boolean isQueenSafeToPlace(int[][] chess,int row,int col){
       //bRUTE FORCE 
       
        int[] dr = {-1,-1,0,1,1,1,0,-1};
        int[] dc = {0,-1,-1,-1,0,1,1,1};
        int radius = chess.length;
        for(int idx=0;idx<dr.length;idx++){
            for(int jump=1;jump<=radius;jump++){
                int nr = row + jump*dr[idx];
                int nc = col + jump*dc[idx];
                //check if it is in valid boundary
                if(nr>=0 && nr<radius && nc>=0 && nc<radius){
                   // if in boundary then check ki waha queen h kya 
                    if(chess[nr][nc]==1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void printNqueen(int[][] chess,String psf,int row){
        if(row==chess.length){
            System.out.println(psf.substring(0,psf.length()-1));
            return;
        }

        for(int i=0;i<chess[0].length;i++){
            if(isQueenSafeToPlace(chess,row,i)==true){
                 //jaise hi cell par aaye waha queen rakh do
                chess[row][i] = 1;

                printNqueen(chess, psf+row+i+"-", row+1);

                //jaise hi backtrack krke next config check krne ja rhe ho to pehli wali queen hatate to hue jana taki naya rasta bhi explore ho sake
                chess[row][i] = 0;
            }
        }
    
    }
  public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int[][] chess = new int[n][n];
        printNqueen(chess,"",0);
  }  
}

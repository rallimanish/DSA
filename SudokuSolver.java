import java.util.*;


public class SudokuSolver {
    
    public static void displayBoard(String[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isValid(String[][] board , int row , int col , int num){
        //check row
        for(int i=0;i<board.length;i++){
            if(board[col][i].compareTo(num+"") == 0){
                return false;
            }
        }


        //check column
        for(int i=0;i<board.length;i++){
            if(board[col][i].compareTo(num+"") == 0){
                return false;
            }
        }

        //check the submatrix of 3x3
        for(int i=0;i<board.length;i++){
            if(board[ 3*(row/3)+(i/3) ][ 3*(col/3)+(i%3) ].compareTo(num+"") == 0){
                return false;
            }
        }
        return true;
    }

    public static void solve(String[][] board,int row){

        if(row==board.length){
            displayBoard(board);
            return;
        }

        //har row par par jao fir har row k ke column par check karo ki nkya waha num dal sakte h kya 

        for(int col=0;col<board[0].length;col++){
           if( board[row][col] == "."){
                for(int num=1;num<10;num++){
                    if(isValid(board,row,col,num)==true){
                        
                        //mark 
                        board[row][col] = num;
                        //solve
                        solve(board, row+1);
                        //unmark
                        board[row][col]=".";
                    }
                }
           }
        }
    }
    public static void main(String[] args){
        String[][] board   = { {'5','3','.','.','7','.','.','.','.'},
                                {'6','.','.',"1","9","5",".",".","."}, 
                                {".","9","8",".",".",".",".","6","."}, 
                                {"8",".",".",".","6",".",".",".","3"}, 
                                {"4",".",".","8",".","3",".",".","1"}, 
                                {"7",".",".",".","2",".",".",".","6"}, 
                                {".","6",".",".",".",".","2","8","."}, 
                                {".",".",".","4","1","9",".",".","5"}, 
                                {".",".",".",".","8",".",".","7","9"}};
        
        solve(board,0);
        // displayBoard(board);

        
    }
}

import java.util.*;

public class FloodFill {
    
    // public static void printAllPath(int[][] arr, int r , int c,String psf , boolean[][] visited){
    //     int n = arr.length;
    //     int m  = arr[0].length;

    //     if(r==n-1 && c == m-1){
    //         System.out.println(psf);
    //         return;
    //     }

        

    //     if(r>=0 && c>=0 && r<n && c<m){
    //         visited[r][c]=true;
    //          //top call
    //         if(r-1>=0 && c>=0 && r-1<n && c<m && arr[r-1][c]==0  && visited[r-1][c]==false){
    //             printAllPath(arr,r-1,c,psf+"t",visited);
    //         }
            
    //         //left call
    //         if(r>=0 && c-1>=0 && r<n && c-1< m && arr[r][c-1]==0 && visited[r][c-1]==false){
    //             printAllPath(arr,r,c-1,psf+"l",visited);
    //         }
    //         //down call
    //         if(r+1>=0 && c>=0 && r+1<n && c< m && arr[r+1][c]==0 && visited[r+1][c]==false){
    //             printAllPath(arr,r+1,c,psf+"d",visited);
    //         }
    //         //right call
    //         if(r>=0 && c+1>=0 && r<n && c+1< m && arr[r][c+1]==0 && visited[r][c+1]==false){
    //             printAllPath(arr,r,c+1,psf+"r",visited);
    //         }

    //         visited[r][c]=false;
    //     }
    // }  
    public static void printAllPath(int[][] arr,int r,int c,String psf,boolean[][] visited,int[] dr , int[] dc, char[] dirCharArray){
        int n = arr.length;
        int m  =arr[0].length;

        if(r==n-1 && c==m-1){
            System.out.println(psf);
            return;
        }

        visited[r][c] = true;

        for(int i=0;i<dr.length;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            char dir = dirCharArray[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && arr[nr][nc]==0 && visited[nr][nc]==false ){
                printAllPath(arr,nr,nc,psf+dir,visited,dr,dc,dirCharArray);
            }
        }

        visited[r][c] = false;

    }  
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int[][] arr = { { 0, 1, 0, 0 , 0 , 0 ,0  },
                        { 0, 1, 0, 1 , 1 , 1 , 0 },
                        { 0, 0, 0, 0 , 0 , 0 ,0 },
                        { 1, 0, 1, 1, 0 ,1 , 1 },
                        { 1, 0, 1, 1, 0 ,1 , 1},
                        { 1, 0, 0, 0 , 0 , 0 ,0 } };
        
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        //initailise boolean vsisited array with false 
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                visited[i][j] = false;
            }
        }
        
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        char[] dirCharArray = {'t','l','d','r'};

    
        printAllPath(arr,0,0,"",visited,dr,dc,dirCharArray); 
    }


   
}

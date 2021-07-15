import java.util.*;
import java.io.*;


public class StockSpan{
    public static Scanner scn = new Scanner(System.in);

    public static int[] getNGL(int[] arr){
        int[] ngl = new int[arr.length];
        Stack<Integer> st  = new Stack<>();
        st.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]<arr[i]){
                ngl[st.pop()] =i;
            }
            st.push(i);
        }
        while(st.size()>0){
            ngl[st.pop()]= -1;
        }
        return ngl;
    }
    public static int[] getStockSpan(int[] arr){
        int[] stock = new int[arr.length];
        int[] ngl = getNGL(arr);
        for(int i=0;i<arr.length;i++){
            stock[i] = i-ngl[i];
        }
        return stock;

    }

    public static void takeInput(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]); 
        }
    }
    public static void main(String[] args){
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        takeInput(arr);
        int[] ans = getStockSpan(arr);
        display(ans);
    }
}
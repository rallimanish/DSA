import java.io.*;
import java.util.*;


public class NextGreaterOnRight {


    public static Scanner scn  = new Scanner(System.in);
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
    public static int[]  nextGreaterRight(int[] arr){
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] ans = new int[arr.length];
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[st.peek()]<arr[i]){
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }

        while(st.size()>0){
            ans[st.pop()]=-1;
        }

        return ans;
    }
    public static void main(String[] args){
        int n  = scn.nextInt();
        int[] arr = new int[n];
        takeInput(arr);
        int[] ngr = nextGreaterRight(arr);
        display(ngr);
    }
}

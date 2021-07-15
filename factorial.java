import java.util.*;

public class factorial{


    public static int findFactorial(int n){
        if(n==0){
            return 1;
        }
        int a = findFactorial(n-1);
        return a*n;

    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(findFactorial(n));
    }
}

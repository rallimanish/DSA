import java.util.*;

public class permutationSpaces{

    public static void printPermutationWithSpaces(String str , String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        
        char ch = str.charAt(0);
        String roq = str.substring(1);
        printPermutationWithSpaces(roq,ans+" "+ch);
        printPermutationWithSpaces(roq,ans+ch);

    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        char ch = str.charAt(0);
        String roq = str.substring(1);
        printPermutationWithSpaces(roq,ch+"");
    }
}
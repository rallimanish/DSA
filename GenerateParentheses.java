import java.util.*;


public class GenerateParentheses {
    
   

    public static void printParentheses(int o, int c,String asf){
            if(o==0 && c==0){
                System.out.println(asf);
                return;
            }
           if(o!=0){
               printParentheses(o-1, c, asf+"(");
           }

           if(c>o){
                printParentheses(o, c-1, asf+")");
           }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printParentheses(n,n,"");

    }
}

import java.util.*;


public class PermutationCaseChange {
    
    public static void printPermutationCaseChange(String str , String asf){
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        char chUpperCase = (char)(ch-'a'+'A');
        String roq  = str.substring(1);
      

        printPermutationCaseChange(roq,asf+ch);
        printPermutationCaseChange(roq,asf+chUpperCase);
    }
    public static void main(String[] args){
        Scanner scn  = new Scanner(System.in);
        String str = scn.next();
        printPermutationCaseChange(str,"");

    }
}

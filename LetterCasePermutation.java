import java.util.*;


public class LetterCasePermutation {
    
    public static void printLetterCasePermuutation(String str , String asf){
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String roq = str.substring(1);
        if(Character.isDigit(ch)){
            printLetterCasePermuutation(roq,asf+ch);
        }
        else{
            char chUpperCase = (char)(ch-'a'+'A');
            printLetterCasePermuutation(roq,asf+ch);
            printLetterCasePermuutation(roq,asf+chUpperCase);
        }
    } 
    public static void main(String[] args){
        Scanner scn  = new Scanner(System.in);
        String str = scn.next();
        printLetterCasePermuutation(str,"");
    }
   
}

import java.io.*;
import java.util.*;

public class DuplicateBrackets{

    public static void checkDuplicateBracket(String str){
        Stack<Character> st  = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                //pehle check karo ki stack k top par just opening bracket to nhi pada 
                if(st.size()>0 && st.peek()=='('){
                    System.out.println(true);
                    return;
                }
                else{
                    //opening bracket jabtak nhi milta jata stack k top par tab tak pop
                    while(st.size()>0 && st.peek()!=ch){
                        st.pop();
                    }
                    //us opening bracket bhi to pop karna h 
                    st.pop();
                }
            }
            else{
                st.push(ch);
            }                                                                                                                                                                                                                           
        }
        System.out.println(false);
    }
    public static void main(String[] args){
        Scanner scn  = new Scanner(System.in);
        String str = scn.nextLine();
        checkDuplicateBracket(str);
    }
    
   

}


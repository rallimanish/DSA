import java.util.*;

public class BalancedBrackets{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String exp  = scn.nextLine();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            else if(ch==')'){
                if(st.size()==0){
                    System.out.println(false);
                    return;
                }
                if(st.size()>0 && st.peek()=='('){                                             
                    st.pop();
                }
            }
            else if(ch=='}'){
                if(st.size()==0){
                    System.out.println(false);
                    return;
                }
                if(st.size()>0 && st.peek()=='{'){
                    st.pop();
                }
            }
            else if(ch==']'){
                if(st.size()==0){
                    System.out.println(false);
                    return;
                }
                if(st.size()>0 && st.peek()=='['){
                    st.pop();
                }
            }
            else{
                continue;
            }
        }

        if(st.size()>0){
            System.out.println(false);
            
        }
        else {
            System.out.println(true);
        }

    }
}
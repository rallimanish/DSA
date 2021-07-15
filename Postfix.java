import java.io.*;
import java.util.*;


public class Postfix {
    
    public static int solve(int v1 , int v2 , char x){
        if(x=='+'){
            return v1+v2;
        }
        else if(x=='-'){
            return v1-v2;
        }
        else if(x=='*'){
            return v1*v2;
        }
        else {
            return v1/v2;
        }
    }

    public static void evaluatePostfix(String str){
        Stack<Integer> operand = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                if(operand.size()>0){
                    int val2 = operand.pop();
                    int val1 = operand.pop();
                    int res = solve(val1,val2,ch);
                    operand.push(res);
                }
            }
            else{
                operand.push(ch-'0');
            }
        }
        System.out.println(operand.peek());
    }

    public static void convertPostfixtoPrefix(String str){
        Stack<String> operand = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                if(operand.size()>0){
                    String val2 = operand.pop();
                    String val1 = operand.pop();
                    String res = ch+val1+val2;
                    operand.push(res);
                }
            }
            else{
                operand.push(ch+"");
            }
        }
        System.out.println(operand.peek());
    }

    public static void convertPostfixtoInfix(String str){
        Stack<String> operand = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                if(operand.size()>0){
                    String val2 = operand.pop();
                    String val1 = operand.pop();
                    String res = '('+val1+ch+val2+')';
                    operand.push(res);
                }
            }
            else{
                operand.push(ch+"");
            }
        }
        System.out.println(operand.peek());
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        evaluatePostfix(str);
        convertPostfixtoInfix(str);
        convertPostfixtoPrefix(str);
    }

}

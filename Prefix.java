import java.util.*;



public class Prefix {
    
    public static int solve(int v1 , int v2 , char ch){
        if(ch=='+'){
            return v1+v2;
        }
        else if(ch=='-'){
            return v1-v2;
        }
        else if(ch=='/'){
            return v1/v2;
        }
        else{
            return v1*v2;
        }
    }

    public static void  evaluatePrefix(String str){
        Stack<Integer> operand = new Stack<>();
        for(int i=str.length()-1;i>=0;i--){
            char ch = str.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/' ){
                if(operand.size()>0){
                    int v1 = operand.pop();
                    int v2 = operand.pop();
                    int res  = solve(v1,v2,ch);
                    operand.push(res);
                }
            }
            else{
                operand.push(ch-'0');
            }
        }
        System.out.println(operand.peek());
    }

    public static void convertPrefixtoPostfix(String str){
        Stack<String> operand = new Stack<>();
        for(int i=str.length()-1;i>=0;i--){
            char ch = str.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/' ){
                if(operand.size()>0){
                    String v1 = operand.pop();
                    String v2 = operand.pop();
                    String res  = v1+v2+ch;
                    operand.push(res);
                }
            }
            else{
                operand.push(ch+"");
            }
        }
        System.out.println(operand.peek());
    }
    public static void convertPrefixtoInfix(String str){
        Stack<String> operand = new Stack<>();
        for(int i=str.length()-1;i>=0;i--){
            char ch = str.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/' ){
                if(operand.size()>0){
                    String v1 = operand.pop();
                    String v2 = operand.pop();
                    String res  = '('+v1+ch+v2+')';
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
        evaluatePrefix(str);
        convertPrefixtoPostfix(str);
        convertPrefixtoInfix(str);


    }

}

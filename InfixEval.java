import java.util.*;

public class InfixEval{

    public static int priority(char ch){
        if(ch=='+' || ch=='-'){
            return 1;
        }
        else{
            return 2;
        }

    }

    public static int solve(int val1 , int val2 , char ch){
        if(ch=='-'){
            return val1-val2;
        }
        else if(ch=='+'){
            return val1+val2;
        }
        else if(ch=='/'){
            return val1/val2;
        }
        else{
            return val1*val2;
        }
    }

    public static void evaluateInfix(String str){
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('){
                operator.push(ch);
            }
            else if(ch=='+' || ch=='-' || ch=='/' || ch=='*'){
                if(operator.size()==0 || operator.peek()=='(' || priority(operator.peek())<priority(ch)){
                    operator.push(ch);
                }
                else{
                    while(operator.size()>0 && operator.peek()!='(' &&  priority(operator.peek())>=priority(ch)  ){
                        int val2 = operand.pop();
                        int val1 = operand.pop();
                        char x  = operator.pop();
                        int res = solve(val1, val2, x);
                        operand.push(res);
                    }
                    operator.push(ch);
                }
            }
            else if(ch==')'){
                while(operator.size()>0 && operator.peek()!='('   ){
                    int val2 = operand.pop();
                    int val1 = operand.pop();
                    char x  = operator.pop();
                    int res = solve(val1, val2, x);
                    operand.push(res);
                }
                operator.pop();
            }
            else if(Character.isDigit(ch)){
                operand.push(ch-'0');
            }
        }

        while(operator.size()>0){
            int val2 = operand.pop();
            int val1 = operand.pop();
            char x  = operator.pop();
            int res = solve(val1, val2, x);
            operand.push(res);
        }

        System.out.println(operand.peek());


    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        evaluateInfix(str);

    }
}
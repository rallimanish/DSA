import java.util.*;


public class InfixConversions {
        
    public static int priority(char x){
        if(x=='*' || x=='/'){
            return 2;
        }
        else{
            return 1;
        }
    }


    public static void convertInfixToPrefix(String str){

        Stack<Character> operator = new Stack<>();
        Stack<String> operand = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('){
                operator.push(ch);
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                if(operator.size()==0 || operator.peek()=='('  || priority(operator.peek())< priority(ch)  ){
                    operator.push(ch);
                }
                else{
                    while(operator.size()>0 &&  operator.peek()!='(' &&  priority(operator.peek())>= priority(ch)){
                        char x = operator.pop();
                        String val2 = operand.pop();
                        String val1 = operand.pop();
                        String res = x+val1+val2;
                        operand.push(res);
                    }
                    operator.push(ch);
                }
            }
            else if(ch==')'){
                while(operator.size()>0 &&  operator.peek()!='(' ){
                    char x = operator.pop();
                    String val2 = operand.pop();
                    String val1 = operand.pop();
                    String res = x+val1+val2;
                    operand.push(res);
                }
                operator.pop();
            }
            else{
                operand.push(ch+"");
            }
        }

        while(operator.size()>0){
                    char x = operator.pop();
                    String val2 = operand.pop();
                    String val1 = operand.pop();
                    String res = x+val1+val2;
                    operand.push(res);
        }
        System.out.println(operand.peek());
    }

    public static void convertInfixToPostfix(String str){
        
        Stack<Character> operator = new Stack<>();
        Stack<String> operand = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('){
                operator.push(ch);
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                if(operator.size()==0 || operator.peek()=='('  || priority(operator.peek())< priority(ch)  ){
                    operator.push(ch);
                }
                else{
                    while(operator.size()>0 &&  operator.peek()!='(' &&  priority(operator.peek())>= priority(ch)){
                        char x = operator.pop();
                        String val2 = operand.pop();
                        String val1 = operand.pop();
                        String res =val1+val2+x;
                        operand.push(res);
                    }
                    operator.push(ch);
                }
            }
            else if(ch==')'){
                while(operator.size()>0 &&  operator.peek()!='(' ){
                    char x = operator.pop();
                    String val2 = operand.pop();
                    String val1 = operand.pop();
                    String res = val1+val2+x;
                    operand.push(res);
                }
                operator.pop();
            }
            else{
                operand.push(ch+"");
            }
        }

        while(operator.size()>0){
                    char x = operator.pop();
                    String val2 = operand.pop();
                    String val1 = operand.pop();
                    String res = val1+val2+x;
                    operand.push(res);
        }
        System.out.println(operand.peek());
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        convertInfixToPostfix(str);
        convertInfixToPrefix(str);
    }
}

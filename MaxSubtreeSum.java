import java.util.*;


public class MaxSubtreeSum {

    public static class Node{
        int data;
        ArrayList<Node> children;

        public Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }
    }


    public static Node constructTree(Integer[] arr){
        Node root  = new Node(arr[0]);
        Stack<Node> st = new Stack<>();
        st.push(root);
        for(int i=1;i<arr.length;i++){
            if(st.size()>0 && arr[i]==null){
                st.pop();
            }
            else{
                Node nn = new Node(arr[i]);
                st.peek().children.add(nn);
                st.push(nn);
            }
        }                                                    
        return root;
     }

    public static void displayTree(Node node){
        String str = "";
        str = str+"["+node.data+"]"+" -> ";
        for(Node child : node.children){
            str = str + child.data+", ";
        }
        str = str+".";
        System.out.println(str);
        for(Node child : node.children){
            displayTree(child);
        }
    }

    public static int findMaxSubtreeSum(Node node){
        int sum = 0;
        for(int i=0;i<node.children.size();i++){
            sum = sum+findMaxSubtreeSum(node.children.get(i));
        }
        sum =sum +node.data;
        if(sum>maxsum){
            maxsum = sum;
            msn = node.data;
        }
        return sum;
    }                                                                                                                                                                                                                                                                                                                                                                                                                   

    public static int msn = 0;
    public static int maxsum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Integer[] arr = {10,20,-50,null,60,null,null,30,-70,null,80,-110,null,120,null,null,90,null,null,40,-100,null,null,null};
        Node root = constructTree(arr);
        int sum = findMaxSubtreeSum(root);
        System.out.println(sum);
        
        System.out.println(msn+"@"+maxsum);
    }
}

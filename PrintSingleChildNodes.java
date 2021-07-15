import java.util.*;


public class PrintSingleChildNodes {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data , Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    } 
    public static class Pair{
        Node node;
        int state;

        public Pair(Node node , int state){
            this.node=  node;
            this.state = state;
        }
    }
    public static Node constructTree(Integer[] arr){
        Node root = new Node(arr[0],null,null);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));

        int i=0;
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state==1){
                //Read Kiya
                i++;
                if(arr[i]==null){
                    top.state++;
                }
                else{
                    Node nn = new Node(arr[i],null,null);
                    top.node.left = nn;
                    top.state++;
                    st.push(new Pair(nn,1));
                }
            }
            else if(top.state==2){
                i++;
                if(arr[i]==null){
                    top.state++;
                }
                else{
                    Node nn = new Node(arr[i],null,null);
                    top.node.right = nn;
                    top.state++;
                    st.push(new Pair(nn,1));
                }
            }
            else if(top.state == 3){
                st.pop();
            }
        }
        return root;
    }
    
    public static void printSingleChildNodes(Node node, Node parent){
        // write your code here
        if(node==null){
            return;
        }
        if(parent!=null && parent.left==node && parent.right==null ){
            //im single left child of my parent
            System.out.println(node.data);
        }
        else if(parent!=null && parent.right==node && parent.left==null ){
            //im single right child of my parent
            System.out.println(node.data);
        }
        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
      }
      public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Scanner scn = new Scanner(System.in);
        Node root = constructTree(arr);
        printSingleChildNodes(root, null);
    }
}

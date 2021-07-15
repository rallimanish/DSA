import java.util.*;
 public class PredecessorSuccessor{
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

     public static Node predecessor;
     public static Node  successor;
     public static int state;


     public static void predecessorAndSuccessor(Node node, int data){
       if(state==0){
           if(node.data==data){
               state = 1;
           }
           else{
               predecessor = node;
           }
       }
       else if(state==1){
           successor = node;
           state=2;
       }

        for(Node child : node.children){
           
            predecessorAndSuccessor(child,data);
        }
        
     }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int data = scn.nextInt();
       
        Integer[] arr = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = constructTree(arr);
        predecessor = null;
        successor = null;
        state=0;
        predecessorAndSuccessor(root, data);
        if(predecessor == null){
            System.out.println("Predecessor = Not found");
        } else {
            System.out.println("Predecessor = " + predecessor.data);
        }

        if(successor == null){
            System.out.println("Successor = Not found");
        } else {
            System.out.println("Successor = " + successor.data);
        }

    }
 }
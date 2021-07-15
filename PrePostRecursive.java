import java.util.*;

public class PrePostRecursive{
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

    

    public static void  printTraversal(Node node){
       
        
        System.out.println("Node Pre "+node.data);
        for(Node child:node.children){
            System.out.println("Edge Pre "+node.data+"--"+child.data);
            printTraversal(child);
            System.out.println("Edge Post "+node.data+"--"+child.data);
        }

        System.out.println("Node Post "+node.data);


    }


    public static void main(String[] args){
        Integer[] arr = {10,20,null,30,50,null,60,null,null,40,null,null};
        Node root = constructTree(arr);
        printTraversal(root);
    }
}
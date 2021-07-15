import java.util.*;


public class Linearize {
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
    public static Node getTail(Node slast){
        Node tail =slast;
        while(tail.children.size()>0){
         
            tail = tail.children.get(0);
        }
        return tail;

    } 
    public static void linearize(Node node){
        for(Node child : node.children){
            linearize(child);
        }

        for(int i=node.children.size()-1;i>0;i--){
            Node last = node.children.remove(i);
            Node slast = node.children.get(i-1);
            Node tail = getTail(slast);
            tail.children.add(last);
        }
    }
     

     public static void main(String[] args){
        Integer[] arr = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = constructTree(arr);
        
        displayTree(root);
        linearize(root);
        displayTree(root);
     }
}

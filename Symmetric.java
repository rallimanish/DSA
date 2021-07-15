import java.util.*;

public class Symmetric {
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

  
    public static boolean areMirror(Node n1 ,Node n2){
        if(n1.children.size()!=n2.children.size()){
            return false;
        }
        for(int i=0,j=n2.children.size()-1;i<n1.children.size();i++,j--){
            boolean x = areMirror(n1.children.get(i),n2.children.get(j));
            if(x==false){
                return false;
            }
        }
        return true;
    }

    public static boolean IsSymmetric(Node node){
        boolean y = areMirror(node,node);
        if(y==false){
            return false;
        }
        return true;
    }
     public static void main(String[] args){
        Integer[] arr = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = constructTree(arr);
        System.out.println(IsSymmetric(root));
        
     }
}

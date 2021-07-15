import java.util.*;

public class AreMirror {
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
     
    public static boolean areTheyMirror(Node node1 , Node node2){
        if(node1.children.size()!=node2.children.size()){
            return false;
        }
        for(int i=0,j=node2.children.size()-1;i<node1.children.size() ;i++,j--){
            boolean x = areTheyMirror(node1.children.get(i), node2.children.get(j));
            if(x==false){
                return false;
            }
        }
        return true;
    }
     public static void main(String[] args){
        Integer[] arr1 = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root1 = constructTree(arr1);
        //displayTree(root1);
        Integer[] arr2 = {1,2,5,null,6,null,null,3,7,null,8,11,null,12,null,null,9,null,null,4,10,null,null,null};
        Node root2 = constructTree(arr2);
        //displayTree(root2);
        System.out.println(areTheyMirror(root1,root2));
     }
}

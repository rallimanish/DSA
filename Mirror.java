import java.util.*;


public class Mirror {
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

    public static void mirror(Node node){
        for(int i=0,j=node.children.size()-1; i<j;i++,j--){
            Node temp = node.children.get(j);
          
            node.children.set(j,node.children.get(i));
            node.children.set(i,temp);
           
        }

        for(Node child:node.children){
            mirror(child);
        }
    }
     

     public static void main(String[] args){
        Integer[] arr = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = constructTree(arr);
        System.out.println("--Before --");
        displayTree(root);
        mirror(root);
        System.out.println("--After--");
        displayTree(root);

     }
}

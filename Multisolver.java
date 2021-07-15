import java.util.*;


public class Multisolver {
    
    public static class Node{
        int data;
        ArrayList<Node> children;

        public Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public static Node constructTree(Integer[] arr){
        Node root = new Node(arr[0]);
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

    public static int size;
    public static int min;
    public static int max;
    public static int height;

    public static void multisolver(Node node , int depth){
        //Pre area mein apna kaam
        size++;
        min =   Math.min(min,node.data);
        max = Math.max(max,node.data);
        height = Math.max(height,depth);

        //Recursion call
        for(Node child : node.children){
            multisolver(child, depth+1);
        }
    }


    public static void main(String[] args){
        Integer[] arr = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = constructTree(arr);
        size=0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height=-1;
        multisolver(root,0);
        System.out.println("Size : "+size);
        System.out.println("Min : "+min);
        System.out.println("Max : "+max);
        System.out.println("Height : "+height);
    }
}

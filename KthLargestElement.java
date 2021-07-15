import java.util.*;


public class KthLargestElement {
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

   
    static int ceil;
    static int floor;

    public static void  ceilAndFloor(Node node, int data){
        if(node.data>data){
            if(node.data<ceil){
                ceil = node.data;
            }
        }
        else if(node.data<data){
            if(node.data>floor){
                floor = node.data;
            }
        }
        for(int i=0;i<node.children.size();i++){
            ceilAndFloor(node.children.get(i), data);
        }
    }

    public static int findKthLargest(Node node,int k){
        int factor =  Integer.MAX_VALUE;
        
        for(int i=0;i<k;i++){
            ceilAndFloor(node,factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;
    }
    public static void main(String[] args){
        Integer[] arr = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = constructTree(arr);
        Scanner scn =  new Scanner(System.in);
        int k=  scn.nextInt();
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
       
        int x = findKthLargest(root,k);
        System.out.println(x);
        // System.out.println("CEIL = " + ceil);
        // System.out.println("FLOOR = " + floor);
    }
}

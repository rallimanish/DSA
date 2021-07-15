import java.util.*;


public class Diameter {

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
    

    public static int findDiameter(Node node ){
        int h1=-1;
        int h2 = -1;
        for(int i=0;i<node.children.size();i++){
            int ch =  findDiameter(node.children.get(i));
            //int[] a= {10,20,30,40,15,12,33,36};
            //a[i] > max
            if(ch>h1){
                h2 = h1; //smax = max
                h1 = ch; //max = a[i]
            }
            else if(ch>h2){ //smax>a[i]
                h2 = ch;    //smax = a[i]
            }
        }
        if(h1+h2+2>diameter){
            diameter = h1+h2+2;
        }
        return h1+1;     
    }

    
    public static int diameter=Integer.MIN_VALUE;
     public static void main(String[] args) {
        Integer[] arr = {10,20,-50,null,60,null,null,30,-70,null,80,-110,null,120,null,null,90,null,null,40,-100,null,null,null};
        Node root = constructTree(arr);
        int ht  = findDiameter(root);
        System.out.println(ht);
        System.out.println(diameter);
        
    }
}

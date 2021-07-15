import java.util.*;

public class LCA {
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

     public static ArrayList<Integer> getNodeToRootPath(Node node , int data){
        if(node.data==data){
            ArrayList<Integer> x = new ArrayList<Integer>();
            x.add(node.data);
            return x;
        }

        for(Node child:node.children){
            ArrayList<Integer> res = getNodeToRootPath(child,data);
            if(res.size()>0){
                res.add(node.data);
                return res;
            }
        }

        ArrayList<Integer> empty = new ArrayList<Integer>();
        return empty;

     }

    public static int findLCA(Node node , int d1 , int d2){
        ArrayList<Integer> p1 = getNodeToRootPath(node,d1);
        ArrayList<Integer> p2 = getNodeToRootPath(node,d2);
        int i=p1.size()-1;
        int j=p2.size()-1;
      
        while(i>=0 && j>=0 &&  p1.get(i)==p2.get(j) ){
        
            i--;
            j--;
        }
        return p1.get(i+1);
    }

     public static void main(String[] args){
        Integer[] arr = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = constructTree(arr);
        Scanner scn = new Scanner(System.in);
        int d1 = scn.nextInt();
        int d2  = scn.nextInt();
        System.out.println(findLCA(root,d1,d2));

     }
}

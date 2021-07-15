
import java.util.*;

public class PathToLeafFromRootInRange {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data , Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    } 
    public static class Pair{
        Node node;
        int state;

        public Pair(Node node , int state){
            this.node=  node;
            this.state = state;
        }
    }
    public static Node constructTree(Integer[] arr){
        Node root = new Node(arr[0],null,null);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));

        int i=0;
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state==1){
                //Read Kiya
                i++;
                if(arr[i]==null){
                    top.state++;
                }
                else{
                    Node nn = new Node(arr[i],null,null);
                    top.node.left = nn;
                    top.state++;
                    st.push(new Pair(nn,1));
                }
            }
            else if(top.state==2){
                i++;
                if(arr[i]==null){
                    top.state++;
                }
                else{
                    Node nn = new Node(arr[i],null,null);
                    top.node.right = nn;
                    top.state++;
                    st.push(new Pair(nn,1));
                }
            }
            else if(top.state == 3){
                st.pop();
            }
        }
        return root;
    }
    public static void printPathToLeafFromRootInRange(Node node,int lo , int hi,String path){
        //if leaf node
        if(node.left==null && node.right==null){
            sum = sum+node.data;
            path = path+node.data+" ";
            if(sum>=lo && sum<=hi){
                //System.out.println(sum);
                System.out.println(path);
            }
           
            sum = sum-node.data;

        }
        if(node!=null){
            sum = sum+node.data;
            path= path+node.data+" ";
        }
        if(node.left!=null){
            printPathToLeafFromRootInRange(node.left, lo, hi,path);
        }
        if(node.right!=null){
            printPathToLeafFromRootInRange(node.right, lo, hi,path);
        }
        sum = sum-node.data;
        
    }
    public static int  sum=0;
    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Scanner scn = new Scanner(System.in);
        Node root = constructTree(arr);
        int lo = scn.nextInt();
        int hi = scn.nextInt();
        String path="";
        printPathToLeafFromRootInRange(root,lo,hi,path);
    }
}

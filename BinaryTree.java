import java.util.*;

public  class BinaryTree{
    
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;

        }
        public Node(int data , Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair{
          Node node;
          int state;

          public Pair(Node node,int state){
              this.node = node;
              this.state = state;
          }
    }
    public static Node constructTree(Integer[] arr){
        Node root  = new Node(arr[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,0));
        int i=0;

        while(st.size()>0){
            Pair p = st.peek();
            if(p.state ==0){
                i++;
                if(arr[i]!=null){
                    Node nn = new Node(arr[i]);
                    p.node.left = nn;
                    st.push(new Pair(nn,0));
                }
                p.state++;
            }
            else if(p.state==1){
                i++;
                if(arr[i]!=null){
                    Node nn = new Node(arr[i]);
                    p.node.right = nn;
                    st.push(new Pair(nn,0));
                }
                p.state++;
            }
            else{
                st.pop();
            }
        }

        return root;
    }

    public static void displayTree(Node root){
        if(root==null){
            return;
        }
        String str = "";
        str +=root.left==null ? ".":""+root.left.data;
        str += "<- ["+root.data+"] ->";
        str += root.right==null ? ".":""+root.right.data;
        System.out.println(str);
        displayTree(root.left);
        displayTree(root.right);
    }

    public static void main(String[] args){
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root  = constructTree(arr);
        displayTree(root);

    }

}
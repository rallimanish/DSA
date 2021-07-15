import java.util.*;


public class LevelOrderTraversal {
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

    public static void printLevelOrderTraversal(Node node){
            Queue<Node> q = new ArrayDeque<>();
            q.add(node);

            while(q.size()>0){
                int count  = q.size();
                for(int i=1;i<=count;i++){
                    Node x = q.remove();
                    if(x!=null){
                        System.out.print(x.data+" ");
                    }
                    if(x.left!=null){
                        q.add(x.left);
                    }
                    if(x.right!=null){
                        q.add(x.right);
                    }
                }
                System.out.println();
            }
    }
    public static void main(String[] args){
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root = constructTree(arr);
        printLevelOrderTraversal(root);
    }
}

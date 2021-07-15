import java.util.*;


public class FindAndNodetoRootpath {
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
    public static ArrayList<Integer> path1;
    public static boolean find(Node node, int data){
        // write your code here
        if(node==null){
            return false;
        }
        if(node.data==data){
            path1.add(node.data);
            return true;
        }
        boolean x = find(node.left,data);
        if(x==true){
            path1.add(node.data);
            return true;
        }
        boolean y = find(node.right,data);
        if(y==true){
            path1.add(node.data);
            return true;
        }
        return false;

      }
    
      public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        // write your code here
        if(node==null){
            ArrayList<Integer> empty = new ArrayList<>();
            return empty;
        }
        if(node.data==data){
            ArrayList<Integer> al = new ArrayList<>();
            al.add(node.data);
            return al;
        }
        ArrayList<Integer> lres = nodeToRootPath(node.left, data);
        if(lres.size()>0){
            lres.add(node.data);
            return lres;
        }
        ArrayList<Integer> rres = nodeToRootPath(node.right, data);
        if(rres.size()>0){
            rres.add(node.data);
            return rres;
        }
        ArrayList<Integer> b = new ArrayList<>();
        return b;
      }
    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Scanner scn = new Scanner(System.in);
        Node root = constructTree(arr);
        int data = scn.nextInt();
        path1 = new ArrayList<>();
        boolean found = find(root, data);
        System.out.println(found);

        ArrayList<Integer> path = nodeToRootPath(root, data);
        System.out.println(path);

        
    }
}

import java.util.*;




public class NodesKDistanceAway {
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
    public static ArrayList<Node> findNodeToRootPath(Node node ,int data){
        if(node==null){
            ArrayList<Node> empty = new ArrayList<>();
            return empty;
        }
        if(node.data==data){
            ArrayList<Node> al = new ArrayList<>();
            al.add(node);
            return al;
        }
        ArrayList<Node> l  =  findNodeToRootPath(node.left,data);
        if(l.size()>0){
            l.add(node);
            return l;
        }
        ArrayList<Node> r  =  findNodeToRootPath(node.right,data);
        if(r.size()>0){
            r.add(node);
            return r;
        }
        ArrayList<Node> empty = new ArrayList<>();
        return empty;

    }
    public static void findKlevelDown(Node node , Node blockage,int k){
            if(node==null){
                return;
            }
            if(k==0){
                System.out.println(node.data);
            }
            if(node.left!=blockage){
                findKlevelDown(node.left, blockage, k-1);
            }
            if(node.right!=blockage){
                findKlevelDown(node.right,blockage,k-1);
            }
    }
    public static void printKNodesFar(Node node, int data, int k) {
        // write your code here
        ArrayList<Node> path = findNodeToRootPath(node,data);
        Node blockage=null;
        for(int i=0;i<path.size();i++){
            findKlevelDown(path.get(i),blockage,k);
            blockage = path.get(i);
            k--;
        }

    }
    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Scanner scn = new Scanner(System.in);
        Node root = constructTree(arr);
        int data = scn.nextInt();
        int k = scn.nextInt();
        printKNodesFar(root,data,k);

        
    }

}

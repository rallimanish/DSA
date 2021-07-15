import java.util.*;



public class IterativePreorderPostorder {
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
    public static class Pair{
        Node node;
        int state;
        public Pair(Node node , int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void printIterativePreandPostOrder(Node node) {
        // write your code here
        Stack<Pair> st = new Stack<>();
        String pre ="";
        String post = "";
        st.push(new Pair(node,-1));
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state==-1){
                pre = pre+top.node.data+" ";
                top.state++;
            }
            else if(top.state==top.node.children.size()){
                post = post+top.node.data+" ";
                st.pop();
            }
            else{
                Node child = top.node.children.get(top.state);
                st.push(new Pair(child,-1));
                top.state++;
            }
        }
        System.out.println(pre);
        System.out.println(post);
      }
    public static void main(String[] args){
        Integer[] arr = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = constructTree(arr);
        printIterativePreandPostOrder(root);
    }
}

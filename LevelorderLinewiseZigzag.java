import java.util.*;


public class LevelorderLinewiseZigzag {
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

 
     
    public static void printLevelorderLinewiseZigzag(Node node){
        Queue<Node> q = new ArrayDeque<>();
        Stack<Node> st = new Stack<>();
        int l=1;
        q.add(node);
        while(q.size()>0){
            int sz  = q.size();
            for(int i=0;i<sz;i++){
                Node x = q.remove();
                if(l%2!=0){
                    System.out.print(x.data+" ");
                    for(Node child : x.children){
                        st.add(child);
                    }
                }
                else{
                    Node y = st.pop();
                    System.out.print(y.data+" ");
                }
                
                for(Node child : x.children){
                    q.add(child);
                }
            }
            System.out.println();
            l++;
        }
        

    }
     public static void main(String[] args){
        Integer[] arr = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = constructTree(arr);
        printLevelorderLinewiseZigzag(root);

     } 
}

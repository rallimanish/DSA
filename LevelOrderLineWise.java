import java.util.*;


public class LevelOrderLineWise {
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

 
     
    public static void printLevelOrderLinewise(Node node){
        //Using two queue
        // Queue<Node> mq = new ArrayDeque<>();
        // Queue<Node> cq = new ArrayDeque<>();
        // mq.add(node);

        // while(mq.size()>0){
            
        //     //get print pop
        //     Node x = mq.remove();
        //     System.out.print(x.data+" ");

        //     //add children
        //     for(Node child : x.children){
        //         cq.add(child);
        //     }

        //     //if mq is empty then swap it with cq
        //     if(mq.size()==0){
        //         Queue<Node> temp = mq;
        //         mq = cq;
        //         cq = temp;
        //         System.out.println();
        //     }
        // }

        //using a single queue
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        while(q.size()>0){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                Node x = q.remove();
                System.out.print(x.data+" ");
                for(Node child : x.children){
                    q.add(child);
                }
               
            }
            System.out.println();
        }
        

    }
     public static void main(String[] args){
        Integer[] arr = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = constructTree(arr);
        printLevelOrderLinewise(root);

     }    
}

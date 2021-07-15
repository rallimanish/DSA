import java.util.*;


public class CountBinaryStrings {

    public static void printBinaryString(int l, int n, int lav, String asf){
        if(l==n){
            System.out.println(asf);
            return;
        }

        if(lav==0){
                printBinaryString(l+1, n, 1, asf+"1");
        }
        if(lav==1){
            printBinaryString(l+1, n,0, asf+"0");
            printBinaryString(l+1, n,1, asf+"1");
        }
    }

    public 


    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printBinaryString(0, n,1,"");
    }    
}

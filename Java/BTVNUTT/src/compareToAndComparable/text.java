package compareToAndComparable;

import java.util.Arrays;

public class text {
    public static int[] reverse(int[] x){
        int[] rs = new int[x.length];
        int index =0;
        for(int i=x.length-1;i>=0;i--){
            rs[index]=x[i];
            index++;
        }
        return rs;
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,8,2,6,3,7,9,4};
        int[] b = new int[15];
        System.out.println("arr: "+ Arrays.toString(a));
        // ham sap xep tang dan
        Arrays.sort(a);
        System.out.println("arr sau khi sap xep: "+Arrays.toString(a));

        //ham tim kiem
        System.out.println(Arrays.binarySearch(a,4));
        System.out.println(Arrays.binarySearch(a,-1));

        // ham dien gia tri
        Arrays.fill(b,5);
        System.out.println("b sau khi dien gia tri: "+Arrays.toString(b));

        // ham sap xep giam dan
        Arrays.sort(a);
        a=reverse(a);
        System.out.println("a sau khi giam gian: "+Arrays.toString(a));



    }
}

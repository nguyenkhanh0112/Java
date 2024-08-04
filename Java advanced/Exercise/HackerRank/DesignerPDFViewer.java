package Exercise.HackerRank;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesignerPDFViewer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> h = new ArrayList<>();
        for (int i=0;i<26;i++){
            int number = sc.nextInt();
            h.add(number);
        }
        for (int c:h) {
            System.out.print(c+" ");
        }
        String word = sc.next();
        int area1 = area(word,h);
        System.out.println(area1);
    }
     public static int area(String word,ArrayList<Integer> h){
        int maxheight =0;
        for (char c:word.toCharArray()) {
            int index = c -'a';
            maxheight = Math.max(maxheight,h.get(index));
        }
        return maxheight*1*word.length();
    }
}

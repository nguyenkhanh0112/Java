package Exercise.HackerRank;



import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Arrarylist1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = sc.nextInt();
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                int a = sc.nextInt();
                row.add(a);
            }
            data.add(row);
        }
//        int numQueries = sc.nextInt();
//        for (int i = 0; i < numQueries; i++) {
//            int lineIndex = sc.nextInt();
//            int position = sc.nextInt();
//
//            // Check if the line index is valid
//            if (lineIndex >= 1 && lineIndex <= n) {
//                ArrayList<Integer> line = data.get(lineIndex - 1);
//                // Check if the position is valid
//                if (position >= 1 && position <= line.size()) {
//                    // Print the number at the specified position
//                    System.out.println(line.get(position - 1));
//                } else {
//                    System.out.println("ERROR!");
//                }
//            } else {
//                System.out.println("ERROR!");
//            }
//        }
        Logger logger = Logger.getLogger(Arrarylist1.class.getName());
        int sizeQuery = sc.nextInt();
        for (int i= 0;i<sizeQuery;i++){
            int x = sc.nextInt();
            int y =sc.nextInt();
            if(x>=1 && x <=n){
                ArrayList<Integer> line = data.get(x-1);
                if(y>=1&&y<=line.size()){
                    System.out.println(line.get(y-1));
                }else{
                    System.out.println("ERROR!");
                };
            }else{
                System.out.println("ERROR!");
            }
        }
    }

}

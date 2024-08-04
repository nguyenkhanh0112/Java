package QueueAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ViduDueue {
    public static void main(String[] args) {
        Deque<String> danhSachVN = new ArrayDeque<String>();
        danhSachVN.offer("Adonis Feed");
        danhSachVN.offer("Phe bung");
        danhSachVN.offer("Nguyen Van Khanh");
        danhSachVN.offerFirst("11");
        danhSachVN.offerLast("20");

        while(true){
            String ten = danhSachVN.poll();
            if(ten ==null)
                break;
            System.out.println(ten);
        }

    }
}

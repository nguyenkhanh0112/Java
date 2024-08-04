package QueueAndDeque;

import java.util.PriorityQueue;
import java.util.Queue;

public class ViduPriorityQueue {
    public static void main(String[] args) {
        Queue<String> danhSachSV = new PriorityQueue<String>();
        danhSachSV.offer("Nguyen van khanh");
        danhSachSV.offer("phe bung");
        danhSachSV.offer("Adonis Feed");

        while(true){
            String ten = danhSachSV.poll();// ham lay ra va xoa
            // ham peek lay ra nhung khong xoa
            if(ten==null){
                break;
            }
            System.out.println(ten);
        }
    }
}

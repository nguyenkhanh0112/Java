package QueueAndDeque;

import java.util.LinkedList;
import java.util.Queue;

public class ViduQueue {
    public static void main(String[] args) {
     /*
     một số phương thức thường được sử dụng cua Queue interface là:
     + add()- chèn phần tử đã chỉ định vào hàng đợi.Nếu tác vụ thành công,add(
        trả về true , nếu không nó xẽ ném ra một ngoại lệ
    +offer()- chen phan tử đã ch định vaào hàng đợi. nếu tác vụ thành công  offer() return true
        , neu khong no se return false.
    + element()-return first của quêu. nem mot ngoai le neu hang doi trong.
    +peek()-return first,return null neu hang doi rong
    +remove() return va close phan dau cua hang doi. nem mot ngoai le neu hang doi trong
    +poll()-return and loai bo phan dau cua hang doi .return null neu han doi trong.

    DQueue
    nhung dqueue co 2 dau nen ta co the addFirst() and addLast()
    */
        Queue<String> danhSachSV = new LinkedList<String>();
        danhSachSV.offer("Adonis Feed");
        danhSachSV.offer("Nguyen van khanh");
        danhSachSV.offer("phe bung");

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
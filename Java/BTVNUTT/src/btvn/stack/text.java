package btvn.stack;

import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        Stack stack =new Stack();
        int luachon=0;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Stack");
            System.out.println("1.Push(đây một phần từ vào mảng)");
            System.out.println("2.Pop(lấy phần từ trên đỉnh ngăn xếp rồi xóa)");
            System.out.println("3.isEmpty(kiểm tra rỗng)");
            System.out.println("4.numOfElement(trả về số lượng hiện có của ngăn xếp)");
            System.out.println("5.search(tim kiem trả về chỉ số trong stack)");
            System.out.println("6.display(in danh sách ra màn hình)");
            System.out.println("0.exit program");

            luachon =sc.nextInt();
            if(luachon==1){
                System.out.println("Nhập phần tử cần thêm ");
                int x=sc.nextInt();
                stack.push(x);
            }else if(luachon==2){
                System.out.println("Phần từ trên đỉnh ngăn xếp: "+stack.pop());
            }else if(luachon==3){
                if(stack.isEmpty())
                    System.out.println("stack rỗng");
                else
                    System.out.println("stack không rỗng");
            }else if(luachon==4){
                System.out.println("số phần tử hiện có trong ngăn xếp: "+stack.numOfElement());
            }else if(luachon==5){
                System.out.println("Nhập phàn tử cần tìm");
                int x = sc.nextInt();
                System.out.println("Chỉ số của phần tử "+x+" là: "+stack.search(x));
            }else if(luachon==6){
                System.out.println("Danh sách các phần tử có trong ngăn xếp là: ");
                stack.display();
            }else if(luachon==0)
                break;
        }
    }
}

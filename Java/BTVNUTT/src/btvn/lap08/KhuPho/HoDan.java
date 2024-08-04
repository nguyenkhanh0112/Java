package btvn.lap08.KhuPho;

    /*
Câu 1:
Để quản lý các hộ dân trong một khu phố, người ta quản lý các thông tin
như sau:
- Với mỗi hộ dân, có các thuộc tính:
+ Số thành viên trong hộ ( số người)
+ Số nhà của hộ dân đó. ( Số nhà được gắn cho mỗi hộ dân)
+ Thông tin về mỗi cá nhân trong hộ gia đình.
- Với mỗi cá nhân, người ta quản lý các thông tin như: họ và tên, tuổi,
năm sinh, nghề nghiệp.
1. Hãy xây dựng lớp Nguoi để quản lý thông tin về mỗi cá nhân.
2. Xây dựng lớp KhuPho để quản lý thông tin về các hộ gia đình.
3. Viết các phương thức nhập, hiển thị thông tin cho mỗi cá nhân.
4. Cài đặt chương trình thực hiện các công việc sau:
- Nhập vào một dãy gồm n hộ dân (n - nhập từ bàn phím).
- Hiển thị ra màn hình thông tin về các hộ trong khu phố.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoDan {

    private int thanhVien;
    private int soNha;
    private List<Nguoi> nguoiList = new ArrayList<Nguoi>();
    public HoDan(){}

    public int getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(int thanhVien) {
        this.thanhVien = thanhVien;
    }

    public int getSoNha() {
        return soNha;
    }

    public void setSoNha(int soNha) {
        this.soNha = soNha;
    }

    public void nhapThongTin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số nhà cho hộ: ");
        this.soNha = sc.nextInt();
        System.out.println("Nhập số lượng thành vien trong hộ: ");
        this.thanhVien = sc.nextInt();
        System.out.println("----Nhập thông tin về mỗi cá nhân trong hộ gia đình---- ");
        for(int i=0;i<thanhVien;i++){
            System.out.println("Nhập thông tin cho cá nhân thứ: "+(i+1));
            Nguoi nguoi = new Nguoi();
            nguoi.nhapThongTinCaNhan();
            nguoiList.add(nguoi);
        }
    }
    public void xuatThongTin(){
        System.out.println("Số nhà: "+soNha);
        System.out.println("Số Thành viên: "+thanhVien);
        System.out.println("Thông tin về các cá nhân trong hộ: ");
        for (Nguoi nguoi:nguoiList) {
            System.out.println(nguoi);
        }
        System.out.println("---------------------");
    }
}

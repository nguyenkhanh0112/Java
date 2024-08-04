package btvn.lap08.KhuPho;

import java.util.Scanner;

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
public class CaNhan {
    private String hoVaTen;
    private int tuoi;
    private int namSinh;
    private String ngheNghiep;

    public CaNhan() {
    }

    public CaNhan(String hoVaTen, int tuoi, int namSinh, String ngheNghiep) {
        this.hoVaTen = hoVaTen;
        this.tuoi = tuoi;
        this.namSinh = namSinh;
        this.ngheNghiep = ngheNghiep;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }
    public void nhapThongTinCaNhan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập họ và tên: ");
        this.hoVaTen = sc.nextLine();
        System.out.println("Nhập tuổi: ");
        this.tuoi = sc.nextInt();
        System.out.println("Nhập năm sinh: ");
        this.namSinh = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập nghề nghiệp: ");
        this.ngheNghiep= sc.nextLine();
    }

    @Override
    public String toString() {
        return "CaNhan{" +
                "hoVaTen='" + hoVaTen + '\'' +
                ", tuoi=" + tuoi +
                ", namSinh=" + namSinh +
                ", ngheNghiep='" + ngheNghiep + '\'' +
                '}';
    }
}

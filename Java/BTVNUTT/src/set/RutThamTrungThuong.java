package set;

import java.util.*;

public class RutThamTrungThuong {
    Set<String> thungHopPhieuDuThua = new HashSet<String>();

    public RutThamTrungThuong() {}
    public boolean themMaDuThuong(String giatri){
        return this.thungHopPhieuDuThua.add(giatri);
    }
    public boolean xoaMaDuThuong(String giatri){
        return this.thungHopPhieuDuThua.remove(giatri);
    }

    public boolean kiemTra(String giatri){
        return this.thungHopPhieuDuThua.contains(giatri);
    }
    public void xoaTatca(){
        this.thungHopPhieuDuThua.clear();
    }
    public int Size(){
        return this.thungHopPhieuDuThua.size();
    }
    public String rutMotPhieu(){
        Random rand = new Random();
        String ketQua= "";
        int index = rand.nextInt(this.thungHopPhieuDuThua.size());
        ketQua=(String)this.thungHopPhieuDuThua.toArray()[index];
        return ketQua;
    }
    public void inTatCa(){
        System.out.println(Arrays.toString(this.thungHopPhieuDuThua.toArray()));
    }
    public static void main(String[] args) {
        int luachon=0;
        Scanner sc = new Scanner(System.in);
        RutThamTrungThuong ruttham = new RutThamTrungThuong();
        while(true){
            System.out.println("---------------------------");
            System.out.println("MENU: ");
            System.out.println("1. Them ma so du phong");
            System.out.println("2. Xoa ma so du phong");
            System.out.println("3. Kiem tra ma so du thuong co ton tai hay khong ");
            System.out.println("4. Xoa tat cac cac phieu du thuong ");
            System.out.println("5. So luong phieu du phong ");
            System.out.println("6. Rut tham trung thuong");
            System.out.println("7. In ra tat ca cac phieu");
            System.out.println("0. Thoat khoi chuong trinh ");
            luachon =sc.nextInt();
            sc.nextLine();
            if(luachon==1||luachon==2||luachon==3) {
                System.out.println("Nhap vao ma so du thuong: ");
                String giatri = sc.nextLine();
                if(luachon==1)
                    ruttham.themMaDuThuong(giatri);
                else if(luachon==2)
                    ruttham.xoaMaDuThuong(giatri);
                else if(luachon==3){
                    System.out.println("ket qua kiem tra : "+ruttham.kiemTra(giatri));
                }
            }else if(luachon==4){
                ruttham.xoaTatca();
            }else if(luachon==5){
                System.out.println("so luong phieu du thuong con lai la: "+ruttham.Size());
            }else if(luachon==6){
                System.out.println("ma so trung thuong la: "+ruttham.rutMotPhieu());
            }else if(luachon==7){
                System.out.println("Cac ma phieu du thuong la: ");
                ruttham.inTatCa();
            }else if(luachon==0){
                break;
            }
        }
    }
}

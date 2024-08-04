package model;

import view.ThucDonView;

import java.util.StringTokenizer;

public class ThucDonModel {
    private String luachon_MonChinh;
    private String luachon_MonPhu;
    private double tongTien;

    public ThucDonModel(){
        this.luachon_MonChinh="";
        this.luachon_MonPhu="";
        this.tongTien = 0;
    }
    public ThucDonModel(String luachon_MonChinh,String luachon_MonPhu,double tongTien) {
        this.tongTien=tongTien;
        this.luachon_MonChinh= luachon_MonChinh;
        this.luachon_MonPhu = luachon_MonPhu;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getLuachon_MonPhu() {
        return luachon_MonPhu;
    }

    public void setLuachon_MonPhu(String luachon_MonPhu) {
        this.luachon_MonPhu = luachon_MonPhu;
    }

    public String getLuachon_MonChinh() {
        return luachon_MonChinh;
    }

    public void setLuachon_MonChinh(String luachon_MonChinh) {
        this.luachon_MonChinh = luachon_MonChinh;
    }

    public void tinhtongtien() {
        this.tongTien = 0;
        if(this.luachon_MonChinh.equals("Cơm"))
            tongTien+=20000;
        else if(this.luachon_MonChinh.equals("Phở"))
            tongTien+=20000;
        else if(this.luachon_MonChinh.equals("Bánh Mì"))
            tongTien+=15000;
        StringTokenizer stk = new StringTokenizer(this.luachon_MonPhu,";");
        while (stk.hasMoreElements()){
            String monPhu = stk.nextToken();
            monPhu = monPhu.trim();
            if(monPhu.equals("Trà sữa"))
                tongTien+=5000;
            else if(monPhu.equals("Bánh Ngọt"))
                tongTien+=5000;
            else if(monPhu.equals("cocacola"))
                tongTien+=7000;
            else if (monPhu.equals("Nem"))
                tongTien+=3000;
            else if (monPhu.equals("sữa"))
                tongTien+=6000;
            else if(monPhu.equals("Trà hoa quả"))
                tongTien+=9000;
            else if(monPhu.equals("Xúc xíc"))
                tongTien+=7000;
            else if (monPhu.equals("Kem"))
                tongTien+=4000;
        }
    }
}

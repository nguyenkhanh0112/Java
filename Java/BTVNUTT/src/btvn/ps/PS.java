package btvn.ps;

public class PS {
    private int tu;
    private int mau;

    public PS(){
        this.tu=0;
        this.mau=1;
    }
    public PS(int tu,int mau){
        this.tu=tu;
        this.mau=mau;
    }

    public int getMau() {
        return mau;
    }

    public void setMau(int mau) {
        this.mau = mau;
    }

    public int getTu() {
        return tu;
    }

    public void setTu(int tu) {
        this.tu = tu;
    }
    public int gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    public void rutGonPS(){
        int i=gcd(tu,mau);
        this.setTu(this.getTu()/i);
        this.setMau(this.getMau()/i);
    }

    public void congPS(PS ps){
        int tu = this.getTu()*ps.getMau()+this.getMau()* ps.getTu();
        int mau = this.getMau()*ps.getMau();
        PS tongPS = new PS(tu,mau);
        tongPS.rutGonPS();
        System.out.println("Tong 2 PS la: "+tongPS.getTu()+" / "+tongPS.getMau());
    }
    public void truPS(PS ps){
        int tu = this.getTu()*ps.getMau()-this.getMau()* ps.getTu();
        int mau = this.getMau()*ps.getMau();
        PS hieuPS = new PS(tu,mau);
        hieuPS.rutGonPS();
        System.out.println("Hieu 2 PS la: "+hieuPS.getTu()+" / "+hieuPS.getMau());
    }
    public void nhanPS(PS ps){
        int tu = this.getTu()* ps.getTu();
        int mau = this.getMau()*ps.getMau();
        PS tichPS = new PS(tu,mau);
        tichPS.rutGonPS();
        System.out.println("Tich 2 PS la: "+tichPS.getTu()+" / "+tichPS.getMau());
    }
    public void chiaPS(PS ps){
        int tu = this.getTu()* ps.getMau();
        int mau = this.getMau()*ps.getTu();
        PS thuongPS = new PS(tu,mau);
        thuongPS.rutGonPS();
        System.out.println("Thuong 2 PS la: "+thuongPS.getTu()+" / "+thuongPS.getMau());
    }



}

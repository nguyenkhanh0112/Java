package dtos;

public class CTChuyenNganh {
    private int MACTCN;
    private String MACN;
    private String MAMH;

    public CTChuyenNganh() {
        
    }
    
    public CTChuyenNganh(int MACTCN, String MACN, String MAMH) {
        this.MACTCN = MACTCN;
        this.MACN = MACN;
        this.MAMH = MAMH;
    }

    public int getMACTCN() {
        return MACTCN;
    }

    public void setMACTCN(int MACTCN) {
        this.MACTCN = MACTCN;
    }

    public String getMACN() {
        return MACN;
    }

    public void setMACN(String MACN) {
        this.MACN = MACN;
    }

    public String getMAMH() {
        return MAMH;
    }

    public void setMAMH(String MAMH) {
        this.MAMH = MAMH;
    }
}


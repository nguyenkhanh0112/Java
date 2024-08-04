package businesslogiclayer;

import java.sql.ResultSet;

import dataaccesslayer.XULYHOCPHIDAO;

public class XULYHOCPHIBUS {
    private XULYHOCPHIDAO dao = new XULYHOCPHIDAO();

    public ResultSet GetDataHocPhi(String MASV) {
        return dao.getDataHocPhi(MASV);
    }

    public ResultSet GetDataTongHocPHi(String MASV) {
        return dao.getDataTongHocPhi(MASV);
    }

    public ResultSet GetDataByHOCKY(String MASV, int HOCKY) {
        return dao.getDataByHOCKY(MASV, HOCKY);
    }

    public ResultSet GetAllDataHocPhi(String MAKHOA, String MACN, String MALOP) {
        return dao.getAllDataHocPhi(MAKHOA, MACN, MALOP);
    }

    public ResultSet GetAllDataTongHocPhi(String MAKHOA, String MACN, String MALOP) {
        return dao.getAllDataTongHocPhi(MAKHOA, MACN, MALOP);
    }

    public ResultSet GetAllDataNoHocPhi(String MAKHOA, String MACN, String MALOP) {
        return dao.getAllDataNoHocPhi(MAKHOA , MACN, MALOP);
    }
}

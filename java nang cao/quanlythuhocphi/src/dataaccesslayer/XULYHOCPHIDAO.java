package dataaccesslayer;

import java.sql.ResultSet;

public class XULYHOCPHIDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getDataHocPhi(String MASV) {
        Object[] param = { MASV };
        return _dbConnect.getData("sp_XULYHOCPHI_all", param);
    }

    public ResultSet getDataTongHocPhi(String MASV) {
        Object[] param = { MASV };
        return _dbConnect.getData("sp_XULYHOCPHI_sum_all", param);
    }

    public ResultSet getDataByHOCKY(String MASV, int HOCKY) {
        Object[] param = { MASV, HOCKY };
        return _dbConnect.getData("sp_XULYHOCPHI_select_byhocky", param);
    }

    public ResultSet getAllDataHocPhi(String MAKHOA, String MACN, String MALOP) {
        Object[] param = { MAKHOA, MACN, MALOP };
        return _dbConnect.getData("sp_XULYHOCPHI_ds_all", param);
    }

    public ResultSet getAllDataTongHocPhi(String MAKHOA, String MACN, String MALOP) {
        Object[] param = { MAKHOA, MACN, MALOP };
        return _dbConnect.getData("sp_XULYHOCPHI_ds_sum_all", param);
    }

    public ResultSet getAllDataNoHocPhi(String MAKHOA, String MACN, String MALOP) {
        Object[] param = { MAKHOA, MACN, MALOP };
        return _dbConnect.getData("sp_XULYHOCPHI_ds_nohp_all", param);
    }
}

package dataaccesslayer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CHUONGTRINHHOCDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData(String MASV) throws SQLException {
        Object[] param = { MASV };
        return _dbConnect.getData("sp_CHUONGTRINHHOC_select_all", param);
    }

    public ResultSet getData(String MASV, int HOCKY) throws SQLException {
        Object[] param = { MASV, HOCKY };
        return _dbConnect.getData("sp_CHUONGTRINHHOC_find_hocky", param);
    }

    public ResultSet getDataByTenMH(String MASV, String TENMH) throws SQLException {
        Object[] param = { MASV, TENMH };
        return _dbConnect.getData("sp_CHUONGTRINHHOC_find_tenmh", param);
    }

    public ResultSet getDataByTenMH(String MASV, String TENMH, int HOCKY) throws SQLException {
        Object[] param = { MASV, TENMH, HOCKY };
        return _dbConnect.getData("sp_CHUONGTRINHHOC_find_tenmh_by_hocky", param);
    }

    public ResultSet getDataByChuyenNganh(String MACN) throws SQLException {
        Object[] param = { MACN };
        return _dbConnect.getData("sp_CHUONGTRINHHOC_by_chuyennganh", param);
    }

    public ResultSet findByTenMHandChuyenNganh(String MACN, String TENMH) throws SQLException {
        Object[] param = { MACN, TENMH };
        return _dbConnect.getData("sp_CHUONGTRINHHOC_find_by_tenmh_chuyennganh", param);
    }

    public ResultSet getDataNotInChuyenNganh(String MACN) throws SQLException {
        Object[] param = { MACN };
        return _dbConnect.getData("sp_CHUONGTRINHHOC_not_in_chuyennganh", param);
    }

    public ResultSet findByTenMHNotInChuyenNganh(String MACN, String TENMH) throws SQLException {
        Object[] param = { MACN, TENMH };
        return _dbConnect.getData("sp_CHUONGTRINHHOC_find_by_tenmh_not_in_chuyennganh", param);
    }
}

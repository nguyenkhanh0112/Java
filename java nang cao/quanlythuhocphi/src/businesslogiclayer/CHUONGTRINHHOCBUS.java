package businesslogiclayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import dataaccesslayer.CHUONGTRINHHOCDAO;

public class CHUONGTRINHHOCBUS {
    private CHUONGTRINHHOCDAO dao = new CHUONGTRINHHOCDAO();

    public ResultSet GetData(String MASV) throws SQLException {
        return dao.getData(MASV);
    }

    public ResultSet GetData(String MASV, int HOCKY) throws SQLException {
        return dao.getData(MASV, HOCKY);
    }

    public ResultSet GetDataByTenMH(String MASV, String TENMH) throws SQLException {
        return dao.getDataByTenMH(MASV, TENMH);
    }

    public ResultSet GetDataByTenMH(String MASV, String TENMH, int HOCKY) throws SQLException {
        return dao.getDataByTenMH(MASV, TENMH, HOCKY);
    }

    public ResultSet GetDataByChuyenNganh(String MACN) throws SQLException {
        return dao.getDataByChuyenNganh(MACN);
    }

    public ResultSet FindByTenMHandChuyenNganh(String MACN, String TENMH) throws SQLException {
        return dao.findByTenMHandChuyenNganh(MACN, TENMH);
    }

    public ResultSet GetDataNotInChuyenNganh(String MACN) throws SQLException {
        return dao.getDataNotInChuyenNganh(MACN);
    }

    public ResultSet FindByTenMHNotInChuyenNganh(String MASV, String TENMH) throws SQLException {
        return dao.findByTenMHNotInChuyenNganh(MASV, TENMH);
    }
}

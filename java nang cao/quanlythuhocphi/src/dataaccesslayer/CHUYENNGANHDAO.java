package dataaccesslayer;

import java.sql.ResultSet;

import dtos.ChuyenNganh;

public class CHUYENNGANHDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData() {
        String sql = "sp_CHUYENNGANH_select_all";
        return _dbConnect.getData(sql);
    }

    public ResultSet getDataByID(String ID) {
        String sql = "sp_CHUYENNGANH_select_macn";
        Object[] param = {ID};
        return _dbConnect.getData(sql, param);
    }

    public ResultSet getDataByMAKHOA(String MAKHOA) {
        String sql = "sp_CHUYENNGANH_select_by_makhoa";
        Object[] param = {MAKHOA};
        return _dbConnect.getData(sql, param);
    }

    public int insert(ChuyenNganh obj) {
        String sql = "sp_CHUYENNGANH_insert";
        Object[] param = {obj.getMaCN(), obj.getTenCN(), obj.getMaKhoa()};
        return _dbConnect.executeSQL(sql, param);
    }

    public int update(ChuyenNganh obj) {
        String sql = "sp_CHUYENNGANH_update";
        Object[] param = {obj.getMaCN(), obj.getTenCN(), obj.getMaKhoa()};
        return _dbConnect.executeSQL(sql, param);
    }

    public int delete(String ID) {
        String sql = "sp_CHUYENNGANH_delete";
        Object[] param = {ID};
        return _dbConnect.executeSQL(sql, param);
    }
}

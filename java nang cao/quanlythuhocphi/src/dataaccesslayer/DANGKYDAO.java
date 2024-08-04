package dataaccesslayer;

import java.sql.ResultSet;

import dtos.DangKy;

public class DANGKYDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData() {
        return _dbConnect.getData("sp_DANGKY_select_all", null);
    }

    public ResultSet getDataByID(int ID) {
        Object[] param = {ID};
        return _dbConnect.getData("sp_DANGKY_select_madk", param);
    }

    public ResultSet getDataByMASV(String MASV) {
        Object[] param = {MASV};
        return _dbConnect.getData("sp_DANGKY_select_masv", param);
    }

    public ResultSet getDataByMASVandHOCKY(DangKy obj) {
        Object[] param = {obj.getMASV(), obj.getHocKy()};
        return _dbConnect.getData("sp_DANGKY_select_masv_hocky", param);
    }

    public ResultSet getDataSTTMaDK() {
        return _dbConnect.getData("SELECT IDENT_CURRENT('DANGKY') + 1", null);
    }

    public int insert(DangKy obj) {
        Object[] param = {obj.getMASV(), obj.getHocKy()};
        return _dbConnect.executeSQL("sp_DANGKY_insert", param);
    }

    public int update(DangKy obj) {
        Object[] param = {obj.getMADK(), obj.getMASV(), obj.getHocKy()};
        return _dbConnect.executeSQL("sp_DANGKY_update", param);
    }

    public int delete(int ID) {
        Object[] param = {ID};
        return _dbConnect.executeSQL("sp_DANGKY_delete", param);
    }
}

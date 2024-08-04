package dataaccesslayer;

import java.sql.ResultSet;

import dtos.GiangVien;

public class GIANGVIENDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData() {
        return _dbConnect.getData("sp_GIANGVIEN_select_all", null);
    }

    public ResultSet getDataByID(String ID) {
        Object[] param = { ID };
        return _dbConnect.getData("sp_GIANGVIEN_select_magv", param);
    }

    public ResultSet getDataByChuyenNganh(String MACN) {
        Object[] param = { MACN };
        return _dbConnect.getData("sp_GIANGVIEN_select_by_chuyennganh", param);
    }

    public int insert(GiangVien obj) {
        Object[] param = { obj.getMaGV(), obj.getMaKhoa(), obj.getHo(), obj.getTen(), obj.getHocHam() };
        return _dbConnect.executeSQL("sp_GIANGVIEN_insert", param);
    }

    public int update(GiangVien obj) {
        Object[] param = { obj.getMaGV(), obj.getMaKhoa(), obj.getHo(), obj.getTen(), obj.getHocHam() };
        return _dbConnect.executeSQL("sp_GIANGVIEN_update", param);
    }

    public int delete(String ID) {
        Object[] param = { ID };
        return _dbConnect.executeSQL("sp_GIANGVIEN_delete", param);
    }
}

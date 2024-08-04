package dataaccesslayer;

import java.sql.ResultSet;

import dtos.PhieuThu;

public class PHIEUTHUDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData() {
        return _dbConnect.getData("sp_PHIEUTHU_select_all", null);
    }

    public ResultSet getDataByID(int ID) {
        Object[] param = { ID };
        return _dbConnect.getData("sp_PHIEUTHU_select_mapt", param);
    }

    public ResultSet getDataByMASV(String MASV) {
        Object[] param = { MASV };
        return _dbConnect.getData("sp_PHIEUTHU_select_masv", param);
    }

    public ResultSet getDataByMaSVandHK(String MASV, int HOCKY) {
        Object[] param = { MASV, HOCKY };
        return _dbConnect.getData("sp_PHIEUTHU_select_masv_hocky", param);
    }

    public ResultSet getDataSTTPT() {
        return _dbConnect.getData("SELECT IDENT_CURRENT('PHIEUTHU') + 1", null);
    }

    public int insert(PhieuThu obj) {
        Object[] param = { obj.getMaSV(), obj.getNienKhoa(), obj.getHocKy() };
        return _dbConnect.executeSQL("sp_PHIEUTHU_insert", param);
    }

    public int update(PhieuThu obj) {
        Object[] param = { obj.getMaPT(), obj.getMaSV(), obj.getNienKhoa(), obj.getHocKy() };
        return _dbConnect.executeSQL("sp_PHIEUTHU_update", param);
    }

    public int delete(int ID) {
        Object[] param = { ID };
        return _dbConnect.executeSQL("sp_PHIEUTHU_delete", param);
    }
}

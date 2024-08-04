package dataaccesslayer;

import java.sql.ResultSet;

import dtos.Khoa;

public class KHOADAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData() {
        return _dbConnect.getData("sp_KHOA_select_all");
    }

    public ResultSet getDataByID(String ID) {
        Object[] param = {ID};
        return _dbConnect.getData("sp_KHOA_select_makhoa", param);
    }

    public int insert(Khoa obj) {
        Object[] param = {obj.getMaKhoa(), obj.getTenKhoa(), obj.getDonGia()};
        return _dbConnect.executeSQL("sp_KHOA_insert", param);
    }

    public int update(Khoa obj) {
        Object[] param = {obj.getMaKhoa(), obj.getTenKhoa(), obj.getDonGia()};
        return _dbConnect.executeSQL("sp_KHOA_update", param);
    }

    public int delete(String ID) {
        Object[] param = {ID};
        return _dbConnect.executeSQL("sp_KHOA_delete", param);
    }
}

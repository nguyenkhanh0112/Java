package dataaccesslayer;

import java.sql.ResultSet;

import dtos.NguoiDung;

public class NGUOIDUNGDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData() {
        return _dbConnect.getData("sp_NGUOIDUNG_select_all", null);
    }

    public ResultSet getDataByID(String ID) {
        Object[] param = { ID };
        return _dbConnect.getData("sp_NGUOIDUNG_select_tentaikhoan", param);
    }

    public int insert(NguoiDung obj) {
        Object[] param = { obj.getTenTaiKhoan(), obj.getMatKhau(), obj.getQuyen() };
        return _dbConnect.executeSQL("sp_NGUOIDUNG_insert", param);
    }

    public int update(NguoiDung obj) {
        Object[] param = { obj.getTenTaiKhoan(), obj.getMatKhau(), obj.getQuyen() };
        return _dbConnect.executeSQL("sp_NGUOIDUNG_update", param);
    }

    public int delete(String ID) {
        Object[] param = { ID };
        return _dbConnect.executeSQL("sp_NGUOIDUNG_delete", param);
    }
}

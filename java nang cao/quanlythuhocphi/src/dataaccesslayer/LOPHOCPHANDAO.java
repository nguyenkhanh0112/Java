package dataaccesslayer;

import java.sql.ResultSet;

import dtos.LopHocPhan;

public class LOPHOCPHANDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData() {
        return _dbConnect.getData("sp_LOPHOCPHAN_select_all", null);
    }

    public ResultSet getDataByID(int ID) {
        Object[] param = { ID };
        return _dbConnect.getData("sp_LOPHOCPHAN_select_malhp", param);
    }

    public ResultSet getDataByChuyenNganh(String MACN) {
        Object[] param = { MACN };
        return _dbConnect.getData("sp_LOPHOCPHAN_select_by_chuyennganh", param);
    }

    public ResultSet getDataMaLHP() {
        return _dbConnect.getData("SELECT IDENT_CURRENT('LOPHOCPHAN') + 1");
    }

    public int insert(LopHocPhan obj) {
        Object[] param = { obj.getNienKhoa(), obj.getHocKy(), obj.getMaMH(), obj.getMaGV(), obj.getMaCN(), obj.isHuyLop() };
        return _dbConnect.executeSQL("sp_LOPHOCPHAN_insert", param);
    }

    public int update(LopHocPhan obj) {
        Object[] param = { obj.getMaLHP(), obj.getNienKhoa(), obj.getHocKy(), obj.getMaMH(), obj.getMaGV(), obj.getMaCN(), obj.isHuyLop() };
        return _dbConnect.executeSQL("sp_LOPHOCPHAN_update", param);
    }

    public int delete(int ID) {
        Object[] param = { ID };
        return _dbConnect.executeSQL("sp_LOPHOCPHAN_delete", param);
    }
}

package dataaccesslayer;

import java.sql.ResultSet;

import dtos.CTDangKy;

public class CTDANGKYDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData() {
        return _dbConnect.getData("sp_CTDANGKY_select_all", null);
    }

    public ResultSet getDataByID(int ID) {
        Object[] param = { ID };
        return _dbConnect.getData("sp_CTDANGKY_select_mactdk", param);
    }

    public int insert(CTDangKy obj) {
        Object[] param = { obj.getMaLHP(), obj.getMaDK() };
        return _dbConnect.executeSQL("sp_CTDANGKY_insert", param);
    }

    public int update(CTDangKy obj) {
        Object[] param = { obj.getMaCTDK(), obj.getMaLHP(), obj.getMaDK() };
        return _dbConnect.executeSQL("sp_CTDANGKY_update", param);
    }

    public int delete(int ID) {
        Object[] param = { ID };
        return _dbConnect.executeSQL("sp_CTDANGKY_delete", param);
    }

    public int delete(CTDangKy obj) {
        Object[] param = { obj.getMaLHP(), obj.getMaDK() };
        return _dbConnect.executeSQL("sp_CTDANGKY_delete_bysv", param);
    }
}

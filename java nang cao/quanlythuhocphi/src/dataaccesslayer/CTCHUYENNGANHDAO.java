package dataaccesslayer;

import java.sql.ResultSet;

import dtos.CTChuyenNganh;

public class CTCHUYENNGANHDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData() {
        return _dbConnect.getData("sp_CTCHUYENNGANH_select_all");
    }

    public ResultSet getDataByID(String ID) {
        Object[] param = { ID };
        return _dbConnect.getData("sp_CTCHUYENNGANH_select_mactcn", param);
    }

    public int insert(CTChuyenNganh obj) {
        Object[] param = { obj.getMACN(), obj.getMAMH() };
        return _dbConnect.executeSQL("sp_CTCHUYENNGANH_insert", param);
    }

    public int update(CTChuyenNganh obj) {
        Object[] param = { obj.getMACN(), obj.getMAMH(), obj.getMACTCN() };
        return _dbConnect.executeSQL("sp_CTCHUYENNGANH_update", param);
    }

    public int delete(int ID) {
        Object[] param = { ID };
        return _dbConnect.executeSQL("sp_CTCHUYENNGANH_delete", param);
    }

    public int deleteByMaMH(String MAMH) {
        Object[] param = { MAMH };
        return _dbConnect.executeSQL("sp_CTCHUYENNGANH_delete_by_mamh", param);
    }
}

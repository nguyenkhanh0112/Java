package dataaccesslayer;

import java.sql.ResultSet;

import dtos.Lop;

public class LOPDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData() {
        return _dbConnect.getData("sp_LOP_select_all", null);
    }

    public ResultSet getDataByID(String ID) {
        Object[] param = { ID };
        return _dbConnect.getData("sp_LOP_select_malop", param);
    }

    public ResultSet getDataByMAKHOA(String MAKHOA) {
        Object[] param = { MAKHOA };
        return _dbConnect.getData("sp_LOP_select_by_makhoa", param);
    }

    public ResultSet getDataByMACN(String MACN) {
        Object[] param = { MACN };
        return _dbConnect.getData("sp_LOP_select_by_macn", param);
    }

    public int insert(Lop obj) {
        Object[] param = { obj.getMaLop(), obj.getMaCN() };
        return _dbConnect.executeSQL("sp_LOP_insert", param);
    }

    public int update(Lop obj) {
        Object[] param = { obj.getMaLop(), obj.getMaCN() };
        return _dbConnect.executeSQL("sp_LOP_update", param);
    }

    public int delete(String ID) {
        Object[] param = { ID };
        return _dbConnect.executeSQL("sp_LOP_delete", param);
    }
}

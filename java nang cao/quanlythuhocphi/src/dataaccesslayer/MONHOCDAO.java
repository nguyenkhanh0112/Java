package dataaccesslayer;

import java.sql.ResultSet;

import dtos.MonHoc;

public class MONHOCDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData() {
        return _dbConnect.getData("sp_MONHOC_select_all");
    }

    public ResultSet getDataByID(String ID) {
        Object[] param = { ID };
        return _dbConnect.getData("sp_MONHOC_select_mamh", param);
    }

    public int insert(MonHoc obj) {
        Object[] param = { obj.getMaMH(), obj.getTenMH(), obj.getHocKy(), obj.getSoTinChi() };
        return _dbConnect.executeSQL("sp_MONHOC_insert", param);
    }

    public int update(MonHoc obj) {
        Object[] param = { obj.getMaMH(), obj.getTenMH(), obj.getHocKy(), obj.getSoTinChi() };
        return _dbConnect.executeSQL("sp_MONHOC_update", param);
    }

    public int delete(String ID) {
        Object[] param = { ID };
        return _dbConnect.executeSQL("sp_MONHOC_delete", param);
    }
}

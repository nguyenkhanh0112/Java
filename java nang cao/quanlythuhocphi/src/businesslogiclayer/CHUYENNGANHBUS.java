package businesslogiclayer;

import java.sql.ResultSet;

import dataaccesslayer.CHUYENNGANHDAO;
import dtos.ChuyenNganh;

public class CHUYENNGANHBUS {
    private CHUYENNGANHDAO dao = new CHUYENNGANHDAO();

    public ResultSet GetData() {
        return dao.getData();
    }

    public ResultSet GetData(String ID) {
        return dao.getDataByID(ID);
    }

    public ResultSet GetDataByMAKHOA(String MAKHOA) {
        return dao.getDataByMAKHOA(MAKHOA);
    }

    public int Insert(ChuyenNganh obj) {
        return dao.insert(obj);
    }

    public int Update(ChuyenNganh obj) {
        return dao.update(obj);
    }

    public int Delete(String ID) {
        return dao.delete(ID);
    }
}

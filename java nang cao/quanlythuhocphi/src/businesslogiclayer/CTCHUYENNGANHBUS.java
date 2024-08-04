package businesslogiclayer;

import dataaccesslayer.CTCHUYENNGANHDAO;
import dtos.CTChuyenNganh;

import java.sql.ResultSet;

public class CTCHUYENNGANHBUS {
    private CTCHUYENNGANHDAO dao = new CTCHUYENNGANHDAO();

    public ResultSet GetData() {
        return dao.getData();
    }

    public ResultSet GetData(String ID) {
        return dao.getDataByID(ID);
    }

    public int Insert(CTChuyenNganh obj) {
        return dao.insert(obj);
    }

    public int Update(CTChuyenNganh obj) {
        return dao.update(obj);
    }

    public int Delete(int ID) {
        return dao.delete(ID);
    }

    public int DeleteByMaMH(String MAMH) {
        return dao.deleteByMaMH(MAMH);
    }
}

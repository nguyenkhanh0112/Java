package businesslogiclayer;

import dataaccesslayer.LOPDAO;
import dtos.Lop;

import java.sql.ResultSet;

public class LOPBUS {
    private LOPDAO dao = new LOPDAO();

    public ResultSet GetData() {
        return dao.getData();
    }

    public ResultSet GetData(String ID) {
        return dao.getDataByID(ID);
    }

    public ResultSet GetDataByMAKHOA(String MAKHOA) {
        return dao.getDataByMAKHOA(MAKHOA);
    }

    public ResultSet GetDataByMACN(String MACN) {
        return dao.getDataByMACN(MACN);
    }

    public int Insert(Lop obj) {
        return dao.insert(obj);
    }

    public int Update(Lop obj) {
        return dao.update(obj);
    }

    public int Delete(String ID) {
        return dao.delete(ID);
    }
}

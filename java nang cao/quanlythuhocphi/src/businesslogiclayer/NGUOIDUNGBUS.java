package businesslogiclayer;

import java.sql.ResultSet;

import dataaccesslayer.NGUOIDUNGDAO;
import dtos.NguoiDung;

public class NGUOIDUNGBUS {
    private NGUOIDUNGDAO dao = new NGUOIDUNGDAO();

    public ResultSet GetData() {
        return dao.getData();
    }

    public ResultSet GetData(String ID) {
        return dao.getDataByID(ID);
    }

    public int Insert(NguoiDung obj) {
        return dao.insert(obj);
    }

    public int Update(NguoiDung obj) {
        return dao.update(obj);
    }

    public int Delete(String ID) {
        return dao.delete(ID);
    }
}

package businesslogiclayer;

import dataaccesslayer.MONHOCDAO;
import dtos.MonHoc;

import java.sql.ResultSet;

public class MONHOCBUS {
    private MONHOCDAO dao = new MONHOCDAO();

    public ResultSet GetData() {
        return dao.getData();
    }

    public ResultSet GetData(String ID) {
        return dao.getDataByID(ID);
    }

    public int Insert(MonHoc obj) {
        return dao.insert(obj);
    }

    public int Update(MonHoc obj) {
        return dao.update(obj);
    }

    public int Delete(String ID) {
        return dao.delete(ID);
    }
}

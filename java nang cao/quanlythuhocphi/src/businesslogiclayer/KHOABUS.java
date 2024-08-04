package businesslogiclayer;

import dataaccesslayer.KHOADAO;
import dtos.Khoa;

import java.sql.ResultSet;

public class KHOABUS {
    private KHOADAO dao = new KHOADAO();

    public ResultSet GetData() {
        return dao.getData();
    }

    public ResultSet GetData(String ID) {
        return dao.getDataByID(ID);
    }

    public int Insert(Khoa obj) {
        return dao.insert(obj);
    }

    public int Update(Khoa obj) {
        return dao.update(obj);
    }

    public int Delete(String ID) {
        return dao.delete(ID);
    }
}

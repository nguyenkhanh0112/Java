package businesslogiclayer;

import dataaccesslayer.LOPHOCPHANDAO;
import dtos.LopHocPhan;

import java.sql.ResultSet;

public class LOPHOCPHANBUS {
    private LOPHOCPHANDAO dao = new LOPHOCPHANDAO();

    public ResultSet GetData() {
        return dao.getData();
    }

    public ResultSet GetData(int ID) {
        return dao.getDataByID(ID);
    }

    public ResultSet GetDataMaLHP() {
        return dao.getDataMaLHP();
    }

    public ResultSet GetDataByChuyenNganh(String MACN) {
        return dao.getDataByChuyenNganh(MACN);
    }

    public int Insert(LopHocPhan obj) {
        return dao.insert(obj);
    }

    public int Update(LopHocPhan obj) {
        return dao.update(obj);
    }

    public int Delete(int ID) {
        return dao.delete(ID);
    }
}

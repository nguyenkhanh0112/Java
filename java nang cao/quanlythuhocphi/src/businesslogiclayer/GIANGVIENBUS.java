package businesslogiclayer;

import dataaccesslayer.GIANGVIENDAO;
import dtos.GiangVien;

import java.sql.ResultSet;

public class GIANGVIENBUS {
    private GIANGVIENDAO dao = new GIANGVIENDAO();

    public ResultSet GetData() {
        return dao.getData();
    }

    public ResultSet GetData(String ID) {
        return dao.getDataByID(ID);
    }

    public ResultSet GetDataByChuyenNganh(String MACN) {
        return dao.getDataByChuyenNganh(MACN);
    }

    public int Insert(GiangVien obj) {
        return dao.insert(obj);
    }

    public int Update(GiangVien obj) {
        return dao.update(obj);
    }

    public int Delete(String ID) {
        return dao.delete(ID);
    }
}

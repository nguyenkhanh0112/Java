package businesslogiclayer;

import dataaccesslayer.SINHVIENDAO;
import dtos.SinhVien;

import java.sql.ResultSet;

public class SINHVIENBUS {
    private SINHVIENDAO dao = new SINHVIENDAO();

    public ResultSet GetData() {
        return dao.getData();
    }

    public ResultSet GetData(String ID) {
        return dao.getDataByID(ID);
    }

    public ResultSet GetDataByCondition(String MAKHOA, String MACN, String MALOP) {
        return dao.getDataByCondition(MAKHOA, MACN, MALOP);
    }

    public int Insert(SinhVien obj) {
        return dao.insert(obj);
    }

    public int Update(SinhVien obj) {
        return dao.update(obj);
    }

    public int Delete(String ID) {
        return dao.delete(ID);
    }
}

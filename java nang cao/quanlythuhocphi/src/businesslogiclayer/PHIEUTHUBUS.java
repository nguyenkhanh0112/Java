package businesslogiclayer;

import dataaccesslayer.PHIEUTHUDAO;
import dtos.PhieuThu;

import java.sql.ResultSet;

public class PHIEUTHUBUS {
    private PHIEUTHUDAO dao = new PHIEUTHUDAO();

    public ResultSet GetData() {
        return dao.getData();
    }

    public ResultSet GetData(int ID) {
        return dao.getDataByID(ID);
    }

    public ResultSet GetDataSTTPT() {
        return dao.getDataSTTPT();
    }

    public ResultSet GetDataByMASV(String MASV) {
        return dao.getDataByMASV(MASV);
    }

    public ResultSet GetDataByMaSVandHK(String MASV, int HOCKY) {
        return dao.getDataByMaSVandHK(MASV, HOCKY);
    }

    public int Insert(PhieuThu obj) {
        return dao.insert(obj);
    }

    public int Update(PhieuThu obj) {
        return dao.update(obj);
    }

    public int Delete(int ID) {
        return dao.delete(ID);
    }
}

package businesslogiclayer;

import java.sql.ResultSet;

import dataaccesslayer.DANGKYDAO;
import dtos.DangKy;

public class DANGKYBUS {
    private DANGKYDAO dao = new DANGKYDAO();

    public ResultSet GetData() {
        return dao.getData();
    }

    public ResultSet GetData(int ID) {
        return dao.getDataByID(ID);
    }

    public ResultSet GetDataByMASV(String MASV) {
        return dao.getDataByMASV(MASV);
    }

    public ResultSet GetDataByMASVandHOCKY(DangKy obj) {
        return dao.getDataByMASVandHOCKY(obj);
    }

    public ResultSet GetDataSTTMaDK() {
        return dao.getDataSTTMaDK();
    }

    public int Insert(DangKy obj) {
        return dao.insert(obj);
    }

    public int Update(DangKy obj) {
        return dao.update(obj);
    }

    public int Delete(int ID) {
        return dao.delete(ID);
    }
}

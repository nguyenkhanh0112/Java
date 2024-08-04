package businesslogiclayer;

import dataaccesslayer.CTPHIEUTHUDAO;
import dtos.CTPhieuThu;

import java.sql.ResultSet;

public class CTPHIEUTHUBUS {
    private CTPHIEUTHUDAO dao = new CTPHIEUTHUDAO();

    public ResultSet GetData() {
        return dao.getData();
    }

    public ResultSet GetData(int MACTPT) {
        return dao.getDataByMACTPT(MACTPT);
    }

    public ResultSet GetDataByMaPT(int MAPT) {
        return dao.getDataByMaPT(MAPT);
    }

    public int GetDataSTTCTPT() {
        return dao.getSTTCTPT();
    }

    public int Insert(CTPhieuThu obj) {
        return dao.insert(obj);
    }

    public int Update(CTPhieuThu obj) {
        return dao.update(obj);
    }

    public int Delete(int MACTPT) {
        return dao.delete(MACTPT);
    }
}

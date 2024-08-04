package businesslogiclayer;

import dataaccesslayer.XULYDANGKYDAO;
import dtos.DangKy;

import java.sql.ResultSet;

public class XULYDANGKYBUS {
    private XULYDANGKYDAO dao = new XULYDANGKYDAO();

    public ResultSet GetData(DangKy obj) {
        return dao.getData(obj);
    }

    public ResultSet GetData(DangKy obj, String TENMH) {
        return dao.getData(obj, TENMH);
    }

    public ResultSet GetDataLHPChuaDK(DangKy obj) {
        return dao.getDataLHPChuaDK(obj);
    }
}

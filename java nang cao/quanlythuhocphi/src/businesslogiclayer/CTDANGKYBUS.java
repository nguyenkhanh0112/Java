package businesslogiclayer;

import dataaccesslayer.CTDANGKYDAO;
import dtos.CTDangKy;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CTDANGKYBUS {
    private CTDANGKYDAO dao = new CTDANGKYDAO();

    public ResultSet GetData() throws SQLException {
        return dao.getData();
    }

    public ResultSet GetData(int ID) throws SQLException {
        return dao.getDataByID(ID);
    }

    public int Insert(CTDangKy obj) throws SQLException {
        return dao.insert(obj);
    }

    public int Update(CTDangKy obj) throws SQLException {
        return dao.update(obj);
    }

    public int Delete(int ID) throws SQLException {
        return dao.delete(ID);
    }

    public int Delete(CTDangKy obj) throws SQLException {
        return dao.delete(obj);
    }
}

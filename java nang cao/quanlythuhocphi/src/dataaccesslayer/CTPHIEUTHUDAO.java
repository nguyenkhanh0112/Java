package dataaccesslayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import dtos.CTPhieuThu;

public class CTPHIEUTHUDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData() {
        return _dbConnect.getData("sp_CTPHIEUTHU_select_all");
    }

    public ResultSet getDataByMACTPT(int MACTPT) {
        Object[] param = {MACTPT};
        return _dbConnect.getData("sp_CTPHIEUTHU_select_mactpt", param);
    }

    public ResultSet getDataByMaPT(int MAPT) {
        Object[] param = {MAPT};
        return _dbConnect.getData("sp_CTPHIEUTHU_select_mapt", param);
    }

    public int getSTTCTPT() {
        // Note: This method returns a single value, not a DataTable.
        // Here, we assume that the method returns an integer value.
        // You may need to modify this according to your database structure and requirements.
        ResultSet rs = _dbConnect.getData("SELECT IDENT_CURRENT('CTPHIEUTHU') + 1");
        try {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int insert(CTPhieuThu obj) {
        Object[] param = {obj.getMAPT(), obj.getNgayDong(), obj.getSoTienDong()};
        return _dbConnect.executeSQL("sp_CTPHIEUTHU_insert", param);
    }

    public int update(CTPhieuThu obj) {
        Object[] param = {obj.getMACTPT(), obj.getMAPT(), obj.getNgayDong(), obj.getSoTienDong()};
        return _dbConnect.executeSQL("sp_CTPHIEUTHU_update", param);
    }

    public int delete(int MACTPT) {
        Object[] param = {MACTPT};
        return _dbConnect.executeSQL("sp_CTPHIEUTHU_delete", param);
    }
}

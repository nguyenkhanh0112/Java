package dataaccesslayer;

import java.sql.ResultSet;

import dtos.DangKy;

public class XULYDANGKYDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData(DangKy obj) {
        Object[] param = {obj.getMADK(), obj.getMASV(), obj.getHocKy()};
        return _dbConnect.getData("sp_XULYDANGKY_select_masv", param);
    }

    public ResultSet getData(DangKy obj, String TENMH) {
        Object[] param = {obj.getMADK(), obj.getMASV(), obj.getHocKy(), TENMH};
        return _dbConnect.getData("sp_XULYDANGKY_select_tenmh", param);
    }

    public ResultSet getDataLHPChuaDK(DangKy obj) {
        Object[] param = {obj.getMADK(), obj.getMASV(), obj.getHocKy()};
        return _dbConnect.getData("sp_XULYDANGKY_select_chuadk", param);
    }
}

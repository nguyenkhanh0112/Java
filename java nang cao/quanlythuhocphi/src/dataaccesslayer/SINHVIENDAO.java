package dataaccesslayer;

import java.sql.ResultSet;

import dtos.SinhVien;

public class SINHVIENDAO {
    private dbConnect _dbConnect = new dbConnect();

    public ResultSet getData() {
        return _dbConnect.getData("sp_SINHVIEN_select_all");
    }

    public ResultSet getDataByID(String ID) {
        Object[] param = { ID };
        return _dbConnect.getData("sp_SINHVIEN_select_masv", param);
    }

    public ResultSet getDataByCondition(String MAKHOA, String MACN, String MALOP) {
        Object[] param = { MAKHOA, MACN, MALOP };
        return _dbConnect.getData("sp_SINHVIEN_select_by_khoa_chuyennganh_lop", param);
    }

    public int insert(SinhVien obj) {
        Object[] param = {
            obj.getMaSV(),
            obj.getHo(),
            obj.getTen(),
            obj.getMaLop(),
            obj.isPhai(),
            obj.getNgaySinh(),
            obj.getDiaChi(),
            obj.isDangNghiHoc(),
            obj.getTenTaiKhoan()
        };
        return _dbConnect.executeSQL("sp_SINHVIEN_insert", param);
    }

    public int update(SinhVien obj) {
        Object[] param = {
            obj.getMaSV(),
            obj.getHo(),
            obj.getTen(),
            obj.getMaLop(),
            obj.isPhai(),
            obj.getNgaySinh(),
            obj.getDiaChi(),
            obj.isDangNghiHoc(),
            obj.getTenTaiKhoan()
        };
        return _dbConnect.executeSQL("sp_SINHVIEN_update", param);
    }

    public int delete(String ID) {
        Object[] param = { ID };
        return _dbConnect.executeSQL("sp_SINHVIEN_delete", param);
    }
}

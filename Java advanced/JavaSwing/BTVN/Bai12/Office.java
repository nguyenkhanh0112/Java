package JavaSwing.BTVN.Bai12;

import java.util.ArrayList;

public class Office {
    private String nameOffice;
    private ArrayList<Staff> staffArrayList;

    public Office(String nameOffice) {
        this.nameOffice = nameOffice;
        this.staffArrayList = new ArrayList<>();
    }

    public Office(String nameOffice, ArrayList<Staff> staffArrayList) {
        this.nameOffice = nameOffice;
        this.staffArrayList = staffArrayList;
    }

    public Office() {
    }

    public String getNameOffice() {
        return nameOffice;
    }

    public void setNameOffice(String nameOffice) {
        this.nameOffice = nameOffice;
    }

    public ArrayList<Staff> getStaffArrayList() {
        return staffArrayList;
    }
    public void addOffice(Staff staff){
        this.staffArrayList.add(staff);
    }
    public void removeOffice(int index){
        this.staffArrayList.remove(index);
    }
    public void updateOffice(int index,Staff staff){
        this.staffArrayList.set(index,staff);
    }
    public int sizeOffice(){
        return this.staffArrayList.size();
    }

    @Override
    public String toString() {
        return  nameOffice;
    }
}

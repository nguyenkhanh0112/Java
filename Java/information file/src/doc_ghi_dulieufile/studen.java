package doc_ghi_dulieufile;

import java.io.Serializable;

public class studen implements Serializable {
    private String name;
    private int old;
    private double marks;

    public studen(String name, int old, double marks) {
        this.name = name;
        this.old = old;
        this.marks = marks;
    }
    public studen(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name +";"+old+";"+marks;
    }
}

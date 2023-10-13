package model;

import java.io.Serializable;

public class NhanSu implements Serializable {
    private String manv;
    private String tennv;
    private String tenpb;

    public NhanSu(String manv, String tennv, String tenpb) {
        this.manv = manv;
        this.tennv = tennv;
        this.tenpb = tenpb;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }
}

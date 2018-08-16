package day9.domain;

import day9.annotation.Column;
import day9.annotation.Row;

@Row
public class User {
    @Column(index = 1)
    public String a;
    @Column(index = 0)
    public String b;
    @Column(index = 3)
    public String c;
    public String d;
    @Column(index = 2)
    public String e;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }
}

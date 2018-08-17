package day11.domain;

public class User {

    static {
        System.err.println("static block executed ..");
    }

    private String a;
    protected String b;
    public String c;
    String d;

    private void a() {

    }

    public void b() {

    }

    protected String c() {
        return null;
    }

    public String d() {
        return null;
    }
}

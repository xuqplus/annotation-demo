package day10.domain;

public class User extends BaseUser implements UserInterface {

    private String a;
    protected String b;
    public String c;
    String d;

    // @Override
    void aBase() {

    }

    @Override
    public void bBase() {
        System.out.println("extended");
    }

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

    String e() {
        return null;
    }

    @Override
    public void aItf() {

    }

    @Override
    public void bItf() {

    }

    @Override
    public String dItf() {
        return null;
    }
}

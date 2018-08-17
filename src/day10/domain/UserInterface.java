package day10.domain;

public interface UserInterface {

    /**
     * java 8
     * |    接口内可以申明public方法
     * |    接口内可以申明public方法并提供默认实现
     * |    接口内不能申明private成员
     */


    default void aItf() {

    }

    void bItf();

    default String cItf() {
        return null;
    }

    String dItf();
}

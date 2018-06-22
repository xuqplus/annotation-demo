package day7.service;

import day7.annotation.Message;
import day7.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Run {

    @Autowired
    public User user;

    @Message
    public String msg;

    @Message(msg = "你好世界")
    public String msg1;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg1() {
        return msg1;
    }

    public void setMsg1(String msg1) {
        this.msg1 = msg1;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void say() {
        System.out.println("hello, its me.");
    }
}

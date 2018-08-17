package day11;

import day11.domain.User;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/yqf";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) throws Exception {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(Main.class.getPackage().getName() + File.separator + "app.xml");
        context.start();
        // testClassForName();
        // testNew();

        testJdbc();
    }

    private static void testJdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");
            while (resultSet.next()) {
                List row = new ArrayList();
                for (int i = 1; ; i++) {
                    try {
                        row.add(resultSet.getObject(i));
                    } catch (Exception e) {
                        System.out.println(row);
                        break;
                    }
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testNew() {
        User user = new User();
        System.out.println(User.class.getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println();
    }

    private static void testClassForName() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        User user = (User) Class.forName("day11.domain.User").newInstance();
        System.out.println(User.class.getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println();
    }
}
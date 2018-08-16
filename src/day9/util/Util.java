package day9.util;

import day9.annotation.Column;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Util {

    public static final Map<Integer, Object> get(Object o) throws NoSuchFieldException, IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();
        Map<Integer, Object> r = new TreeMap();
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (null != column) {
                Object v = field.get(o);
                r.put(column.index(), v);
            }
        }
        return r;
    }

    public static final void set(Object o, List<String> columns) throws NoSuchFieldException, IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();
        Map<Integer, Object> r = new TreeMap();
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (null != column) {
                field.set(o, columns.get(column.index()));
            }
        }
    }
}

package start;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Reflection {
    public static String[] generateClientTable(ArrayList<?> dataList) {

        Class<?> clazz = dataList.get(0).getClass();
        Field[] fields = clazz.getDeclaredFields();
        String[] columnNames = new String[fields.length];
        Object[][] rowData = new Object[dataList.size()][fields.length];
        for (int i = 0; i < fields.length; i++) {
            columnNames[i] = fields[i].getName();
        }
        for (int i = 0; i < dataList.size(); i++) {
            Object dataObj = dataList.get(i);
            for (int j = 0; j < fields.length; j++) {
                fields[j].setAccessible(true);
                try {
                    rowData[i][j] = fields[j].get(dataObj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return columnNames;
    }
}

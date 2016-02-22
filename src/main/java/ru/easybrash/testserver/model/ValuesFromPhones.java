package ru.easybrash.testserver.model;

import java.util.ArrayList;

/**
 * Created by tagnik'zur on 22.02.2016.
 */
public class ValuesFromPhones {

    public static class SingletonHolder {
        public static final ValuesFromPhones HOLDER_INSTANCE = new ValuesFromPhones();
    }

    public static ValuesFromPhones getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    private ArrayList<String> values = new ArrayList<String>();

    public void addValue(String value) {
        values.add(value);

//        printValues();
    }

    public String getValue(int index) {
        if (values.size() != 0) {
            return values.get(index);
        }
        return null;
    }

    public String getLast() {
        if (values.size() != 0) {
            return values.get(values.size() - 1);
        }
        return "empty";
    }

    public ArrayList<String> getValues() {
        return values;
    }

    private void printValues() {
        for (int i = 0; i < values.size(); i++) {
            System.out.print(values.get(i));
            System.out.print(" *** ");
        }
        System.out.println();
    }
}

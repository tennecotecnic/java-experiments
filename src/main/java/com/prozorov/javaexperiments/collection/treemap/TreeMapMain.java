package com.prozorov.javaexperiments.collection.treemap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


    public class TreeMapMain {
        public static void main(String[] args) throws IOException {
            TreeMap<String, Double> list = new TreeMap<>();
            String fileName = args[0];
            //String fileName = "D:/test.txt";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            boolean flag = false;

            while(reader.ready()) {
                String stroka = reader.readLine();
                String [] array = stroka.split(" ");
                Double price = Double.parseDouble(array[1]);
                if (!list.isEmpty()) {
                    for(Map.Entry<String, Double> m: list.entrySet()) {
                        String key = m.getKey();
                        if (array[0].equals(key)) {
                            Double value = m.getValue();
                            value = value + price;
                            //list.remove(key);
                            //list.put(key, value);
                            list.replace(key, value);
                            flag = true;
                        }
                    }
                    if (!flag) {
                        list.put(array[0], price);
                    }
                    else {
                        flag = false;
                    }
                }
                else {
                    list.put(array[0], price);
                }
            }
            reader.close();

            for(Map.Entry<String, Double> m1: list.entrySet()) {
                String key = m1.getKey();
                Double value = m1.getValue();
                System.out.println(key + " " + value);
            }
        }
    }

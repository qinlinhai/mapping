package aaa;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public  class Dog {

    String a="123";

    public static void main(String[] args) {
        int a=123;
        String s = String.valueOf(a);
        System.out.println(s);
        String v=a+"";
        System.out.println(v);
        File file=new File("ds");
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}

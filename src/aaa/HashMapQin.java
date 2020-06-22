package aaa;

import javax.jws.soap.SOAPBinding;
import java.util.*;

public class HashMapQin {
    public static void main(String[] args) {
        HashMap<Integer,User> hashMap=new HashMap<>();
        hashMap.put(1,new User("秦林海",22));
        hashMap.put(2,new User("王成贤",23));
        hashMap.put(3,new User("红松",21));
        System.out.println(hashMap);
        HashMap<Integer, User> hashMap1 = HashMapQin.sortHashMap(hashMap);
        System.out.println(hashMap1);
        int a=(int)(Math.random()*10);
        System.out.println(a);
        Vector<Object> objects = new Vector<>();
    }
    public static HashMap<Integer,User> sortHashMap(HashMap<Integer,User> hashMap1){
        Set<Map.Entry<Integer, User>> entries = hashMap1.entrySet();
        List<Map.Entry<Integer, User>> list = new ArrayList<>(entries);

        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge()-o1.getValue().getAge();
            }
        });

        LinkedHashMap<Integer,User> linkedHashMap=new LinkedHashMap<>();
        for (Map.Entry<Integer,User> a:list){
            linkedHashMap.put(a.getKey(),a.getValue());
        }
        return linkedHashMap;

    }

}

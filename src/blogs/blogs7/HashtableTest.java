package blogs.blogs7;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashtableTest {
    public static void main(String[] args) {
        Hashtable<String,Integer> hashtable = new Hashtable<String,Integer>();

        hashtable.put("lihua",1);
        hashtable.put("zhangsan",2);
        hashtable.put("lisi",3);
        hashtable.put("wangwu",4);

        Set<Map.Entry<String, Integer>> entries = hashtable.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

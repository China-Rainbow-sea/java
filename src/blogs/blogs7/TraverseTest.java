package blogs.blogs7;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TraverseTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("Hello");
        set.add("World");
        set.add("Hello World");

        for (String s : set) {
            System.out.println(s);
        }
    }



    public static void main1(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("HAHAHAHA");

        for(int i = 0; i < list.size();i++) {
            System.out.println(list.get(i));
        }
    }
}

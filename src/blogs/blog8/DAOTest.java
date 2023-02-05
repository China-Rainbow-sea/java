package blogs.blog8;

import day25.DAOS;
import org.junit.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test() {
        DAOS<User> dao = new DAOS<User>();

        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1002,20,"昆菱"));
        dao.save("1003",new User(1003,25,"蔡依林"));

        dao.update("1003",new User(1003,30,"万文山"));

        dao.delete("1002");

        List<User> list = dao.list();
        list.forEach(System.out::println);


    }
}


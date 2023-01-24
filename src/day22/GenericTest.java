package day22;

import org.junit.Test;

/**
 * 自定义泛型可以吗 ？ 可以
 *   自定义泛型的时候，<> 尖括号中的是一个标识符，随便写。
 *   Java源代码中经常出现的是:
 *    <E>和<T>
 *   E是 Element 单词首字母
 *   T 是 Type 单词首字母
 *
 * @param <fasjiofjdisoajoifjasio>
 */

public class GenericTest<fasjiofjdisoajoifjasio> {
    public void doSome(fasjiofjdisoajoifjasio o) {
        System.out.println(o);
    }


    @Test
    public void test() {
        // new 对象的时候指定了泛型是: String类型
        GenericTest<String> genericTest = new GenericTest<>();
        genericTest.doSome("afjasoifjoasd");

        // 类型不一致
        // genericTest.doSome(100);


        // 不用泛型就是 Object 类型
        GenericTest genericTest2 = new GenericTest();
        genericTest2.doSome(new Object());
    }

    @Test
    public void test2() {
        GenericTest<Integer> genericTest = new GenericTest<>();
        genericTest.doSome(1000);
        // 类型不一致
        // genericTest.doSome("abc");
    }
}

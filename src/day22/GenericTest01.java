package day22;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 泛型
 * jdk5.0 之后推出的新特性：泛型
 * 泛型这种语法机制，只在程序编译阶段起作用，只是给编译器参考的。(运行阶段泛型没用)
 *  // 使用了泛型好处是什么 ?
 *   第一: 集合中存储的元素类型统一了。
 *   第二: 从集合中取出的元素类型是泛型指定的类型，不需要进行大量的 “向下转型”
 *
 *
 *  4. 泛型的缺点是什么 ???
 *  导致集合中存储的元素缺乏多样性 ！！！
 *
 */
public class GenericTest01 {

    /**
     * JDK之后引入了：自动类型推断机制。(又称为 钻石表达式)
     *
     */
    @Test
    public void test3() {
       // ArrayList<这里的类型会自动推断>(), 前提是 JDK8 之后才允许的.
       // 自动类型推断，钻石表达式！
       List<Animal> myList = new ArrayList<>();
       myList.add(new Bird());
       myList.add(new Cat());
       myList.add(new Animal());

       // 遍历
        Iterator<Animal> iterator = myList.iterator();
        while(iterator.hasNext()) {
            Animal animal = iterator.next();
            animal.move();
        }


        List<String> strList = new ArrayList<>();
        // 类型不匹配
        // strList.add(new Cat());  //
        strList.add("abc");

        // 类型不匹配
        // strList.add(123);

        strList.add("http://www.baidu.com");
        strList.add("http://www.bjpowernod3e.com");

        System.out.println(strList.size());
    }

    /**
     * 使用 JDK5 之后的泛型机制
     */
    @Test
    public void test2() {

        // 使用泛型list<Animal>之后，表示 List 集合中只允许存储Animal 类型的数据
        // 用泛型来指定集合中存储的数据类型
        List<Animal> myList = new ArrayList<Animal>();

        // 指定List 集合中只能存储Animal ,那么存储String就编译报错了.
        // 这样用了泛型之后，集合中元素的数据类型更加统一了.
        // myList.add("abc");

        // 创建对象
        Cat c = new Cat();
        Bird bird = new Bird();

        // 将对象添加到集合中
        myList.add(c);
        myList.add(bird);

        // 获取迭代器
        // 这个表示迭代器迭代的是 Animal 类型。
        Iterator<Animal> iterator = myList.iterator();

        while(iterator.hasNext()) {
            Animal animal = iterator.next();  // 使用了泛型其中返回的就是你在泛型中设定的类型了
            animal.move();

        }


    }


    /**
     * 没有使用jdk5泛型的处理
     */
    @Test
    public void test() {

        // 不使用泛型机制，分析程序存在缺点:
        List myList = new ArrayList();

        // 准备对象
        Cat cat = new Cat();
        Bird bird = new Bird();

        // 将对象提添加到集合当中
        myList.add(cat);
        myList.add(bird);
        myList.add(new Animal());



        // 遍历集合: 取出每个Animal ，让它move
        Iterator iterator = myList.iterator();  // 迭代器

        while(iterator.hasNext()) {
            // 没有这个语法，通过迭代器取出的就是 Object
            // Animal a = iterator.next() // 默认返回的时 Object 类型

            Object object = iterator.next();  //

            // object 中没有我们定义的方法，无法调用，需要向下转型
            // 注意: 只有相对应的实例才，可以向下转型，不然会存在运行报异常
            if(object instanceof Cat) {
                Cat c = (Cat) object;
                c.move();
            } else if (object instanceof Bird) {
                Bird b = (Bird)object;
                b.move();
            } else if(object instanceof Animal) {
                Animal animal = (Animal)object;
                animal.move();
            }
        }

    }
}


class Animal {
    public void move() {
        System.out.println("动物走路");
    }

}


class Cat extends Animal {
    @Override
    public void move() {
        System.out.println("猫，走路");
    }


}

class Bird extends Animal {
    @Override
    public void move() {
        System.out.println("小鸟，飞");
    }

}

package day14;

public class Woman extends Person{
    public int id = 2;

    @Override
    public void eat() {
        System.out.println("woman 子类吃饭");
    }

    public void walk() {
        System.out.println("woman 女人逛街");
    }
}

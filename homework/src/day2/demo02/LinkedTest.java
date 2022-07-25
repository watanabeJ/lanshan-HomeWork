package day2.demo02;

public class LinkedTest {
    public static void main(String[] args)
    {
        Linked<String> linked = new Linked<>();
        linked.add("1");
        linked.add("2");
        linked.add("3");
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");//增
        linked.print();//遍历

        System.out.println("===============");

       linked.deleteNode(3);//减
        linked.print();

        System.out.println("===============");

        System.out.println(linked.search(2));//查找

        System.out.println("===============");

        linked.reversal();//翻转
        linked.print();
    }
}



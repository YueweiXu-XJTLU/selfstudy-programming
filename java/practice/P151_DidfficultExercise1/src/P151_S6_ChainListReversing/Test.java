package P151_S6_ChainListReversing;

import P151_S4_MyArrayList.MyConsumer;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();

        MyLinkedList.Node<String> node = mll.add(); //[1, 2, 3, 4, 5, 6]

        mll.forEach(node, System.out::print); //123456
        System.out.println();

        mll.forEach(mll.reverse(node, 2, 5), System.out::print); //154326
        System.out.println();
    }
}

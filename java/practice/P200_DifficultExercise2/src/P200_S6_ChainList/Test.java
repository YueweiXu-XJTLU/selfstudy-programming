package P200_S6_ChainList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> mll1 = new MyLinkedList<>();
        MyLinkedList.Node<String> node1 = mll1.add();

        mll1.sort(); //sort test
        System.out.println(mll1.getElements());
        System.out.println("==========");

        MyLinkedList<String> mll2 = new MyLinkedList<>();
        MyLinkedList.Node<String> node2 = mll2.add();

        mll1.mergeSort(mll2); //mergeSort test
    }
}

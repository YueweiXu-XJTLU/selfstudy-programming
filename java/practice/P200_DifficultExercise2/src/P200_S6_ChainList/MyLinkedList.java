package P200_S6_ChainList;

import java.util.ArrayList;
import java.util.Scanner;

public class MyLinkedList<E> {
    private int size;
    private Node<E> head;

    public ArrayList<String> getElements() {
        return elements;
    }

    private ArrayList<String> elements = new ArrayList<>();



    //define a private inner class inside a List Class as node
    static class Node<E> {
        E data; //data for current Node Object
        Node<E> next; //address for next Node Object

        //constructor for Node<E>
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }



    public Node<E> add(){
        head = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter data for current node (enter \"exit\" to exit):");
            E data = (E) sc.nextLine();

            //exit
            if (data.equals("exit")) break;

            //add head node
            if (head == null) {
                head = new Node<E>((E) data, null);
                size++;
                continue;
            }

            //add normal node
            Node<E> temp = head; //as head is always returned, we need a temp to work as a pointer
            //尾插法
            //judge if is tail node
            while (temp.next != null) {
                temp = temp.next; //move temp to be the tail node for data adding
            }
            //create the new node
            temp.next = new Node<E>(data, null);
            size++;
        }

        return head;
    }



    public void forEach(Node<E> head, MyConsumer<E> action) {
        if (head == null) {
            System.out.println(head);
            return;
        }

        while (head != null) {
            action.accept((E) head.data);
            head = head.next;
        }
    }



    public void sort() {
        //1.not null verification
        if (head == null || head.next == null) {
            System.out.println("No data yet!");
            return;
        }

        //2.iterate the node to add all data into an ArrayList
        Node<E> temp = head.next;
        while (true) {
            if (temp.next == null) {
                elements.add((String) temp.data);
                break;
            }
            elements.add((String) temp.data);

            //iterate
            temp = temp.next;
        }

        //3.sort use ArrayList
        elements.sort((o1, o2) -> Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2)));
    }



    public void mergeSort(MyLinkedList<E> mll2) {
        //1.fill elements with data for each mll
        this.sort();
        mll2.sort();

        //2.merge the elements
        ArrayList<String> newArrayList = this.elements;
        newArrayList.addAll(mll2.elements);

        //3.sore
        newArrayList.sort((o1, o2) -> Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2)));

        //4.output
        System.out.println(newArrayList);
    }
}

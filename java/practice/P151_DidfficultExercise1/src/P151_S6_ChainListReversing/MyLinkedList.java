package P151_S6_ChainListReversing;

import P151_S4_MyArrayList.MyConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyLinkedList<E> {
    private int size;



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
        Node<E> head = null;
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



    public Node<E> reverse(Node<E> head, int left, int right) {
        if (head == null || left > right || left < 1 || right < 1 ||left > size || right > size) {
            System.out.println("Invalid Input For reverse()!");
            return null;
        }

        //We want to reverse some nodes, but they can still form the ChainList use the original addresses, hence we only reverse the data
        //create a list for data storage
        List<E> list = new ArrayList<>();

        //create a pointer
        Node<E> pointer = head;

        //look for left node (as the first node for reversed data input)
        Node<E> leftNode = null;
        int index = 1;
        while(pointer != null) {
            if (index == left) {
                leftNode = pointer;
                break;
            }
            index++;
            pointer = pointer.next;
        }

        //iterate until right node, add data into list
        while (index <= right) {
            index++;
            list.add(pointer.data);
            pointer = pointer.next;
        }

        //reverse data inside list
        for (int i = list.size() - 1; i >= 0; i--) {
            leftNode.data = list.get(i);
            leftNode = leftNode.next;
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

}

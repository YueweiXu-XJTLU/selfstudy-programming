package P139_List_ArrayListAndLinkedList;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        //1. ArrayList:
        //data stored discontinuously as arrays

        //fast searching according to indices
        //slow adding: add, then move all elements with larger indices afterward, if array's length is not enough, create a new array with length = 1.5*formal_length and migrate the formal elements into new array
        //slow removing: remove, then move all element ahead



        //2. LinkedList:

        //data stored discontinuously based on Doubly-Linked-List(链表) as nodes(结点)(a node = address of the formal element + an element + address of the next element)

        //slow searching according to indices: each time start from the head/tail-node, search sequentially, even according to indices\
        //fast adding & removing: no need to Expansion or move various element, just change a few data in a few nodes (especially fast for the head & tail-node)
        //special methods for head & tail-node: .addFirst()/.addLast()/.getFirst()/.getLast()/.removeFirst()/.removeLast()

        //Special applications for LinkedList
        //1.Queue(队列): First In First Out (FIFO 先进先出)
        LinkedList<String> queue = new LinkedList<>();
        //Enqueue (入队)
        queue.addLast("1");
        queue.addLast("2");
        queue.addLast("3");
        System.out.println(queue); //[1, 2, 3]
        //Dequeue (出队)
        System.out.println(queue.removeFirst()); //1
        System.out.println(queue.removeFirst()); //2
        System.out.println(queue); //[3]

        System.out.println("=====");

        //2.Stack(栈): Last In First Out (LIFO 后进先出)
        LinkedList<String> stack = new LinkedList<>();
        //Push (压栈/进栈): add to bottom (栈底)
        stack.push("6"); //same as stack.addFirst("6");
        stack.push("5"); //same as stack.addFirst("5");
        stack.push("4"); //same as stack.addFirst("4");
        System.out.println(stack); //[4, 5, 6]
        //Pop (弹栈/出栈): remove from top (栈顶)
        System.out.println(stack.pop()); //4 //same as System.out.println(stack.removeFirst());
        System.out.println(stack.pop()); //5 //same as System.out.println(stack.removeFirst());
        System.out.println(stack); //[6]
    }
}

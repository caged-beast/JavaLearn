package java_API;
//LinkedList底层用双链表实现，可以用来建栈或队列

import java.util.LinkedList;
import java.util.List;

public class LinkedList2 {
    public static void main(String[] args) {
        LinkedList<String> stack = new LinkedList<>();
        stack.addFirst("java");//先进后出
        stack.addFirst("c++");
        stack.push("python");//push()就是addFirst()
        System.out.println(stack);
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());
        System.out.println(stack.pop());//pop()就是removeFirst()
        System.out.println("----------------");
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast("No.1");//先进先出
        queue.addLast("No.2");
        queue.addLast("No.3");
        System.out.println(queue);
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
    }
}

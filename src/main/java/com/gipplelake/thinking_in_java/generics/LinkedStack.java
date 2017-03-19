package com.gipplelake.thinking_in_java.generics;

/**
 * 使用泛型创建一个堆栈类
 *
 * @author dengqg
 */
public class LinkedStack<T> {
    //持有top节点，初始栈首和栈尾是同个空节点，随着元素的push进来，栈首为新数据，栈尾始终是空节点
    //使用末端哨兵（end sentinel）判断堆栈何时为空
    private Node top = new Node();


    //使用组合模式构建节点
    private class Node {
        T item;
        Node next;

        Node() {
            item = null;
            next = null;
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean isEnd() {
            return item == null && next == null;
        }
    }

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.isEnd()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();
        String test = "i am a good boy";
        for (String s : test.split(" ")) {
            stack.push(s);
        }
        String result;
        while ((result = stack.pop()) != null) {
            System.out.println(result);
        }


    }
}

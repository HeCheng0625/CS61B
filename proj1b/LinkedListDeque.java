public class LinkedListDeque<T> implements Deque<T> {
    public class Node {
        private T item;
        private Node next;
        private Node prev;
        public Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
        public Node(Node n, Node p) {
            next = n;
            prev = p;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    @Override
    public void addFirst(T item) {
        size += 1;
        Node temp = new Node(item, sentinel.next, sentinel);
        sentinel.next.prev = temp;
        sentinel.next = temp;
    }

    @Override
    public void addLast(T item) {
        size += 1;
        Node temp = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.next = temp;
        sentinel.prev = temp;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node temp = sentinel.next;
        while (temp != sentinel) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        Node temp = sentinel.next;
        temp.next.prev = sentinel;
        sentinel.next = temp.next;
        size -= 1;
        return temp.item;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) return null;
        Node temp = sentinel.prev;
        temp.prev.next = sentinel;
        sentinel.prev = temp.prev;
        size -= 1;
        return temp.item;
    }

    @Override
    public T get(int index) {
        if (index >= size) return null;
        Node temp = sentinel.next;
        while (index > 0) {
            index -= 1;
            temp = temp.next;
        }
        return temp.item;
    }

    private T getRecursiveHelp(int index, Node temp) {
        if (index == 0) return temp.item;
        else return getRecursiveHelp(index - 1, temp.next);
    }

    public T getRecursive(int index) {
        if (index >= size) return null;
        return getRecursiveHelp(index, sentinel.next);
    }
}
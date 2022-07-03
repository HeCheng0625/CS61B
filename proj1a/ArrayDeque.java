public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int length;
    private int front;
    private int last;

    public ArrayDeque() {
        array = (T []) new Object[8];
        size = 0;
        length = 8;
        front = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        T[] newArray = (T []) new Object[length * 2];
        for (int i = 0; i < size; i++) newArray[i] = array[(i + front) % length];
        array = newArray;
        front = 0;
        last = size - 1;
        length *= 2;
    }

    public void addFirst(T item) {
        if (size == length) resize();
        if (!isEmpty()) front = (front + length - 1) % length;
        array[front] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size == length) resize();
        if (!isEmpty()) last = (last + length + 1) % length;
        array[last] = item;
        size += 1;
    }

    public T removeFirst() {
        if (size == 0) return null;
        T result = array[front];
        if (size != 1) front = (front + 1 + length) % length;
        size -= 1;
        return result;
    }

    public T removeLast() {
        if (size == 0) return null;
        T result = array[last];
        if (size != 1) last = (last - 1 + length) % length;
        size -= 1;
        return result;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) System.out.print(array[(front + i) % length] + " ");
    }

    public T get(int index) {
        if (index >= size) return null;
        return array[(front + index) % length];
    }
}

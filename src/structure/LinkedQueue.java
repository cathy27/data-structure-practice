package structure;

import java.util.LinkedList;

/**
 * Project cathy27_dataStructurePractice
 * Created by Wings on 2016/11/14 0014 20:39
 */
public class LinkedQueue<T> implements Queue<T> {

    private LinkedList<T> linkedList;

    public LinkedQueue() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void add(T t) {
        this.linkedList.addLast(t);
    }

    @Override
    public T remove() {
        return this.linkedList.removeFirst();
    }

    @Override
    public int size() {
        return this.linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }

    @Override
    public T front() {
        return this.linkedList.peekFirst();
    }
}

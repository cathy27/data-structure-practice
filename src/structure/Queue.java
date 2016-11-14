package structure;

/**
 * Created by yilei on 2016/11/14.
 */
public interface Queue<T> {
    /**
     * 入队：从队尾加入一个元素
     */
    void add(T t);
    /**
     * 出队：移走队头元素并返回
     * @return 当前队头元素
     */
    T remove();
    /**
     * 当前队列元素个数
     */
    int size();
    /**
     * 判断当前队列是否为空
     * @return
     */
    boolean isEmpty();
    /**
     * 返回队头元素，不删除
     * @return t
     */
    T front();
}

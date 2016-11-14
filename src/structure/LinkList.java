package structure;

/**
 * Created by yilei on 2016/11/14.
 */
public class LinkList<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkList(){
        head = tail = null;
    }

    private static class Node<T>{
        private T data;
        private Node<T> next;


        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public void addHead(T point){
        this.head = new Node();
        head.setData(point);
        if(tail == null){
            tail = head;
        }
    }

    public void printLinkList(){
        Node<T> curr = this.head;
        if(isEmpty()){
            try{
                throw new Exception("linklist is empty");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        while(curr!= null){
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    public void addTail(T point){
        tail = new Node();
        tail.setData(point);
        head.setNext(tail);
    }

    public void insert(T point){
        if(this.head == null){
            addHead(point);
        }else if(this.tail == this.head){
            addTail(point);
        }else{
            Node<T> preNext = head.getNext();
            @SuppressWarnings({"unchecked","rawtypes"})
            Node<T> newNode = new Node();
            newNode.setData(point);
            this.head.setNext(newNode);
            newNode.setNext(preNext);
        }
    }

    public void delete(T data){
        Node<T> curr = head, prev = null;
        boolean suc = false;
        while (curr != null) {
            if (curr.getData().equals(data)) {
                if (curr == head) {
                    System.out.println('\n'+"delet head node");
                    head = curr.getNext();
                    suc = true;
                    return;
                }
                if (curr == tail) {
                    System.out.println('\n'+"delete tail node");
                    tail = prev;
                    prev.setNext(null);
                    suc = true;
                    return;
                } else {
                    System.out.println('\n'+"delete center node");
                    prev.setNext(curr.getNext());
                    suc = true;
                    return;
                }
            }
            prev = curr;
            curr = curr.getNext();
        }
        if(suc == false){
            System.out.println('\n'+"没有这个数据");
        }
    }

    public boolean isEmpty(){
        return this.head == null || this.tail == null;
    }

    public static Node recursionInverse(Node head){
        //head看作是前一个节点，head.getNext()是当前节点，reHead是反转后新链表的头结点
        if(head == null || head.getNext() == null){
            return head;
        }
        Node reHead = recursionInverse(head.getNext());
        head.getNext().setNext(head);//当前节点的指针域指向前一节点
        head.setNext(null);//前一节点的指针域另为null
        return reHead;//反转后新链表的头结点
    }

    public static Node ergodicInverse(Node head){
        if(head == null)
            return head;
        Node pre = head; //上一节点
        Node cur = head.getNext(); //当前节点
        Node tmp; //临时节点，用于保存当前节点的指针域
        while (cur != null){// 当前节点null，说明位于尾节点
            tmp = cur.getNext();
            cur.setNext(pre);//反转指针域的指向

            //指针往下移动
            pre = cur;
            cur = tmp;
        }
        //最后将原链表的头结点的指针域置位null，还回新链表头结点
        head.setNext(null);

        return pre;
    }

    public static void main(String[] args) {
        LinkList<Integer> mylist = new LinkList<Integer>();
        mylist.insert(5);
        mylist.insert(6);
        mylist.insert(7);
        mylist.insert(3);
        mylist.insert(9);
        mylist.printLinkList();
        mylist.head = ergodicInverse(mylist.head);
        mylist.printLinkList();
    }

}



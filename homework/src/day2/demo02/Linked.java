package day2.demo02;

public final class Linked<T> {  //泛型类，此链表支持泛型输入
    //此链表头结点不存数据，数据放在下一个开始的节点中，头结点不参与索引，我们这里的第一个节点不包括头结点，是指有数据的节点。
    public int size=0; //节点数量
    public Node<T> head;//定义头结点
    public Node<T> tail;//定义尾节点
    /**
     * 链表的构造方法
     */
    public Linked(){
        Node<T> firstNode = new Node<T>(); //创建链表的时候先创建头结点
        firstNode.data =null;
        firstNode.next =null;
        head=firstNode; //把此节点作为头结点
        tail=firstNode; //把此节点作为尾节点
    }
    /**
     * 添加元素
     * @param data
     */
    public void add(T data)
    {
        Node<T> node = new Node<T>();
        node.data=data;
        node.next=null;
        if(size>0)
        {
            Node<T> preNode = getPreNode(size);//获取前一个节点
            preNode.next= node; //使前一个节点指向当前节点
            tail=node; //把当前节点作为尾节点
            size++; //长度加一
        }
        else if(size==0)
        {
            head.next= node; //使头结点指向当前节点
            tail=node; //把当前节点作为尾节点
            size++; //长度加一
        }
    }
    /**
     * 获取指定索引的前一个节点
     */
    public Node<T> getPreNode(int index){
        Node<T> preNode = new Node<T>();
        preNode = head.next;
        for(int i=0; i<index-1;i++)   //从头结点开始循环查找节点
        {
            preNode=preNode.next ;
        }
        return preNode;		//返回此节点
    }
    /**
     * 删除指定索引处的节点
     * 返回被删除节点的数据
     * @param index
     */
    public T deleteNode(int index)
    {
        if(index<0&&index>size)
        {
            return null;
        }
        else if (index ==0) //删除第一个节点(头结点)后的那个节点
        {
            T data = head.next.data;
            head.next=head.next.next;//使头结点指向删除节点的下一个节点
            head.next.next=null;//指针赋空，可以被GC清除删除的元素
            size--;
            return data;
        }
        else if(index==size-1)//删除最后一个节点
        {
            Node<T> preNode = getPreNode(index);//获取前一个节点
            preNode.next = null;//使前一个节点指向null
            T data = preNode.next.data; //保存数据
            tail = preNode; //前一节点设为尾节点
            size--;
            return data;
        }
        else
        {
            Node<T> preNode = getPreNode(index);//获取前一个节点
            Node<T> theNode = preNode.next;//当前节点
            T data = theNode.data; //保存数据
            preNode.next = theNode.next;//使前一个节点指向当前节点的下一个节点
            theNode.next=null;//当前节点指针赋为空
            size--;
            return data;
        }
    }
    /**
     * 查找指定索引的节点
     */
    public T search(int index)
    {
        if(index<0&&index>size-1) //在范围外，返回null
        {
            return null;
        }
        else if(index==0)
        {
            return head.next.data; //返回第一个节点的数据（头结点的下一个节点）
        }
        else
        {
            Node<T> preNode = getPreNode(index); //获取前一个节点
            T data =preNode.next.data; //返回索引节点的数据
            return data;
        }
    }
    /**
     * 链表反转
     */
    public void reversal(){
        Node<T> newHeadNode = new Node<T>();//定义一个节点，之后作为新的头结点
        newHeadNode.data=null; //数据域为空
        for(int i = size ; i>2 ; i--  )
        {
            if(i==size) //第一次操作时使新节点指向最后一个节点
            {
                newHeadNode.next=getPreNode(size-1).next;
                getPreNode(i).next=getPreNode(i-2).next; //循环使得后一个节点指向前一个节点
                getPreNode(i-1).next=null; //断开向前一个节点至后一个节点的引用
            }
            else
            {
                getPreNode(i).next=getPreNode(i-2).next; //循环使得后一个节点指向前一个节点
                getPreNode(i-1).next=null; //断开向前一个节点至后一个节点的引用
            }
        }
        getPreNode(2).next=head.next; //使得第二个节点指向第一个节点（头结点不算入节点数）
        getPreNode(1).next=null; //断开引用
        tail=head.next;//原先的第一个节点变成尾节点
        head.next=null;//断开原头结点
        head=newHeadNode;//把新的节点变为头结点
    }

    public void print(){
        for(int i=0; i<size;i++)
        {
            System.out.println(search(i));
        }
    }
}

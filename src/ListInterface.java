public interface ListInterface {

    /*
    essential operations
    */
    public boolean isEmpty();

    public int getSize();

    public void clear();

    public Object getHead();

    public Object getTail();

    public Object get(Node node);

    public Node search(Object object);

    public boolean add(Object object);

    public boolean insert(Node node, Object object);

    public boolean insert(Object objectRef, Object object);

    public boolean insertHead(Object object);

    public boolean insertTail(Object object);

    public boolean set(Node node, Object object);

    public boolean remove(Node node);

    /*
    expansion operations
     */
    public boolean contains(Object object);

    public Object[] toArray();

    public Object[] toArray(Object[] object);

    public MiListaCircular subList(Node from, Node to);

    public MiListaCircular sortList();

}

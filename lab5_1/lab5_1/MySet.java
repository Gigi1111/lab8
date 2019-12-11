package lab5_1;

public interface MySet<T>{
    public int size();
    public void addElement(T o);
    public void union(MySetAsList s);
    public void intersection(MySetAsList s);
    public void subtract(MySetAsList s);
    public void remove(T o);
    public boolean isElement(T o);
    public String listElements();
}

package lab5_1;

public interface MySet<T>{
    public int size();
    public void addElement(T o);
    public MySetAsList<T> union(MySetAsList s);
    public MySetAsList<T> intersection(MySetAsList s);
    public MySetAsList<T> subtract(MySetAsList s);
    public void remove(T o);
    public boolean isElement(T o);
    public String listElements();
}

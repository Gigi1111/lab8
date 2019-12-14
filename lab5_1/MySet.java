package lab5_1;

//Alexej's version
public interface MySet<T>{
    public int size();
    public void addElement(T o);
    public void union(MySetAsList s);
    public void intersection(MySetAsList s);
    public void subtract(MySetAsList s);
    public void remove(T o);
    public boolean isElement(T o);
    public String listElements();
    public String powerSet();
}

//Fan's version
//package lab5_1;
//
//public interface MySet<T>{
//    public int getSize();
//    public boolean isEmpty();
//    public void add(T o);
//    public MySetAsList union(MySetAsList s2);
//    public MySetAsList intersection(MySetAsList s);
//    public MySetAsList subtract(MySetAsList s);
//    public void remove(T o);
//    public boolean isElement(T o);
//    public String listElements();
//    public String powerSet();
//}
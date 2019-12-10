package lab5_1;

public class MySetAsList<T> implements MySet<T> {
    // to store a set we reuse our list implementation
    // for our application we don't need to know whether the elements are ordered or not...
     private MyLinkedList<T> setList;
     private int size;
    //MySetAsList test = new MySetAsList();

    // constructor

    public MySetAsList(){
        this.setList = new MyLinkedList<>();
        this.size = setList.length;
    }




    @Override
    public int size() {
        return size;
    }

    @Override
    public void addElement(T o) {
        setList.add(o);
        size = setList.length;
    }

    @Override
    public void union(MySetAsList s) {
        // union of sets can not have double elements!

        // add all elements from second set
        for (int i = 1; i <= s.size; i++){
            T elem = (T) s.getElem(i);
            setList.add(elem);
        }
        // filter dublicates
        for (int i = 1; i <= setList.length; i++) {
            for (int j = 1; j <= setList.length; j++){
                if (setList.get(i) == setList.get(j) && i != j){
                    setList.remove(i);
                    size--;
                }
            }
        }
        // update size:
        size = setList.length;
    }

    public Object getElem(int i) {
        return setList.get(i);
    }

    @Override
    public void remove(T o) {
        setList.remove(o);

        // update size:
        size = setList.length;

    }

    @Override
    public boolean isElement(T o) {
        boolean flag = false;
        for (int i = 1; i <= setList.length; i++){
            if (setList.get(i) == o) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void intersection(MySetAsList s) {
        // add all elements from second set
        for (int i = 1; i <= s.size; i++){
            T elem = (T) s.getElem(i);
            setList.add(elem);
        }
        // look for dublicates and let them remain in the set
        for (int i = 1; i <= setList.length; i++) {
            for (int j = 1; j <= setList.length; j++){
                if (setList.get(i) != setList.get(j) && i == j){
                    setList.remove(i);
                }
            }
        }
        // update size:
        size = setList.length;
    }
}

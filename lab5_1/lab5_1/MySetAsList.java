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

        // compare one element of second set to each element of first set at a time
        for (int i = 1; i <= s.size; i++){
            T elem = (T) s.getElem(i);
            boolean dupl = false;

            for (int j = 1; j <= setList.length; j++){
                if (elem == setList.get(j)){
                    dupl = true; // set duplicate flag to true if one is found
                }
            }

            if (dupl == false) {
                setList.add(elem); // add element from second set if it is unique
            }

        }
        // update size:
        size = setList.length;
    }

    // helper function to extract elements out of sets by idx
    private Object getElem(int i) {
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
        // creating an empty temporary list for duplicate elements
        MyLinkedList tmp = new MyLinkedList();

        // compare every element of second set to every element of first set
        // if it is present in both, add it to the temporary list
        for (int i = 1; i <= s.size; i++){
            T elem = (T) s.getElem(i);

            for (int j = 1; j <= setList.length; j++){
                if (elem == setList.get(j)){
                   tmp.add(elem);
                }
            }
        }
        // our linked list structure is now the new established set of intersected elements
        setList = tmp;
        // update size:
        size = setList.length;
    }

    @Override
    public String listElements() {
        String fullSet = "{";
        for (int i = 1; i <= setList.length; i++) {
            if (i == setList.length){
                fullSet += (int)setList.get(i) + "}";
            } else {
                fullSet += (int)setList.get(i) + ", ";
            }
        }
        return fullSet;
    }


}

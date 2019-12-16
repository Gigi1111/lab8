package lab5_1;

public class MySetAsList<T> implements MySet<T> {
    // to store a set we reuse our list implementation
    // for our application we don't need to know whether the elements are ordered or not...
     private MyLinkedList<T> setList;
     private int size;

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
        if(!isElement(o)) {
            setList.add(o);
            size = setList.length;
        }
    }

    @Override
    public MySetAsList<T> union(MySetAsList s) {
        // union of sets can not have double elements!

        // create new return set:
        MySetAsList<T> uni = new MySetAsList<>();

        // copy all elements from invoking set into return set:

        for (int i = 1; i <= setList.length; i++){
            uni.addElement(setList.get(i));
            uni.size++;
        }

        // compare one element of second set to each element of first set at a time
        for (int i = 1; i <= s.size; i++){
            T elem = (T) s.getElem(i);
            boolean dupl = false;

            for (int j = 1; j <= uni.size; j++){
                if (elem == uni.getElem(j)){
                    dupl = true; // set duplicate flag to true if one is found
                }
            }

            if (dupl == false) {
                uni.addElement(elem); // add element from second set if it is unique
            }

        }

        return uni;
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
    public MySetAsList<T> intersection(MySetAsList s) {

        // create new return set:
        MySetAsList<T> inter = new MySetAsList<>();

        // compare every element of second set to every element of first set
        // if it is present in both, add it to the temporary list
        for (int i = 1; i <= s.size; i++){
            T elem = (T) s.getElem(i);

            for (int j = 1; j <= inter.size; j++){
                if (elem == inter.getElem(j)){
                   inter.addElement(elem);
                }
            }
        }
        return inter;
    }

    @Override
    public MySetAsList<T> subtract(MySetAsList s) {

        // create new return set, based on the invoking set object:
        MySetAsList<T> sub = new MySetAsList<>();
        sub.setList = this.setList;
        sub.size = this.size;

        // compare one element of second set to each element of first set at a time
        for (int i = 1; i <= s.size; i++){
            T elem = (T) s.getElem(i);
            boolean dupl = false;

            for (int j = 1; j <= sub.setList.length; j++){
                if (elem == sub.setList.get(j)){
                    dupl = true; // we have to work with flags to avoid messing around with iterator
                }
            }
            if (dupl == true){
                sub.remove(elem);
            }
        }
        return sub;
    }

    @Override
    public void listElements() {
        String fullSet = "";
        if (this.size == 0) {
            fullSet= "{ }";
        } else {
            for (int i = 1; i <= setList.length; i++) {
                if (i == 1) {
                    fullSet += "{ " + setList.get(i);
                } else {
                    fullSet += ", " + setList.get(i);
                }
            }
            fullSet += " }";
            System.out.println(fullSet);
        }
    }
}

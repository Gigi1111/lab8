package lab5_1;

public class Main {
    public static void main (String[] args) {
        MySetAsList setOne = new MySetAsList();
        MySetAsList setTwo = new MySetAsList();

        int a = 1;
        int b = 2;
        int c = 3;

        int d = 4;
        int    e = 5;
        int f = 2;


        setOne.addElement(a);
        setOne.addElement(b);

        setTwo.addElement(d);
        setTwo.addElement(e);
        setTwo.addElement(a);

        System.out.println(setOne.listElements());

        System.out.println(setOne.isElement(a));

        setOne.union(setTwo);

        System.out.println(setOne.listElements());

        setOne.intersection(setTwo);

        System.out.println("intersection of One and Two");
        System.out.println(setOne.listElements());

    }
}

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

        for (int i = 1; i <= setOne.size(); i++) {
            int element = (int)setOne.getElem(i);
            System.out.println(element);
        }

        System.out.println(setOne.isElement(a));

        setOne.union(setTwo);

        for (int i = 1; i <= setOne.size(); i++) {
            int element = (int)setOne.getElem(i);
            System.out.println(element);
        }

    }
}

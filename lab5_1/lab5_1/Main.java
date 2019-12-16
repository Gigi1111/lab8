package lab5_1;

public class Main {
    public static void main (String[] args) {
        MySetAsList<String> setOne = new MySetAsList();
        MySetAsList<String> setTwo = new MySetAsList();
        MySetAsList<String> setThree = new MySetAsList();



        setOne.addElement("A");
        setOne.addElement("B");

        setTwo.addElement("D");
        setTwo.addElement("E");
        setTwo.addElement("A");

        System.out.println("set one:");
        setOne.listElements();
        System.out.println(setOne.size());

        System.out.println("set two:");
        setTwo.listElements();

        System.out.println("set one - set two");
        setThree = setTwo.subtract(setOne);
        setThree.listElements();

    }
}

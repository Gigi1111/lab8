package lab5_1;

//Alexej's version
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
    public void subtract(MySetAsList s) {

        // compare one element of second set to each element of first set at a time
        for (int i = 1; i <= s.size; i++){
            T elem = (T) s.getElem(i);
            boolean dupl = false;

            for (int j = 1; j <= setList.length; j++){
                if (elem == setList.get(j)){
                    dupl = true; // we have to work with flags to avoid messing around with iterator
                }
            }
            if (dupl == true){
                setList.remove(elem);
            }
        }
        // update size:
        size = setList.length;
    }

    @Override
    public String listElements() {
        String fullSet = "";
        if (this.size == 0) {
            return "{ }";
        } else {
            for (int i = 1; i <= setList.length; i++) {
                if (i == setList.length) {
                    fullSet += (int) setList.get(i) + " }";
                }
                if (i == 1) {
                    fullSet += "{ " + (int) setList.get(i);
                } else {
                    fullSet += (int) setList.get(i) + ", ";
                }
            }
            return fullSet;
        }
    }
    
    @Override
  public String powerSet() {
		int num_of_powersets = (int) Math.pow(2, size());
		// 2,2,2 yes or no
		MySetAsList[] powersets = new MySetAsList[num_of_powersets];
		for(int k=0;k<num_of_powersets;k++)
			powersets[k]=new MySetAsList();
		
		//create 9 subsets
		String[] elements = setList.toString().split(" ");//!!
		
		//0  1 2   12
		//0     ;1        (0,1)2^0(0,2)2^1(0,4)2^2  n-1  n-2 n-3==0
		//0  1  ;0   1    2=2^2=4
		//01 01 ;01  01  
		int n=elements.length-1;
		String[] sets = new String[num_of_powersets];
		for(int i=0;i<num_of_powersets;i++) {
			for(int j=0; j<=n;j++) {//i=8, 4
				int divide=(int)Math.pow(2, n-j);
				if((int)(i/divide)%2==0) {
					powersets[i].addElement(elements[j]);
				}
			}
			sets[i]=powersets[i].listElements();
		}
		String combined = String.join("", sets);
		return combined;
	}
    
    
    public static void main(String[] args) {
	 	MySetAsList<String> s1=new MySetAsList<String>();
	 	s1.addElement("1");
	 	s1.addElement("2");
	 	s1.addElement("3");
	 	System.out.println("s1:"+ s1.listElements());
	 	MySetAsList<String> s2=new MySetAsList<String>();
	 	s2.addElement("3");
	 	s2.addElement("2");
	 	s2.addElement("1");
	 	System.out.println("s2:"+ s2.listElements());
	 	System.out.println("union:"+ s1.union(s2).listElements());
	 	System.out.println("subtract:"+ s1.subtract(s2).listElements());
	 	System.out.println("intersection:"+ s1.intersection(s2).listElements());
	 	System.out.println("powersets:"+ s1.powerSet());
	 }
}

//Fan's version
//package lab5_1;
//
//public class MySetAsList<T> implements MySet<T> {
//    // to store a set we reuse our list implementation
//    // for our application we don't need to know whether the elements are ordered or not...
//     private MyLinkedList<T> linkedListInSet;
//     private int size;
//
//     public MyLinkedList<T> getList(){
//    	 return linkedListInSet;
//     }
//     public static void main(String[] args) {
//	 	MySetAsList<String> s1=new MySetAsList<String>();
//	 	s1.add("1");
//	 	s1.add("2");
//	 	s1.add("3");
//	 	System.out.println("s1:"+ s1.listElements());
//	 	MySetAsList<String> s2=new MySetAsList<String>();
//	 	s2.add("3");
//	 	s2.add("7");
//	 	s2.add("2");
//	 	s2.add("1");
//	 	s2.add("7");
//	 	s2.add("6");
//	 	s2.add("9");
//	 	System.out.println("s2:"+ s2.listElements());
//	 	System.out.println("union:"+ s1.union(s2).listElements());
//	 	System.out.println("subtract:"+ s1.subtract(s2).listElements());
//	 	System.out.println("intersection:"+ s1.intersection(s2).listElements());
//	 	System.out.println("powersets:"+ s1.powerSet());
//	 }
//     
//
//     // constructor
//    public MySetAsList(){
//        linkedListInSet = new MyLinkedList<>();
//    }
//
//    @Override
//    public int getSize() {
//    	return getList().length;
//    }
//    @Override
//	public boolean isEmpty() {
// 		return getSize()==0;
// 	}
//
//    @Override
//    public void add(T data) {
//    	if(!isElement(data))
//    		getList().add(data);
//    }
//
//    @Override//!need to return set
//    public MySetAsList union(MySetAsList s2) {
//    	//first create s3 that has all the s1
//   	//iterate through s2 and check if s1 has s2, if not add in
//    	MySetAsList s3 = new MySetAsList();
//    	int i=0;
//    	int j=0;
//    	MyNode n1=getList().head;
//    	MyNode n2=s2.getList().head;
//    	
//    	while(n1!=null) {
//    		s3.add(n1.data);
//    		n1=n1.next;
//    	}
//    	while(n2!=null) {
//    		if(!s3.isElement(n2.data)) {
//    			s3.add(n2.data);
//    		}
//    		n2=n2.next;
//    	}
//    	
//    	return s3;
//    }
//
//    // helper function to extract elements out of sets by idx
//    private Object getElem(int i) {
//        return getList().get(i);
//    }
//
//    @Override
//    public void remove(T o) {
//        getList().remove(o);
//    }
//
//    @Override
//    public boolean isElement(T o) {
//    	return getList().get(o)!=-1;
//    }
//
//    @Override
//    public MySetAsList intersection(MySetAsList s2) {
//    	MySetAsList s3 = new MySetAsList();
//    	int i=0;
//    	int j=0;
//    	MyNode n1=getList().head;
//    	MyNode n2=s2.getList().head; 	
//    	
//    	while(n1!=null) {
//    		if(s2.isElement(n1.data)) {
//    			s3.add(n1.data);
//    		}
//    		n1=n1.next;
//    	}
//    	
//    	return s3;
//    }
//
//    @Override
//    public MySetAsList subtract(MySetAsList s2) {
//    	MySetAsList s3 = new MySetAsList();
//    	int i=0;
//    	int j=0;
//    	MyNode n1=getList().head;
//    	MyNode n2=s2.getList().head;
//    	
//    	
//    	while(n1!=null) {
//    		if(!s2.isElement(n1.data)) {
//    			s3.add(n1.data);
//    		}
//    		n1=n1.next;
//    	}
//    	
//    	return s3;
//    }
//
//    @Override
//    public String powerSet() {
//		int num_of_powersets = (int) Math.pow(2, getSize());
//		// 2,2,2 yes or no
//		MySetAsList[] powersets = new MySetAsList[num_of_powersets];
//		for(int k=0;k<num_of_powersets;k++)
//			powersets[k]=new MySetAsList();
//		
//		//create 9 subsets
//		String[] elements = getList().toString().split(" ");//!!
//		
//		//0  1 2   12
//		//0     ;1        (0,1)2^0(0,2)2^1(0,4)2^2  n-1  n-2 n-3==0
//		//0  1  ;0   1    2=2^2=4
//		//01 01 ;01  01  
//		int n=elements.length-1;
//		String[] sets = new String[num_of_powersets];
//		for(int i=0;i<num_of_powersets;i++) {
//			for(int j=0; j<=n;j++) {//i=8, 4
//				int divide=(int)Math.pow(2, n-j);
//				if((int)(i/divide)%2==0) {
//					powersets[i].add(elements[j]);
//				}
//			}
//			sets[i]=powersets[i].listElements();
//		}
//		String combined = String.join("", sets);
//		return combined;
//	}
//
//	@Override
//	 public String listElements() {
//	    return "{"+String.join(",", getList().toString().split(" "))+"}";
//	}
//}
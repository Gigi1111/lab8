package lab5_1;

import java.util.EmptyStackException;


public class StackAsList<T> implements Stack<T>{
	MyLinkedList<T> ll;
	static int size;
	MyNode<T> top;
	
	public StackAsList(){
		ll=new MyLinkedList<T>();
		top=ll.end;
	}

	public static void main(String[] args) {
		StackAsList<String> st=new StackAsList<String>();
		while(true) {
			st.push("1");
		}
	}
	public int getSize() {
		size=ll.length;
        return size;
    }

	 	public boolean isEmpty() {
	        return getSize() == 0;
	    }
	 	
	 	
	 	public void push(T element) {
	    	
	    	if(getSize()>1000)
	    		throw new RuntimeException("Stack Overflow!!");
	    	ll.add(element); 
	    }

	    public T pop() {
	    	 return (T) ll.removeLast();
	    	
	    }
	    public T peek() {
		    return (T) ll.getEnd();
	    }
	    public String toString() {
	    	MyNode<T> n = ll.head;
	    	String s="";
	    	for(int i=1; i<=ll.length ;i++) {
	    		if( n!=null) {
	    		s=s+n.data+" ";
	    		n=n.next;
	    		}
	    	}
		    return s;
	    }
	   
}

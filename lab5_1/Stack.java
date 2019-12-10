package lab5_1;

public interface Stack<T> {
	    public int getSize();
     	public boolean isEmpty();
	    public T pop();
	    public T peek();
	    public String toString();
		public void push(T element);
}

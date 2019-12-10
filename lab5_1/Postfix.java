package lab5_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Postfix {
	private static String numbers="1234567890ABCDEF";
	private static String operators="+-*/^";
	public static int res=0;
	public static String prio="";
	
	public Postfix() {
		
	}
	
	public static String evaluate(String str,int base) {//evaluate double digit and double/int mix
		 res=0;
		 String last="x";
		StackAsList<String> n=new StackAsList<String>();
		StackAsList<String> op=new StackAsList<String>();
		
		for(int i=0;i<str.length();i++) {
			String c=str.substring(i,i+1);
	
			if(operators.contains(c)) {
				if(n.getSize()>1) {
					String top=n.peek();
					//System.out.println("top:"+top);
					int two=0,one=0;
					if(numbers.indexOf(top)>9) {
						two=(int)Long.parseLong(n.pop(),16);
					}else {
						two=Integer.parseInt(n.pop());
					}
					top=n.peek();
					if(numbers.indexOf(top)>9) {
						one=(int)Long.parseLong(n.pop(),16);
					}else {
						one=Integer.parseInt(n.pop());
					}
								
					

					int result=0;
					if(c.equals("+")) {
						result=one+two;
					}
					else if(c.equals("-")){
						result = one-two;
					}
					else if(c.equals("*")){
						result = one*two;
					}
					else if(c.equals("/")){
						result = one/two;
					}
					else if(c.equals("^")){
						result = (int)Math.pow(one,two);
					}
					n.push(String.valueOf(result));
				}
			}else if(numbers.contains(c)){//it's a number

				n.push(c);	
				
			}
			last=c;
			n.toString();
		}
		//if(n.getSize()==1) {
			String re=""+Integer.parseInt(n.pop());
			if(base==16) {
				//System.out.println("16 result:"+re);
				return inHex(Integer.parseInt(re));
			}
			return re;
		//}
		//return -1;
	}
	private static String inHex(int deci) {
    	String str="";
    	
    	String[] hexaSign= {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    	for(int i=0;Math.pow(16, i)<=deci;i++) {
    		str+=hexaSign[ (deci/((int)Math.pow(16, i)))%16];
    	//	System.out.println("str:"+str);
    	}
    	return strReverse(str);
    }
    private static String strReverse(String str) {
    	String str2="";
    	for(int i=str.length()-1;i>=0;i--) {
    		str2+=str.charAt(i);
    	}
    	return str2;
    }
	 public static void main(String[] args)throws IOException {
		 
//		 while(true){
//			 System.out.print("Type in your infix: ");  
//		 
//	        BufferedReader reader =  
//	                   new BufferedReader(new InputStreamReader(System.in)); 
//	        
//	      
//	        String userInput  = reader.readLine().replaceAll("\\s+",""); 
//	        if(userInput.equals("quit"))break;
//
//
//	        System.out.println("You typed in: "+ userInput);    
//	        System.out.println("Its postfix form: "+infixToPostfix(userInput));  
//	        System.out.println("Calculation result: "+evaluate(infixToPostfix(userInput)));  
//		 
//		 }
//		 System.out.print("End of Game");  
		// System.out.print(evaluate("5+1"));  
		 
	}
	 public static String infixToPostfix (String ifx){
		 String s="";
		 StackAsList<String> n=new StackAsList<String>();
		 StackAsList<String> op=new StackAsList<String>();
		 StackAsList<String> parenth=new StackAsList<String>();
		 int nn=0;
		
		prio="";
		String rightop="";
		String lastop="";
		String currentop="";
		String lastnum="";
		String last="x";
//not well formed situation: 
//1. two numbers(only allow single digit)or operators in a row
//2. ends or start with operator
//3.  no ) after (, equal amount of parenthesis
//4. /0 divide by 0 
		for(int i=0;i<ifx.length();i++) {
			 String c=ifx.substring(i,i+1);
			 if(i+2<ifx.length()) {
				 String c2 = ifx.substring(i+1,i+2);
				 if(operators.contains(c)&& operators.contains(c2)) {
					 throw new IllegalArgumentException("Can't have two operators in a row!");
						
				 }else if(numbers.contains(c)&& numbers.contains(c2)) {
					 throw new IllegalArgumentException("Can't have two numbers in a row!");
						
				 }else if(c.equals("/")&& c2.equals("0")) {
					 throw new IllegalArgumentException("Can't divide by 0!");
				 }
			 }
			 if(c.equals("(")) {
					parenth.push(c);
				}else if(c.equals(")")) {
					parenth.pop();
				}
			 
			 if(operators.contains(c)||c.equals("(")||c.equals(")")) {
				//2. ends or start with operator
				 if(operators.contains(c)&& (i==0 || i==ifx.length()-1)) {
					 throw new IllegalArgumentException("Operators can't be at the beginning or end!");
				 }
					 
				 if(c.equals("(")||c.equals(")")) {
					 prio=c;
					 continue;
				 }
				 else {
					 if((operators.indexOf(c)>1 && (lastop.equals("+")||lastop.equals("-"))&&!prio.contentEquals(")"))
						 ||
						 (operators.indexOf(c)>3 && (lastop.equals("*")||lastop.equals("/"))&&!prio.contentEquals(")"))
						 ||
							prio.equals("(")) {

					prio="";
					
					while(operators.indexOf(n.peek())>-1) {
						String temp=n.pop();
						op.push(temp);		
					}
				 }
				 			 
				 op.push(c);
				 }
			}else if(numbers.contains(c)){//it's a number
				
				n.push(c);
				nn++;
				if(nn==2 && op.getSize()>0) {
						nn=1;
						
						while(op.getSize()>0) {
						lastop=op.pop();
							n.push(lastop);
					}
						
				}
			}
			
			last=c;
			 
		 }
		if(parenth.getSize()>0) {//means () doesn't match
			 throw new IllegalArgumentException("Parenthesis mismatch!");
				
		}
		 while(op.getSize()>0) {
				n.push(op.pop());
			}
		
		 return  n.toString().replaceAll("\\s+","");
	 }
}


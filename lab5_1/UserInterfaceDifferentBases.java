//package lab5_1;
//
//import java.awt.event.ActionListener;
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import javax.swing.border.*;
////Integrate a checkbox for switching between decimal and
////hexadecimal formats. Do not show the hexadecimal digits 
////(or grey them out) when you have the calculator in decimal mode.
//
//
//public class UserInterfaceDifferentBases extends UserInterface 
//{
//	private boolean selected = false;
//	private int base = 10;
//	 JButton bin = new JButton("bin");
//     JButton oct = new JButton("oct");
//     JButton dec = new JButton("dec");
//     JButton hex = new JButton("hex");
//	
//	 public UserInterfaceDifferentBases(CalcEngine engine)
//	    {
//	       super(engine);
//	       makeFrame();
//	       frame.setVisible(true);
//	    }
//	 
//	 private void makeFrame()
//	    {
//	        frame = new JFrame(calc.getTitle());
//	        
//	        contentPane = (JPanel)frame.getContentPane();
//	        contentPane.setLayout(new BorderLayout(8, 8));
//	        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));
//	        display = new JTextField();
//	        contentPane.add(display, BorderLayout.NORTH);
//	        
//	        //
//	        JPanel basePanel = new JPanel(new GridLayout(1, 4));//ver,hor
//	       
////	        btn.setBackground(Color.BLACK);
////	        btn.setForeground(Color.GRAY);
////	        basePanel.add(bin);
////	        basePanel.add(oct);
////	        basePanel.add(dec);
////	        basePanel.add(hex);
//	        addButton(basePanel, "bin");
//        	addButton(basePanel, "oct");  
// 	        addButton(basePanel, "dec");
// 	        addButton(basePanel, "hex");    	        
// 	       contentPane.add(basePanel, BorderLayout.CENTER);
//	      
////	        JCheckBox check16 = new JCheckBox("Hexadecimal");
////	        check16.setSelected(false);
////	        addCheckBox(contentPane,check16);
//	        
//	       fillButtons();
//	        	
//
//	    }
//	 
//	    
//	    private void fillButtons() {
//		// TODO Auto-generated method stub
//	    	 
//		       
//	        if(selected==true || base==16) {//hexa
//	        	 buttonPanel= new JPanel(new GridLayout(7, 4));//ver,hor
//	        	addButton(buttonPanel, "D");
//	 	        addButton(buttonPanel, "E");
//	 	        addButton(buttonPanel, "F");    
//	 	        buttonPanel.add(new JLabel(" "));
//	 	       
//	 	        addButton(buttonPanel, "A");
//	 	        addButton(buttonPanel, "B");
//	 	        addButton(buttonPanel, "C");
//	 	        buttonPanel.add(new JLabel(" "));
//	 	        
//	 	       addButton(buttonPanel, "7");
//		        addButton(buttonPanel, "8");
//		        addButton(buttonPanel, "9");	        
//		        addButton(buttonPanel, "+");
//		        
//		        addButton(buttonPanel, "4");
//		        addButton(buttonPanel, "5");
//		        addButton(buttonPanel, "6");
//		        addButton(buttonPanel, "-");
//		             
//		       
//		        addButton(buttonPanel, "1");
//		        addButton(buttonPanel, "2");
//		        addButton(buttonPanel, "3");
//		        addButton(buttonPanel, "*");
//		        
//		        addButton(buttonPanel, "0");
//		        buttonPanel.add(new JLabel(" "));
//		        buttonPanel.add(new JLabel(" "));
//		        addButton(buttonPanel, "/");
//		        
//		        addButton(buttonPanel, "Cl");	     
//		        addButton(buttonPanel, "?");
//		        buttonPanel.add(new JLabel(" "));	        
//		        addButton(buttonPanel, "=");
//	        }
//	        else if(base==10){//deci
//	        	 buttonPanel= new JPanel(new GridLayout(5, 4));//ver,hor
//	        	addButton(buttonPanel, "7");
//	  	        addButton(buttonPanel, "8");
//	  	        addButton(buttonPanel, "9");	        
//	  	        addButton(buttonPanel, "+");
//	  	        
//	  	        addButton(buttonPanel, "4");
//	  	        addButton(buttonPanel, "5");
//	  	        addButton(buttonPanel, "6");
//	  	        addButton(buttonPanel, "-");
//	  	             
//	  	       
//	  	        addButton(buttonPanel, "1");
//	  	        addButton(buttonPanel, "2");
//	  	        addButton(buttonPanel, "3");
//	  	        addButton(buttonPanel, "*");
//	  	        
//	  	        addButton(buttonPanel, "0");
//	  	        buttonPanel.add(new JLabel(" "));
//	  	        buttonPanel.add(new JLabel(" "));
//	  	        addButton(buttonPanel, "/");
//	  	        
//	  	        addButton(buttonPanel, "Cl");	     
//	  	        addButton(buttonPanel, "?");
//	  	        buttonPanel.add(new JLabel(" "));	        
//	  	        addButton(buttonPanel, "=");
//	        }    
//	        else if(base==8){//deci
//	        	 buttonPanel= new JPanel(new GridLayout(4, 4));//ver,hor
//	        
//	  	    
//	  	        
//	  	        addButton(buttonPanel, "4");
//	  	        addButton(buttonPanel, "5");
//	  	        addButton(buttonPanel, "6");
//	  	        addButton(buttonPanel, "7");
//	  	       
//	  	             
//	  	       
//	  	        addButton(buttonPanel, "0");
//	  	        addButton(buttonPanel, "1");
//	  	        addButton(buttonPanel, "2");
//	  	        addButton(buttonPanel, "3");
//	  	        
//	  	        
//	  	        addButton(buttonPanel, "+");
//	  	      	addButton(buttonPanel, "-");
//	  	      	addButton(buttonPanel, "*");
//	  	        addButton(buttonPanel, "/");
//	  	        
//	  	        addButton(buttonPanel, "Cl");	     
//	  	        addButton(buttonPanel, "?");
//	  	        buttonPanel.add(new JLabel(" "));	        
//	  	        addButton(buttonPanel, "=");
//	        }   
//	        else if(base==2) {
//	        	
//		       buttonPanel= new JPanel(new GridLayout(3, 4));//ver,hor
//		        	     
//		        addButton(buttonPanel, "0");
//			  	addButton(buttonPanel, "1");
//			  	buttonPanel.add(new JLabel(" "));
//			  	buttonPanel.add(new JLabel(" "));
//		        	
//			  	 addButton(buttonPanel, "+");
//			  	 addButton(buttonPanel, "-");
//			  	 addButton(buttonPanel, "*");
//			  	 addButton(buttonPanel, "/");
//			  	 
//		  	        
//		  	        addButton(buttonPanel, "Cl");	     
//		  	        addButton(buttonPanel, "?");
//		  	        buttonPanel.add(new JLabel(" "));	        
//		  	        addButton(buttonPanel, "=");
//		          
//	        }
//	        
//	        
//	        contentPane.add(buttonPanel, BorderLayout.SOUTH);
//	     
////	        status = new JLabel(calc.getAuthor());
////	        contentPane.add(status, BorderLayout.SOUTH);
//
//	        
//	        frame.pack();
//	}
//
//		/**
//	     * Add a button to the button panel.
//	     * @param panel The panel to receive the button.
//	     * @param buttonText The text for the button.
//	     */
//	    private void addButton(Container panel, String buttonText)
//	    {
//	        JButton button = new JButton(buttonText);
//	        button.addActionListener(this);
//	        panel.add(button);
//	    }
//
//	    private void addCheckBox(Container panel, JCheckBox check16) {
//	    	check16.addActionListener(this);
//	    	panel.add(check16,BorderLayout.CENTER);
//	    }
//	    /**
//	     * An interface action has been performed.
//	     * Find out what it was and handle it.
//	     * @param event The event that has occured.
//	     */
//	    public void actionPerformed(ActionEvent event)
//	    {
//	    	 
//	        String command = event.getActionCommand();
//
//	        if(command.equals("bin")){
//	 	       base=2;
//	 	      bin.setBackground(Color.BLACK);
//		 	  	contentPane.remove(buttonPanel);
//	       		fillButtons();
//	        
//	        }else if(command.equals("oct")){
//	        	base=8;
//	        	oct.setBackground(Color.BLACK);
//	        	contentPane.remove(buttonPanel);
//	       		fillButtons();
//	        }else if(command.equals("dec")){
//	        	base=10;
//	        	dec.setBackground(Color.BLACK);
//	        	contentPane.remove(buttonPanel);
//	       		fillButtons();
//	        }else if(command.equals("hex")){
//        		base=16;
//        		hex.setBackground(Color.BLACK);
//        		contentPane.remove(buttonPanel);
//	       		fillButtons();
//            }else if(command.equals("0") ||
//	           command.equals("1") ||
//	           command.equals("2") ||
//	           command.equals("3") ||
//	           command.equals("4") ||
//	           command.equals("5") ||
//	           command.equals("6") ||
//	           command.equals("7") ||
//	           command.equals("8") ||
//	           command.equals("9")) {
//	        	
////	          long number = Long.parseLong(command,16);
//	        	int number = Integer.parseInt(command);
//	             calc.numberPressed(number,base);
//	        }else if((base==16||selected==true) &&(command.equals("A") ||
//	                command.equals("B") ||
//	                command.equals("C") ||
//	                command.equals("D") ||
//	                command.equals("E") ||
//	                command.equals("F")) ) {
//	        	
//	      	
//	        	long num =Long.parseLong(command,16);
//	        	int number = (int)num;
//	            calc.numberPressed(number,base);//times 16 not 10
//	        	
//	        }
//	        else if(command.equals("+")) {
//	            calc.plus();
//	        }
//	        else if(command.equals("-")) {
//	            calc.minus();
//	        }
//	        else if(command.equals("*")) {
//	            calc.multi();
//	        }
//	        else if(command.equals("/")) {
//	            calc.div();
//	        }
//	        else if(command.equals("=")) {
//	            calc.equals();
//	        }
//	        else if(command.equals("Cl")) {
//	            calc.clear();
//	        }
//	        else if(command.equals("?")) {
//	            showInfo();
//	        }
//	        else if(command.equals("Hexadecimal")) {
//	        	
//	        	contentPane.remove(buttonPanel);
//	        	if(selected==true) {
//	        		selected=false;//false: display in deci
//	        		fillButtons();
//	        
//	        	}else {
//	        		selected=true;//true: display in hexa
//	        		fillButtons();
//	        	}
//	       
//	            	
//	     
//	        }
//
//	        redisplay();
//	    }
//
//		public boolean isSelected() {
//	    	return selected;
//	    }
//	    /**
//	     * Update the interface display to show the current value of the 
//	     * calculator.
//	     */
//	    protected void redisplay()
//	    {
//	    	if(base!=10)
//	    		display.setText(" " + inDiffBase((int)calc.getDisplayValue(),base));
//	    	
//	    	else {//dec
//	    		if( calc.getDisplayValue()%1>0)
//	    	        display.setText("" + calc.getDisplayValue());
//	    	    	else{
//	    	    		display.setText("" + (int)calc.getDisplayValue());
//	    	    	}
//	    	}
//	    	
//	    }
//	    private String inDiffBase(int deci,int base) {
//	    	String str="";
//	    	String[] hexaSign= {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
//	    	for(int i=0;Math.pow(base, i)<=deci;i++) {
//	    		str+=hexaSign[ (deci/((int)Math.pow(base, i)))%base];
//	    	}
//	    	return strReverse(str);
//	    }
////	    private String inHex(int deci) {
////	    	String str="";
////	    	String[] hexaSign= {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
////	    	for(int i=0;Math.pow(16, i)<=deci;i++) {
////	    		str+=hexaSign[ (deci/((int)Math.pow(16, i)))%16];
////	    	}
////	    	return strReverse(str);
////	    }
////	    private String inBin(int deci) {
////	    	String str="";
////	    	for(int i=0;Math.pow(2, i)<=deci;i++) {
////	    		str+=(deci/((int)Math.pow(2, i)))%2;
////	    	}
////	    	return strReverse(str);
////	    }
////	    private String inOct(int deci) {
////	    	String str="";
////	    	for(int i=0;Math.pow(8, i)<=deci;i++) {
////	    		str+=(deci/((int)Math.pow(8, i)))%8;
////	    	}
////	    	return strReverse(str);
////	    }
//	    private String strReverse(String str) {
//	    	String str2="";
//	    	for(int i=str.length()-1;i>=0;i--) {
//	    		str2+=str.charAt(i);
//	    	}
//	    	return str2;
//	    }
//	   
//	}
//

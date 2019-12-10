package lab5_1;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
//Integrate a checkbox for switching between decimal and
//hexadecimal formats. Do not show the hexadecimal digits 
//(or grey them out) when you have the calculator in decimal mode.


public class UserInterfaceHex extends UserInterface 
{
	public String res;
	public String pressed;
	private int base=10;
	private boolean selected = false;
	
	 public UserInterfaceHex(CalcEngine engine)
	    {
	       super(engine);
	       makeFrame();
	       frame.setVisible(true);
	    }
	 
	 private void makeFrame()
	    {
	        frame = new JFrame(calc.getTitle());
	        
	        contentPane = (JPanel)frame.getContentPane();
	        contentPane.setLayout(new BorderLayout(8, 8));
	        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));
	        display = new JTextField();
	        
	        contentPane.add(display, BorderLayout.NORTH);
	        JCheckBox check16 = new JCheckBox("Hexadecimal");
	        check16.setSelected(false);
	        addCheckBox(contentPane,check16);
	        
	       fillButtons();
	        	

	    }
	 
	    
	    private void fillButtons() {
		
		       
	        if(selected==true) {//hexa
	        	base=16;
	        	 buttonPanel= new JPanel(new GridLayout(7, 4));
	        	addButton(buttonPanel, "D");
	 	        addButton(buttonPanel, "E");
	 	        addButton(buttonPanel, "F");    
	 	        buttonPanel.add(new JLabel(" "));
	 	       
	 	        addButton(buttonPanel, "A");
	 	        addButton(buttonPanel, "B");
	 	        addButton(buttonPanel, "C");
	 	        buttonPanel.add(new JLabel(" "));
	        }
	        else {//deci
	        	base=10;
	        	 buttonPanel= new JPanel(new GridLayout(5, 4));
	        }    
	       	      
	    
	        addButton(buttonPanel, "7");
	        addButton(buttonPanel, "8");
	        addButton(buttonPanel, "9");	        
	        addButton(buttonPanel, "+");
	        
	        addButton(buttonPanel, "4");
	        addButton(buttonPanel, "5");
	        addButton(buttonPanel, "6");
	        addButton(buttonPanel, "-");
	             
	       
	        addButton(buttonPanel, "1");
	        addButton(buttonPanel, "2");
	        addButton(buttonPanel, "3");
	        addButton(buttonPanel, "*");
	        
	        addButton(buttonPanel, "0");
	        buttonPanel.add(new JLabel(" "));
	        addButton(buttonPanel, "^");
	        addButton(buttonPanel, "/");
	        
	        addButton(buttonPanel, "Cl");	     
	        addButton(buttonPanel, "?");
	        buttonPanel.add(new JLabel(" "));	        
	        addButton(buttonPanel, "=");
	        
	        
	        contentPane.add(buttonPanel, BorderLayout.SOUTH);
	     
//	        status = new JLabel(calc.getAuthor());
//	        contentPane.add(status, BorderLayout.SOUTH);

	        
	        frame.pack();
	}

		/**
	     * Add a button to the button panel.
	     * @param panel The panel to receive the button.
	     * @param buttonText The text for the button.
	     */
	    private void addButton(Container panel, String buttonText)
	    {
	        JButton button = new JButton(buttonText);
	        button.addActionListener(this);
	        panel.add(button);
	    }

	    private void addCheckBox(Container panel, JCheckBox check16) {
	    	check16.addActionListener(this);
	    	panel.add(check16,BorderLayout.CENTER);
	    }
	    /**
	     * An interface action has been performed.
	     * Find out what it was and handle it.
	     * @param event The event that has occured.
	     */
	    public String returnPressed() {
	    	return pressed;
	    }
	    public void actionPerformed(ActionEvent event)
	    {
	    	 
	    	String command = event.getActionCommand();


	        
	        if(command.equals("=")) {
	            calc.equals(base);
	        }
	        
	        else if(command.equals("Cl")) {
	            calc.clear();
	        }
	        else if(command.equals("?")) {
	            showInfo();
	        }
	        
	        // else unknown command.
	        else if(command.equals("Hexadecimal")) {
	        	
	        	contentPane.remove(buttonPanel);
	        	if(selected==true) {
	        		selected=false;//false: display in deci
	        		fillButtons();
	        
	        	}else {
	        		selected=true;//true: display in hexa
	        		fillButtons();
	        	}
	       
	            	
	     
	        }
	        else{//number and A-F
	        	calc.displayAppend(command);
	        }
	        redisplay();
////	          long number = Long.parseLong(command,16);
//	        	int number = Integer.parseInt(command);
//	             calc.numberPressed(number,base);
//	        }else if(selected==true &&(command.equals("A") ||
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
//	     
	    }

		public boolean isSelected() {
	    	return selected;
	    }
	    /**
	     * Update the interface display to show the current value of the 
	     * calculator.
	     */
//	    protected void redisplay()
//	    {
//	    	if(selected) {//hex
//	    		res=inHex((int)calc.getDisplayValue());
//	    		display.setText("" + res);
//	    	}else {
//	    		if( calc.getDisplayValue()%1>0) {
//	    			res=String.valueOf(calc.getDisplayValue());
//	    	        display.setText("" + res);
//	    		}
//	    	        else{
//	    	    		res= String.valueOf((int)calc.getDisplayValue());
//	    	    		display.setText("" + res);
//	    	    	}
//	    	}
//	    	
//	    	
//	    }
		 protected void redisplay()
		    {
		    	 
		    	display.setText(calc.getDisplay());
		    	
//		    	if( calc.getDisplayValue()%1>0)
//		        display.setText("" + calc.getDisplayValue());
//		    	else{
//		    		display.setText("" + (int)calc.getDisplayValue());
//		    	}
		    }

	    public String returnRes() {
	    	return res;
	    }
	    private String inHex(int deci) {
	    	String str="";
	    	String[] hexaSign= {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	    	for(int i=0;Math.pow(16, i)<=deci;i++) {
	    		str+=hexaSign[ (deci/((int)Math.pow(16, i)))%16];
	    	}
	    	return strReverse(str);
	    }
	    private String strReverse(String str) {
	    	String str2="";
	    	for(int i=str.length()-1;i>=0;i--) {
	    		str2+=str.charAt(i);
	    	}
	    	return str2;
	    }
	   
	}


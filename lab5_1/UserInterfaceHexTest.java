package lab5_1;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

class UserInterfaceHexTest {
	private int id= 0;
	private ActionEvent event;
	private CalcEngine engine = new CalcEngine();
	private UserInterfaceHex uihex = new UserInterfaceHex(engine);
	private String str;
	
	@Test
	 public void testDecPrecedence() {
		String[] testCases = {"1+2*3=","2+0*3=","5-5*2=",
				"1+2*6*3+1=","1*2*3-1*4+2*5=","1*0+3*0=", 
				"0*1+0*3=","8-3*4/2-2/1=","0+0=",
				"4*3/6=","6/3*4+1=","1-2*3+8/4=",
				"2*3-4^2+6/3=","2^3*2-7*2=","2*4*0+0/3^2-4="
				};
		String[] answer = {"7","2","-5",
				"38","12","0", 
				"0","0","0",
				"2","9","-3",
				"-8","2","-4"
				};
		for(int j=0;j<testCases.length;j++) {
			str=testCases[j];
			for(int i=0;i<str.length();i++) {
				event = new ActionEvent(this, id++, ""+str.charAt(i));
				uihex.actionPerformed(event);
			}
			assertEquals(answer[j],engine.getDisplay());
			//clear the string after each calculation
			event = new ActionEvent(this, id++, "Cl");
			uihex.actionPerformed(event);
		}
			
	}
	//hex
	@Test
	 public void testHexPrecedence() {
		String[] testCases = {"1+0=","0+2=","1+3*0=",
				"1+2*6*3+1=","1*2*3-1*4+2*5=","1-1*0+3*0=", 
				"1+0*1+2-0*3=","8-3*4/2-2/1+2^0=","0+2/2^1=",
				"4*3/6=","6/3*4+1=","A-2*3+8/4=",
				"F-3^2+C/3=","2^3*A-B*2=","2*C*1/8+9/3^2+A="
				};
		String[] answer = {"1","2","1",
				"26","C","1", 
				"3","1","1",
				"2","9","6",
				"A","3A","E"
				};

		
		event = new ActionEvent(this, id++, "Hexadecimal");
		uihex.actionPerformed(event);
		for(int j=0;j<testCases.length;j++) {
			str=testCases[j];
			for(int i=0;i<str.length();i++) {
				event = new ActionEvent(this, id++, ""+str.charAt(i));
				uihex.actionPerformed(event);
			}
			assertEquals(answer[j],engine.getDisplay());
			//clear the string after each calculation
			event = new ActionEvent(this, id++, "Cl");
			uihex.actionPerformed(event);	
		}
			
	}


}
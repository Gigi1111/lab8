package lab5_1;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.Test;

class UserInterfaceTest {
	private int id= 0;
	private ActionEvent event;
	private CalcEngine engine = new CalcEngine();
	private UserInterface uihex = new UserInterface(engine);
	private String str;
	
	@Test
	 public void testDecAdd() {
		str="0+0=";//0
		for(int i=0;i<str.length();i++) {
			event = new ActionEvent(this, id++, ""+str.charAt(i));
			uihex.actionPerformed(event);
		}
		assertEquals("0", engine.getDisplay());
	 
		event = new ActionEvent(this, id++, "C");
		uihex.actionPerformed(event);
		
		str="2+1=";//3
		for(int i=0;i<str.length();i++) {
			event = new ActionEvent(this, id++, ""+str.charAt(i));
			uihex.actionPerformed(event);
		}
		assertEquals("3", engine.getDisplay());
	}
	@Test
	 public void testDecMin() {
		
		str="4-5=";//-1
		for(int i=0;i<str.length();i++) {
			event = new ActionEvent(this, id++, ""+str.charAt(i));
			uihex.actionPerformed(event);
		}
		assertEquals("-1", engine.getDisplay());
		
		event = new ActionEvent(this, id++, "C");
		uihex.actionPerformed(event);
		
		//3+4-8=-1
		str="3+4-8=";//-1
		for(int i=0;i<str.length();i++) {
			event = new ActionEvent(this, id++, ""+str.charAt(i));
			uihex.actionPerformed(event);
		}
		assertEquals("-1", engine.getDisplay());
	}
	@Test
	 public void testDecMul() {
		str="1*0=";//0
		for(int i=0;i<str.length();i++) {
			event = new ActionEvent(this, id++, ""+str.charAt(i));
			uihex.actionPerformed(event);
		}
		assertEquals("0", engine.getDisplay());
		
		event = new ActionEvent(this, id++, "C");
		uihex.actionPerformed(event);
		
		str="4*5=";//20
		for(int i=0;i<str.length();i++) {
			event = new ActionEvent(this, id++, ""+str.charAt(i));
			uihex.actionPerformed(event);
		}
		assertEquals("20", engine.getDisplay());
		
		
		event = new ActionEvent(this, id++, "C");
		uihex.actionPerformed(event);
		
		str="3+4*5=";//23
		for(int i=0;i<str.length();i++) {
			event = new ActionEvent(this, id++, ""+str.charAt(i));
			uihex.actionPerformed(event);
		}
		assertEquals("23", engine.getDisplay());
	}
	@Test
	 public void testDecDiv() {
		str="1/4=";//3.75
		for(int i=0;i<str.length();i++) {
			event = new ActionEvent(this, id++, ""+str.charAt(i));
			uihex.actionPerformed(event);
		}
		assertEquals("0", engine.getDisplay());
		
		event = new ActionEvent(this, id++, "C");
		uihex.actionPerformed(event);
		
		str="4/2=";//2
		for(int i=0;i<str.length();i++) {
			event = new ActionEvent(this, id++, ""+str.charAt(i));
			uihex.actionPerformed(event);
		}
		assertEquals("2", engine.getDisplay());
		
		event = new ActionEvent(this, id++, "C");
		uihex.actionPerformed(event);
		
		str="3-1/2=";//3 -(int)0.5=0 =3-0
		for(int i=0;i<str.length();i++) {
			event = new ActionEvent(this, id++, ""+str.charAt(i));
			uihex.actionPerformed(event);
		}
		assertEquals("3", engine.getDisplay());
	}
	@Test
	 public void testDecParenth() {
		//String[] testCases = {"1+2*6*3+1=","1*2*3-1*4+2*5","1*0+3*0", "0*1+0*3"};
		str="3*(3-1)=";//3.75
		for(int i=0;i<str.length();i++) {
			event = new ActionEvent(this, id++, ""+str.charAt(i));
			uihex.actionPerformed(event);
		}
		assertEquals("6", engine.getDisplay());
		
		event = new ActionEvent(this, id++, "C");
		uihex.actionPerformed(event);
		
	}
	@Test
	 public void testDecPrecedence() {
		String[] testCases = {"1+2*6*3+1=","1*2*3-1*4+2*5","1*0+3*0", "0*1+0*3"};
		String[] answer = {"1+2*6*3+1=","1*2*3-1*4+2*5","1*0+3*0", "0*1+0*3"};
		//str="1/4=";//3.75
		for(int i=0;i<str.length();i++) {
			event = new ActionEvent(this, id++, ""+str.charAt(i));
			uihex.actionPerformed(event);
		}
		assertEquals("0", engine.getDisplay());
		
		event = new ActionEvent(this, id++, "C");
		uihex.actionPerformed(event);
		
	}
	

}

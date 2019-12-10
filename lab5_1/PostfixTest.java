package lab5_1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.Reader;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

class PostfixTest {
	private String[] calc= {"12*3+","123*+","12+34^-","12^34*-",
			 "123*+45^-6+",
			 "12+3*456-^+",
			 "12+34/+5+678+*+",
			 "91-2-32*-1-",
			 "23^4*",
			 "432^*",
			 "23^2*72*-"};
	private String[] calcIn= {"1 * 2 + 3","1 + 2 * 3","1 + 2 - 3 ^ 4","1 ^ 2 - 3 * 4",
			"1 + 2 * 3 - 4 ^ 5 + 6",
			 "( 1 + 2 ) * 3 + ( 4 ^ ( 5 - 6 ) ) ",
			 "1 + 2 + 3 / 4 + 5 + 6 * ( 7 + 8 )", 
			 "9 - 1 - 2 - 3 * 2 - 1",
			 "2^3*4",
			 "4*3^2",
			 "2^3*2-7*2"};
	
	 String[] ans= {"5","7","-78","-11","-1011","9","98", "-1","32","36","2"};
	 
	@Test
	void testEvaluate() {
		 
		
		 for(int i=0;i<calc.length;i++) {
			 String result = Postfix.evaluate(calc[i],10);
			 System.out.println(calc[i]+" = " + result);
			 System.out.println("ans[i]: " + ans[i]);
			 assertEquals(ans[i], result);
		 }
		
	}
	
	@Test
	void testInfixToPostfix() {
		
		 for(int i=0;i<calcIn.length;i++) {
			String result = Postfix.infixToPostfix(calcIn[i]);		
			System.out.print(calcIn[i].replaceAll("\\s+","")+" to post is " +result);
			 assertEquals(calc[i], result);
			 String res =  Postfix.evaluate(result,10);
			 System.out.println(" and result is " +res);
			 assertEquals(ans[i], res);
		 }
		
	}
	
	

}



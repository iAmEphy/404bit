
public class ALU_test {
	 public static void runTests()
	    {
		 
		 longword test = new longword();
	     longword test1 = new longword();
	     
	     longword result = new longword();
	     
	     bit x = new bit();
	     bit y = new bit();
	     bit[] operation = new bit[4];
	     x.set();
	     y.clear();
	     
	     test.set(0);
	     
	     test1.set(0);
	     System.out.println("And test");
	     //AND test
	     //x for 1 and y for 000
	     operation[0] = x;
	     operation[1] = y;
	     operation[2] = y;
	     operation[3] = y;
	     
	     
	     System.out.println("123 and 321");
	     test.set(123); 
	  	 //0111 1011
	     
	     test1.set(321);
	     //0001 0100 0001
	     
	     result = ALU.doOp(operation, test, test1);
	     
	     System.out.println("Result is " + result.toString());

	     //OR 1001
	     System.out.println("OR function 123 and 321");
	     operation[3] = x; 
	     
	     result = ALU.doOp(operation, test, test1);
	     System.out.println("result is  " + result.toString());


	     // XOR 1010
	     System.out.println("XOR 123 and 321");
	     operation[2] = x;
	     operation[3] = y;
	     
	     result = ALU.doOp(operation, test, test1);
	     
	     System.out.println("result is" + result.toString());

	     // NOT 1011
	     operation[3] = x;
	     
	     System.out.println("NOT 123 and 321");
	     
	     result = ALU.doOp(operation, test, test1);
	     
	     System.out.println("result is " + result.toString());

	     //left shift 1100
	     System.out.println("Left shift 123 amd 321");
	     operation[0] = x;
	     operation[1] = x;
	     operation[2] = y;
	     operation[3] = y;
	     
	     result = ALU.doOp(operation, test, test1);
	     
	     System.out.println("result is " + result.toString());
	     
	     
	     //right shift 1101
	     test.setBit(0, x);

	     operation[0] = x;
	     operation[1] = x;
	     operation[2] = y;
	     operation[3] = x;
	     
	     System.out.println("Right shift 123 and 321");
	     result = ALU.doOp(operation, test, test1);
	     System.out.println("result is " + result.toString());
	     
	     //add 1110
	     operation[0] = x;
	     operation[1] = x;
	     operation[2] = x;
	     operation[3] = y;
	     
	     System.out.println("add test 123 + 321");
	     
	     result = ALU.doOp(operation, test, test1);
	     
	     System.out.println("result is " + result.toString());   
	     System.out.println(result.getSigned());

	     //subtract 1111
	     System.out.println("subtract 123 - 321");
	     operation[0] = x;
	     operation[1] = x;
	     operation[2] = x;
	     operation[3] = x;
	     
	     
	     result = ALU.doOp(operation, test, test1);
	     System.out.println("Result is " + result.toString());
	     System.out.println(result.getSigned());

	     //multiply 0111
	     operation[0] = y;
	     operation[1] = x;
	     operation[2] = x;
	     operation[3] = x;

	     System.out.println("Multiply 123 * 321");
	     result = ALU.doOp(operation, test, test1);
	     System.out.println("result is " + result.toString());
	     System.out.println(result.getSigned());
	 }
	    
	 
}

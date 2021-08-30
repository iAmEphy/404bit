
public class cpu_test1 {
	
	
	public static void runTests()
    {
	computer computertest1 = new computer();
	
    System.out.println("test 1");
    
    //halt
    String halt1 = "0000 0000 0000 0000";
    
    //interrupt 
    String interrupt = "0010 0000 0000 0010";
    String interrupt1 = "0010 0000 0000 0000";
    
    //move 10 register0
    String ten = "0001 0000 0000 1010"; 
    
    //move 20 register 1
    String twenty = "0001 0001 0001 0100";
    
    //move -10 register 2
    String negative10 = "0001 0010 1111 0110";
    
    //add 10+20
    String add = "1110 0001 0000 0011";
    
    //subtract 10-20
    String subtract = "1111 0000 0001 0100";

    //multiply 10*20
    String multiply = "0111 0001 0000 0101";
    
    //load it in
    String[] computer1 = {ten, twenty, negative10, add, subtract, multiply, interrupt1, interrupt, halt1};
    
    //preload
    computertest1.preload(computer1);
    
    //and run
    computertest1.run();

    computer computertest2 = new computer();
    
    System.out.println();
    
    System.out.println("test 2, bit op");
    
    //move 24 register 0
    String twentyfour = "0001 0000 0001 1000"; 
 
    //24 register 1 0001
    String twentyf = "0001 0001 0001 1000";
    
    //5 register 2
    String five = "0001 0010 0000 0101";
    
    //multiply 24*24 register 3
    String multiply10 = "0111 0001 0000 0011"; 
    
    //and register 3 register 2 into register 4
    String and324 = "1000 0011 0010 0100";
    
    //or 3 4 into 5
    String or345 = "1001 0011 0100 0101 ";
    
    //xor register 3 and register 2 into register 6
    String xor326 = "1010 0011 0010 0110";
    
    //not regster 3  register 7
    String not37 = "1011 0011 0000 0111"; // NOT R4 R8 *Second Register doesn't matter for NOT
    
    //left shift register 3 by register 1 into register 8
    String leftshift318 = "1100 0011 0001 1000";
    
    
    //righshift register 3 by register 2 into register 9
    String rightshift329 = "1101 0011 0010 1001";
    
    String[] computer2 = {twentyfour, twentyf, five, multiply10, and324, or345,xor326, not37, leftshift318, rightshift329, interrupt1, interrupt, halt1};

    computertest2.preload(computer2);
    
    computertest2.run();


    }
}

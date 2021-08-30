
public class assembler_test {
	
	public static void runTests(){
		
		//same as cpu_test1 instructions 
		
		String halt = "HALT";
		
		String register = "INTR 0";
        
        String memoery = "INTR 1";
		
        String move10 = "MOVE R0 10";
        
        String move20 = "MOVE R1 20";
        
        String moveneg10 = "MOVE R2 -10";
        
        String add1 = "ADD R1 R0 R3";
        
        String subtract = "SUB R0 R1 R4";
        
        String mul1 = "MUL R0 R1 R5";

        String[] instructions = {move10, move20, moveneg10, add1, subtract, mul1, register, memoery, halt};
        
        String[] test;
        
        test = Assembler.assemble(instructions);
        
        computer cpu = new computer();

        cpu.preload(test);
        
        cpu.run();

        String move24 = "MOVE R0 24";
        
        String move244 = "MOVE R1 24";
        
        String move5 = "MOVE R2 5";
        
        String multiply = "MUL R1 R0 R3";

        String and = "AND R3 R2 R4";
        
        String or = "OR R3 R4 R5";
        
        String xor = "XOR R3 R2 R6";
        
        String not = "NOT R3 R7";
        
        String leftshift = "LS R1 R3 R8";
        
        String rightshift = "RS R3 R2 R9";

        String[] instructions2 = {move24, move244, move5, multiply, and, or, xor, not, leftshift, rightshift, halt};
        
        String[] test2;
        
        test2 = Assembler.assemble(instructions2);
        
        computer cpu2 = new computer();

        cpu2.preload(test2);
        
        cpu2.run();
    }
}

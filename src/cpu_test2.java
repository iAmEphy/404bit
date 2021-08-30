
public class cpu_test2{
	
	public static void runTests(){
		
		String move = "MOVE R0 0";
		
		String move1 = "MOVE R1 1";
		
		String move2 = "MOVE R2 2";

		//Compare r2 r1
		String comp1 = "COMP R2 R1";
		
		String brgr = "BNGR 1"; 
		
		String breq = "BNEQ 3";

		String add = "ADD R0 R1 R0";
		
		String inc = "ADD R1 R2 R1";
		
		String loop = "JUMP 3";
		
		String brGREQ = "BRGRTEQU 2"; 
		
		String brEQ = "BREQ 1";
		
		String BRLES = "BRLESS 2";

		String interrupt = "INTR 0";
	        
		String intr1 = "INTR 1";
	        
		String halt = "HALT"; 

	        
		String[] instructions = {move, move1, move2, comp1, brgr, breq, add, inc, loop, brGREQ, brEQ, BRLES, interrupt, intr1, halt};

	        
		String[] load;
	        
		load = Assembler.assemble(instructions);
	        
		computer cpu = new computer();
	        
		cpu.preload(load);
	        
		cpu.run();
	    }
}


public class cpu_test3 {
	
	public static void runTests(){
        
        String jump = "JUMP 1";
        
        String pop = "POP R5"; 
        
        String pop1 = "POP R1"; 
        
        String add = "ADD R1 R2 R3";
        
        String push = "PUSH R1"; 
        
        String returnS = "RTN"; 
        
        String move = "MOVE R0 2"; 

        String push1 = "PUSH R1"; 

        String call = "CALL 1"; 

        //print
        String inter = "INTR 0";
        
        String mem = "INTR 1"; 
        
        String halt = "HALT"; 

        String[] instructions = {jump, pop, pop1, add, push, returnS, move, push1, call, inter,  mem, halt};
        
        
        String[] load;
        
        load = Assembler.assemble(instructions);
        
        computer cpu = new computer();
        
        cpu.preload(load);
        
        cpu.run();

    }
}

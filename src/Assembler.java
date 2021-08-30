import java.util.ArrayList;

public class Assembler {
	
	public static String[] assemble (String[] strings) {
		
		ArrayList<String> currentInstructions = new ArrayList<>();
		
        ArrayList<String> bitList = new ArrayList<>();
        
        String bit;
        
        int i;

        //loop through assembly
        for (i = 0; i < strings.length; i++){

            currentInstructions.clear();
            
            //tokenize them
            currentInstructions = Assembler.lexer(strings[i]); 
            
            //parse the instructions
            bit = Assembler.parse(currentInstructions);
            
            //list of instructions
            bitList.add(bit);
            
        }
        
        String[] loadinstruc = new String[bitList.size()];
        
        //list to string to load
        bitList.toArray(loadinstruc); 
        
        return loadinstruc;
        
	}
	
	
	public static ArrayList<String> lexer(String currentInstructions){ 
		
		//token them
        ArrayList<String> instruct = new ArrayList<>();
        
        //current
        char c;
        
        //white space
        char next = ' ';

        String token;
        
        //string build tokens
        StringBuilder stringbuild = new StringBuilder();
        
        int i;
        
        for (i = 0; i < currentInstructions.length(); i++){
        	
            c = currentInstructions.charAt(i);
            
            if(i != (currentInstructions.length() - 1)){
            	
            	next = currentInstructions.charAt(i + 1);
            	
            }
            
            else{
            	
                next = '\0';
                
            }
            
            
            if(Character.isLetterOrDigit(c) || c == '-'){

                stringbuild.append(c);
                
                //empty
                if(next == '\0'){
                
                    token = stringbuild.toString(); 
                    
                    //add token to list
                    instruct.add(token);
                    
                    token = ""; 
                    
                    
                    stringbuild.delete(0, stringbuild.length());
                    
                }
            }
            
            //end of token
            else if(Character.isWhitespace(c)){
                token = stringbuild.toString();
                
                instruct.add(token);
                
                token = "";
                
                stringbuild.delete(0, stringbuild.length());
                
            }
            
        }
        
        return instruct;
    }
	
	
	public static String parse(ArrayList<String> currentInstructions){
		
		
	    //bit the instructions
		String bitcode;
		
		
		String opInstruction = "";
		
		//token
		String op = currentInstructions.get(0); 
		
		op = op.toUpperCase();
		
		
		switch(op){
		
		//add
		
		case "ADD":
			
			bitcode = "1110";
			
	        opInstruction = put3registers(currentInstructions, bitcode);
	        
	        break;
	            //sub
		case "SUB":
			
			bitcode = "1111";
			
			opInstruction = put3registers(currentInstructions, bitcode);
			
			break;
			//MULTIPLY
		case "MUL":
			bitcode = "0111";
			
			opInstruction = put3registers(currentInstructions, bitcode);
			
			break;
			//move
		case "MOVE":
			
			bitcode = "0001";
			
			opInstruction = move(currentInstructions, bitcode);
			
			break;

	            //and
		case "AND":
			
			
			bitcode = "1000";
			
			opInstruction = put3registers(currentInstructions, bitcode);
			
			break;
			
			//or
		case "OR":
			
			bitcode = "1001";
			
			opInstruction = put3registers(currentInstructions, bitcode);
			
			break;
		
			//xor
		case "XOR":
			
			bitcode = "1010";
			opInstruction = put3registers(currentInstructions, bitcode);
	                
			break;
			
			//not 2 registers
		case "NOT":
	             
			bitcode = "1011";
			
			
			opInstruction = not(currentInstructions, bitcode); 
			
			break;
			//left shift
		case "LS":
			
			bitcode = "1100";
			
			opInstruction = put3registers(currentInstructions, bitcode);
			break;
			
			//right shift
		case "RS":
			  
			bitcode = "1101";
			
			opInstruction = put3registers(currentInstructions, bitcode);
	        break;

	        //interrupt
		case "INTR":
			
			bitcode = "0010";
			
			opInstruction = interrupt(currentInstructions, bitcode);
			
	        break;
	        
	            
	        //halt all 0
		case "HALT": 
			
			opInstruction = "0000 0000 0000 0000";
			
			break;
			
		case "JUMP":
			
            bitcode = "0011";

            
            break;
            
        case "CMPR":
        	
            bitcode = "0100";

            
            break;
            
            //BR LESSTHAN
        case "BRLESS":
        	
            bitcode = "0101 00";
            
 
            break;
            
            //EQUALS
        case "BREQ":
        	
            bitcode = "0101 01";

            
            break;
            
            //GREATER
        case "BRGRT":
        	
            bitcode = "0101 10";

            
            break;
            
            //GREATER or equal
        case "BRGRTEQU":

            bitcode = "0101 11";

            
            break;
            
            
            
        case "PUSH":
        	
        	bitcode = "0110 0000 0000 ";
           
            break;
            
        case "POP":
        	bitcode = "0110 0100 0000 ";
            
            break;
            
        case "CALL":
        	
        	bitcode = "0110 10";
            
            break;
            
        case "RTN" + "":
        			opInstruction = "0110 1100 0000 0000";
            break;
		default:

            System.out.println("error");
            
            opInstruction = "0000 0000 0000 0000";
            
	        }
		 
		return opInstruction;
		
	    }
	 
	

    public static String put3registers(ArrayList<String> currentInstructions, String op)
    {
        String register1 = currentInstructions.get(1);
        
        String register2 = currentInstructions.get(2);
        
        String register3 = currentInstructions.get(3);
        
        register1 = changetoRegister(register1);
        
        register2 = changetoRegister(register2);
        
        register3 = changetoRegister(register3);
        
        String anotherregister;
        
        anotherregister = op + " " + register1 + " " + register2 + " " + register3;

        return anotherregister;
    }

    public static String changetoRegister(String register){
    	
        int register1;
        
        String theregister;
        
        StringBuilder stringbuild = new StringBuilder(register);
        
        longword change = new longword();
        
        //delete first character of reigster
        stringbuild.deleteCharAt(0);
        
        register = stringbuild.toString();
        
        register1 = Integer.parseInt(register);
        
        change.set(register1);
        
        theregister = change.toString();
        
        theregister = theregister.substring(28);
        
        return theregister;
        
    }

    public static String interrupt(ArrayList<String> currentInstructions, String op){
    	
    	//2 interrupts
        int interrupt12;
        
        String interruptstring;
        
        String anotherregister;
        
        interrupt12 = Integer.parseInt(currentInstructions.get(1));
        
        if(interrupt12 == 0) {
        	
        	interruptstring = " 0000 0000 0000";

        }
            
        else {
        	interruptstring = " 0000 0000 0010";
        }
        
        anotherregister = op + " " + interruptstring;

        return anotherregister;
        
    }

    public static String not(ArrayList<String> currentInstructions, String op){
    	
        String register1 = currentInstructions.get(1);
        
        String register2 = currentInstructions.get(2);
        
        register1 = changetoRegister(register1);
        
        register2 = changetoRegister(register2);
        
        String reg2 = "0000";
        
        String anotherregister;
        
        anotherregister = op + " " + register1 + " " + reg2 +" " + register2;
 
        return anotherregister;
    }

    public static String move(ArrayList<String> currentInstructions, String op){
    	
        String register1 = currentInstructions.get(1);
        
        register1 = changetoRegister(register1);
        
        String valuebit;
        
        int value = Integer.parseInt(currentInstructions.get(2));
        
        longword convert = new longword();
        
        convert.set(value);
        
        valuebit = convert.toString();
        
        valuebit = valuebit.substring(24);
        
        String anotherregister;
        
        anotherregister = op + " " + register1 + " " + valuebit;
        
        return anotherregister;
    }
}

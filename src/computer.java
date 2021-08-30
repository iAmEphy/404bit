
public class computer {
	
	bit halt = new bit();
	
	private memory memoryvariable = new memory();
	
	longword pc = new longword();
	//PROGRAM COUNTER ASSIGNMENT 6
	longword currentInstruction = new longword();
	
	//an array of 16 longwords; these will be our registers.
	longword[] register = new longword[16];
	 
	
	longword op1 = new longword();    
	longword op2 = new longword();
	
	longword result = new longword();
	
	longword variables = new longword();
	
	bit[] op = new bit[4];
	
	
	
	//1 =
	//0 <
	//0 >
	bit[] compare1 = new bit[2]; 
	
	bit[] comparecompare = new bit[2];
	
	bit br = new bit();
	
	longword stack = new longword();
	
	bit[] stackbit = new bit[2];
	
	public computer() {
		
		halt.set(1);
		
		pc.set(0);
		
		stack.set(1020);
	        
		
	        
		int i;
		
		
		for (i = 0; i < 4; i++)
        {
            op[i] = new bit();
        }
		
		//initizalize registers
		for(i = 0; i < 16; i ++){
			
            register[i] = new longword();
            
        }
		
		for(i = 0; i < 2; i++){
            compare1[i] = new bit();
            
            comparecompare[i] = new bit();
            
            
            stackbit[i] = new bit();
        }
	}
	
	public void run(){
       
		halt.clear();
	        
		while (halt.getValue() == 0) {
			
			fetch();
			decode(); 
			execute();    
			store();
			
	        }
	}
	
	public void fetch() {
		
		
		int bytwo = 2;
		
        longword increments = new longword();
        
        currentInstruction.copy(memoryvariable.read(pc));
        
        //16-31
        currentInstruction = currentInstruction.rightShift(16); 
        
        //16 bits
        increments.set(bytwo); 
        
        //increment by 2
        pc.copy(rippleAdder.add(pc, increments));
		
		
	}
	public void decode() {
		
		int i;
		//First 4 bits of currentInstruction are the opcode
		//Next 4 are first register
		//Next 4 are second register
		//Last 4 are destination register
		
		//shift mask 4 bits right shift 
		
		longword pointer = new longword();
		
		longword mask = new longword();
		
		//check for halts
		if (currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 0 && currentInstruction.getBit(18).getValue() == 0 && currentInstruction.getBit(19).getValue() == 0){
			
		}
		
		//Move 0001 0010 0000 1010
		else if(currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 0 && currentInstruction.getBit(18).getValue() == 0 && currentInstruction.getBit(19).getValue() == 1){
			//target register
			mask.set(3840); 
			
			pointer.copy((currentInstruction.and(mask)));
			
			pointer = pointer.rightShift(8);
			
			op1.copy(pointer); 
			
			//variables register
			// 0000 0000 0000 0000 0000 0000 1111 1111
			mask.set(255);
			
			pointer.copy((currentInstruction.and(mask)));
			
			
			//negative
			if(pointer.getBit(24).getValue() == 1){
				
				variables.set(-1);
				
				}
			
			else{
				variables.set(0);
			}
			
			
			//from 24 to 32
			for(i = 24; i < 32; i++){
				
				variables.setBit(i, pointer.getBit(i));
				
			} 
		}
		
		//interrupt 0010 0000 0000 0000 
		else if(currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 0 && currentInstruction.getBit(18).getValue() == 1 && currentInstruction.getBit(19).getValue() == 0){
		        
		}
		

        //compare
        //0100
        else if (currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 1 && currentInstruction.getBit(18).getValue() == 0 && currentInstruction.getBit(19).getValue() == 0){
                    
        	//R1
        	mask.set(240);
        	
        	pointer.copy(currentInstruction.and(mask));
        	
        	pointer = pointer.rightShift(4);
        	
        	op1.copy(register[pointer.getSigned()]);
        	
        	//R2
        	mask.set(15);
        	
        	pointer.copy((currentInstruction.and(mask)));
        	
        	op2.copy(register[pointer.getSigned()]);
        }

                
        //BR
        else if (currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 1 && currentInstruction.getBit(18).getValue() == 0 && currentInstruction.getBit(19).getValue() == 1){
            
        	mask.set(3072); 

        	
        	pointer.copy(currentInstruction.and(mask)); 
        	
        	//2 right most bits
        	pointer = pointer.rightShift(10);
        	
        	comparecompare[0].set(pointer.getBit(30).getValue());
        	
        	comparecompare[1].set(pointer.getBit(31).getValue());

        	//branch
        	//0011 1111 1111
        	mask.set(1023);
        	
        	pointer.copy(currentInstruction.and(mask));
        	
        	
        	if(pointer.getBit(22).getValue() == 1) {
        		
        		variables.set(-1);
        		
        	}
        	else {
        		
        		variables.set(0);
        		
        	}
        	
        	for(i = 22; i < 32; i++){
        		
        		variables.setBit(i, pointer.getBit(i));
        		
        	}
        	
        }
		
		//stack
        else if (currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 1 && currentInstruction.getBit(18).getValue() == 1 && currentInstruction.getBit(19).getValue() == 0){
                
        	stackbit[0] = currentInstruction.getBit(20);
        	
        	stackbit[1] = currentInstruction.getBit(21);
        	
        	//push/pop
        	if(stackbit[0].getValue() == 0) {
        		
        		//push 
        		if(stackbit[1].getValue() == 0){
        			
        			mask.set(15); //1111
        			
        			pointer.copy(currentInstruction.and(mask));

        			op1.copy(register[pointer.getSigned()]);
        			
        		}
        		//pop
        		else{
                            
        			mask.set(15);
        			
        			pointer.copy(currentInstruction.and(mask));
                            
        			op1.copy(pointer);
        			}
        		}
        	
        	else{
        		
        		//call 10
        		
        		if(stackbit[1].getValue() == 0){
        			
        			mask.set(2047);
        			
        			
        			variables = currentInstruction.and(mask);
                 
        		}
        		}
        	
        }
		
		
		//jump
		else if (currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 0 && currentInstruction.getBit(18).getValue() == 1 && currentInstruction.getBit(19).getValue() == 1) {
			
		}
		else {
			
			//op1
			
            mask.set(3840);
            
            pointer.copy((currentInstruction.and(mask)));
            
            //first 4 bits getsigned
            pointer = pointer.rightShift(8); 
            
            
            //put pointer and register into op1
            op1.copy(register[pointer.getSigned()]); 
            
            //op2
            
            mask.set(240);
            
            pointer.copy((currentInstruction.and(mask)));
            
            pointer = pointer.rightShift(4);
            
            op2.copy(register[pointer.getSigned()]);
		}
	}
	
	public void execute() {
		
		bit[] op = new bit[4];

		int i;

        for(i = 0; i < 4; i++){
        	
            op[i].set(currentInstruction.getBit((16 + i)).getValue()); 
            
        }

        if (op[0].getValue() == 0 && op[1].getValue() == 0 && op[2].getValue() == 0 && op[3].getValue() == 0){
        	
        	//halt
            halt.set();
            
        }

        //move
        else if(op[0].getValue() == 0 && op[1].getValue() == 0 && op[2].getValue() == 0 && op[3].getValue() == 1){
           
        }
        
        //jump
        else if (currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 0 && currentInstruction.getBit(18).getValue() == 1 && currentInstruction.getBit(19).getValue() == 1) {
        	
        }
        
        //compare
        else if (currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 1 && currentInstruction.getBit(18).getValue() == 0 && currentInstruction.getBit(19).getValue() == 0){
        	
        	bit[] subtract = new bit[4];
                    
        	for(i = 0; i < 4; i++) {
        		
        		subtract[i] = new bit();
        		
        	}
        	
        	for (i = 0; i < 4; i++) {
        		
        		subtract[i].set();
        		
        	}
        	
        	result.copy(ALU.doOp(subtract, op1, op2));
                
        }
        
        
        //BR
        else if(currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 1 && currentInstruction.getBit(18).getValue() == 0 && currentInstruction.getBit(19).getValue() == 1) {

        	bit[] multiply = new bit[4];
        	
        	//0111
        	for(i = 0; i < 4; i++) {
        		
        		multiply[i] = new bit();
        		
        	}
        	
        	
        	for(i = 1; i < 4; i++) {
        		
        		 multiply[i].set();
        		 
        	}
        	
        	longword size = new longword();
        	
        	size.set(2);
        	
        	//make size value
        	variables = ALU.doOp(multiply, variables, size);
        	
        	
        	if(comparecompare[0].getValue() == 0){
        		
        		// < 00
        		if(comparecompare[1].getValue() == 0){
        			
        			if(compare1[0].getValue() == 0 && compare1[1].getValue() == 0) {
        				
        				br.set();
        				
        			}
        			
        		}
                        
        		//=
        		else{ 
        			
        		
        			if(compare1[1].getValue() == 1){
        				
        				br.set();
        				
        			}  
                        
                    
        		}
        	}
        		
        		else{
                        if(comparecompare[1].getValue() == 0){
                        	
                        	// >
                            if(compare1[0].getValue() == 1) {
                            	
                                br.set();
                                
                            }
                        }
                        
                        // > or = 
                        else{
                        
                        	//0 or 1
                        	if(compare1[0].getValue() == 1 || compare1[1].getValue() ==1) { 
                        		
                                br.set();
                        	}
                        
                        }
                    
        		}
                
        }
        
        
        //intterrupt
        else if (op[0].getValue() == 0 && op[1].getValue() == 0 && op[2].getValue() == 1 && op[3].getValue() == 0){
            String thestring;
            
            //prints
            if(currentInstruction.getBit(30).getValue() == 0){
            	
                System.out.println();
                
                for(i = 0; i < register.length; i++){
                	
                    thestring = register[i].toString();
                    
                    
                    System.out.printf("register %d %s %d%n", i, thestring, register[i].getSigned());
                    
                }
            }

            //print memory
            else{
            	longword increments = new longword();
            	
                longword counter = new longword();
                
                longword fourbytes = new longword();
                
                
                
                bit[] anotherbit = new bit[8];
                
                
                for(i = 0; i < anotherbit.length; i++) {
                	
                	anotherbit[i] = new bit();
                	
                }
                
                increments.set(1);
                
                counter.set(0);
                
                
                int x;
                
                System.out.println("print all bytes");
                
                for (i = 0; i < 1020; i++)
                {
                    fourbytes.copy(memoryvariable.read(counter));
                    
                    for (x = 0; x < 8; x++){
                    	
                    	//byte x into bits
                        anotherbit[x].set(fourbytes.getBit(x).getValue());
                        
                    }
                    
                    System.out.print("byte " + i);
                    
                    for(x = 0; x < 8; x++) {
                    	
                    	//print 8 bits
                        System.out.print(anotherbit[x].getValue());
                        
                    }
                    
                    counter = rippleAdder.add(counter, increments);
                    
                }
                
                for(i = 0; i < 4; i++){
                
                    for (x = 0; x < 8; x++){
                    	
                        anotherbit[x].set(fourbytes.getBit(((i * 8) + x)).getValue());
                        
                    }
                    
                    System.out.print("byte " + (i + 1020));
                    
                    for(x = 0; x < 8; x++){
                    
                    	//print 8 bits
                    	System.out.print(anotherbit[x].getValue());
                        
                    }
                    
                    if (i % 4 == 3) {
                    	
                        System.out.println();
                        
                    }
                }
            }
        }
        //stack
        else if (currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 1 && currentInstruction.getBit(18).getValue() == 1 && currentInstruction.getBit(19).getValue() == 0){

        	
        	//call
        	if(stackbit[0].getValue() == 1 && stackbit[1].getValue() == 0){
        		
        		longword size = new longword();
        		
        		size.set(2);
        		
        		bit[] multiply = new bit[4];
        		
        		for(i = 0; i < 4; i++) {
        			multiply[i] = new bit();
        		}
        		for(i = 1; i < 4; i++) {
        			
        			//multiply
        			multiply[i].set(); 
        			
        		}
        		
        		//change address line to instruction
        		variables.copy(ALU.doOp(multiply, variables, size)); 
        		
        		
        	}
        	
        	
        }
        
        else{
        	
            result.copy(ALU.doOp(op, op1, op2));
            
         }
	}
	
	public void store() {
		longword mask = new longword();
		
		//halt
		if (op[0].getValue() == 0 && op[1].getValue() == 0 && op[2].getValue() == 0 && op[3].getValue() == 0){
			
			halt.set();
			
		}
		
		//move
		else if(op[0].getValue() == 0 && op[1].getValue() == 0 && op[2].getValue() == 0 && op[3].getValue() == 1) {
			
			//value into register
			register[op1.getSigned()].set(variables.getSigned());
			
		}

		//interrupt
		else if(op[0].getValue() == 0 && op[1].getValue() == 0 && op[2].getValue() == 1 && op[3].getValue() == 0){
		
		}
		
		//jump 0011
		else if (currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 0 && currentInstruction.getBit(18).getValue() == 1 && currentInstruction.getBit(19).getValue() == 1){
			
			int jumpvariable;
			
			mask.set(4095);
			
			//value of line to jump
			currentInstruction = currentInstruction.and(mask);
			
			
			jumpvariable = (int) currentInstruction.getUnsigned();
			
			//2 bytes
			pc.set(jumpvariable*2);
		}
		
		//compare
		else if(currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 1 && currentInstruction.getBit(18).getValue() == 0 && currentInstruction.getBit(19).getValue() == 0){
			
			if(result.getSigned() == 0){
				
				compare1[0].clear();
				
				//1 is =
				compare1[1].set();
			}
			
			else if(result.getSigned() > 0){
		        
				compare1[0].set();
				
				//10 is >
				compare1[1].clear();
				
			}
			
			else{
				
				compare1[0].clear();
				
				
				compare1[1].clear();
		         
			}
			
		}

		
		//BR
		else if(currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 1 && currentInstruction.getBit(18).getValue() == 0 && currentInstruction.getBit(19).getValue() == 1){
			
			int i;
			
			bit[] add = new bit[4];
			
			for(i = 0; i < 4; i++){
				
				add[i] = new bit();
				
			}
			
			for(i = 0; i < 3; i++){
				
				add[i].set();
				
			}
			
			if(br.getValue() == 1){
				
				pc = ALU.doOp(add, pc, variables);
				
				//clear
				br.clear(); 
				
			}
		}
		
		//stack
		else if (currentInstruction.getBit(16).getValue() == 0 && currentInstruction.getBit(17).getValue() == 1 && currentInstruction.getBit(18).getValue() == 1 && currentInstruction.getBit(19).getValue() == 0){
		            
			longword increment = new longword();
			
			//change stack pointer 4 bytes
			increment.set(4);
			
			longword clear = new longword();
			
			clear.set(0);
			
			
			if(stackbit[0].getValue() == 0){
				
				
				//push
				if(stackbit[1].getValue() == 0){
					
					//write to stack
					memoryvariable.write(stack, op1); 
					
					stack.copy(rippleAdder.subtract(stack, increment)); 
					
				}
				//POP
				else{
					
					stack.copy(rippleAdder.add(stack, increment));
					
					variables.copy(memoryvariable.read(stack));
					//clear variable from stack
					memoryvariable.write(stack, clear); 
					
					//pop into registered
					register[op1.getSigned()].copy(variables); 
					}
				
			}
			
			else{
				
				longword returns = new longword();
				
				if(stackbit[1].getValue() == 0){
					
					
					returns.copy(pc); 
					
					memoryvariable.write(stack, returns);
					
					stack.copy(rippleAdder.subtract(stack, increment));
					
					
					pc.copy(variables); 
		                
				}
				//return
				else{
					stack.copy(rippleAdder.add(stack, increment));
					
					
					//where to retunr to
					returns.copy(memoryvariable.read(stack));
					
					
					//remove from stack
					memoryvariable.write(stack, clear);
					
					
					//return address
					pc.copy(returns);
					
					register[15].set(0); 
					
				}
		            
			}
		        
		}
		
		else{
		
			//1111
		
			mask.set(15); 
		
		//put result into register
		register[(currentInstruction.and(mask)).getSigned()].copy(result);
		
		}
		
	}
	
	public void preload(String[] cpuinstructions) {
		
		int count;
		
		int i;
		bit x = new bit();
		
		bit y = new bit();
		
		x.set();
		
		y.clear();
		
		
		count = cpuinstructions.length;
		
		String string2;
		
		longword replace = new longword();
		
		longword increments = new longword();
		
		longword counter = new longword();
		
		counter.set(0);
		
		if(count % 2 == 0){
			
			
			for(i = 0; i < count; i += 2){
				
				
				
				//add 2 = 32bits
				string2 = cpuinstructions[i].concat(cpuinstructions[i+1]);
				
				//white space
				string2 = string2.replaceAll("\\s", "");
				
				int z;
				
				//change to longword
				for(z = 0; z < 32; z++) {
					
					if(string2.charAt(z) == '0'){
						
						replace.setBit(z, y);
						
						
					}
					
					else{
						
						replace.setBit(z, x);
						
						
					}
				}
				
				memoryvariable.write(counter, replace);
				
				increments.set(4);
				
				
				counter = rippleAdder.add(counter, increments); 
			}
			
		}
		
		else{
			
			int z;
			
			for(i = 0; i < (count - 1); i += 2){
				
				
				string2 = cpuinstructions[i].concat(cpuinstructions[i+1]);
				
				//white space
				string2 = string2.replaceAll("\\s", "");
				
				for(z = 0; z < 32; z++){
					
					
					if(string2.charAt(z) == '0'){
						
						replace.setBit(z, y);
					
					}
					
					else {
						
						replace.setBit(z, x);
					}
					
				}
				
				
				memoryvariable.write(counter, replace);
				
				
				increments.set(4);
				
				
				counter = rippleAdder.add(counter, increments);
				
	            }
			
			
			string2 = cpuinstructions[count - 1];
			
			
			//white space
			string2 = string2.replaceAll("\\s", "");
			
			
			//make string to longword
			for(z = 0; z < 16; z++) {
				
				if (string2.charAt(z) == '0') {
					
					replace.setBit(z, y);
				}
				else{
					
					replace.setBit(z, x);
					
				}
			}
			
			
			for(z = 16; z < 32; z++) {
				
				//16-31 all 0
				replace.setBit(z, y);
			
			}
			
			memoryvariable.write(counter, replace);
		}
	}
}

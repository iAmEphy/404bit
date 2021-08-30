
public class longword implements ILongword {
	
	private bit[] word;
	
	//construct
	public longword() {
		word = new bit[32];
		
		int i;
		
		for(i = 0; i < 32; i++) {
			
			word[i] = new bit();
			
		}
		
	}
	
	
	
	
	
	
	
	//get bit i
	@Override
	public bit getBit(int i) {
		// TODO Auto-generated method stub
		if(i < 0 || i > 31) {
			
			System.out.println("need new bit within range");
			
			return null;
			
		}
		else {
			bit words = new bit();
			
			words.set(word[i].getValue());
			
			System.out.println();
			
			return words;
			
		}
	}

	@Override
	
	//set bit i
	public void setBit(int i, bit value) {
		// TODO Auto-generated method stub
		
		if(i > -1 && i < 32) {
			word[31 - i].set(value.getValue());
		}
		else {
			
			System.out.println("not in range");
			
		}
		
	}

	@Override
	
	//and 2 word
	public longword and(longword other) {
		// TODO Auto-generated method stub
		
		longword result = new longword();
		
		for(int i = 0; i < 32; i++) {
			
			result.word[i] = word[i].and(other.word[i]);
			
		}
		
		return result;
	}

	
	//or 2 word
	@Override
	public longword or(longword other) {
		// TODO Auto-generated method stub
		
		longword result = new longword();
		
		for(int i = 0; i < 32; i++) {
			
			result.word[i] = word[i].or(other.word[i]);
			
		}
		
		return result;
		
	}

	
	//xor 2 word and put in another word
	@Override
	public longword xor(longword other) {
		// TODO Auto-generated method stub
		
		longword result = new longword();
		
		for(int i = 0; i < 32; i++) {
			
			result.word[i] = word[i].xor(other.word[i]);
			
		}
		
		return null;
	}

	@Override
	
	//not bit and gets value 
	public longword not() {
		// TODO Auto-generated method stub
		
		longword result = new longword();
		
		for(int i = 0; i < 32; i++) {
			
			result.word[i] = word[i].not();
			
		}
		
		
		return result;
	}

	@Override
	
	//right shift word by certain amount
	public longword rightShift(int amount) {
		// TODO Auto-generated method stub
		
		if(amount > 0 && amount < 32) {
			
			longword result = new longword();
			
			result.set(0);
			
			for (int i = 0; i < amount; i++)
				
				//clear first amount
				
                result.word[i].clear(); 
			
            for (int i = 0; i < 32 - amount; i++)
            	
            {
            	
                result.setBit(i + amount, this.word[i]);
                
            }
            
            return result;
			
		}
		else {
			System.out.println("not in range");
			
			return null;
		}

		
	}

	@Override
	
	//leftshift 
	public longword leftShift(int amount) {
		// TODO Auto-generated method stub
		
		if(amount > 0 && amount < 32) {
			
			longword result = new longword();
			
            bit left = new bit();
            
            left.set(0);
            
            for (int i = 0; i < 32 - amount; i++)
            	
            	//fill amount
            	
            {
            	
                result.setBit(i, this.word[i + amount]); 
                
            }
            for (int i = 32 - amount; i < 32; i++)
            	//fill 
            	
                result.setBit(i, left); 
            
            return result;
            
        }
		else {
			System.out.println("not in range");
			
			return null;
		}

		
	}


	@Override
	public long getUnsigned() {
		
		//get unsigned
		// TODO Auto-generated method stub
		
		long result = 0;
		
		for(int i = 0; i < 32; i++) {
			
			result += word[31 - i].getValue() * Math.pow(2, i);
			
		}
		return result;
	}

	@Override
	public int getSigned() {
		// TODO Auto-generated method stub
		
		
		//get signed loop through bits and add bit value 
		int result = 0;
		
		if(word[0].getValue() == 0) {
			
			for(int i = 1; i < 32; i++) {
				
				result += word[i].getValue() * (Math.pow(2,  (31 - i)));
				
			}
		}
		else {
			
			for(int i = 1; i < 32; i++) {
				
				result += word[i].not().getValue() * (-Math.pow(2, (31 - i)));
				
			}
			
			result--;
		}
		
		return result;
		
		
	}

	@Override
	public void copy(longword other) {
		// TODO Auto-generated method stub
		
		//copy value from another word
		for(int i = 0; i < 32; i++) {
			
			this.word[i].set(other.word[i].getValue());
			
		}
		
	}

	@Override
	public void set(int value) {
		
		//set value of bits
		//get bit binary
		
		// TODO Auto-generated method stub
		
		if(value > 0) {
			
			int binary[] = new int[32];
			
			int dex = 0;
			
			while(value > 0) {
				
				binary[dex++] = value % 2;
				
				value = value / 2;
				
			}

			for (int i = 0; i < 32; i++) {
				
				this.getBit(i).set(binary[i]);
				
			}
			
		}
		else {
			
			for (int i = 0; i < 32; i++) {
				
				this.getBit(i).clear();
				
			}
		}
		
	}


	
	public String toString() {
		//tostring method
		
		String strings = "";
		
		for(int i = 0; i < 32; i++) {
			if(i == 31) {
				
				strings += "" + word[i].getValue();
				
			}
			else {
				
				strings += "" + word[i].getValue();
				
			}
			
		}
		return strings;
		
	}
	
}

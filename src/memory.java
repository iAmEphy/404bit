
public class memory {

	private bit[] memory;
	//make memory bit
	
	//constructor hardcode for loop each bit to memory
	public memory() {
		//8192 8 bit per byte
		memory = new bit[8192];
		
		int i;

        for (i = 0; i < 8192; i++) {
            memory[i] = new bit();
        }
	}
	
	
	//read
	public longword read(longword address) {
		longword result = new longword();
		
		//get signed *8 and put in startering bit
		//int starter = address.getSigned() * 8;
		
		//this index counter
		//int pointer = 0;
		
		int i;
		
		//loop, address will get signed * 8 and set it in result
		for (i = 0; i <= 31; i++)
        {
            result.setBit(i, memory[(address.getSigned() * 8) + i]);
        }
		
		return result;
	}
	
	public void write(longword address, longword value) {
		
		//ifs to check and set the values
		if (address.getSigned() > 0 && address.getSigned() < 1020){
			
            int i;
            
            for (i = 0; i < 32; i++)
            {
            	
            	memory[i + (address.getSigned() * 8)].set(value.getBit(i).getValue());
            	
            }
        }
		
        else if(address.getSigned() > 1020 && address.getSigned() < 1024){
            int i;
            
            int temp;
            
            //int starter = address.getSigned() * 8;
            
            temp = address.getSigned() - 1020;
            
            for (i = (temp * 8); i < 32; i++)
            {
            	
                memory[i + (address.getSigned() * 8)].set(value.getBit(i).getValue());
                
            }
        }
        else{
        }
	}

	
}

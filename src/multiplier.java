
public class multiplier {
	public static longword multiply (longword a, longword b) {
		longword numbers = new longword();
		longword shift = new longword();
		rippleAdder adder = new rippleAdder();

		longword result = new longword();
	        
		result.set(0);
		
		int i;
	        
		int x;
		
		//for loop every bit a *b
		for (i = 31; i >= 0; i--)
	        {
			
			//this for b
			for (x = 31; x >= 0; x--) 
	            {
	            	
	            	//a[i] * b
	                numbers.setBit(x, a.getBit(i).and(b.getBit(x))); // numbers = a[i] * b
	            }
	            
	            shift = numbers.leftShift(31 - i); 

	            //adds the multiplied 
	            result = rippleAdder.add(result, shift); 
	            
	        }
		
		return result;
		
	}
}



public class bit implements IBit{
	
	int value = 0;
	
	@Override
	public void set(int value) {
		
		// TODO Auto-generated method stub
		
		this.value = value;
		
		//this will set the bit
		
	}

	@Override
	public void toggle() {
		// TODO Auto-generated method stub
		if(value == 0) {
			
			value = 1;
			
		}
		else {
			
			value = 0;
		}
		
		//this will switch value 0 to 1 or 1 to 0
	}

	@Override
	public void set() {
		
		// TODO Auto-generated method stub
		
		this.value = 1;
		
		//this will set the value to 1
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		this.value = 0;
		
		//this will set value to 0
	}

	@Override
	public int getValue() {
		
		// TODO Auto-generated method stub
		
		return this.value;
		
		//this will return the value
	}

	@Override
	public bit and(bit other) {
		// TODO Auto-generated method stub
		
	bit result = new bit();
	
	if(value == 0) {
		
		result.set(0);
		
	}
	else {
		result.set(1);
		
	}
		
		return result;
		
		//if 1 bit is 0, return 0, else return 1 since both are 1
	}

	@Override
	public bit or(bit other) {
		// TODO Auto-generated method stub
		bit result = new bit();
		
		if(value == 1) {
			
			result.set(1);
			
		}
		else {
			
			if(other.value == 1) {
				result.set(1);
			}
			
			else {
				result.set(0);
			}
		}
		//if 1 bit is 1, return 1, and if both bits are 0, return 0
			
		
		return result;
	}

	@Override
	public bit xor(bit other) {
		// TODO Auto-generated method stub
		bit result = new bit();
		
		if(value == 0) {
			
			if(other.value == 0) {
				
				result.set(0);
				
			}
			else {
				
				result.set(1);
				
			}
		}
		else {
			
			if(other.value == 0) {
				
				result.set(1);
				
			}
			else {
				
				result.set(0);
				
			}
			
			
		}
		
		//this will return 1 only if one bit is 1 & if both bits are same it will return 0
		return result;
	}

	@Override
	public bit not() {
		// TODO Auto-generated method stub
		bit result = new bit();
		
		if(value == 0) {
		
			result.set(1);
			
		}
		else {
			
			result.set(0);
			
		}
		
		return result;
	}
	
	public String toString() {
		if(value == 0) {
			
			return "0";
			
		}
		else {
			return "1";
		}
	}
	
}

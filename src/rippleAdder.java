
public class rippleAdder {
	
	
	
	
	//add method
	public static longword add(longword a, longword b) {
		
		int i;
		longword result = new longword();
		
		bit carry = new bit();
		bit x = new bit();
		bit y = new bit();
		
		//loop through
		for (i = 31; i >=0 ; i--){
			if (a.getBit(i).getValue() == 0) {
				
                if(b.getBit(i).getValue() == 0) {
                	
                    if(carry.getValue() == 0){ //if a and b = 0, carry = 0, setbit and clear
                    	
                        result.setBit(i, y);
                        
                        carry.clear();
                        
                    }
                    else{ //else with 1 then setbit 1
                    
                        result.setBit(i, x); 
                        
                        carry.clear();
                    }
                }
                else{
                
                    if(carry.getValue() == 0) { //if theres 1 then set 1
                    
                        result.setBit(i, x);
                        
                        carry.clear();
                    }
                    else{ //if theres 1 1 then its 10
                
                        result.setBit(i, y);
                        
                        carry.set();
                        
                    }
                }
            }
            else {
            	
                if(b.getBit(i).getValue() == 0){
             
                    if(carry.getValue() == 0) { //if its 1 then 0 0, then 1 01
                   
                        result.setBit(i, x);
                        carry.clear();
                    }
                    else { //if 1 then 0 and then 1 then its 2 

                        result.setBit(i, y); 
                        carry.set();
                    }
                }
                else{
                
                    if(carry.getValue() == 0){  //if its 1 1 and carry is 0, then its 2
                        result.setBit(i, y);
                        
                        carry.set();
                        
                    }
                    else{ //if all 1, then its 3
                   
                        result.setBit(i, x);
                        carry.set();
                    }
                }
            }
        }
        return result;
	}
	//subtract method
	public static longword subtract(longword a, longword b) {
		longword negativeb = b.not();
		
		longword result = new longword();
		
		longword complement = new longword();
	        
		bit x= new bit();
		
		x.set();
		
		complement.set(0);
		
		complement.setBit(31, x);
		
		negativeb = add(negativeb, complement);
	    
	    result = add(a, negativeb);
	    
	    return result;
	}
}


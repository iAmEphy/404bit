
public class multiplier_test {
	
	public static void runTests(){
		
        longword test = new longword();
        
        longword test1 = new longword();
        
        longword result = new longword();
        
        bit y = new bit();
        
        bit x = new bit();
        x.set();
        y.clear();
        
        test.set(0);
        test1.set(0);
       
        System.out.println("Test 12 * 69");
        test.set(12); 
        //1100
       
        test1.set(69); 
        //0100 0101

        result = multiplier.multiply(test, test1);
        
        System.out.println("result is " + result.getUnsigned()); 
        //828 0011 0011 1100

        
        System.out.println("Test 123 * 321");
        
        test.set(123); //0111 1011

        test1.set(321); //0001 0100 0001

        
        
        result = multiplier.multiply(test, test1);
        
        System.out.println("Result is" + result.getUnsigned());
        
      
        System.out.println("-123 * -321");
        
        test.set(-123); 
        //0001 0111 1011
     
        test1.set(-321);
        // 0001 0100 0001

        result = multiplier.multiply(test, test1);
        System.out.println("Result is " + result.getSigned());

  
        System.out.println("Test -123 * 321");
        test1.set(321);


        result = multiplier.multiply(test, test1);
        
        System.out.println("Result is " + result.getSigned());


    }
		
		
		
	

}

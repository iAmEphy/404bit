
public class memory_test {

	public static void runTests(){
		
        memory test = new memory();
        
        longword address = new longword();
        
        //the value paramter of write
        longword valueparam = new longword();
        
        longword result = new longword();
        
        bit x = new bit();
        
        bit y = new bit();
        
        x.set();
        
        y.clear();

        System.out.println("Test address 64");
      
        address.set(64);
        valueparam.set(128); //1000 0000
        
        test.write(address, valueparam);
        //address / 8 should work
        
        System.out.println("Test address 16");
        
        address.set(16);
        
        test.write(address, valueparam);
        

        System.out.println("32");
        
        address.set(32); //0010 0000
        test.write(address, valueparam);
        
        System.out.println("Setting address to negative 1");
        
        address.set(-1); 
        //shouldnt work
        
        test.write(address, valueparam);
        
        System.out.println("read test 64");
        
        address.set(64);
        
        result = test.read(address);
        
        System.out.println("result is " + result.getSigned());
        
        System.out.println("read test 32");
        
        address.set(32);
        
        result = test.read(address);
        
        System.out.println("result is " + result.getSigned());

        System.out.println("read test 16");
        
        address.set(16);
        
        result = test.read(address);
        
        System.out.println("result is " + result.getSigned());
        
    }
}

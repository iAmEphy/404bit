
public class rippleAdder_test {
	
	static void runTests()
    {
        longword test = new longword();
        
        longword test1 = new longword();
        
       
        bit x = new bit();
        
        bit y = new bit();
        
        y.clear();
        
        x.set();

        System.out.println("add test 1234 and 4321");
        //setting tests
        test.set(0);
        test1.set(0);

        test.set(1234); //0100 1101 0010 = 1234

        test1.set(4321); //0001 0000 1110 0001 = 4321

        longword result = rippleAdder.add(test, test1);
        
        System.out.println("result is " + result.getSigned());


        System.out.println("Test 2. -5 + 10");
        test.set(0);
        test1.set(0);

        test.set(-5); //0011 0101

        test1.set(10); //1010

        result = rippleAdder.add(test, test1);
        
        System.out.println("result is " + result.getSigned());


        System.out.println("Minus test 4321 - 1234");

        test.set(0);
        test1.set(0);
        
      
        //setting tests
        test.set(4321);
        test1.set(1234); 

        result = rippleAdder.subtract(test1, test);
        System.out.println("result is " + result.getSigned());

        
        System.out.println("minus 1234 - 4321");
        test.set(0);
        test1.set(0);

        test.set(1234); 


        test1.set(4321);

        result = rippleAdder.subtract(test, test1);
        System.out.println("result is " + result.getSigned());

    }
}

public class longword_test {
	
    private longword_test(){
    	
    	
    }
    
    static void runTests(){
    	
        System.out.println("longword test");
        
        String strings;
        
        longword testvalue = new longword();
        
        longword testvalue2 = new longword();
        
        longword result = new longword();
        
        bit bits;
        
        bit x = new bit();
        
        bit y = new bit();
        //set to 1 and 0
        x.set(1);
        y.set(0);
        
        
        //to string test
        System.out.println("tostring() test");
        
        //max 32 bit
        testvalue.set(2147483647);
        
        testvalue.setBit(0, x);
        
        strings = testvalue.toString();
        
        System.out.println("All string to 1");
        
        System.out.println(strings + " ");
        

        
        //set bit test
        System.out.println("setBit() 1 test");
        testvalue.setBit(5, x);
        bits = testvalue.getBit(5);
        
        strings = bits.toString();
        
        if(bits.getValue() == 1) {
        	
            System.out.println("Success " + strings);
            
        }
        else {
        	
            System.out.println("Failed" + strings);
        
        }
        
        
        
        System.out.println("setBit 0 test:");
        
        testvalue.setBit(5, y);
        
        bits = testvalue.getBit(5);
        
        strings = bits.toString();
        
        if (bits.getValue() == 0) {
        	
        	
            System.out.println("Sucess " + strings);
        }
        
        else {
        	
            System.out.println("Failed " + strings);
            
        }
        
        
        
        //get bit test
        System.out.println("get bit 1 test:");
        
        testvalue.set(2147483647);
        
        bits = testvalue.getBit(5);
        
        strings = bits.toString();
        if (bits.getValue() == 1) {
        	
        	System.out.println("Success" + strings);
        	
        }         
        else {
            System.out.println("Failed " + strings);
        }
        
        System.out.println("get bit 0 test:");
        
        testvalue.set(0);
        
        bits = testvalue.getBit(5);
        strings = bits.toString();
        if (bits.getValue() == 0) {
        	
        	System.out.println("Success" + strings);
        	
        }         
        else {
            System.out.println("Failed " + strings);
        }


        //and test
        
        System.out.println("and test");
        
        testvalue.set(269484032);

        testvalue2.set(2146435071);
        
        testvalue2.setBit(0, x);

        result = testvalue.and(testvalue2);
        
        strings = result.toString();
        
        System.out.println("string is 29th bit on 1");
        
        System.out.println(strings);

        
        
        //or test 2 values
        System.out.println("or test");
        testvalue.set(269484032);

        testvalue2.set(2129657855);
        
        testvalue2.setBit(0, x);

        
        result = testvalue.or(testvalue2);
        
        strings = result.toString();
        
        System.out.println("string is 25th bit off 0");
        
        System.out.println(strings);
        
        

        //xor test 2 values
        System.out.println("xor test");
        
        testvalue.set(269484032);

        testvalue2.set(2129657855);
        
        testvalue2.setBit(0, x);

        result = testvalue.xor(testvalue2);
        
        strings = result.toString();
        
        System.out.println("string is 29th and 25th bits off 0");
        System.out.println(strings);
        
        
        //the not test
        System.out.println("Starting not() test:");
        
        testvalue.set(269484032);

        result = testvalue.not();
        
        strings = result.toString();
        
        System.out.println("string is 29th and 21st bits off 0");
        
        System.out.println(strings);

        
        
        //right shift
        System.out.println("right shift 3 test value 123456789 ");
        
        testvalue.set(123456789);
        
        result = testvalue.rightShift(3);
        
        System.out.println("should be 1110 1011 0111 1001 1010 0010");
        
        strings = result.toString();
        
        System.out.println(strings);
        

        
        //left shift test
        System.out.println("Starting left shift 3 same value");
        testvalue.set(123456789);
       
        result = testvalue.leftShift(3);
        System.out.println("should be 0011 1010 1101 1110 0110 1000 1010 1000");
        
        strings = result.toString();
        
        System.out.println(strings);
        
        
        //unsigned test
        System.out.println("unsigned test");
        
        testvalue.set(3);
        
        testvalue2.set(2147483647);
        
        testvalue2.setBit(0, x);
        
        long longresult;
        
        long longresult2;
        
        longresult = testvalue.getUnsigned();
        
        longresult2 = testvalue2.getUnsigned();
        
        System.out.println("values are 3 and 4,294,967,295");
        
        System.out.printf("values are %d and %d%n%n", longresult, longresult2);
        
        
        //get signed test
        System.out.println("get signed test");
        testvalue.set(-3);
        
        testvalue2.set(3);

        int a;
        
        int b;
        
        a = testvalue.getSigned();
        
        b = testvalue2.getSigned();
        
        System.out.println("values are -3 and 3");
        
        System.out.printf("values are %d and %d%n%n", a, b);
        

        //copy test
        System.out.println("copy() test first value 123456789 and 123");
        
        testvalue.set(123456789);
       
        result.copy(testvalue);
        
        System.out.println("value is 0111 0101 1011 1100 1101 0001 0101");
        
        strings = result.toString();
        
        System.out.println(strings);
        
        testvalue.set(123);
        
        System.out.println("Expect 0000 0000 0000 0000 0000 0000 0111 1011");
        
        strings = testvalue.toString();
        
        
        System.out.println(strings);
        
    }
    
}
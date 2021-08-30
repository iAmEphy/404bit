
public class bit_test {
	
	private bit_test(){
	
	}
	
	static void runTests() {
		
		String strings;
		
		bit testvalue = new bit();
		testvalue.set(1);
		
		bit comparevalues = new bit();
		
		bit result;
		
		//getValue test
		if(testvalue.getValue() == 1) {
			
			strings = testvalue.toString();
			
			System.out.println("Success get value test " + strings);
			
		}
		else {
			
			strings = testvalue.toString();
			
			System.out.println("Fail"  + strings);
			
		}
		
		//test set value to 0
		System.out.println("Set to 0 for set value");
		testvalue.set(0);
		
		if(testvalue.getValue() == 0) {
			
			strings = testvalue.toString();
			System.out.println("Success " + strings);
			
		}
		else {
			
			strings = testvalue.toString();
			System.out.println("Failed " + strings);
			
		}
		
		//set value test to 1
		System.out.println("Set to 1");
		testvalue.set(1);
		
		if(testvalue.getValue() == 1) {
			
			strings = testvalue.toString();
			System.out.println("Success " + strings);
			
		}
		else {
			
			strings = testvalue.toString();
			System.out.println("Failed " + strings);
			
		}
		
		//toggle test
		System.out.println("Set to 0");
		testvalue.set(0);
		testvalue.toggle();
		
		
		if(testvalue.getValue() == 1) {
			System.out.println("Sucess toggle to 1");
		}
		else {
			strings = testvalue.toString();
			System.out.println("Failed toggle " + strings);
		}
		
		System.out.println("Set to 1");
		testvalue.set(1);
		testvalue.toggle();
		
		
		if(testvalue.getValue() == 1) {
			System.out.println("Sucess toggle to 0");
		}
		else {
			strings = testvalue.toString();
			System.out.println("Failed toggle " + strings);
		}
		
		
		//set test
		System.out.println("Set to 0");
		testvalue.set(0);
		testvalue.set();
		if(testvalue.getValue() == 1) {
			System.out.println("Set to 1 success.");
		}
		
		else {
			strings = testvalue.toString();
			System.out.println("Failed set " + strings);
		}
		
		//clear test
		System.out.println("Set to 1 clear test");
		testvalue.set(1);
		testvalue.clear();
		
		if(testvalue.getValue() == 0) {
			
			System.out.println("Cleared to 0, success");
		}
		else {
			strings = testvalue.toString();
			System.out.println("Failed clear " + strings);
			
		}
       
		
		//And test
		System.out.println("set to 0 and 0");
		
		testvalue.set(0);
		
		comparevalues.set(0);
		
		result = testvalue.and(comparevalues);
		
		if(result.getValue() == 0) {
			strings = result.toString();
			
			System.out.println("Success " + strings);
			
		}
		else {
			
			strings = result.toString();
			
			System.out.println("Failed " + strings);
			
		}
		
		
		System.out.println("set to 1 and 0");
		
		testvalue.set(1);
		
		comparevalues.set(0);
		
		result = testvalue.and(comparevalues);
		
		if(result.getValue() == 0) {
			strings = result.toString();
			
			System.out.println("Success " + strings);
			
		}
		else {
			
			strings = result.toString();
			
			System.out.println("Failed " + strings);
			
		}
		
		System.out.println("set to 1 and 1");
		
		testvalue.set(1);
		
		comparevalues.set(1);
		
		result = testvalue.and(comparevalues);
		
		if(result.getValue() == 1) {
			strings = result.toString();
			
			System.out.println("Success " + strings);
			
		}
		else {
			
			strings = result.toString();
			
			System.out.println("Failed " + strings);
			
		}
		
		
		//OR tests
		System.out.println("set 0 or 0 test");
		
		testvalue.set(0);
		
		comparevalues.set(0);
		
		result = testvalue.or(comparevalues);
		
		if(result.getValue() == 0) {
			
			strings = result.toString();
			
			System.out.println("Success " + strings);
		}
		
		else {
			
			strings = result.toString();
			
			System.out.println("Failed 0 " + strings);
			
		}
		
		System.out.println("set 1 or 0 test");
		
		testvalue.set(1);
		
		comparevalues.set(0);
		
		result = testvalue.or(comparevalues);
		
		if(result.getValue() == 1) {
			
			strings = result.toString();
			
			System.out.println("Success " + strings);
		}
		
		else {
			
			strings = result.toString();
			
			System.out.println("Failed 0 " + strings);
			
		}
		
		System.out.println("set 0 or 1 test");
		
		testvalue.set(0);
		
		comparevalues.set(1);
		
		result = testvalue.or(comparevalues);
		
		if(result.getValue() == 1) {
			
			strings = result.toString();
			
			System.out.println("Success " + strings);
		}
		
		else {
			
			strings = result.toString();
			
			System.out.println("Failed 0 " + strings);
			
		}
		
		
		System.out.println("set 1 or 1 test");
		
		testvalue.set(1);
		
		comparevalues.set(1);
		
		result = testvalue.or(comparevalues);
		
		if(result.getValue() == 1) {
			
			strings = result.toString();
			
			System.out.println("Success " + strings);
		}
		
		else {
			
			strings = result.toString();
			
			System.out.println("Failed 0 " + strings);
			
		}
		
		//XOR 
		
		System.out.println("Set 1 xor 1 test");
		
		testvalue.set(1);
		
		comparevalues.set(1);
		
		result = testvalue.xor(comparevalues);
		
		if(result.getValue() == 0) {
			strings = result.toString();
			
			System.out.println("Success " + strings);
		
		}
		
		else {
			
			strings = result.toString();
			
			System.out.println("Failed " + strings);
		}
		
		
		System.out.println("Set 1 xor 0 test");
		
		testvalue.set(1);
		
		comparevalues.set(0);
		
		result = testvalue.xor(comparevalues);
		
		if(result.getValue() == 1) {
			
			strings = result.toString();
			
			System.out.println("Success " + strings);
		
		}
		
		else {
			
			strings = result.toString();
			
			System.out.println("Failed " + strings);
		}
		
		System.out.println("Set 0 xor 1 test");
		
		testvalue.set(0);
		
		comparevalues.set(1);
		
		result = testvalue.xor(comparevalues);
		
		if(result.getValue() == 1) {
			
			strings = result.toString();
			
			System.out.println("Success " + strings);
		
		}
		
		else {
			
			strings = result.toString();
			
			System.out.println("Failed " + strings);
		}
		
		System.out.println("Set 0 xor 0 test");
		
		testvalue.set(0);
		
		comparevalues.set(0);
		
		result = testvalue.xor(comparevalues);
		
		if(result.getValue() == 0) {
			
			strings = result.toString();
			
			System.out.println("Success " + strings);
		
		}
		
		else {
			
			strings = result.toString();
			
			System.out.println("Failed " + strings);
		}
		
		
		System.out.println("Not test set to 0");
		
		testvalue.set(0);
		
		result = testvalue.not();
		
		if(result.getValue() == 0) {
			strings = result.toString();
			
			System.out.println("Success It's set to 0 " + strings);
			
		}
		
		else {
			strings = result.toString();
			
			System.out.println("failed not set to 0 " + strings);
		}
		
		
		
		
	}
	
}

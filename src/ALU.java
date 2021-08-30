
public class ALU {
	public static longword doOp(bit[] operation, longword a, longword b) {
		
		longword result = new longword();
		
		int pointer = 0;
		String chars = "";
		rippleAdder adder = new rippleAdder();
		
		while (pointer < operation.length) {
			
			chars += operation[pointer].getValue();
			
			pointer++;
			
		}

		

		switch (chars) {
		case "1000":
			// and
			
			result = a.and(b);
			
			break;

		case "1001":
			// or
			
			result = a.or(b);
			break;

		case "1010":
			// xor
			
			result = a.xor(b);
			break;

		case "1011":
			// not
			
			result = a.not();
			break;

		case "1100":
			// left shift
			
			result = a.leftShift(b.getSigned());
			break;

		case "1101":
			// right shift
			
			result = a.rightShift(b.getSigned());
			break;

		case "1110":
			// add
			
			result = rippleAdder.add(a, b);
			
			break;

		case "1111":
			// subtract
			
			result = rippleAdder.subtract(a, b);
			break;

		case "0111":
			// multiply
			
			result = multiplier.multiply(a, b);
			break;
		}

		return result;

	}
	
}

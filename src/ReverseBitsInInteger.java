/*
 * Square Interview Coding Questions:
 * Reverse bits in an integer
 */

public class ReverseBitsInInteger {
	public static void main(String[] args) {
		int data = 456;
		String inputStr = convertDecToBin(data);
		System.out.println("input value : " + inputStr + " (" + convertBinToDec(inputStr) + ")");
		String result = reverse(data);
		System.out.println("reversed value : " + result + " (" + convertBinToDec(result) + ")");
	}
	
	public static String reverse(int n) {
		String input = convertDecToBin(n);
		char[] inputChar = input.toCharArray();
		for (int i = 0; i < inputChar.length / 2; i++) {
			char tmp  = inputChar[i];
			inputChar[i] = inputChar[inputChar.length - 1 - i];
			inputChar[inputChar.length - 1 - i] = tmp;
		}
		return new String(inputChar);
	}
	
	public static int convertBinToDec(String binStr) {
		int dec = 0;
		char[] bin = binStr.toCharArray();
		for (int i = bin.length - 1; i >= 0; i--) {
			if (bin[i] == '1') {
				dec += Math.pow(2, bin.length - 1 - i);
			}
		}
		return dec;
	}
	
	public static String convertDecToBin(int n) {
		StringBuffer str = new StringBuffer();
		int r = 0;
		while (n > 0) {
			r = n % 2;
			str.insert(0, r);
			n = n / 2;
		}
		return str.toString();
	}
}

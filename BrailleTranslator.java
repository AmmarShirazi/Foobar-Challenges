class Braille { // the attempt was to find a pattern and follow it but turns out just storing all characters in array would have been a better solution
	
	private final static String space = "000000";
	private final static String capital = "000001";
	private final static String[] firstTenCharacters = {"100000", "110000", "100100", "100110", "100010", "110100", "110110", "110010", "010100", "010110"};
	
	
	public static final String getBrailleString(Character ch) { // return appropriate values, empty string is return for incorrect inputs.
		
		String sol = new String(); // solution
		if (ch.equals(' ')) {
			sol = sol.concat(space);
			return sol;
		}
		boolean capitalFlag = false;
		if ((int)ch.charValue() >= 65 && (int)ch.charValue() <= 90) {
			sol = sol.concat(capital);
			capitalFlag = true;
		}
		if (capitalFlag == false && ((int)ch.charValue() >= 97 && (int)ch.charValue() <= 122) == false) {
			return "";
		}
		int charIndex = 0;
		if (capitalFlag == false) {
			charIndex = (int)ch.charValue() - 97;
		}
		else {
			charIndex = (int)ch.charValue() - 65;
		}
		
		if (charIndex <= 9) {
			sol = sol.concat(firstTenCharacters[charIndex]);
			return sol;
		}
		
		if (charIndex <= 19) {
			StringBuilder tempString = new StringBuilder(firstTenCharacters[charIndex - 10]);
			tempString.setCharAt(2, '1');
			sol = sol.concat(tempString.toString());
			return sol;
		}
		
		if (charIndex == 22) {
			return "010111";
		}
		int offset = -1; //offset needed as w was added later in Braille
		if (charIndex <= 21) {
			offset = 20;
		}
		else {
			
			offset = 21;
		}
		
		StringBuilder tempString = new StringBuilder(firstTenCharacters[charIndex - offset]);
		tempString.setCharAt(2, '1');
		tempString.setCharAt(5, '1');
		sol = sol.concat(tempString.toString());
		return sol;
		
	}
	
}

class Solution {
	public static String solution(String S) {
		
		String sol = new String();
		int Slength = S.length();
		for (int i = 0; i < Slength; i++)  {
			sol = sol.concat(Braille.getBrailleString(S.charAt(i)));
		}
		return sol;
	}
}

class Main {
	

	public static void main(String[] args) {
		
		String testSolution = Solution.solution("The quick brown fox jumps over the lazy dog");
		
		
		if (testSolution.equals("000001011110110010100010000000111110101001010100100100101000000000110000111010101010010111101110000000110100101010101101000000010110101001101100111100011100000000101010111001100010111010000000011110110010100010000000111000100000101011101111000000100110101010110110")) {
			System.out.println("it works");
		}

	}

}

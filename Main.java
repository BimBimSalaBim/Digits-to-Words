package wordNumbers;
import java.util.*;
public class Main {
	static String[] belowTwenty = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty"};
	static String[] tens = {"Twenty","Thirty","Forty", "Fifty","Sixty","Seventy","Eighty","Ninety"};
	static String hun = "Hundred";
	static String thou = "Thousand";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a number between 0 and 9999. Press 0 to quit.");
		int input = in.nextInt();
		if(input == 0) {
			in.close();
		}
		else {
		System.out.println(words(input));
		main(args);
		}
	}
	public static String words(int num) {
		String number = ""+num;
		if(num < 21) {
			return belowTwenty[num];
		}
		else if(100 > num && num >= 20) {
			return lessThanHundred(Character.getNumericValue(number.charAt(0)),Character.getNumericValue(number.charAt(1)));
		}
		else if(1000 > num && num >= 100) {
			return lessThan1K(Character.getNumericValue(number.charAt(0)), Character.getNumericValue(number.charAt(1)), Character.getNumericValue(number.charAt(2)));
		}
		else if(10000 > num && num >= 1000) {
			return lessThan10K(Character.getNumericValue(number.charAt(0)), Character.getNumericValue(number.charAt(1)), Character.getNumericValue(number.charAt(2)),Character.getNumericValue(number.charAt(3)));
		}
		return null;
	}
	public static String lessThanHundred(int place1, int place2) {
			String under20 = place1+""+place2;
			if(Integer.parseInt(under20) < 21) {
				return belowTwenty[Integer.parseInt(under20) ];
			}
			else if(place2 != 0 ) {
			return tens[place1- 2] + "-" + belowTwenty[place2 ];
			}
			else {
				if(place1 == 1) {
					return "Ten";
				}
				else {
					return tens[place1 - 2];
				}
			}
	}
	public static String lessThan1K(int place1, int place2, int place3) {
		if(place1 == 0) {
			return lessThanHundred(place2,place3);
		}
		if(place2  == 0 && place3  == 0) {
			return belowTwenty[place1] + " " + hun ;
			}
		else {
			return belowTwenty[place1] + " " + hun + " " + lessThanHundred(place2,place3);
		}
	}
	public static String lessThan10K(int place1, int place2, int place3, int place4) {
		if(place2  == 0 && place3  == 0 && place4 == 0) {
			return belowTwenty[place1] + " " + thou ;
			}
		else {
			return belowTwenty[place1] + " " + thou + " " + lessThan1K(place2,place3,place4);
		}
	}
}

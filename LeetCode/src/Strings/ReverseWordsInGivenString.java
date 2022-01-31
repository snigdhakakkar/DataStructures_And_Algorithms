package Strings;

public class ReverseWordsInGivenString {
	
	public static void main(String[] args) {
		String str = "I love coding in Java";
		
		//Method 1
		System.out.print(reverseWords1(str));
		System.out.println();
				
		//Method 2
		System.out.print(reverseWordsInStringBuilder(str));
		System.out.println();
	}
	
	public static String reverseWords1(String str) {
		String finalStr = "";
		String tempStr = "";
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c != ' ') {
				tempStr = tempStr + c;
			} else {
				finalStr = " " + tempStr + finalStr;
				tempStr = "";
			}
		}
		
		finalStr = tempStr + finalStr;
		
		return finalStr;
	}
	
	public static String reverseWordsInStringBuilder(String str) {
		StringBuilder finalStr = new StringBuilder();
		StringBuilder tempStr = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == ' ') {
				finalStr.insert(0, tempStr).insert(0, " ");
				tempStr.setLength(0);
				} else {
					tempStr.append(c);
				}
			}
		finalStr.insert(0, tempStr);
		return finalStr.toString();
	}

}

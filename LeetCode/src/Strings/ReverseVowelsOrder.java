package Strings;

public class ReverseVowelsOrder {
	
	public static void main(String[] args) {
		String str = "equation";
		ReverseVowelsOrder a = new ReverseVowelsOrder();
		
		System.out.println(a.reverseVowelsOrder(str));
	}
	
	public String reverseVowelsOrder(String str) {
		int start, end;
		start = 0;
		end = str.length() - 1;
		
		char[] charArr = str.toCharArray();
		
		while(start < end) {
			if(!isVowel(charArr[start])) {
				start++;
				continue;
			}
			
			if(!isVowel(charArr[end])) {
				end--;
				continue;
			}
			
			char c = charArr[start];
			charArr[start] = charArr[end];
			charArr[end] = c;
			
			start++;
			end--;
		}
		
		return String.valueOf(charArr);
	}
	
	public boolean isVowel(char c) {
		if(c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'I' || c == 'i' ||
				c == 'o' || c == 'O' || c == 'u' || c == 'U') {
			return true;
		}
		
		return false;	
	}

}

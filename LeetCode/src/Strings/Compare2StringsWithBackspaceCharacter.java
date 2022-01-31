package Strings;

public class Compare2StringsWithBackspaceCharacter {
	
	public static void main(String[] args) {
		String str1 = "gfh##s";
		String str2 = "gh#s";
		
		Compare2StringsWithBackspaceCharacter a = new Compare2StringsWithBackspaceCharacter();
		
		System.out.println(a.compare2StringsWithBackspaceCharacter(str1, str2));
	}
	
	public boolean compare2StringsWithBackspaceCharacter(String str1, String str2) {
		int end1 = str1.length() - 1;
		int end2 = str2.length() - 1;
		
		while(end1 >= 0 && end2 >= 0) {
			int str1Index = getChar(str1, end1);
			int str2Index = getChar(str2, end2);
			
			if(str1Index < 0 && str2Index < 0) {
				return true;
			}
			
			if(str1Index < 0 || str2Index < 0) {
				return false;
			}
			
			if(str1.charAt(str1Index) != str2.charAt(str2Index)) {
				return false;
			}
			
			end1 = str1Index - 1;
			end2 = str2Index - 1;
		}
		
		return true;
	}
	
	public static int getChar(String str, int end) {
		int specialCharacter = 0;
		
		while(end >= 0) {
			if(str.charAt(end) != '#') {
				if(specialCharacter == 0) {
					return end;
				} else {
					specialCharacter--;
				}
			} else {
				specialCharacter++;
			}
			end--;
		}
		return end;
	}

}

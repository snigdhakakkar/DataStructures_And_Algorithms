package array;

public class URLify {
	
	//Assuming that the string has sufficient free space in the end
	
	public static void replaceSpaces(char[] str, int truelength) {
		int spaceCount = 0, index = 0, i = 0;
		for (i = 0; i < truelength; i++) {
			
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		    
		index = truelength + spaceCount * 2;
		
		if (truelength < str.length) {
			str[truelength] = '\0'; //Replacing additional spaces in the end with null character
		}
		
		for (i = truelength - 1; i >= 0; i-- ) {
			
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			}
			
			else {
				str[index - 1] = str[i];
				index--;
			}
		}
	
	}
	
	public static int findLastCharacter(char[] str) {
		for (int i = str.length - 1; i >= 0; i--) {
			
			if (str[i] != ' ') {
				return i;
			}
		}
		
		return -1;
		
	}
	
	public static String charArrayToString(char[] arr) {
		return new String(arr);
		
		
	}
	
	public static void main(String[] args) {
		String str = "Mr John Smith ";
		char[] arr = str.toCharArray();
		int truelength = findLastCharacter(arr) + 1;
		replaceSpaces(arr, truelength);
		System.out.println("\"" + charArrayToString(arr) + "\"");
	}

}

package array;

public class URLify_v3 {
	
	/*count occurrences of target between start(inclusive) and end(exclusive) */
	public static int countOfChar(char[] str, int start, int end, int target) {
		int count = 0;
		for(int i = start; i < end; i++) {
			if(str[i] == target) {
				count++;
			}
		}
		return count;
	}
	
	public static void replaceSpaces(char[] str, int trueLength) {
		int numberOfSpaces = countOfChar(str, 0, trueLength, ' ');
		int newIndex = trueLength - 1 + numberOfSpaces*2;
		
		//Adding null character if there are excess spaces at the end
		if(newIndex + 1 < str.length) {
			str[newIndex + 1] = '\0';
		}
		
		for(int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -= 1){
			if(str[oldIndex] == ' ') {
				/*insert %20*/
				str[newIndex] = '0';
				str[newIndex - 1] = '2';
				str[newIndex - 2] = '%';
				newIndex -= 3;
			} else {
				str[newIndex] = str[oldIndex];
				newIndex -= 1;
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
		String str = "Mr John Smith    ";
		char[] arr = str.toCharArray();
		int trueLength = findLastCharacter(arr) + 1;
		replaceSpaces(arr, trueLength);	
		System.out.println("\"" + charArrayToString(arr) + "\"");
	}

}

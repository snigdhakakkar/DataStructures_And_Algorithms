package Strings;

public class TrimTheSring {
	
	public static void main(String[] args) {
		
		String s = "    Hello User!!  Welcome    onboard     ";
		
		char a[] = s.toCharArray();
		int start = 0; 
		int end = a.length - 1;
		int count;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] != ' ') {
				start = i;
				break;
			}
		}
		
		for(int i = a.length - 1; i > start-1; i--) {
			if(a[i] != ' ') {
				end = i;
				break;
			}
		}
		
		count = end - start + 1;
		
		String result = new String(a, start, count);
		
		System.out.println(result);
	}

}

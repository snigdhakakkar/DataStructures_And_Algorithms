package Strings;

public class ReplaceCharacterInString {
	
public static void main(String[] args) {
		
		String s = "    Hello User!!  Welcome    Onboard     ";
		
		char a[] = s.toCharArray();
		for(int i = 0; i < a.length; i++) {
			
			if(a[i] == 'o' || a[i] == 'O') {
				a[i] = 'y';
			}
		}
		
		System.out.print(a);
		
	}

}

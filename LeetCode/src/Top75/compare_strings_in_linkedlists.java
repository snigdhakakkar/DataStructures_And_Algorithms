package Top75;

/*
 * Problem statement - Compare strings stored in two Linked Lists. 
 * Return true if the strings stored in both the lists are similar.

List 1: "He" -> " llo" -> "wor" -> "ld"
List 2: "H" --> "e" --> "ll" --> "owo" --> "r" --> "ld"
Both the lists store “helloworld”.
 */

public class compare_strings_in_linkedlists {
	
	public static boolean isMatch(Node head1,Node head2) {
		Node n1 = head1, n2 = head2;
		int i1=0,i2=0;
		while(n1!=null && n2!=null) {
			if(i1==n1.val.length()) {
				n1 = n1.next;
				i1 = 0;
			}
			
			if(i2==n2.val.length()){
                n2 = n2.next;
                i2 = 0;
            }
			
			if(n1==null && n2==null){
                return true;
            }else if(n1==null||n2==null||n1.val.charAt(i1)!=n2.val.charAt(i2)){
                return false;
            }
            i1++;
            i2++;
		}   
		
		return n1 == null && n2 == null;
		
	}

}

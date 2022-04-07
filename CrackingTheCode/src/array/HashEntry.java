package array;

public class HashEntry {
	
	String key;
	String value;
	HashEntry next;
	
	HashEntry(String key, String value){
		this.key = key;
		this.value = value;
		this.next = null;
	}

}

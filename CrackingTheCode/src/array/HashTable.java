package array;

public class HashTable {
	
	private int INITIAL_SIZE = 16;
	private HashEntry[] data; //LinkedList
	
	HashTable(){
		data = new HashEntry[INITIAL_SIZE];
	}
	
	public void put(String key, String value) {
		
		//Get the index
		int index = getIndex(key);
		
		//Create the LinkedList entry
		HashEntry entry = new HashEntry(key, value);
		
		//If no entry there  - add it
		if(data[index] == null) {
			data[index] = entry;
		}
		
		//else handle the collision by adding to the end of the Linked List
		else {
			HashEntry entries = data[index];
			//walk to the end..
			while(entries.next != null) {
				entries = entries.next;
			}
			
			//add our new entry there
			entries.next = entry;
		}
	}
	
	public String get(String key) {
		
		//get the index
		int index = getIndex(key);
		
		//get the current list of entries
		HashEntry entries = data[index];
		
		//if we have existing entries against the key..
		if(entries != null) {
			//walk chain until find a match
			while(!entries.key.equals(key) && entries.next != null) {
				entries = entries.next;
			}
			//return the found match
			return entries.value;
		}
		
		//if we have no entries against the key..
		return null;
	}
	
	private int getIndex(String key) {
		//get the hash code
		int hashCode = key.hashCode();
		System.out.println("hashcode = " + hashCode);
		
		//convert to index
		int index = (hashCode & 0x7fffffff)% INITIAL_SIZE; //shift mask to avoid negative hashcode value
		
		//hack to force collision for testing
		if (key.equals("John Smith") || key.equals("Sandra Doe")) {
			index = 4;
		}
		
		System.out.println("index = " + index);
		
		return index;
	}
 
}

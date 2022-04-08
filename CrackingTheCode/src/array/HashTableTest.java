package array;
import static junit.Assert.*;				
import junit.Test;	
public class HashTableTest {
	
	private HashTable hashTable;
	
	public void Setup() {
		hashTable = new HashTable();
	}
	
	public void PutAndGet() {
		hashTable.put("John Smith", "521-1234");
		hashTable.put("Lisa Smith", "521-8976");
		hashTable.put("Same Doe", "521-5030");
		hashTable.put("Sandra Dee", "521-9655");
		hashTable.put("Ted Baker", "418-4165");
		
		assert.assertEquals(expected: "521-1234", hashTable.get("John Smith"));
		assert.assertEquals(expected: "521-8976", hashTable.get("Lisa Smith"));
		assert.assertEquals(expected: "521-5030", hashTable.get("Same Doe"));
		assert.assertEquals(expected: "521-9655", hashTable.get("Sandra Dee"));
		assert.assertEquals(expected: "418-4165", hashTable.get("Ted Baker"));
		
		hashTable.toString();
	}
	
	public void Collision() {
		
	}

}

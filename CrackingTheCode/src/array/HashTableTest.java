package array;
import static junit.Assert.*;				
import junit.Test;	
public class HashTableTest {
	
	private HashTable hashTable;
	
	@Before
	public void Setup() {
		hashTable = new HashTable();
	}   
	
	@Test
	public void PutAndGet() {
		hashTable.put("John Smith", "521-1234");
		hashTable.put("Lisa Smith", "521-8976");
		hashTable.put("Same Doe", "521-5030");
		hashTable.put("Sandra Dee", "521-9655");
		hashTable.put("Ted Baker", "418-4165");
		
		Assert.assertEquals(expected: "521-1234", hashTable.get("John Smith"));
		Assert.assertEquals(expected: "521-8976", hashTable.get("Lisa Smith"));
		Assert.assertEquals(expected: "521-5030", hashTable.get("Same Doe"));
		Assert.assertEquals(expected: "521-9655", hashTable.get("Sandra Dee"));
		Assert.assertEquals(expected: "418-4165", hashTable.get("Ted Baker"));
		
		hashTable.toString();
	}
	
	@Test
	public void Collision() {
		//these keys will collide
		HashTable.put("John Smith", "521-1234");
		hashTable.put("Sandra Dee", "521-9655");
	}

}

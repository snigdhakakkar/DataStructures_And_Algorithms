package Queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheImp1 {

	Deque<CacheEntry> q = new LinkedList<>();
	Map<Integer, CacheEntry> map = new HashMap<>();
	int Cache_Size = 3;
	
	public String getFromCache(int key) {
		if(map.containsKey(key)) {
			CacheEntry entry = map.get(key);
			q.remove(entry);
			q.addFirst(entry);
			return entry.value;
		}
		return null;
	}
	
	public void putEntryIntoCache(int key, String value) {
		if(map.containsKey(key)) {
			CacheEntry entry = map.get(key);
			q.remove(entry);
		} else {
			if(q.size() == Cache_Size) {
				CacheEntry entryToBeRemoved = q.removeLast();
				map.remove(entryToBeRemoved.key);
			}
		}
		CacheEntry newEntry = new CacheEntry(key, value);
		q.addFirst(newEntry);
		map.put(key, newEntry);
		
	}
	
	public static void main(String[] args) {
		LRUCacheImp1 cache = new LRUCacheImp1();
		cache.putEntryIntoCache(1, "Product-1-info");
		cache.putEntryIntoCache(2, "Product-2-info");
		cache.putEntryIntoCache(3, "Product-3-info");
		cache.putEntryIntoCache(4, "Product-4-info");
		
		System.out.println(cache.getFromCache(2));
		System.out.println(cache.getFromCache(6));
	}
}

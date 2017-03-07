/**
 * 
 */
package com.for22.mjcp.concurrency.concurrentnavigablemap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author liqiankun
 *
 */
public class ConcurrentNavigableMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ConcurrentNavigableMap<String,String> map = new ConcurrentSkipListMap<String,String>();
		map.put("2", "two");
		map.put("1", "one");
		map.put("4", "four");
		map.put("3", "three");
		map.put("5", "five");
		/*
		 * The headMap(T toKey) method returns a view of the map containing the
		 * keys which are strictly less than the given key.
		 * 
		 * If you make changes to the original map, these changes are reflected
		 * in the head map.
		 */
		ConcurrentNavigableMap<String,String> headMap = map.headMap("2");
		foreach(headMap);
		
		/*
		 * The tailMap(T fromKey) method returns a view of the map containing
		 * the keys which are greater than or equal to the given fromKey.
		 * If you make changes to the original map, these changes are reflected in the tail map. 
		 */
		ConcurrentNavigableMap<String,String> tailMap = map.tailMap("2");
		foreach(tailMap);
		
		/*
		 * The subMap() method returns a view of the original map which contains
		 * all keys from (including), to (excluding) two keys given as
		 * parameters to the method
		 */
		ConcurrentNavigableMap<String,String> subMap = map.subMap("2", "5");
		foreach(subMap);
		
		
		NavigableSet<String> ns = map.descendingKeySet();
		foreach(ns);
		
		ConcurrentNavigableMap<String,String>  cnmap=	map.descendingMap();
		foreach(cnmap);
		
		NavigableSet<String> ns2 = map.navigableKeySet();
		foreach(ns2);
		
	}
	
	static void foreach(ConcurrentNavigableMap<String,String> map){
		Set<Map.Entry<String,String>> cs = map.entrySet();
		for(Entry<String,String> en:cs){
			System.out.println(en.getKey()+"-"+en.getValue());
		}
		System.out.println("---------");
	}
	static void foreach(Set<String> set){
		for(String s:set)
			System.out.println(s);
	}

}

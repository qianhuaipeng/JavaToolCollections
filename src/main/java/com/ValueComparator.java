package com;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ValueComparator implements Comparator<Double> {
	Map<Double, Double> base;

	public ValueComparator(Map<Double, Double> base) {
		this.base = base;
	}

	@Override
	public int compare(Double o1, Double o2) {
		if (base.get(o1).doubleValue() >= base.get(o2).doubleValue()) {
			return -1;
		} else {
			return 1;
		}
	}

	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(
			final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k2).compareTo(map.get(k1));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};
		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	  public static void main(String[] args) {  
	        HashMap<Double, Double> map = new HashMap<Double, Double>();  
	        map.put(11.5, 99.5);  
	        map.put(22.1, 67.2);  
	        map.put(222.2, 67.5);  
	        map.put(223.2, 67.6);  
	  
	        ValueComparator bvc = new ValueComparator(map);  
	        TreeMap sorted_map = new TreeMap(bvc);  
	  
	        System.out.println("unsorted map: " + map);  
	  
	        sorted_map.putAll(map);  
	  
	        System.out.println("results: " + sorted_map);  
	  
	        Map<Double, Double> sorted_map2 = sortByValues(map);  
	          
	        System.out.println("results2: " + sorted_map2);  
	    }  
}

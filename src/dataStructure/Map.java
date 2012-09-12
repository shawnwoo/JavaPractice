package dataStructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Map<K, V> {
	private int size;
	private int DEFAULT_CAPACITY = 16;

	private Entry<K, V>[] values = new Entry[DEFAULT_CAPACITY];

	public V get(K key) {
		for (int i = 0; i < size; i++) {
			if (values[i] != null) {
				if (values[i].getKey().equals(key)) {
					return values[i].getValue();
				}
			}
		}
		return null;
	}

	public void put(K key, V value) {
		boolean insert = true;
		for (int i = 0; i < size; i++) {
			if (values[i].getKey().equals(key)) {
				values[i].setValue(value);
				insert = false;
			}
		}
		if (insert) {
			ensureCapacity();
			values[size++] = new Entry<K, V>(key, value);
		}
	}

	public int size() {
		return size;
	}

	public void remove(K key) {
		for (int i = 0; i < size; i++) {
			if (values[i].getKey().equals(key)) {
				values[i] = null;
				size--;
				condensArray(i);
			}
		}
	}

	public Set<K> keySet(){
		Set<K> set= new HashSet<K>();
		for(int i=0;i<size;i++){
			set.add(values[i].getKey());
		}
		return set;
	}
	
	private void condensArray(int start) {
		for (int i=start;i<size;i++){
			values[i]=values[i+1];
		}
	}
	
	

	private void ensureCapacity() {
		if (size == values.length) {
			int newSize = values.length * 2;
			values = Arrays.copyOf(values, newSize);
		}
	}

}

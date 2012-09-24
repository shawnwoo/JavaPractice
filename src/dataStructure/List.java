package dataStructure;

import java.util.Arrays;

public class List <E> {
	private int size=0;
	private static final int DEFAULT_CAPACITY=10;
	private Object elements[];
	
	public List(){
		elements=new Object[DEFAULT_CAPACITY];
		
	}
	
	public void add(E e){
		if(size==elements.length){
			ensureCapacity();
		}
		elements[size++]=e;
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public E get(int i){
		if(i>elements.length){
			throw new IndexOutOfBoundsException("Index: "+i+" , Size "+i);
		}
		return (E)elements[i];
	}

	private void ensureCapacity() {
		int newSize=elements.length*2;
		elements=Arrays.copyOf(elements, newSize);
		
	}
	
	public static void main(String[] args){
		List l=new List();
		
		for(int i=0;i<=100;i++){
			l.add(i);
		}
		
		System.out.println(l.size);
		System.out.println(l.get(60));
	}
	
}

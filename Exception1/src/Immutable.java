import java.util.ArrayList;

import org.apache.commons.lang3.*;

import java.util.Collection;
import java.util.List;
import java.io.Serializable;
public class Immutable<E> extends ArrayList<E> {

	/**
	 * 
	 */
	
	public static void main(String... args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		list.add(2);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(4);
		Immutable<Integer> im= new Immutable<Integer>(list) ;
		im.get(0);
		System.out.println(im.get(0));
	}
	@SafeVarargs
	public final  <T> List<T> asList(T... arguments){
		
		
		if (arguments != null) {
			return list.subList((Integer) arguments[0], (Integer) arguments[1]);
		} else {
			return list;
		}
	}
	
	@Override
	public E get(int index) {
		@SuppressWarnings("unchecked")
		E ele = (E) list.get(index);
		E element = (E) org.apache.commons.lang3.SerializationUtils.clone((Serializable)ele);
		
		return element;
	}

	private static List list,lisCopy;
	public Immutable(Collection<? extends E> collection){
		if(list == null){
			list = new ArrayList();
			list.addAll(collection);
		}
		else{
			throw new UnsupportedOperationException("This class is immutable so you cant change it!");
		}
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(E e) throws UnsupportedOperationException{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This ArrayList is immutable so you cant add new elements");
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This ArrayList is immutable so you cant delete  elements");
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This ArrayList is immutable so you cant delete  elements");
	}
	
}

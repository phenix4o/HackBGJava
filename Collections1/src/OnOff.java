import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class OnOff<E> implements Collection<E> {
	
	
	List<E> list;
	
	public static void main(String... args){
		OnOff o = new OnOff<Integer>();
		o.add(10);
		o.add(19);
		System.out.println(Arrays.toString(o.toArray()));
		o.add(19);
		System.out.println(Arrays.toString(o.toArray()));
		o.add(10);
		System.out.println(Arrays.toString(o.toArray()));
	}
	public OnOff(){
		list = new ArrayList<E>();
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return list.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		if(!e.equals(null)){
			if(list.contains(e)){
				list.remove(e);
			}else{
				list.add(e);
			}
		}
		else{
			System.out.println("The element must not equal null");
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}

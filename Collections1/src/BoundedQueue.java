import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class BoundedQueue<T> implements Queue {
	private  List<T> array;
	private static  int counter = 0;

	public static void main(String... args) {
		BoundedQueue<Integer> boundedQueue = new BoundedQueue<Integer>(2);
		boundedQueue.offer(1);
		boundedQueue.offer(2);
		boundedQueue.offer(3);
		boundedQueue.offer(4);
		boundedQueue.offer(5);
		boundedQueue.offer(6);
		boundedQueue.offer(7);
		System.out.println(boundedQueue.toString());
	}

	public BoundedQueue(int size) {
		// TODO Auto-generated constructor stub
		array =  new ArrayList<T>();
		counter = size;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return counter;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(Object e) {
		// TODO Auto-generated method stub
		if(array.size()<counter){
			array.add((T) e);
		}
		else{
			int size = array.size()-1;
			array.remove(0);
			array.add(size, (T) e);
		}
		return true;
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		return array.toString();
	}
}

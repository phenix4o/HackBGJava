import java.util.ArrayList;
import java.util.Iterator;

public class MyArray<T> extends ArrayList<T> {
	public static void main(String... args){
		MyArray<Integer> ma = new MyArray<Integer>();
		ma.add(20);
		ma.add(60);
		ma.add(80);
		System.out.println(ma.maximum+" "+ma.minimum);
	}
	private int maximum, minimum = Integer.MAX_VALUE;
	
	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	@Override
	public boolean add(T object) {
		if ((Integer) object < getMinimum()) {
			setMinimum((Integer) object);
		}
		if ((Integer) object > getMaximum()) {
			setMaximum((Integer) object);
		}
		return super.add(object);
	}

	@Override
	public void add(int index, T object) {
		if ((Integer) object < getMinimum()) {
			setMinimum((Integer) object);
		}
		if ((Integer) object > getMaximum()) {
			setMaximum((Integer) object);
		}
		super.add(index, object);
	}

	@Override
	public void clear() {
		super.clear();
	}

	@Override
	public T get(int index) {
		return super.get(index);
	}

	@Override
	public int size() {
		return super.size();
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public boolean contains(Object object) {
		return super.contains(object);
	}

	@Override
	public T remove(int index) {
		return super.remove(index);
	}

	@Override
	public boolean remove(Object object) {
		return super.remove(object);
	}

	@Override
	public Iterator<T> iterator() {
		return super.iterator();
	}

	@Override
	public T set(int index, T object) {
		return super.set(index, object);
	}
}

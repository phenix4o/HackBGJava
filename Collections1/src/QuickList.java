import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class QuickList implements Statistics, Iterable<Integer>,
		Iterator<Integer> {
	List<Integer> container;
	public static int count = 0;

	public QuickList() {
		container = new ArrayList<Integer>();
	}

	public void add(int integer) {
		container.add(integer);
	}

	@Override
	public float getMean() {
		float sum = 0f;
		for (Integer i : container) {
			sum += i;
		}
		return sum / container.size();
	}

	@Override
	public float getMedian() {
		float result = 0f;
		if(container.size()%2==0){
			int index = (container.size()/2)-1;
			int index2 = container.size()/2;
			result = (float)((float) container.get(index)+(float)container.get(index2))/2;
		
		}else{
			int index = container.size()/2;
			result = container.get(index);
		}
		return result;

	}

	@Override
	public ArrayList<Integer> getMode() {
		ArrayList<Integer> most = new ArrayList<Integer>();

		int num = 0;
		int count = 0;

		for (int i = 0; i < container.size(); i++) {
			int cur_num = container.get(i);
			int cur_count = 1;

			for (int i2 = 0; i2 < container.size(); i2++) {
				if (container.get(i2) == cur_num)
					cur_count++;
			}
			if (cur_count > count) {
				num = cur_num;
				count = cur_count;
				most.clear();
				most.add(num);

			} else if (cur_count == count) {
				boolean flag = false;
				for (int i3 = 0; i3 < most.size(); i3++) {
					if (most.get(i3) == cur_num) {
						flag = true;
					}
				}
				if (flag == false) {
					most.add(cur_num);
				}
			}

		}
		;

		return most;
	}

	@Override
	public int getRange() {
		// TODO Auto-generated method stub
		return Collections.max(container) - Collections.min(container);
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public boolean hasNext() {
		if (count < container.size()) {
			return true;
		}
		return false;
	}

	@Override
	public Integer next() {
		if (count == container.size()) {
			throw new NoSuchElementException();
		}
		count++;
		Object[] array = container.toArray();
		return (Integer) array[count - 1];
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();

	}

}

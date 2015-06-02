import java.util.HashMap;

public class NotNullHashmap<K, V> extends HashMap<K, V> {
	private boolean flag = false;

	public NotNullHashmap(boolean flag) {
		this.setFlag(flag);
	}

	@Override
	public V get(Object key) throws NullKeyException {
		// TODO Auto-generated method stub
		if (!flag && key==null) {
			throw new NullKeyException();
		} else

			return super.get(key);
	}

	@Override
	public V put(K key, V value) throws NullKeyException, NullValueException {
		// TODO Auto-generated method stub
		if (!flag) {
			if (key == null) {
				throw new NullKeyException();
			} else if (value == null) {
				throw new NullValueException();
			} else if (value != null && key != null) {
				return super.put(key, value);
			} 
		} else {
			return super.put(key, value);
		}
		return null;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public static void main(String... args){
		NotNullHashmap<Integer, Integer> map = new NotNullHashmap<Integer, Integer>(false);
		map.put(1, 2);
		System.out.println(map.get(1));
	}
}

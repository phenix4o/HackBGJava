
public class LearnGeometryTask implements Task{
	public int duration = 1;
	private int priority = 1;
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}

	@Override
	public void setPriority(int priority) {

	}

	@Override
	public void setTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTime() {
		// TODO Auto-generated method stub
		return duration;
	}

	@Override
	public int compare(Task t, Task t2) {
		// TODO Auto-generated method stub
		return t.getPriority()-t2.getPriority();
	}
}

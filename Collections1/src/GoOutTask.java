
public class GoOutTask implements Task{
	public int duration;
	private int priority = 2;
	public GoOutTask(int i) {
		// TODO Auto-generated constructor stub
		this.duration = i;
	}

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

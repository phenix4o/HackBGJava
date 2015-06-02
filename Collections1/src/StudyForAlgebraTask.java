
public class StudyForAlgebraTask implements Task {
	public int duration = 3;
	private int priority;
	public StudyForAlgebraTask(int priority) {
		// TODO Auto-generated constructor stub
		this.priority = priority;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}

	@Override
	public void setPriority(int priority) {
		// TODO Auto-generated method stub
		this.priority = priority;
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

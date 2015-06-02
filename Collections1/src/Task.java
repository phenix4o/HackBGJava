import java.util.Comparator;


public interface Task extends Comparator<Task>{
	public int  getPriority();
	public void setPriority(int priority);
	public void setTime();
	public int getTime();
	public int compare(Task t,Task t2);
}

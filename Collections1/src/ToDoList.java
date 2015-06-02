import java.util.ArrayList;
import java.util.List;


public class ToDoList {
	List <Task> container;
	int remainingHour;
	public ToDoList(int remainingHour){
		this.remainingHour =remainingHour;
		container = new ArrayList<Task>();
	}
	public void addTask(Task t){
		container.add(t);
	}
	public void markedFinished(Task t){
		remainingHour -=t.getTime();
		int index = container.indexOf(t);
		container.remove(index);
	}
	public void markedCancelled(Task t){
		container.remove(container.indexOf(t));
	}
	public Task getTop(){
		return container.get(0);
	}
	public boolean canFinish(){
		int sum = 0;
		for(int i= 0;i<container.size();i++){
			sum+=container.get(i).getTime();
		}if(remainingHour-sum>=0){
			return true;
		}
		return false;
	}
	public int getRemainenigTime(){
		int sum = 0;
		for(int i= 0;i<container.size();i++){
			sum+=container.get(i).getTime();
		}
		int result = remainingHour-sum;
		return result;
	}
}

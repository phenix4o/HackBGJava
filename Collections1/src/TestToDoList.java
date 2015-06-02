public class TestToDoList {
	public static void main(String [] args){
		ToDoList todo = new ToDoList(11); //11 hours remaining!
		todo.addTask(new StudyForAlgebraTask(10)); //maximum priority!
		todo.addTask(new LearnGeometryTask()); //default priority, smaller than 10
		todo.addTask(new GoOutTask(2));  //default priority, smaller than 10
		todo.addTask(new SleepTask()); //straight 8 hours, of course!

		if (todo.canFinish()){
		    System.out.println("Woohoo!");
		} else {
		    System.out.println("I am ...screwed :(");
		}

		System.out.println(todo.getTop().getClass().getName()); //StudyForAlgebraTask
		System.out.println(todo.getRemainenigTime()); //su
	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListOfStudent {

	public static void main(String... args) {
		List<Student> list = new ArrayList<Student>();

		list.add(new Student("Martin", 6));
		list.add(new Student("Kristina", 5));
		list.add(new Student("Karamfila", 5));
		list.add(new Student("Lucho", 5));
		System.out.println(list.get(0).grade + " " + list.get(0).name);
		Collections.sort(list, new StudentGradeComparator());
		System.out.println(list.get(0).grade + " " + list.get(0).name);
		Collections.sort(list, new StudentNameComparator());
		System.out.println(list.get(0).grade + " " + list.get(0).name);
	}

}

class Student {
	int grade;

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;

	public Student(String name, int grade) {
		this.grade = grade;
		this.name = name;
	}
}

class StudentNameComparator implements Comparator<Student> {
	@Override
	public int compare(Student std, Student std2) {
		return std.name.compareTo(std2.name);
	}

}

class StudentGradeComparator implements Comparator<Student> {
	@Override
	public int compare(Student std, Student std2) {

		return std.grade - std2.grade;

	}

}

package com.hackbulgaria.corejava2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.hackbulgaria.corejava2.data.Gender;
import com.hackbulgaria.corejava2.data.Student;
import com.hackbulgaria.corejava2.data.StudentsDataFactory;

public class StudentOperationsImpl implements StudentOperations {
	private List<Student> list;
	public StudentOperationsImpl(List<Student> list) {
		// TODO Auto-generated constructor stub
		this.list = list;
	}
	@Override
	public double getAverageMark() {
		return 	list.stream().mapToDouble(Student::getGrade).average().getAsDouble();
	}

	@Override
	public List<Student> getAllPassing() {
		return list.stream().filter(s->s.getGrade()>=3).collect(Collectors.toList());
	}

	@Override
	public List<Student> getAllFailing() {
		return list.stream().filter(s->s.getGrade()==2).collect(Collectors.toList());
	}

	@Override
	public Map<Boolean, List<Student>> splitStudentsByMarks(float splitMark) {
		
		return null;
	}

	@Override
	public List<Student> orderByMarkDescending() {
		
		return list.stream().sorted(Comparator.comparingDouble(Student::getGrade).reversed()).collect(Collectors.toList());
	}

	@Override
	public List<Student> orderByMarkAscending() {
	
		
		return list.stream().sorted(Comparator.comparingDouble(Student::getGrade)).collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentsWithLowestMarks() {
		double min = list.stream().mapToDouble(s->s.getGrade()).min().getAsDouble();
		return list.stream().filter(s->s.getGrade()==min).collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentsWithHighestMarks() {
		double max = list.stream().mapToDouble(s->s.getGrade()).max().getAsDouble();
		return list.stream().filter(s->s.getGrade()==max).collect(Collectors.toList());
	}

	@Override
	public Map<Integer, List<Double>> getMarksDistributionByAge() {
		
		
		return null;
	}

	@Override
	public Map<Gender, Double> getAverageMarkByGender() {
		
		return null;
	}

	@Override
	public Map<Double, Integer> getMarksDistribution() {
	
		return null;
	}

	@Override
	public String getEmailToHeader() {
		
		return null;
	}

	@Override
	public Map<Gender, Map<Integer, List<Student>>> splitStudentMarksByGenderAndThenByAge() {
		
		
		return null;
	}

}

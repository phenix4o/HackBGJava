package week5Annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

@ClassInfo(author = "Martin Nanchev", revision = 2, related = { Object.class }, checked = false)
public class TestAnnotation {
	public static void main(String... agrs) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for(Annotation annotation: TestAnnotation.class.getAnnotations()){
			System.out.println(annotation);
		}
		TestAnnotation cl = new TestAnnotation();
		
		System.out.println(cl.getClass().getAnnotation(ClassInfo.class));
	}
}

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

public class PrintAllPeopleSignedForMorThanOneCourse { 
	private static final String COURSE = "courses";
	private static final String NAME = "name";
	private static final String STUDENT_NAME = "student_name";
	private static ArrayList<String> studentsList;
	private static HashMap<String, Integer> mapOfStudents;
	private static TreeMap<String, Integer> sortedMapOfStudents;
	
	public static void printAllStudentsInMoreThanOneCourse(String url) {
		studentsList = findStudents(getJSONArray(url));
		for (String name : studentsList) {
			System.out.println(name);
		} 
	} 
	 
	public static void printCheckins(String url) {
		mapOfStudents = findCheckins(getJSONArray(url));
		sortedMapOfStudents = sortMap(mapOfStudents);
		for (Map.Entry<String, Integer> entry : sortedMapOfStudents.entrySet()) {
			System.out.println(entry.getKey() + "/" + entry.getValue());
		} 
	} 
 
 
	private static TreeMap<String, Integer> sortMap(HashMap<String, Integer> mapOfStudents2) {
		ValueComparator vc = new ValueComparator(mapOfStudents2);
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(vc);
		sortedMap.putAll(mapOfStudents2);
		return sortedMap;
	} 
 
 
	private static JSONArray getJSONArray(String url) {
		CloseableHttpClient httpClient;
		HttpGet source;
		CloseableHttpResponse response = null;
		HttpEntity entity;
		String data;
		JSONArray jArr = null;
		try { 
			httpClient = HttpClients.createDefault();
			source = new HttpGet(url);
			response = httpClient.execute(source);
			entity = response.getEntity();
			data = EntityUtils.toString(entity);
			jArr = new JSONArray(data);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
			try { 
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} 
		return jArr;
	} 
 
 
	private static ArrayList<String> findStudents(JSONArray jArr) {
		String courses;
		String nameOfStudent;
		JSONArray tempJArray;
		ArrayList<String> students = new ArrayList<String>();
		try { 
			for (int i = 0; i < jArr.length(); i++) {
				nameOfStudent = jArr.getJSONObject(i).getString(NAME);
				courses = jArr.getJSONObject(i).getString(COURSE);
				tempJArray = new JSONArray(courses);
				if (tempJArray.length() > 1) {
					students.add(nameOfStudent);
				} 
			} 
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return students;
	} 
	 
	private static HashMap<String, Integer> findCheckins(JSONArray jArr) {
		String nameOfStudent;
		int count;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		try { 
			for (int i = 0; i < jArr.length(); i++) {
				nameOfStudent = jArr.getJSONObject(i).getString(STUDENT_NAME);
				if (!map.containsKey(nameOfStudent)) {
					count = 1;
					map.put(nameOfStudent, count);
				} else { 
					count = map.get(nameOfStudent);
					map.put(nameOfStudent, ++count);
				} 
			} 
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return map;
	} 
} 
 
 
class ValueComparator implements Comparator<String> {
	Map<String, Integer> map;
	 
	public ValueComparator(Map<String, Integer> map) {
		this.map = map;
	} 
	 
	@Override 
	public int compare(String o, String o2) {
		if (map.get(o) >= map.get(o2)) {
			return -1; 
		} else { 
			return 1; 
		} 
	} 
	 
} 
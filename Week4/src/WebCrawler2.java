import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler2 {
	private static String domain = null;
	private static ArrayList<URL> visited = new ArrayList<URL>();

	public static void main(String[] args) {
		try {
			String website = "http://ebusiness.free.bg/";
			domain = website;
			URL url = new URL(website);
			System.out.println(url);
			String needle = "�����������";
			Search(url, needle);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private static void Search(URL url, String needle) throws IOException {
		visited.add(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream(), Charset.forName("UTF-8")));

		StringBuilder content = new StringBuilder();
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}

		in.close();

		String contentAsString = content.toString();

		if (contentAsString.contains(needle)) {
			System.out.println("Found at - " + url.toString() + " (out of "
					+ visited.size() + " searched urls)");
			return;
		}

		ArrayList<String> links = getAllLinks(contentAsString);

		for (String next : links) {
			if (next.contains("http")) {
				if (!next.contains(domain)) {
					continue;
				}
			}

			if (next.contains("/")) {
				next = next.substring(next.lastIndexOf("/") + 1);
			}

			URL nextUrl = new URL(domain + next);

			if (!visited.contains(nextUrl)) {
				// System.out.println("Next - " + nextUrl);
				Search(nextUrl, needle);
			}
		}
	}

	private static ArrayList<String> getAllLinks(String url) {
		ArrayList<String> resultList = new ArrayList<>();
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);

		while (matcher.find()) {
			resultList.add(matcher.group(1));
		}

		return resultList;
	}
}

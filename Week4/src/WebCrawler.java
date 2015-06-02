import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class WebCrawler {

	public static void main(String[] args) throws ClientProtocolException,
			IOException, URISyntaxException {
		String needle = "Револвираща";
		URI link = new URI("http://ebusiness.free.bg");
		webCrawlerStart(needle, link);

	}

	public static void webCrawlerStart(String needle, URI link)
			throws ClientProtocolException, IOException, URISyntaxException {
		URI url = link;
		HttpGet request = new HttpGet(url.toString());

		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse response = httpClient.execute(request);

		HttpEntity entity = response.getEntity();
		String entityContents = EntityUtils.toString(entity);
		if (entityContents.contains(needle)) {
			System.out.println(url);
		} else {
			Set<String> list = getAllLinks(entityContents);
			for (String s : list) {
				URI url2 = new URI(s);
				StringBuilder sb = new StringBuilder();
				sb.append(url2.toString());

				URI uri = new URI(sb.toString());
				System.out.println(uri.toString());
				sb.setLength(0);
			}
		}
	}

	private static Set<String> getAllLinks(String content) {
		Set<String> resultList = new TreeSet<String>();
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			if (!matcher.group(1).startsWith(".")) {
				resultList.add(matcher.group(1));
				
			}

		}
		return resultList;
	}
}

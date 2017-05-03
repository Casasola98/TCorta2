package fastTextContent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HTMLBrowser {
	
	private final String SearcherAgent = "Mozilla/5.0";
	private StringBuffer SearchingAnswer;
    
    public HTMLBrowser(){     
    }
    
    public String getSearchResult(String SearchWord) throws Exception {
        String DefaultURL = "http://www.google.com/search?q=";
        String Link = DefaultURL + SearchWord;
        URL BrowsingURL = new URL( Link );
        HttpURLConnection Connection = (HttpURLConnection) BrowsingURL.openConnection();
        Connection.setRequestProperty("User-Agent", SearcherAgent);
        int CodeofResponse = Connection.getResponseCode();
        BufferedReader BufReader = new BufferedReader( new InputStreamReader(Connection.getInputStream()));
        SearchingAnswer = new StringBuffer();
        String ObtainedContent;
        while ((ObtainedContent = BufReader.readLine()) != null) {
        	SearchingAnswer.append(ObtainedContent);
        }
        BufReader.close();
        return SearchingAnswer.toString();   
    }
    
}

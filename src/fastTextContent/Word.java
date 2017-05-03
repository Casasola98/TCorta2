 package fastTextContent;

public class Word {
	private String SearchingTime;
	private String HTTPGet;
	private String SearchedWord;
	public boolean InHash = false;
	
	public Word(String pSearchingTime, String pHTTPGet, String pSearchedWord){
		setSearchingTime(pSearchingTime);
		setHTTPGet(pHTTPGet);
		setSearchedWord(pSearchedWord);
	}
	
	private void setSearchingTime(String pSearchingTime){
		SearchingTime = pSearchingTime; 
	}
	
	private void setHTTPGet(String pHTTPGet){
		HTTPGet = pHTTPGet;
	}
	
	private void setSearchedWord(String pSearchedWord){
		SearchedWord = pSearchedWord;
	}
	
	public String getSearchingTime(){
		return SearchingTime; 
	}
	
	public String getHTTPGet(){
		return HTTPGet;
	}
	
	public String getSearchedWord(){
		return SearchedWord;
	}
}

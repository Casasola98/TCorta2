package fastTextContent;

import java.util.Observable;
import java.util.Observer;

public class Execution extends Observable implements Runnable{
	
	private long InitialTime;
	private long FinalTime;
	private String SearchWord;
	private String HTMLInformation;
    private String SearchingTime;
    private Word  Searched;
    private boolean FromHash = false;
    
    public boolean getFronHash() {
        return FromHash;
    }
    
    public String getHTMLInformation() {
        return HTMLInformation;
    }

    public String getSearchingTime() {
        return SearchingTime;
    }
    
    public Word getSearched() {
        return Searched;
    }
	
	private void setInitialTime(long pInitialTime){
		InitialTime = pInitialTime;
	}

	public long getInitialTime(){
		return InitialTime;
	}
	
	private void setFinalTime(long pFinalTime){
		FinalTime = pFinalTime;
	}
	
	public long getFinalTime(){
		return FinalTime;
	}
	
	private void setSearchWord(String pSearchWord){
		SearchWord = pSearchWord;
	}
	
	public String getSearchWord(){
		return SearchWord;
	}
	
	public HTMLBrowser searchWord(){
		return null;
	}

    public Execution(String palabraBuscada, Observer observer){
        this.HTMLInformation = "<html> Sin contenido. </html>";
        this.SearchWord = palabraBuscada;
        addObserver(observer);
    }
    
    public Execution(String pWord, Word HTML){
        this.SearchWord = pWord + "  From Hashtable"; 
        this.HTMLInformation = HTML.getHTTPGet(); 
        this.SearchingTime = HTML.getSearchingTime();
        this.Searched = HTML;
        this.Searched.InHash = true;
    }
    
    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg); 
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); 
    }
    
    @Override
    public void run() {
        HTMLBrowser WorkerHTML = new HTMLBrowser();
        try {
        	setInitialTime(System.currentTimeMillis());
        	HTMLInformation = WorkerHTML.getSearchResult(SearchWord);
    		setFinalTime(System.currentTimeMillis());
    		long Time = getFinalTime() - getInitialTime();
    		Searched = new Word(Long.toString(Time), HTMLInformation, SearchWord);
        } catch (Exception ex) {  
        	HTMLInformation = "<html> An error has ocurred charging the info. </html>";	
        }
        setChanged();
        notifyObservers(this);
    }
}

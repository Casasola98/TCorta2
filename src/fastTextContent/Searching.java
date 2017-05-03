package fastTextContent;

import java.util.Hashtable;

import java.util.Observable;
import java.util.Observer;

public class Searching implements Observer {
	
	private static Searching SingletonSearching = null;
	private static Hashtable<String, Word> SearchedWords = new Hashtable<String, Word>() ;
	
	private Searching(){
		
	}

    public static Searching getSingletonSearching(){
    	if (SingletonSearching == null)
    		SingletonSearching = new Searching();
        return SingletonSearching;
    }
	
    public boolean containsObject(String key) { 
    	return SearchedWords.containsKey(key); 
    }
    
    public void saveWord(String key, Word value){ 
    	SearchedWords.put(key, value);
    }
    
    public Word getValue(String key) { 
    	return SearchedWords.get(key); 
    }

    @Override
    public void update(Observable o, Object arg) {
        Execution ResultWord = (Execution) arg;
        if (! this.containsObject(ResultWord.getSearchWord()) ){
        	saveWord(ResultWord.getSearchWord(), ResultWord.getSearched());
        }
    }
    
}

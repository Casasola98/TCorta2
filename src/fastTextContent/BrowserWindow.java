package fastTextContent;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

public class BrowserWindow extends javax.swing.JDialog implements ComponentListener, Observer {
 
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private ArrayList<Word> BrowsingResult;
    private Set<String> BrowsedWord;
    
    BrowserWindow(){
    	BrowsingResult = new ArrayList<Word>();
    	BrowsedWord = new HashSet<>();
    }
 
    public void executeWords() throws Exception {
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 1000));
 
        jPanel1.setLayout(new java.awt.GridLayout(0, 640 / 120));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setViewportView(jPanel1);
        jScrollPane1.addComponentListener(this);
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
        
        
        for (Word Result : BrowsingResult){
        
        javax.swing.JLabel Information = new javax.swing.JLabel();	
        	
        if (Result.InHash){
        	Information = new javax.swing.JLabel("Search Time: " + Result.getSearchingTime() +  "\n  Word:" + Result.getSearchedWord() + "  from Hashtable");
        	Information.setPreferredSize(new Dimension(300, 200));
        }
        else if (! Result.InHash){
        	Information = new javax.swing.JLabel("Search Time: " + Result.getSearchingTime() +  "\n  Word:" + Result.getSearchedWord());
        	Information.setPreferredSize(new Dimension(300, 200));
        }
        
        
        Browser browser = new Browser();
        BrowserView htmlViewer = new BrowserView(browser);
        htmlViewer.setSize(new Dimension(400, 200));  
        browser.loadHTML(Result.getHTTPGet());
        
        
        JLabel HTTPShowing = new JLabel();
        HTTPShowing.add(htmlViewer);

        jPanel1.add(Information);
        jPanel1.add(HTTPShowing);
        }
       
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    @Override
    public void componentResized(ComponentEvent e) {
        if (e.getComponent().getWidth() > 300)
            ((java.awt.GridLayout)jPanel1.getLayout()).setColumns(
                    e.getComponent().getWidth() / 300);
        jPanel1.doLayout();
    }
 
    @Override
    public void componentMoved(ComponentEvent e) {
    }
 
    @Override
    public void componentShown(ComponentEvent e) {
    }
 
    @Override
    public void componentHidden(ComponentEvent e) {
    }
    
    
    @Override
    public void update(Observable o, Object arg) {        
        
        Execution Result = (Execution) arg;
        BrowsingResult.add(Result.getSearched());
        
        Searching CacheResult = Searching.getSingletonSearching();
        //CacheResult.toString();      
        
        if(BrowsedWord.size() == BrowsingResult.size()){
        	try {
				executeWords();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
    
    
    public void Browsing(String Words){
    	
        this.BrowsedWord = new HashSet<>();
        this.BrowsingResult = new ArrayList<>();
        if (!Words.equalsIgnoreCase("")){ 
            BrowsedWord = new HashSet<>(Arrays.asList(Words.split(" ")));
        }
        else {
            BrowsedWord = new HashSet<>();
        }
        BrowsedWord.forEach( (word) -> SearchingProcess(word) ); 
    }
    private void SearchingProcess(String pWord) {
        Searching CacheBrowsing = Searching.getSingletonSearching();
        if (CacheBrowsing.containsObject(pWord)){ 
            Word CacheResult = CacheBrowsing.getValue(pWord);
            update(null, new Execution( pWord, CacheResult));     
        } else {
            Execution getterThread = new Execution(pWord, this);
            getterThread.addObserver(CacheBrowsing);
            Thread BrowsingRun = new Thread(getterThread);
            BrowsingRun.start();
        }
    }
 
}
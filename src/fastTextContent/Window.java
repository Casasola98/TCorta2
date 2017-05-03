package fastTextContent;

import java.awt.event.ActionEvent;

public class Window extends javax.swing.JFrame {

		private javax.swing.JTextField Browse;
	    private javax.swing.JButton SearchButton;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JPanel jPanel1;   
	    
	    BrowserWindow Searches;
		
	    public Window() throws Exception {
	        initComponents();
	    }

	    @SuppressWarnings("unchecked")
	    
	    private void initComponents() {
	        jPanel1 = new javax.swing.JPanel();
	        jLabel1 = new javax.swing.JLabel();
	        Browse = new javax.swing.JTextField();
	        SearchButton = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setTitle("Fast Text Browser");
	        
	        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

	        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
	        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	        jLabel1.setText("BROWSER");

	        SearchButton.setText("Search");
	        SearchButton.addActionListener(new java.awt.event.ActionListener() {
	        	public void actionPerformed(ActionEvent evt) {
	            	try {
						SearchButtonActionPerformed(evt);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(134, 134, 134)
	                        .addComponent(jLabel1))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(53, 53, 53)
	                        .addComponent(Browse, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(156, 156, 156)
	                        .addComponent(SearchButton)))
	                .addContainerGap(68, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(43, 43, 43)
	                .addComponent(jLabel1)
	                .addGap(51, 51, 51)
	                .addComponent(Browse, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(57, 57, 57)
	                .addComponent(SearchButton)
	                .addContainerGap(62, Short.MAX_VALUE))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	    }

	    public static void main(String args[]) {
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
						new Window().setVisible(true);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });
	    }
	    
	    public String getBrowsingWords() { 
	    	return Browse.getText(); 
	    }
	    
	    
	    private void SearchButtonActionPerformed(ActionEvent evt) throws Exception {
	        BrowserWindow Searches = new BrowserWindow();
	    	Searches.Browsing(getBrowsingWords());
	    }
                               
	}


package grafik;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.awt.image.BufferedImage; 
import java.io.File; 
import java.io.IOException; 
import java.io.InputStream; 
import java.net.JarURLConnection; 
import java.net.URL; 

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Class extends JFrame implements ActionListener{
    
    static int START = 6;
    static ArrayList<Card>  allcardsoldstack = new ArrayList<Card>();
    static ArrayList<Card>  allcardsnewstack = new ArrayList<Card>();
    static JButton sort1 = new JButton(); 
    static JPanel deck = new JPanel();
    static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    static ClassLoader classLoader2 = Thread.currentThread().getContextClassLoader();
    
    
	public static void main(String[] args) throws IOException 
	{
	
		Card test = new Card(8);
        test.setDeckname("acht");
        allcardsoldstack.add(test);
        
        test = new Card(6);
        test.setDeckname("sechs");
        allcardsoldstack.add(test);
        
        test = new Card(9);
        test.setDeckname("neun");
        allcardsoldstack.add(test);
        
        test = new Card(7);
        test.setDeckname("sieben");
        allcardsoldstack.add(test);
        
        test = new Card(10);
        test.setDeckname("zehn");
        allcardsoldstack.add(test);
		
		
		Card rtest = new Card(2);
        rtest.setDeckname("ass");
      
        allcardsoldstack.add(rtest);
		new Class();
		paintCards();
	}
    public Class ()
    {
    	System.out.println("Working dir:  " + System.getProperty("user.dir"));
    	
       
    	
    	this.setTitle("Sort By Selection Example - Gard Game");
    	sort1.addActionListener(this);
    	deck.setLayout(null);
    	deck.setBackground(Color.GREEN);
    	int mx = 600;
    	int my =418;
        sort1.setBounds(mx,my,83,30);
        sort1.setText("Sort");
    	//System.out.println(my+mx);
    	this.getContentPane().add(deck);
    	this.setSize(1300, 930);
    	this.setLocation(10, 10);
    	this.setVisible(true);
    	deck.add(sort1);
    	
    
    	
    }
    public void actionPerformed (ActionEvent ae){
        
        if(ae.getSource() == this.sort1){
            System.out.println("Deck wird sortiert");    
            try {
				sortCards();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    private static void sortCards () throws IOException
    {
    	
    	
    	int next = 8;
    	
    	for (int g = 0 ; g < allcardsoldstack.size() ; g++)
    	{
    		Card current = allcardsoldstack.get(g);
    		int valuecurrent = current.getValue();
    		
    		if(current.getValue() < next) {
    			next = valuecurrent;
    			
    		}
    	}
    	
    	System.out.println("smallest card value: "+next);
    	for(int r = 0 ; r < 6 ; r++)
    	{
    		if(allcardsoldstack.get(r).getValue() == next)
    		{
    			Card c = allcardsoldstack.get(r);
    			allcardsnewstack.add(c);
    			allcardsoldstack.remove(r);
    			break;
    		}
    	}
    	paintSortedCards();
    }
    private static boolean paintCards() throws IOException
    {
    	
    	for(int j = 0 ; j< 6 ; j++) {
    	ImageIcon icBeispiel = new ImageIcon("./pictures/"+allcardsoldstack.get(j).getDeckname());
    	JLabel lbl = new JLabel(icBeispiel);
       
    	deck.add(lbl);
    	lbl.setBounds(30+(j*205), 30, 205, 455);
    	}
    	
    	
    	
    	
    	return true;
    
    
    }
    private static boolean paintSortedCards() throws IOException
    {
    	for(int i = 0 ; i < allcardsnewstack.size() ; i++)
    	{
    	ImageIcon icBeispiel = new ImageIcon("./pictures/"+allcardsnewstack.get(i).getDeckname());
    	JLabel lbl = new JLabel(icBeispiel);
     
    	deck.add(lbl);
    	lbl.setBounds(30+(i*205), 330, 205, 455);
    	
    	}
    	return true;
    }
}

package grafik;

public class Card 
{
	private int value;
	private String deckname;
	
    public Card(int valu)
    {
    	this.value = valu;
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDeckname() {
		return deckname;
	}

	public void setDeckname(String deckname) {
		this.deckname = deckname;
		// attach ending
		this.deckname = this.deckname  + ".png";
		
	}
	
	public void showInfo()
	{
		 System.out.println("new card created\nname: "+this.getDeckname()
		 +"\nvalue of card: "+this.value);
	}
}

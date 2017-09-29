/**
 * Created by 180553 on 9/19/2017.
 */
public class Card
{
    private int val;
    private char sut;
    public Card(int value,char suit)
    {
      val=value;
      sut=suit;
    }
    public Card(String val_Suit)
    {
        int num=-1;
        try
        {
            num=Integer.parseInt(val_Suit.substring(0,1));
        }
        catch (Exception e)
        {
            switch (val_Suit.substring(0,1))
            {
                case "T": num=10;break;
                case "A": num=14;break;
                case "Q": num=12;break;
                case "J": num=11;break;
                case "K": num=13;break;
            }
        }
        val=num;
        sut=val_Suit.charAt(1);
    }
    public int getVal(){ return val;}

    public char getSut(){ return sut;}

    public int compareTo(Card other){ return val-other.getVal();}
    
    public String toString(){return val+sut+"";}
}

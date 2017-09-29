/**
 * Created by 180553 on 9/19/2017.
 */
public class WarRunner
{
    public static void main(String[] args)
    {
        String[] cardsArray=Tools.FileToStringArray("Input.txt");
        ArrayQueue Player1;
        ArrayQueue Player2;
        ArrayQueue Table;
        for(int i=0;i<cardsArray.length;i+=2)
        {
            String[] tempCHolder=Tools.SeperateByDelim(cardsArray[i]," ");
            Player1= new ArrayQueue(Tools.SeperateByDelim(cardsArray[i]," ").length+Tools.SeperateByDelim(cardsArray[i]," ").length);
            Player2= new ArrayQueue(Tools.SeperateByDelim(cardsArray[i]," ").length+Tools.SeperateByDelim(cardsArray[i]," ").length);
            Table= new ArrayQueue(Tools.SeperateByDelim(cardsArray[i]," ").length+Tools.SeperateByDelim(cardsArray[i]," ").length);
            for(String c: tempCHolder)
                Player1.enqueue(new Card(c));
            tempCHolder=Tools.SeperateByDelim(cardsArray[i+1]," ");
            for(String c: tempCHolder)
                Player2.enqueue(new Card(c));
            int p1Score=0;
            int p2Score=0;
            for(int plays=0;plays<100000;plays++)
            {
               if(Player1.isEmpty() || Player2.isEmpty())
                  break;
                int comp=Player1.peek().compareTo(Player2.peek());
                Table.enqueue(Player1.dequeue());
                Table.enqueue(Player2.dequeue());
                if(comp==0)
                {
                  boolean war=true;
                  do
                  {
                     Table.enqueue(Player1.dequeue());
                     Table.enqueue(Player2.dequeue());
                     comp=Player1.peek().compareTo(Player2.peek());
                     Table.enqueue(Player1.dequeue());
                     Table.enqueue(Player2.dequeue());
                     if(comp!=0)
                        war=false;
                  }while(war);
                  
                }
                if(comp>0)
                {
                    p1Score++;
                    while(!Table.isEmpty())
                     Player1.enqueue(Table.dequeue());
                }
                else
                {
                    p2Score++;
                    while(!Table.isEmpty())
                     Player2.enqueue(Table.dequeue());
                }
            }
            if(Player1.isEmpty() || Player2.isEmpty())
                System.out.println("Player "+(Player1.isEmpty()?"2 ":"1 ")+" Wins!");
            else 
                System.out.println("Tie game stopped at 100000 plays.");
        }
    }
}

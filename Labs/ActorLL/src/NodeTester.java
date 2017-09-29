import java.util.Scanner;

/**
 * Created by 180553 on 9/27/2017.
 */
public class NodeTester
{
    public static void main(String[] args)
    {
        Actor head=null;
        Scanner keyboard;
        Actor current=null;
        keyboard = new Scanner(System.in);
        for(int i=0;i<5;i++)
        {
            Actor temp=new Actor(keyboard.next());
            temp.setNextPtr(head);
            head=temp;
        }
        current=head;
        while (current!=null)
        {
            System.out.println(current.toString());
            current=current.getNextPtr();
        }
    }

}

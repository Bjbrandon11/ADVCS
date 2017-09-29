/**
 * Created by 180553 on 9/27/2017.
 */
public class ActorLinkedList
{
    private Actor head;
    private int count;
    public  ActorLinkedList()
    {
        count=0;
        head=null;
    }
    public void add(Actor actor)
    {
        actor.setNextPtr(head);
        head=actor;
        count++;
    }
    public Actor get(int index)
    {
        Actor temp=head;
        for(int i=0;i<=index;i++)
        {
            temp=temp.getNextPtr();
        }
        return temp;
    }
    public int size(){return count;}
}

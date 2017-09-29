/**
 * Created by 180553 on 9/27/2017.
 */
public class Actor
{
    private Actor next;
    private String name=null;
    public Actor(){next=null;}
    public Actor(String name)
    {
        next=null;
        this.name=name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Actor getNextPtr()
    {
        return next;
    }

    public void setNextPtr(Actor next)
    {
        this.next = next;
    }

    @Override
    public String toString()
    {
        return name;
    }
}

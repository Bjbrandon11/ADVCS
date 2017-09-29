import java.util.Arrays;

/**
 * Created by 180553 on 9/7/2017.
 */
public class ArrayQueue
{
    int front;
    int back;
    int count;
    double[] que;
    public ArrayQueue(int size)
    {
        que = new double[size];
        front=0;
        back=0;
        count=0;
    }


    public void enqueue(double value)
    {
        /*if(front==0 && back==0)
        {
            que[back]=value;
            back++;
        }
        else*/ if(!isFull())
        {
            /*
            if(back+1>que.length-1)
                back=0;
            que[back]=value;
            back+=1;
            */
            que[back]=value;
            //if(size()+1<que.length)
                back=(back+1)%que.length;
            //count++;

        }

    }


    public double dequeue()
    {
        if(!isEmpty())
        {
            double num=que[front];
            //que[front+1]=0;   //for array.toString()
            front=(front+1)%que.length;
            //if(front>que.length-1)
              //  front=0;
            //count--;
            return num;
        }
        else
            return -1;
    }


    public double peek()
    {
        return que[front];
    }


    public int size()
    {
        if(front<=back)
            return back-front;
        return que.length-(front-back);
    }
    public int capacity(){return que.length;}

    public boolean isEmpty()
    {
        return size()!=0;
    }


    public boolean isFull()
    {
        return size()>=que.length;
    }


    public void clear()
    {
        front=0;
        back=0;
    }

    public String toString()
    {
        String ans="{";
        if(front<=back)
        {
            for (int i = 0; i < front - back; i++)
                ans += " " + que[front + i];
        }
        else
        {
            for(int i=front; i<que.length;i++)
                ans+=" "+ que[i];
            for(int i=0; i<back;i++)
                ans+=" "+que[i];
        }
        ans+=" }";
        return ans;
    }
}

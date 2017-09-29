/**
 * Created by 180553 on 9/11/2017.
 */
public class GuitarString
{
    ArrayQueue sound;
    int ticNum;
    public GuitarString(double freq)
    {
        sound=new ArrayQueue((int)(44100/freq));
        //for(int i=0;i<sound.capacity();i++)
          //  sound.enqueue(0);
    }
    public GuitarString(double[] init)
    {
        sound= new ArrayQueue(init.length);
        for(double num:init)
            sound.enqueue(num);
    }
    public void pluck()
    {
        int count=sound.que.length;
        sound.clear();
        for(int i=0; i<count;i++)
            sound.enqueue(Math.random()-.5);

    }
    public void tic()
    {
        double temp=sound.dequeue();
        sound.enqueue(.994*1/2*(temp+sound.peek()));
        ticNum++;
    }
    public double sample(){ return sound.peek();}
    public int Time(){return ticNum;}
}

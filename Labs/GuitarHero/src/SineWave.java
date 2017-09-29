/**
 * Created by 180553 on 9/15/2017.
 */
public class SineWave
{
    ArrayQueue sound;
    boolean play;
    int ticNum;
    double f;
    public SineWave(double freq)
    {
        sound=new ArrayQueue((int)(44100/freq));
        for(int i=0;i<sound.capacity();i++)
          sound.enqueue(Math.sin(freq*i)/2);
        f=freq;
        play=false;
    }

    public void pluck()
    {
        /*int count=sound.que.length;
        sound.clear();
        for(int i=0; i<count;i++)
            sound.enqueue(Math.random()-.5);*/
        play=true;

    }
    public void tic()
    {
        sound.enqueue(sound.dequeue());
        play=false;
    }
    public double sample(){ return play?sound.peek():0;}
    public int Time(){return ticNum;}
}

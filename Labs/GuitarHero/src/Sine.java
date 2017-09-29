import java.util.ArrayList;
import java.util.List;

/**
 * Created by 180553 on 9/15/2017.
 */
//String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
public class Sine
{
    public static void main(String[] args) {

        // Create two guitar strings, for concert A and C
        //double CONCERT_A = 440.0;
        //double CONCERT_C = CONCERT_A * Math.pow(2, 3.0/12.0);
        //GuitarString stringA = new GuitarString(CONCERT_A);
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        SineWave[] strings=new SineWave[keyboard.length()];
        for(int i=0;i<strings.length;i++)
        {
            strings[i]= new SineWave(Math.pow(2, i/12.0)*1/1);
        }

        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {

                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // pluck the corresponding string
                if(keyboard.indexOf(key)>=0)
                    strings[keyboard.indexOf(key)].pluck();

            }

            // compute the superposition of the samples
            double sample = 0;
            for(SineWave s:strings)
                sample+=s.sample();

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for(SineWave s:strings)
                s.tic();
        }
    }
}

/**
 * Created by 180553 on 8/31/2017.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tools
{
    public static String[] FileToStringArray(String address)
    {
        try
        {
            Scanner reader = new Scanner(new File(address+""));
            ArrayList<String> lines = new ArrayList<>();
            while (reader.hasNextLine())
            {
                lines.add(reader.nextLine());
            }
            String[] ans=new String[lines.size()];
            for(int i=0;i<lines.size();i++)
                ans[i]=lines.get(i);
            return ans;
        }
        catch(FileNotFoundException e)
        {
            System.out.println("No File");
            return null;
        }
    }
    public static String[] SeperateByDelim(String str, String delim)
    {
       
        {
            Scanner reader = new Scanner(str).useDelimiter(delim);
            ArrayList<String> lines = new ArrayList<>();
            while (reader.hasNext())
            {
                lines.add(reader.next());
            }
            String[] ans=new String[lines.size()];
            for(int i=0;i<lines.size();i++)
                ans[i]=lines.get(i);
            return ans;
        }
        
    }
}

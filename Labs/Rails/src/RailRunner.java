/**
 * Created by 180553 on 9/5/2017.
 */
public class RailRunner
{
    public static void main(String[] args)
    {
        String[] ex= Tools.FileToStringArray("src/Tests.txt");
        int place=0;
        int len=Integer.parseInt(ex[place].substring(0,ex[place].indexOf(" ")));
        place++;
        while(true)
        {
            if(len==0)
                break;
            int[] end=new int[len];
            int space=0;
            /*for(int i=0;i<ex[place].length();i++)
            {
               if(ex[place].indexOf(" ")!=-1)
               {
                  end[i] = Integer.parseInt(ex[place].substring(0,ex[place].indexOf(" ")));
                  ex[place]=ex[place].substring(ex[place].indexOf(" ")+1);
               }
            }*/
            String[] temp=Tools.SeperateByDelim(ex[place]," ");
            for(int i=0;i<len;i++)
            {
               end[i] = Integer.parseInt(temp[i]);
            }
            int cart=0;
            ArrayStack mid=new ArrayStack(len);

            for(int i=1; i<=len;i++)
            {
                if(!mid.isEmpty() && mid.peek()==end[cart])
                {
                    mid.pop();
                    cart++;
                }
                mid.push(i);
                if(!mid.isEmpty() && mid.peek()==end[cart])
                {
                    mid.pop();
                    cart++;
                }
            }
            if(!mid.isEmpty())
            for(int i=cart; i< end.length ; i++)
            if(!mid.isEmpty() && mid.peek()==end[i])
            {
                mid.pop();
                cart++;
            }
            else break;
            System.out.println(mid.isEmpty()?"Yes":"No");
            place++;
            temp=Tools.SeperateByDelim(ex[place]," ");
            if(temp.length==1 && temp[0].equals("0"))
            {
                len = Integer.parseInt(Tools.SeperateByDelim(ex[place+1]," ")[0]);
                place+=2;
                System.out.println();
               
            }
            if(len==0)
               break;
        }
    }
}

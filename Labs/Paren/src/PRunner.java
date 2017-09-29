/**
 * Created by 180553 on 8/31/2017.
 */
public class PRunner
{
    public static void main(String[] args)
    {
        for(String line: Tools.FileToStringArray("src/List.txt"))
        {
            ArrayStack stack = new ArrayStack(line.length());
            boolean even=true;
            int tms=0;
            for(char place : line.toCharArray())
            {
                tms++;
                if(stack.isEmpty())
                {
                    stack.push(place);
                }
                else
                {
                    switch(place)
                    {
                        case '(' : stack.push(place); break;
                        case ')' : if(stack.peek()=='(') stack.pop(); else even=false; break;
                        case ']' : if(stack.peek()=='[') stack.pop(); else even=false; break;
                        case '[' : stack.push(place); break;
                    }
                }

                if(!even)
                    break;
            }
            if(!stack.isEmpty())
                even=false;
            System.out.println(even?"Yes":"No");
        }
    }
}

import java.util.Arrays;

/**
 * Created by 180553 on 8/21/2017.
 */
public class ArrayStack implements IStack
{
    //place new on top
    //aka 0
    int top;
    char[] stack;
    public ArrayStack(int size)
    {
        stack = new char[size];
        top=-1;
    }

    @Override
    public void push(char value)
    {
        if(!isFull())
        {
            top+=1;
            stack[top]=value;
        }

    }

    @Override
    public char pop()
    {
        if(!isEmpty())
        {
            top-=1;
            char num=stack[top+1];
            stack[top+1]=0;   //for array.toString()
            return num;
        }
        else
            return ' ';
    }

    @Override
    public char peek()
    {
        return stack[top];
    }

    @Override
    public int size()
    {
        return top+1;
    }

    @Override
    public boolean isEmpty()
    {
        return top<0;
    }

    @Override
    public boolean isFull()
    {
        return top==stack.length-1;
    }

    @Override
    public void clear()
    {
        top=-1;
        stack=new char[10];
    }

    public String toString()
    {
        return Arrays.toString(stack);
    }
}

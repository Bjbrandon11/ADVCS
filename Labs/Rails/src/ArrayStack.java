import java.util.Arrays;

/**
 * Created by 180553 on 8/21/2017.
 */
public class ArrayStack implements IStack
{
    //place new on top
    //aka 0
    int top;
    int[] stack;
    public ArrayStack(int size)
    {
        stack = new int[size];
        top=-1;
    }

    @Override
    public void push(int value)
    {
        if(!isFull())
        {
            top+=1;
            stack[top]=value;
        }

    }

    @Override
    public int pop()
    {
        if(!isEmpty())
        {
            top-=1;
            int num=stack[top+1];
            stack[top+1]=0;   //for array.toString()
            return num;
        }
        else
            return -1;
    }

    @Override
    public int peek()
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
        stack=new int[10];
    }

    public String toString()
    {
        return Arrays.toString(stack);
    }
}

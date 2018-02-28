import java.util.*;
public class ThreeStacks {
    int[] arr;
    int capacity;
    int[] top;
    public ThreeStacks(int capacity){
        this.capacity = capacity;
        arr = new int[3*capacity];
        top = new int[3];
    }

    public void push(int stacknumber, int value) throws Exception{
        if(isFull(stacknumber)) throw new Exception("Stack is full");
        top[stacknumber]++;
        arr[indexOf(stacknumber)] = value;
    }

    public int pop(int stacknumber) throws Exception{
        if(isEmpty(stacknumber)) throw new Exception("Stack is empty");
        int topIndex = indexOf(stacknumber);
        int ret = arr[topIndex];
        arr[topIndex] = 0;
        top[stacknumber]--;
        return ret;
    }

    public boolean isEmpty(int number){
        return (top[number]==0);
    }

    public boolean isFull(int number){
        return (top[number]==capacity);
    }

    public int indexOf(int number){
        int offset = number*capacity;
        int tops = top[number];
        return offset+tops-1;
    }
}

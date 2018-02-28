//Follow up still to do
//Pop(int x) 

import java.util.*;
public class StackOfPlates {

    List<Stack> list;
    int capacity;
    public StackOfPlates(int capacity){
        this.capacity = capacity;
        list = new ArrayList();
    }

    public void push(int x){
        Stack<Integer> last = getLastStack();
        if(last!=null && !(last.size()==capacity)) last.push(x);
        else{
            Stack<Integer> stack = new Stack();
            stack.push(x);
            list.add(stack);
        }
    }

    public int pop(){
        Stack<Integer> last = getLastStack();
        if(last==null) throw new EmptyStackException();
        int ret = last.pop();
        if(last.isEmpty()) list.remove(list.size()-1);
        return ret;
    }

    //Returns the newest stack in the set of stacks
    public Stack getLastStack(){
        if(list.size()==0) return null;
        return list.get(list.size()-1);
    }


    //Expected output: 1,2,3 if capacity =2
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the capacity of each set");
        int capacity = in.nextInt();
        StackOfPlates s = new StackOfPlates(capacity);
        s.push(1);
        s.push(2);
        System.out.println(s.list.size());
        s.push(3);
        System.out.println(s.list.size());
        System.out.println(s.pop());
    }
}

import java.util.ArrayList;
import java.util.List;

public class Stack {
    
    public List<Integer> list = new ArrayList<>();
    
    private int top = -1 ;

    public Integer get(){
        int value = list.get(top);
        top--;
        return value;
    }

    public void put(Integer value){
        top++;
        list.add(value);
    }

    public Integer peek(){
        return list.get(top);
    }

    public boolean isEmpty(){
        if(top > -1)
            return true;
        else
            return false;
    }


    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.put(5);
        stack.put(9);
        stack.put(3);
        stack.put(10);
        stack.put(7);

        while (stack.isEmpty()) {
            System.out.println(stack.get());
        }

        System.out.println("done");
    }

}
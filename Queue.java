import java.util.ArrayList;
import java.util.List;

public class Queue {
    
    private List<Integer> list = new ArrayList();
    
    private int end = 0 ;
    private int start = 0;

    public Integer get(){
        int value = list.get(start);
        start++;
        return value;
    }

    public void put(Integer value){
        end++;
        list.add(value);
    }

    public Integer peek(){
        return list.get(start);
    }

    public boolean isEmpty(){
        if(start >= end)
            return true;
        else
            return false;
    }


    public static void main(String[] args) {
        Queue queue = new Queue();

        // test-case 
        queue.put(5);
        queue.put(9);
        queue.put(3);
        queue.put(10);
        queue.put(7);

        while (!queue.isEmpty()) {
            System.out.println(queue.get());
        }

        System.out.println("done");
    }

}
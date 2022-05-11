import java.util.ArrayList;

public class ArrayStack implements IStackable{

    ArrayList<Integer> list = new ArrayList<Integer>(); 

    public int size(){
        return list.size();
    }

    public void push(int v){
        list.add(0, v);
    }

    public int pop(){
    
        int v = list.get(0); 
        list.remove(0); 
      
        return v;
    }
    
    
}
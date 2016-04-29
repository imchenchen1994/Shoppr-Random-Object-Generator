package RandomObjects;

import java.io.Serializable;
import java.util.ArrayList;

public class RandomObjects implements Serializable{
    private ArrayList<Character> arr ;
    private int size;
    private int type;
    private String ans  = new String();
    
    public RandomObjects(ArrayList<Character> arr, int type){
        this.arr = arr;
        this.size = arr.size();
        this.type = type;
    }
    
    public ArrayList<Character>  getArr() {
        return arr;
    }

    public int getSize() {
        return size;
    }
    
    public int getType() {
        return type;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public void setArr(ArrayList<Character> arr) {
        this.arr = arr;

    }

    public void setType(int type) {
        this.type = type;
    }
    
    public String toString(boolean last){
        this.ans = new String();
        for(int i=0;i<this.getArr().size();i++){
            this.ans += (char)this.getArr().get(i); 
        }

        if(!last){
            this.ans += ", ";
        }
        return ans;
    }
}

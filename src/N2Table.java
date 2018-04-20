import java.util.ArrayList;

public class N2Table {
    int[] table;
    boolean[] busy;
    int size;

    public N2Table(int size) {
        this.size = size;
        table = new int[size];
        busy = new boolean[size];
    }

    public boolean insert(int index, int key){
        if(!isBusy(index)){
            table[index] = key;
            busy[index] = true;
            return true;
        }
        else return false;
    }

    public boolean isBusy(int index){
        return busy[index];
    }

    public ArrayList<Integer> getAllInsertedKeys(){
        ArrayList<Integer> keys = new ArrayList<>();

        for(int i=0; i<size; i++){
            if(isBusy(i))
                keys.add(table[i]);
        }

        return keys;
    }

    public void clear(){
        table = new int[size];
        busy = new boolean[size];
    }

    public int getKey(int index){
        return table[index];
    }
}

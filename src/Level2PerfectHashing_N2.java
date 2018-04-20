import java.util.ArrayList;

public class Level2PerfectHashing_N2 extends PerfectHashing_N2 {
    public Level2PerfectHashing_N2(int N) {
        super(N);
        table = new Level2N2Table(N);
        initUniversalHashing(N);
    }

    @Override
    public boolean insert(int key) {
        //System.out.println("hereeeeeeeeeeeeee");
        int h_x = universalHashing.hash(key);

        // if duplicated, ignore
        if(table.isBusy(h_x) && table.getKey(h_x) == key)
            return false;

        if(!table.isBusy(h_x)){
            table.insert(h_x, key);
            return true;
        }
        else{ // collision
            universalHashing.constructMatrixH();
            ArrayList<Integer> keys = table.getAllInsertedKeys();
            keys.add(key);
            ((Level2N2Table) table).clear();
            //System.out.println("table size: " + table.size);
            initUniversalHashing(table.size);
            for(Integer aKey : keys){
                insert(aKey);
            }
        }
        return false;
    }

    public Level2N2Table getTable(){
        return (Level2N2Table) table;
    }
}

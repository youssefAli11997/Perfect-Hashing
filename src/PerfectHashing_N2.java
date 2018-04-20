import java.util.ArrayList;

public class PerfectHashing_N2 implements IPerfectHashing {

    N2Table table;
    IUniversalHashing universalHashing;

    public PerfectHashing_N2(int N){
        table = new N2Table(N*N);
        initUniversalHashing(N*N);
    }

    @Override
    public boolean insert(int key) {
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
            table.clear();
            for(Integer aKey : keys){
                insert(aKey);
            }
        }
        return false;
    }

    @Override
    public boolean search(int key) {
        return table.isBusy(universalHashing.hash(key));
    }


    void initUniversalHashing(int M) {
        int b = (int)(Math.log10(M) / Math.log10(2));
        int u = 32; //(int)(Math.log10(N) / Math.log10(2)) + 2;
        universalHashing = new UniversalHashing(u, b);
    }
}

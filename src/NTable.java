public class NTable {

    Level2PerfectHashing_N2[] table;
    int size;

    public NTable(int size) {
        this.size = size;
        table = new Level2PerfectHashing_N2[size];
        for(int i=0; i<size; i++){
            table[i] = new Level2PerfectHashing_N2(1);
        }
    }

    public boolean insert(int indexLvl1, int key){
        return table[indexLvl1].insert(key);
    }

    public boolean search(int indexLvl1, int key){
        return table[indexLvl1].search(key);
    }
}

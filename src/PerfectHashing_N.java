public class PerfectHashing_N implements IPerfectHashing {

    private NTable table;
    private IUniversalHashing universalHashing;

    public PerfectHashing_N(int N){
        table = new NTable(N);
        initUniversalHashing(N);
    }

    @Override
    public boolean insert(int key) {
        int h_x = universalHashing.hash(key);

        return table.insert(h_x, key);
    }

    @Override
    public boolean search(int key) {
        int h_x = universalHashing.hash(key);

        return table.search(h_x, key);
    }

    private void initUniversalHashing(int M) {
        int b = (int)(Math.log10(M) / Math.log10(2));
        int u = 32; //(int)(Math.log10(N) / Math.log10(2)) + 2;
        universalHashing = new UniversalHashing(u, b);
    }

    public void printTable(){
        System.out.println("****************************");
        int i=0;
        for(IPerfectHashing hashing : table.table){
            System.out.print(i + ": ");
            i++;
            // print 2nd level table.
            for(int key : ((Level2PerfectHashing_N2)hashing).getTable().table){
                System.out.print(key + ", ");
            }
            System.out.println();
        }
        System.out.println("****************************");
    }
}

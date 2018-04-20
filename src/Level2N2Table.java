public class Level2N2Table extends N2Table {
    public Level2N2Table(int size) {
        super(size);
    }

    @Override
    public void clear(){
        this.size += 1;
        this.table = new int[this.size];
        this.busy = new boolean[this.size];
    }
}

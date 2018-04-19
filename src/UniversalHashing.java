import java.util.Random;

public class UniversalHashing implements IUniversalHashing {

    private byte[][] H;
    private int rows;
    private int cols;

    public UniversalHashing(int u, int b){ //  assuming u-bit keys and b-bit indices
        this.rows = b;
        this.cols = u;
        this.H = new byte[this.rows][this.cols];
        constructMatrixH();
    }

    @Override
    public int hash(int key) {
        byte[][] X = getMatrixX(key);
        return get_integer_h_x(X);
    }

    private void constructMatrixH() {
        Random rand = new Random();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                H[i][j] = (byte)rand.nextInt(2);
                System.out.print(H[i][j]);
            }
            System.out.println();
        }
        System.out.println("---- H is done ----");
    }

    private byte[][] getMatrixX(int key) {
        byte[][] X = new byte[cols][1];

        for(int i=0; i<cols; i++){
            X[i][0] = (byte) (key % 2);
            key /= 2;
            System.out.println(X[i][0]);
        }
        System.out.println("---- X is done ----");

        return X;
    }

    private int get_integer_h_x(byte[][] X){
        byte[][] h_x = matrixMultiply(X);
        int value = 0;

        for(int i=0; i<rows; i++){
            value += h_x[i][0] * Math.pow(2, i);
        }
        System.out.println("value of h(x) = " + value);

        return value;
    }

    private byte[][] matrixMultiply(byte[][] X){
        byte[][] h_x = new byte[rows][1];

        for(int i=0; i<rows; i++){
            h_x[i][0] = 0;
            for(int j=0; j<cols; j++){
                h_x[i][0] += (H[i][j] * X[j][0]) % 2;
            }
            h_x[i][0] %= 2;
            System.out.println(h_x[i][0]);
        }
        System.out.println("---- h_x is done ----");

        return h_x;
    }
}

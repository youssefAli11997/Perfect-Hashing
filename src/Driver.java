public class Driver {

    public static void main(String[] args){
        IUniversalHashing hashing = new UniversalHashing(4, 3);
        hashing.hash(5);
    }
}

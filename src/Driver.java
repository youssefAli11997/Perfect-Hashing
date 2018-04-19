public class Driver {

    public static void main(String[] args){
        /*IUniversalHashing hashing = new UniversalHashing(4, 3);
        hashing.hash(5);*/

        IPerfectHashing hashing = new PerfectHashing_N2(5);
        System.out.println(hashing.insert(4));
        System.out.println(hashing.insert(32));
        System.out.println(hashing.insert(4));
        System.out.println(hashing.search(4));
    }
}

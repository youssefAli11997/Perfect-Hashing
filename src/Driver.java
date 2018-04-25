import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args){
        /*IUniversalHashing hashing = new UniversalHashing(4, 3);
        hashing.hash(5);*/

        try {
            Scanner in = new Scanner(new File("test_input/keys10001000.txt"));

            //ArrayList<Integer> keys = new ArrayList<>();

            String[] keys = new String[5];

            while(in.hasNext()){
                String s = in.nextLine();
                keys = s.split(",");
            }

            IPerfectHashing hashing = new PerfectHashing_N2(keys.length);

            //int i=0;

            for(String key : keys){
                /*if(i < 1000)
                    System.out.println(hashing.insert(Integer.parseInt(key)));
                else*/
                    hashing.insert(Integer.parseInt(key));
                //i++;
            }

            if(hashing instanceof PerfectHashing_N) {
                ((PerfectHashing_N) hashing).printTable();
            }

            if(hashing instanceof PerfectHashing_N2){
                System.out.println("rebuilds: "+((PerfectHashing_N2) hashing).getRebuildsCount());
            }


            /*System.out.println(hashing.insert(4));
            System.out.println(hashing.insert(32));
            System.out.println(hashing.insert(4));
            System.out.println(hashing.search(4));*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

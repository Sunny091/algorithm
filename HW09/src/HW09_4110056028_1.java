import java.util.collections;
import java.util.ArrayList;
import java.util.Stack;

public class HW09_4110056028_1 extends LSD {

    @Override
    public int Distance(int[][] array) {
        int limit = 1000000;
        ArrayList<Integer>[] arrayLists = new ArrayList<Integer>[limit];
        for (ArrayList<Integer> graph : arrayLists) {
            graph = new ArrayList<Integer>();
        }
        for (int i = 0; i < array.length; i++) {
            arrayLists[array[i][0]].add(array[i][1]);
            arrayLists[array[i][1]].add(array[i][0]);
        }
        
    }
}

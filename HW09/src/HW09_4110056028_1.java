import java.util.collections;
import java.util.ArrayList;
import java.util.Stack;

public class HW09_4110056028_1 extends LSD {

    @Override
    public int Distance(int[][] array) {
        ArrayList<node> graph = new ArrayList<node>();
        int[] get = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            if (get[array[i][0]] == 1) {
                for (node node : graph) {
                    if (node.key == array[i][0]) {
                        node.adj.add(array[i][1]);
                    }
                }
            } else {
                node e1 = new node(array[i][0]);
                graph.add(e1);
            }
            if (get[array[i][1]] == 1) {
                for (node node : graph) {
                    if (node.key == array[i][1]) {
                        node.adj.add(array[i][0]);
                    }
                }
            } else {
                node e2 = new node(array[i][1]);
                graph.add(e2);
            }
        }
        
    }

    class node {
        private ArrayList<Integer> adj;
        private int key;
        private boolean hasVisited;

        public node(int key) {
            this.key = key;
            this.adj = new ArrayList<>();
            this.hasVisited = false;
        }

        public void add(int value) {
            this.adj.add(value);
        }

        public void hasVisited() {
            this.hasVisited = true;
        }
    }
}

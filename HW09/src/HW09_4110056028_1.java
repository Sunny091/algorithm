import java.util.collections;
import java.util.ArrayList;
import java.util.Stack;

public class HW09_4110056028_1 extends LSD {

    private int distance;

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
        node temp = bfs(graph.get(0), graph);
        for (node node : graph) {
            node.hasVisited = false;
        }
        temp = bfs(temp, graph);
        return distance;
    }

    private node bfs(node start, ArrayList<node> graph) {
        int stackIndex = 0;
        Stack<node> stack = new Stack<node>();
        start.hasVisited = true;
        stack.add(start);
        while (stackIndex < stack.size() - 1) {
            for (node node : stack) {
                for (int adj : node.adj) {
                    stack.push(adj);
                }
            }
        }
    }

    class node {
        private ArrayList<Integer> adj; 
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

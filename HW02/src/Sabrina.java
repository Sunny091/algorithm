public class Sabrina {
    // Online Java Compiler
    // Use this editor to write, compile and run your Java code online

    // Online Java Compiler
    // Use this editor to write, compile and run your Java code online

    class Main {
        public static void main(String[] args) {
            int[] nums = { -6, -5, -4, -1, 0, 1, 2, 3, 5, 6 };
            System.out.println(solve(nums));
        }

        private final static int MAX = 10005;

        private final static int getHash(final int key) {
            return key + MAX;
        }

        private static int solve(int[] nums) {
            final int n = nums.length;
            Queue[] count = new Queue[MAX << 1];
            for (int i = 0; i < (MAX << 1); i++) {
                count[i] = new Queue();
            }
            for (int i = 2; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    count[getHash(nums[i] + nums[j])].push(i);
                }
            }
            int result = 0;
            for (int j = 1; j < n - 2; j++) {
                for (int i = 0; i < j; i++) {
                    Queue T = count[getHash(-(nums[i] + nums[j]))];
                    while (T.size() > 0 && T.getFirst() <= j) {
                        T.pop();
                    }
                    result += T.size();
                }
            }
            return result;
        }

        private static class Queue {
            private Node head;
            private Node tail;
            private int __size;

            Queue() {
                this.__size = 0;
                this.head = null;
                this.tail = null;
            }

            private static class Node {
                public int index;
                public Node next;

                Node(int idx) {
                    this.index = idx;
                    this.next = null;
                }
            }

            public final int size() {
                return __size;
            }

            public final int getFirst() {
                return head.index;
            }

            public void push(int index) {
                Node node = new Node(index);
                __size++;
                if (head == null) {
                    head = tail = node;
                    return;
                }
                tail.next = node;
                tail = node;
            }

            public void pop() {
                __size--;
                head = head.next;
            }
        }
    }

}

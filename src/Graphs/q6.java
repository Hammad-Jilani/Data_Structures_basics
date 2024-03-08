package Graphs;

public class q6 {
    static class Node {
        int row;
        int col;
        Node next;
        Node(int row, int col) {
            this.row = row;
            this.col = col;
            this.next = null;
        }
    }

    static class Linkedlist {
        Node head;
        public Linkedlist() {
            this.head = null;
        }
        void insert(int row, int col) {
            Node node = new Node(row, col);
            if (head == null) {
                head = node;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = node;
            }
        }
        Node delete() {
            if (head == null) {
                return null;
            }
            Node temp = head;
            head = head.next;
            return temp;
        }
        boolean Empty() {
            return head == null;
        }
    }
    private static int islands(int[][] matrix) {
        if (matrix == null||matrix.length == 0||matrix[0].length==0) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int count = 0;
        Linkedlist list = new Linkedlist();
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    list.insert(i, j);
                    matrix[i][j] = 0; // Mark as visited
                    while (!list.Empty()) {
                        Node current = list.delete();
                        for (int k = 0; k < 8; k++) {
                            int nr = current.row + dr[k];
                            int nc = current.col + dc[k];
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < columns &&
                                    matrix[nr][nc] == 1) {
                                list.insert(nr, nc);
                                matrix[nr][nc] = 0;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] matrix = {{0, 1}, {1, 0}, {1, 1}, {1, 0}};
        int number = islands(matrix);
        System.out.println(number);
    }
}

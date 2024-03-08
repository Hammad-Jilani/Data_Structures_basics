package Graphs;


public class task6 {
    static class Node {
        int row;
        int column;
        Node next;
        Node(int row, int column) {
            this.row = row;
            this.column = column;
            this.next = null;
        }
    }
    static class LinkedList {
        Node head;
        int size=0;
        public LinkedList() {
            this.head = null;
        }
        void insert(int row, int col) {
            Node node = new Node(row, col);
            if (head == null) {
                head = node;
                size++;
//            node.next = head;
//            head=node;
//            size++;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = node;
                size++;
            }
        }
        Node delete() {
//            Node temp = head;
//            for (int i = 0; i < index; i++) {
//                temp = temp.next;
//            }
//            return temp;
            if (head == null) {
                size--;
                return null;
            }
            Node temp = head;
            head = head.next;
            size--;
            return temp;
        }
        boolean isEmpty() {
            return size==0;
        }
    }

    private static int islands(int[][] grid) {
        if (grid == null||grid.length == 0||grid[0].length==0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        LinkedList list = new LinkedList();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    list.insert(i, j);
                    grid[i][j] = 0;
                    while (!list.isEmpty()) {
                        Node current = list.delete();
                        for (int r = -1; r <= 1; r++) {
                            for (int c = -1; c <= 1; c++) {
                                if (r == 0 && c == 0) {
                                    continue;
//                                    break;
                                }
                                int nr = current.row + r;
                                int nc = current.column + c;
                                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                                        grid[nr][nc] == 1) {
                                    list.insert(nr, nc);
                                    grid[nr][nc] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}, {1, 1}, {1, 0}};
        int number = islands(grid);
        System.out.println(number);
    }
}
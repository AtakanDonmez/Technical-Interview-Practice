package Ch08_Recursion_and_Dynamic_Programming;

import CtCILibrary.AssortedMethods;

import java.util.ArrayList;

public class Q02_RobotGrid {
    public enum Arrived {LEFT, TOP, UNREACHABLE, START}
    static class Point {
        public int row, column;
        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public String toString() {
            return "(" + row + ", " + column + ")";
        }

        @Override
        public int hashCode() {
            return this.toString().hashCode();
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof Point) && (((Point) o).row == this.row) && (((Point) o).column == this.column);
        }
    }

    public static ArrayList<Point> getPath(boolean[][] maze) {
        int rows = maze.length;
        int columns = maze[0].length;
        Arrived[][] solution = new Arrived[rows][columns];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++) {
                if (i == 0 && j == 0){
                    solution[i][j] = Arrived.START;
                    continue;
                }
                if (maze[i][j]){
                    if ( j > 0 && solution[i][j-1] != Arrived.UNREACHABLE){
                        solution[i][j] = Arrived.LEFT;
                    } else if ( i > 0 && solution[i-1][j] != Arrived.UNREACHABLE){
                        solution[i][j] = Arrived.TOP;
                    } else {
                        solution[i][j] = Arrived.UNREACHABLE;
                    }
                } else {
                    solution[i][j] = Arrived.UNREACHABLE;
                }
            }
        }

        if (solution[rows-1][columns-1] == Arrived.UNREACHABLE){
            return null;
        }

        ArrayList<Point> path = new ArrayList<>();
        Point cur = new Point(rows-1, columns-1);
        path.add(0, cur);
        Point start = new Point(0,0);
        while (!cur.equals(start)){
            int row = cur.row;
            int col = cur.column;
            if (solution[row][col] == Arrived.LEFT){
                col--;
            } else {
                row--;
            }
            cur = new Point(row, col);
            path.add(0, cur);
        }

        return path;
    }

    public static void main(String[] args) {
        int size = 20;
        boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 70);

        AssortedMethods.printMatrix(maze);

        ArrayList<Point> path = getPath(maze);
        if (path != null) {
            System.out.println("\n" + path);
        } else {
            System.out.println("No path found.");
        }
    }

}

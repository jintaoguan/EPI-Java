// Problem 6.16
// Implement a routine that takes a n*m Boolean array A together with
// an entry (x,y) and flips the color of the region assiciated with (x,y).

import java.util.ArrayList;

public class problem_06_16 {

    public void flip_color(boolean[][] matrix, int x, int y) {
        int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        boolean color = matrix[x][y];
        flip_color(matrix, dir, x, y, visited, color );
    }

    public void flip_color(boolean[][] matrix, int[][] dir, int x, int y, boolean[][] visited, boolean orig) {
        matrix[x][y] = !orig;
        visited[x][y] = true;
        for( int i = 0; i < 4; ++i ) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if( nx < 0 || nx >= matrix.length )
                continue;
            if( ny < 0 || ny >= matrix[0].length )
                continue;
            if( matrix[nx][ny] == !orig )
                continue;
            if( visited[nx][ny] == true )
                continue;
            flip_color( matrix, dir, nx, ny, visited, orig );
        }
    }

    public static void main(String[] argv) {
        problem_06_16 solutions = new problem_06_16();
        boolean[][] map = new boolean[][]{
            {true, false, true, false},
            {true, false, false, false},
            {true, true, true, false},
            {true, false, true, false},
        };
        solutions.flip_color(map, 0, 0);

        for( int i = 0; i < 4; ++i ) {
            for( int j = 0; j < 4; ++j )
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
        solutions.flip_color(map, 0, 0);

        for( int i = 0; i < 4; ++i ) {
            for( int j = 0; j < 4; ++j )
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

}

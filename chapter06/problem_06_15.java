// Problem 6.15
// Implement a function which takes a 2D array A ad prints A in spiral order.

import java.util.ArrayList;

public class problem_06_15 {
   
    public void print_matrix_in_spiral_order(int[][] A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[A.length][A[0].length];
        print_matrix_in_spiral_order( A, dir, 0, 0, 0, visited, ans );
        for( Integer num : ans ) {
            System.out.print( num + " " );
        }
    }

    public void print_matrix_in_spiral_order(int[][] A, int[][] dir, int x, int y,
            int cur_dir, boolean[][] visited, ArrayList<Integer> ans) {
        if( ans.size() >= A.length * A[0].length )
            return;
        ans.add(A[x][y]);
        visited[x][y] = true;
        int nx = x + dir[cur_dir][0];
        int ny = y + dir[cur_dir][1];
        if( nx >= 0 && nx < A.length && ny >= 0 && ny < A[0].length && visited[nx][ny] == false ) {
            print_matrix_in_spiral_order( A, dir, nx, ny, cur_dir, visited, ans );
        }
        else {
            cur_dir = ( cur_dir + 1 ) % 4;
            nx = x + dir[cur_dir][0];
            ny = y + dir[cur_dir][1];
            print_matrix_in_spiral_order( A, dir, nx, ny, cur_dir, visited, ans );
        }
    }

    public static void main(String[] argv) {
        problem_06_15 solutions = new problem_06_15();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        for( int i = 0; i < 3; ++i )  {
            for( int j = 0; j < 3; ++j )
                System.out.print(matrix[i][j] + " " );
            System.out.println();
        }
        solutions.print_matrix_in_spiral_order(matrix);
    }

}

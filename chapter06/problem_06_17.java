// Problem 6.17
// Design an algorithm that rotate a n*n 2D array by 90 degrees clock-wise.
// Assume that n = 2^k for some positive integer k. What is the time complexity
// of your algorithm?

public class problem_06_17 {

    // 1.iterative solution
    public void rotate_matrix(int[][] A) {
        for( int i = 0; i < A.length / 2; ++i ) {
            for( int j = i; j < A.length - i - 1; ++j ) {
                int tmp = A[i][j];
                A[i][j] = A[A.length-1-j][i];
                A[A.length-1-j][i] = A[A.length-1-i][A.length-1-j];
                A[A.length-1-i][A.length-1-j] = A[j][A.length-1-i];
                A[j][A.length-1-i] = tmp;
            }
        }
    }

    // TODO 2.recursive solution 
    public void rotate_matrix2(int[][] A) {
        rotate_matrix_helper(A, 0, A.length, 0, A.length);
    }

    public void rotate_matrix_helper(int[][] A, int xs, int xe, int ys, int ye) {
    }

    public static void main(String[] argv) {
        problem_06_17 solutions = new problem_06_17();
        int[][] matrix = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        solutions.rotate_matrix(matrix);
        for( int i = 0; i < matrix.length; ++i ) {
            for( int j = 0; j < matrix[0].length; ++j ) {
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
   }

}

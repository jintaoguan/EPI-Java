// Problem 6.14
// Check whether a 9*9 2D array representing a partially completed
// Sudoku is valid. Specially, check that no row, column, and 3*3 2D subarray
// contains duplicates. A 0-value in the 2D array indicates that entry is blank;
// every other entry is in [1,9].

public class problem_06_14 {

    public boolean is_valid_sudoku(int[][] A) {
        // check the rows
        for( int i = 0; i < A.length; ++i ) {
            boolean is_present[] = new boolean[A.length+1];
            for( int j = 0; j < A.length; ++j ) {
                if( A[i][j] != 0 && is_present[A[i][j]] == true )
                    return false;
                else
                    is_present[A[i][j]] = true;
            }
        }

        // check the columns
        for( int j = 0; j < A.length; ++j ) {
            boolean is_present[] = new boolean[A.length+1];
            for( int i = 0; i < A.length; ++i ) {
                if( A[i][j] != 0 && is_present[A[i][j]] == true )
                    return false;
                else
                    is_present[A[i][j]] = true;
            }
        }

        // check small boxes
        int region_size = (int)Math.sqrt((double)A.length);
        for( int I = 0; I < region_size; ++I ) {
            for( int J = 0; J < region_size; ++J ) {
                boolean is_present[] = new boolean[A.length+1];
                for( int i = 0; i < region_size; ++i ) {
                    for( int j = 0; j < region_size; ++j ) {
                        if( A[region_size*I+i][region_size*J+j] != 0 &&
                                is_present[A[region_size*I+i][region_size*J+j]])
                            return false;
                        else
                            is_present[A[region_size*I+i][region_size*J+j]] = true;
                    }
                }
            }
        }
        return false;
    }
    
    public static void main(String[] argv) {
        problem_06_14 solutions = new problem_06_14();
    }
}

// Problem 6.12
// Given a permutation p represented as a vector, return the vector
// corresponding to the previous permutation of p under lexicographic ordering.

public class problem_06_12 {
    
    public void next_permutation(int[] num) {
        int len = num.length;
        int i = len - 2;
        while( i >= 0 && num[i] >= num[i+1] )
            --i;
        if( i < 0 )
            return;
        int j = len - 1;
        while( num[j] <= num[i] )
            --j;
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
        i++;
        j = len - 1;
        while( i < j ) {
            tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            ++i;
            --j;
        }
    }

    public static void main(String[] argv) {
        problem_06_12 solutions = new problem_06_12();
        int[] arr = new int[]{ 1, 3, 4, 8, 8, 8, 7, 5, 3 };
        solutions.next_permutation(arr);
        for( int i = 0; i < arr.length; ++i )
            System.out.print(arr[i] +" "  );
    }

}

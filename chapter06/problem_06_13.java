// Problem 6.13
// Design a O(n) algorithm for rotating an array A of n elements to the
// right by i positions. You are allowed O(1) additional storage.

public class problem_06_13 {
    
    // right rotation
    public void rotate_array_right(int[] num, int i) {
        if( i >= num.length )
            i = i % num.length;
        if( i == 0 ) 
            return;
        reverse_array( num, 0, num.length - 1 );
        reverse_array( num, 0, i - 1 );
        reverse_array( num, i, num.length - 1 );
    }

    // left rotation
    public void rotate_array_left(int[] num, int i) {
        if( i >= num.length )
            i = i % num.length;
        if( i == 0 ) 
            return;
        reverse_array( num, 0, i - 1 );
        reverse_array( num, i, num.length - 1 );
        reverse_array( num, 0, num.length - 1 );
    }

    public void reverse_array(int[] num, int start, int end) {
        int left = start;
        int right = end;
        while( left < right ) {
            int tmp = num[left];
            num[left] = num[right];
            num[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] argv) {
        problem_06_13 solutions = new problem_06_13();
        int[] arr = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 };
        solutions.rotate_array_right(arr, 3);
        for( int i = 0; i < arr.length; ++i )
            System.out.print(arr[i] +" "  );
        System.out.println();
        solutions.rotate_array_left(arr, 3);
        for( int i = 0; i < arr.length; ++i )
            System.out.print(arr[i] +" "  );
    }

}

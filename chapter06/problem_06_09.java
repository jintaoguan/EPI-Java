// Problem 6.9
// Write a function that takes two strings representing integers, and
// returns an integer representing their product.

public class problem_06_09 {
    
    public String multiply(String num1, String num2) {
        if( num1.equals("0") || num2.equals("0") )
            return "0";
        int l1 = num1.length();
        int l2 = num2.length();
        int[] n1 = new int[l1];
        int[] n2 = new int[l2];
        int[] res = new int[l1+l2];
        // convert num1 to number array
        for( int i = 0; i < l1; ++i )
            n1[i] = num1.charAt(i) - '0';
        // convert num2 to number array
        for( int i = 0; i < l2; ++i )
            n2[i] = num2.charAt(i) - '0';
        // multiply into number array
        for( int i = 0; i < l1; ++i ) {
            for( int j = 0; j < l2; ++j ) {
                res[i+j+1] = res[i+j+1] + n1[i] * n2[j];
            }
        }
        // convert back to string
        StringBuilder sb = new StringBuilder();
        for( int k = l1 + l2 - 1; k >= 0; --k ) {
            sb.append((char)(res[k]%10 + '0'));
            if( k > 0 )
                res[k-1] = res[k-1] + res[k] / 10;
        }
        int count = sb.charAt(sb.length()-1) == '0' ? 1 : 0;
        String s = sb.reverse().substring(count, sb.length());
        return s.isEmpty() ? "0" : s;
    }

    public static void main(String[] argv) {
        problem_06_09 solutions = new problem_06_09();
        String ans = solutions.multiply("1","1");
        System.out.println(ans);
    }

}

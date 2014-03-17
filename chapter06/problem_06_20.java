// Problem 6.20
// Given two strings s(the "search" string) and t(the "text"), find the
// first occurrence of s in t.

public class problem_06_20 {

    // KMP algorithm
    public int findMatch(String t, String s) {
        int textlen = t.length();
        int patnlen = s.length();
        if( t.equals(s) )
            return 0;

        int[] next = new int[s.length()];
        buildNext(s, next);
        int i = 0;
        int j = 0;
        while( i < t.length() && j < s.length() ) {
            if( t.charAt(i) == s.charAt(j) ) {
                i++;
                j++;
                if( j == s.length() )
                    return ( i - s.length() );
            } 
            else if( j == 0 ) 
                i++;
            else if( j != 0 )
                j = next[j-1] + 1;
        }
        return -1;
    }
    
    public void buildNext(String s, int[] next) {
        for( int i = 0; i < next.length; ++i )
            next[i] = -1;
        next[0] = -1;
        int index;
        for( int i = 1; i < next.length; ++i ) {
            index = next[i-1];
            while( index >= 0 && s.charAt(i) != s.charAt(index+1) )
                index = next[index];
            if( s.charAt(i) == s.charAt(index+1) )
                next[i] = index + 1;
            else 
                next[i] = -1;
        }
    }

    public static void main(String[] argv) {
        problem_06_20 solutions = new problem_06_20();

        int ans = solutions.findMatch("banananacana", "anaca");
        System.out.println(ans);
    }

}

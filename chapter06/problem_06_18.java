// Problem 6.18
// Implement run-length encoding and decoding function. Assume
// the string to be encoded consists of letters of the alphabet, with no digits, and the string
// to be decoded is a valid encoding.

public class problem_06_18 {

    public String encode(String s){
        int count = 1;
        StringBuilder sb = new StringBuilder();
        int i;
        for( i = 1; i < s.length(); ++i ) {
            if( s.charAt(i) == s.charAt(i-1) ) {
                count++;
            } else {
                sb.append( count );
                sb.append( s.charAt(i-1) );
                count = 1;
            }
        }
        sb.append( count );
        sb.append( s.charAt(i-1) );
        return sb.toString();
    }

    public String decode(String s) {
        int count = 0;
        char c;
        StringBuilder sb = new StringBuilder();
        int i;
        for( i = 0; i < s.length(); ++i ) {
            c = s.charAt(i);
            if( c >= '0' && c <= '9' ) {
                count = count * 10 + c - '0';
            } else {
                for( int j = 0; j < count; ++j )
                    sb.append( c );
                count = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] argv) {
        problem_06_18 solutions = new problem_06_18();
        String encoded = solutions.encode("aaabbbcccdddddd");
        System.out.println(encoded);
        String decoded = solutions.decode(encoded);
        System.out.println(decoded);

    }

}

import java.util.Arrays;

public class AnagramString {
    
    static boolean anagramStringCheck(String s, String s1) {
        char[] c = s.toCharArray();
        char[] c1= s1.toCharArray();
        char[] c2= new char[c.length];
        char[] c4= new char[c1.length];

        int i,j; char swap=0;;
        for ( i = 0; i < c.length; i++ ) {
            for ( j = i+1; j < c.length; j++) {
                if(c[i] > c[j] && (c[i] != ' ')) {
                    swap = c[j];
                    c[j] = c[i];
                    c[i] = swap;
                }
            }
        }
        j = 0;
        for ( i = 0; i < c.length; i++ ) {
            if ( c[i] != ' ') {
                c2[j] = c[i];
                j++;
            }
        }
        for ( i = 0; i < c1.length; i++ ) {
            for ( j = i+1; j < c1.length; j++) {
                if(c1[i] > c1[j]) {
                    swap = c1[j];
                    c1[j] = c1[i];
                    c1[i] = swap;
                }
            }
        }
        j = 0;
        for ( i = 0; i < c1.length; i++ ) {
            if ( c1[i] != ' ') {
                c4[j] = c1[i];
                j++;
            }
        }
        for ( i = 0; i<c4.length-' '; i++  ) {
            if ( c2[i] != c4[i]) {
                return false;
            }
        }
        System.out.println(Arrays.toString(c2));
        System.out.println(Arrays.toString(c4));
        return true;
    }
    public static void main(String[] args) {
        
        String s  = "clint eastwood";
        String s1 = "old west action";
             
        if(anagramStringCheck(s, s1)) {
            System.out.println("This is an Anagram");
        }
        else {
            System.out.println("This is not an Anagram");
        }
    }
}

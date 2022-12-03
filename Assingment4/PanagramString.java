public class PanagramString {
    
    //Program to check Panagram String 
    static boolean checkPanagram(String s) {
        int i = 0; char j; String lString = "";
        
        //1. Given String Converted to Lower Case & spaces removed & collected in lString String Vairable
        while( i < s.length() ) {
            if( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' && s.charAt(i) != ' ' ){
            lString = lString + (char)(s.charAt(i)+32);
            }
            else if( s.charAt(i) >= 'a' && s.charAt(i) <= 'z' && s.charAt(i) != ' ' ) {
                lString = lString + ( char )( s.charAt(i) );
            }
            i++;
        }
        // System.out.println(lString); To Check converted String
        
        //2. Lowercase String converted to Char Array
        char[] cArray = lString.toCharArray();
        
        // to compare letters in cArray
        j = 'a'; int count = 0;

        /* Array taken for traverse to compare and match letters*/ 
        while ( j <= 'z') {
            
            /* to compare all letters with cArray using default print a'to'z print loop */
            for ( i = 0; i < cArray.length; i++ ) {
                                
                if ( cArray[i] == j ) {             /* Array has been checked for equals */
                    count++;
                    break;
                }
            }
            if ( count == 26 ) {                     /*Final Check for 26 indexes */              
            return true;
            }
            j++;
        }
        return false;
    }
    public static void main(String[] args) {
                
        String s = "zwx y tuv qrs mnop jkl ghi cba def";
       
        System.out.println( checkPanagram(s) );

        if ( checkPanagram(s) )
        System.out.println( "This is a PANAGRAM") ;
        else
        System.out.println( "This is not a PANAGRAM" );
    }
}

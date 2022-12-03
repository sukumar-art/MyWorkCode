
public class MaxOccringString {

    public static boolean maxStrCheck(String s) {
        int i, j; int count =1; 
        char[] sChar = s.toCharArray();

        for ( i = 0; i < sChar.length; i++) {
            
            for ( j = i + 1; j < sChar.length; j++) {
                
                if ( sChar[i] == sChar[j]) {
                    count++;               
                    System.out.println(sChar[i]);
                    System.out.println("Max Occur "+count);    
                }
                
        }
        
    }
    
    return false;
    }
    
    public static void main(String[] args) {
        String s = new String ("apple");
        maxStrCheck(s);
        
    }
}

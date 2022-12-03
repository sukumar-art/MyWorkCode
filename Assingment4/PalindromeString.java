
public class PalindromeString {
    static boolean sCheck(String s) {

        char[] sChar = s.toCharArray();
        int i, j=sChar.length-1;
        
        for(i = 0; i<j; i++) {
            if(sChar[i] != sChar[j-i]) {
                return false; 
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
        String s = new String("madam");
                
        if(sCheck(s)){
            System.out.println("2552 is a Palindrom");
        }
        else{
            System.out.println("2552 is not a Palindrom");
        }
        System.out.println(sCheck(s));
    }
}

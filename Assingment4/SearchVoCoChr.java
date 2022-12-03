
public class SearchVoCoChr {
    
    static String srVoCoChr(String s) {
        
        char[] c=s.toCharArray();                                          //String Converted to Char
        System.out.println(c);
        
        char[] vowels={'a','i','o','u','e'};                               //Vowels Array Created for cross checking        
        
        int i=0; int j;                                                    //Vairabels for Looping
        int vCount=0; int cCount=0; int spaceCount=0; int dCount=0; int sCharCount=0; int collect = 0;
        
        while(i<c.length) {                                                //Loop initiated
            for (j=0; j<vowels.length; j++) {
            
                if(c[i]==vowels[j]) {                                      //Vowels Collected and counted
                    vCount++;
                    collect=vowels[j];
                }
            } 
            if (c[i] != collect && c[i] != ' ') {
                if(c[i] > 'a' && c[i] < 'z')
                cCount++;
                else if(c[i] > '0' && c[i] < '9')
                dCount++;
                else
                sCharCount++;
            }
            if(c[i] == ' ')
                spaceCount++;
            i++;
        }
        System.out.println("Vowels Count     :- "+vCount);
        System.out.println("Consonants Count :- "+cCount);
        System.out.println("Digit Count      :- "+dCount);
        System.out.println("Special Chars    := "+sCharCount);
        System.out.println("No of Spaces     :- "+spaceCount);
                       
        return s;
    }
    public static void main(String[] args) {
        String s="java @ ineuron 123";
        srVoCoChr(s);
    }
}

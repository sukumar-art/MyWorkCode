class DupString {

    String aString(String s) {
        int i; int j; int check;
        
        char[] arr = s.toCharArray();
        
        for(i = 0; i<arr.length; i++) {
            check = 1;
            for (j = i+1; j<arr.length; j++) {
                if(arr[i] == arr[j] && arr[i] != ' ') {
                    check++;
                    arr[j] = '0';
                }
            }
            if(check > 1 &&  arr[i] != '0')
            System.out.print(arr[i]);
        }
        return s; 
        }
    }
public class DuplicateString {
    public static void main(String[] args) {
        
        DupString aString = new DupString();
        
        String s="sasrusas";
        aString.aString(s);
    }
}

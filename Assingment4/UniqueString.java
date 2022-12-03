class UniqueString {
    static String uniString(String s) {
        boolean Char = true;
        char[] sChar = s.toCharArray();
        
        for(int a=0; a<sChar.length; a++) {
            for(int b=a+1; b<sChar.length; b++) {
           
                if(sChar[a] == sChar[b]) {
                Char = false;
            }
            }
            
        }
        if(Char == true)
            System.out.println("This is a Unique String");
            else
            System.out.println("This is not a Unique String");
        return s;
    }
    public static void main(String[] args) {

        String s="ACTING";
        uniString(s);

    }
}
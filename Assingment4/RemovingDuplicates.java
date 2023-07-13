public class RemovingDuplicates {

    static String rDuplicates(String s) {

        int i, j;
        int colect = 0;
        char[] c = s.toCharArray(); // String Converted to CharArray

        for (i = 0; i < c.length; i++) {

            for (j = 0; j < i; j++) {

                if (c[i] == c[j]) {

                    colect = c[j];
                }
            }
            if (c[i] != colect)
                System.out.print(c[i]);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println("Before:-");
        String ar = new String("Java FullStack Job Gurantee course");
        System.out.println(ar);
        System.out.println("After Duplicate Removal:- ");
        rDuplicates(ar);
    }
}

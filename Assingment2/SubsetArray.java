public class SubsetArray {
    static boolean args(int[] a, int[] b){

        int i, j; 
        for(i=0; i<a.length; i++){
            for(j=0; j<b.length; j++){
                if(a[i]==b[j]){
                    break;
                }
            }
            if(j== b.length)
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] a={10,20,30,40,50};
        int[] b={40,60,70,20,10,30,50};

        if(args(a, b)){                                                  //Condition applied to fine subsets
            System.out.println("Array B is Subset of Array A");
        }
        else{
            System.out.println("Array B is Not a Subset of Array A");
        }
    }
}

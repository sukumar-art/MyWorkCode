import java.lang.String;

public class BubbleSort {
    static int bubbleArray(int[] a, int i, int j){
        i=0;
        while(i<a.length){                                           //while loop used inted of for loop
        for(j=1; j<a.length; j++){
            
            if(a[j]<a[j-1]){
                int swapIndex=a[j];
                a[j]=a[j-1];
                a[j-1]=swapIndex;
            }
        }
        i++;
        }
        for(int elem:a){
            System.out.print(elem+" ");
        }
        return j;
    }
    public static void main(String[] args) {
        //WAP TO DEVELOP BUBBLE SORTING METHOD
        int[] a={60,50,10,30,20,70};
        BubbleSort.bubbleArray(a, 0, 0);
    }
}

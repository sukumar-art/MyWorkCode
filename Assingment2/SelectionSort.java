class SelectSort{
    public int sortArray(int[] a, int low, int high){
    //WAP to process given array in to Selection sort method                
        int i=low; int j=high;

        while(i<a.length){                                 //While used insted of for Loop
            int lowest=i;
            for(j=i+1; j<a.length; j++){
                if(a[j]<a[lowest]){
                    lowest=j;
                }
            }
            int smallNum=a[lowest];
            a[lowest]=a[i];
            a[i]=smallNum;
            i++; 
        }
        for(int elem:a)
        System.out.print(elem+" ");
       
        return i;
    }
}
public class SelectionSort {
    public static void main(String[] args) {
        SelectSort sortingArray=new SelectSort();              //Object CCreated
        int[] arr={10,7,9,2,8,3,1,4,6,5};                   
        sortingArray.sortArray(arr, 0, arr.length-1);     //Method Called
    }
}

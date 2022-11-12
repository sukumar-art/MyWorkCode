import java.util.Arrays;

class QS{
    void sortArray(int[] a, int low, int high){
        if(low>=high){
            return;
        }
        int i=low; 
        int j=high;
        int mid = (i+j)/2;  
        int pivot = a[mid];

        while (a[i]<pivot){
            i++;
        }
            while (a[j]>pivot){
                j--;
        }
            if(i<=j){
                int swap=a[i]; 
                a[i]=a[j]; 
                a[j]=swap;
                i++; 
                j--; 
            }
            sortArray(a, low, j);
            sortArray(a, i, high);
    }
    }
    public class QuickSort{
        public static void main(String[] args){
            
            QS sortingArray=new QS();
            
            int[] arr={ 6,7,10,8,9,5,1,2,4};
            sortingArray.sortArray(arr, 0, arr.length-1);
            System.out.println(Arrays.toString(arr));
        }
    }
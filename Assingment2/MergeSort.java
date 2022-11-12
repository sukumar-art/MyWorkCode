class MergeSort{  
    /* Function to merge the subarrays of a[] */  
    void merge(int a[], int low, int mid, int high)    
    {    
        int i, j, k;  
        int n1 = mid - low + 1;    
        int n2 = high - mid;    
          
       /* temporary Arrays */  
            int LeftArray[] = new int[n1];  
            int RightArray[] = new int[n2];  
          
        /* copy data to temp arrays */  
        for (i = 0; i < n1; i++)    
        LeftArray[i] = a[low + i];    
        for (j = 0; j < n2; j++)    
        RightArray[j] = a[mid + 1 + j];    
          
        i = 0; /* initial index of first sub-array */  
        j = 0; /* initial index of second sub-array */   
        k = low;  /* initial index of merged sub-array */  
          
        while (i < n1 && j < n2)    
        {    
            if(LeftArray[i] <= RightArray[j])    
            {    
                a[k] = LeftArray[i];    
                i++;    
            }    
            else    
            {    
                a[k] = RightArray[j];    
                j++;    
            }    
            k++;    
        }    
        while (i<n1)    
        {    
            a[k] = LeftArray[i];    
            i++;    
            k++;    
        }    
          
        while (j<n2)    
        {    
            a[k] = RightArray[j];    
            j++;    
            k++;    
        }    
    }    
      
    void mergeSort(int a[], int low, int high)  
    {  
        if (low < high)   
        {  
            int mid = (low + high) / 2;  
            mergeSort(a, low, mid);  
            mergeSort(a, mid + 1, high);  
            merge(a, low, mid, high);  
        }  
    }  
      
    /* Function to print the array */  
    void printArray(int a[], int n)  
    {  
        int i;  
        for (i = 0; i < n; i++)  
            System.out.print(a[i] + " ");  
    }  
     
    public static void main(String args[])  
    {  
        int a[] = { 1, 6, 4, 2, 7, 8, 5, 3 };  
        int n = a.length;  
        MergeSort mergeSort = new MergeSort();  
        System.out.println("\nBefore sorting array elements are - ");  
        mergeSort.printArray(a, n);  
        mergeSort.mergeSort(a, 0, n - 1);  
        System.out.println("\nAfter sorting array elements are - ");  
        mergeSort.printArray(a, n);  
        System.out.println("");  
    }  
      
}  
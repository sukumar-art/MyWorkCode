class FindingDuplicates {
                                                    
    void sameArgs(int[] a, int i, int j){             //WAP to find duplicate values

        for(i=0; i<a.length; i++){
            for(j=i+1; j<a.length; j++){
                if(a[i]==a[j]){
                    System.out.print(a[j]+" ");
                }
        }
    }
    }
    public static void main(String[] args) {
        FindingDuplicates duplicateIndex=new FindingDuplicates();
        int[] a={1,2,3,4,5,1,5};
        duplicateIndex.sameArgs(a, 0, 0);
    }
}

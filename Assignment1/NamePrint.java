public class NamePrint{
    public static void main(String[] arga){

        int n=13, r,c;
        for(r=0;r<n;r++){
        //I Letter    
            for(c=0;c<n;c++){
                if(c==0)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
                System.out.print(" ");
        //N Letter        
                for(c=0;c<n;c++){
                    if(c==0 || r-c==0 || c==n-1)
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                    
                }
                System.out.print(" ");
        //E Letter
                for(c=0;c<n;c++)
                {
                    if(c==0 || r==0 || r==(n-1)/2 || r==n-1)
                    {
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                System.out.print(" ");
        // U Letter
                for(c=0;c<n;c++){
                    if(c==0 && r<n-1 || r==n-1 && c>0 && c<n-1 || c==n-1 && r<n-1)
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                }
                System.out.print(" ");
        // R Letter
                for(c=0;c<n;c++){
                    if(c==0|| c==n-1 && r>0 && r!=(n-1)/2 || r==0 && c<n-1 || r==(n-1)/2 && c<n-1)
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                }
                System.out.print(" ");
        // O Letter
                for(c=0;c<n;c++){
                    if(r==0 && c>0 && c<n-1 || c==0 && r>0 && r<n-1 || r==n-1 && c>0 && c<n-1 || c==n-1 && r>0 && r<n-1)
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                }
        // N Letter
                 System.out.print(" ");
                 for(c=0;c<n;c++){
                    if(c==0 || r-c==0 || c==n-1)
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                 }              
            }
            System.out.println(" ");
        }
    }
}
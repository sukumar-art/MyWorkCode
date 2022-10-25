
public class QesFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=14, i,j;
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				if(i+j<=(n-1)/2 || i-j>=(n-1)/2 || i==0 || i==n-1 ) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
				
			}
			System.out.println();
		}

	}

}

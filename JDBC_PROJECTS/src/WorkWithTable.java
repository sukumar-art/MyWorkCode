import java.util.*;

public class WorkWithTable {
    // static void execution () {
    //     Scanner scan = new Scanner(System.in);
    //     System.out.println("Select What you want to do with the Table::");
    //             System.out.println("Enter '1' to See Entire Table");
    //             System.out.println("Enter '2' to Search a Record");
    //             System.out.println("Enter '3' to Update a Record");
    //             System.out.println("Enter '4' to Deleate a Record");
    //             System.out.println("Enter '5' to Insert a Record");
    //             System.out.println("Enter '6' to Close the Console");
    //             int sel = scan.nextInt();
                
    //             if (sel == 1) {
    //                 Prepared_Connect.seeTable();
    //             }
    //             if (sel == 2) {
    //                 PreparedSearch.searchRecord();
                    
    //             }
    //             if (sel == 3) {
    //                 PreparedUpdate.updateRecord();
    //             }
    //             if (sel == 4) {
    //                 PreparedDelete.deleteRecord();
    //             }
    //             if (sel == 5) {
    //                 PreparedInsert.insertTable();
                
    //             }            
    //             if(sel == 6) {
                    
    //             }

    //     System.out.println("Enter '1' to Continue or '2' to Exit");
    //     if(scan.nextInt() == 1) {
    //         execution();
    //     } else if (scan.nextInt() == 2) {
    //         System.exit(0);
    //     } else {
    //         System.out.println("Wrong Entry");
    //     }
        
    // }
    public static void main(String[] args) {
        Scanner scan = null;
        try {
            scan = new Scanner(System.in);
            //WorkWithTable.execution();
            while(true) {
                System.out.println("Select What you want to do with the Table::");
                System.out.println("Enter '1' to See Entire Table");
                System.out.println("Enter '2' to Search a Record");
                System.out.println("Enter '3' to Update a Record");
                System.out.println("Enter '4' to Deleate a Record");
                System.out.println("Enter '5' to Insert a Record");
                System.out.println("Enter '6' to Close the Console");
                int sel = scan.nextInt();
                
                if (sel == 1) {
                    Prepared_Connect.seeTable();
                }
                if (sel == 2) {
                    PreparedSearch.searchRecord();
                }
                if (sel == 3) {
                    PreparedUpdate.updateRecord();
                }
                if (sel == 4) {
                    PreparedDelete.deleteRecord();
                }
                if (sel == 5) {
                    PreparedInsert.insertTable();
                }            
                if(sel == 6) {
                    break;
                }
            }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (scan != null) {
                    scan.close();
                }
            }
        
        }
    
    }


// if (sel == 1) {
                //     System.out.println("See the Table");
                    
                // }
                
                // if (sel == 2) {
                //     System.out.println("Search the Table");
                // }
                // if (sel == 3) {
                //     System.out.println("Update the Table");
                // }
                // if (sel == 4) {
                //     System.out.println("Delete the Table");
                // }
                // if (sel == 5) {
                //     System.out.println("Inseart the Table");
                // }            
                // if(sel == 6) {
                //     System.out.println("Close the Table");
                //     break;
                // }

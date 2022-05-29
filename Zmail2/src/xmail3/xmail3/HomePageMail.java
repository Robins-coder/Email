package xmail3.xmail3;

import java.util.Scanner;

public class HomePageMail {

     
     HomePageMail(){}
     static int page_retry_count=0;
     
	public void homepage() {
        System.out.println();
		System.out.println("........Zmail.........");
		System.out.println();
		Scanner input=new Scanner(System.in);
		
		System.out.println(" 1.Create Mail \n 2. login Mail \n 3.Exit");
		System.out.print("=> ");
	    try {
	    	int ch=input.nextInt();
			switch (ch) {
			case 1: {
				   page_retry_count=0;
	               new Loginpage().create_New_Account();
				break;
			}
			case 2:{
				   page_retry_count=0;
				   new Loginpage().login_Account();
				break;
			}
			case 3:{
	            System.exit(0);
				break;
			}
		   }

	
		} catch (Exception e) {
            		
            page_retry_count++;
            if(page_retry_count==3) 
            {   System.out.println();
         	   System.out.println("                [many more attempt]   !!");
         	   System.out.println();
               System.exit(0);
             }
             System.out.println();
             System.out.println("   *Enter valid input ..");
		        System.out.println();
		        homepage();
		
		}
}
	
	
	public static void main(String[] args) {

	       HomePageMail mp=new HomePageMail();
	       mp.homepage();
		}

}

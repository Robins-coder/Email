package xmail3.xmail3;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Loginpage {

     //database	
	static LinkedHashMap<String ,Loginpage> database=new LinkedHashMap<String, Loginpage>();
	
	
	
//	private static LinkedHashMap String;
	String name;
	int password;
	LinkedHashMap mails;
	LinkedHashMap received_mails;
	
	public Loginpage(String name,int password,LinkedHashMap mails,LinkedHashMap received_mails) {
	   this.name=name;
	   this.password=password;
	   this.mails=mails;
	   this.received_mails=received_mails;
	}


	Loginpage()
	{

	}


	static int retry_Create_Account_Page=0;
	static int retry_Login_Page=0;
	public void create_New_Account() {
           mails=new LinkedHashMap<Integer,Modelmail>();
           received_mails=new LinkedHashMap<Integer, Modelmail>() ;
		   Scanner input=new Scanner(System.in);
		   HomePageMail returnhomepage=new HomePageMail();
		   System.out.println();
		   System.out.println("              [Account Created Page]              ");
           System.out.println();
		   
           try {
        	   System.out.println("ENter the Name : ");
               String name=input.next();
               System.out.println("Enter Password : ");
               int pin=input.nextInt();

               if(!(database.containsKey(name))) {
               Loginpage loginpage_detail=new Loginpage(name,pin,mails,received_mails);
               database.put(name, loginpage_detail);
               System.out.println();
               System.out.println("      * * Account Created * * ");
               System.out.println();
                retry_Create_Account_Page=0;
               returnhomepage.homepage();
               }
               else
               {
            	   System.out.println("**User name already exist.....");
            	   create_New_Account();
               }

	    	} catch (Exception e) {
                   retry_Create_Account_Page++;
                   if(retry_Create_Account_Page==3)
                          {System.out.println("             [many more attempt]           !!");;returnhomepage.homepage();}
                   System.out.println();
                   System.out.println(" try again  password must be integer (0-9) !!");
                   System.out.println();
                   create_New_Account();
		    
	    	}
           
	}

	public void login_Account() {
		Scanner input=new Scanner(System.in);
		    System.out.println();
            System.out.println("              [ login Page ]        ");
            System.out.println();
            
            
       
           
            try {
                System.out.println("Enter the name : ");
                String name=input.next();
                System.out.println("Enter Password : ");
                int pin=input.nextInt();
                int pass=database.get(name).password;
          
            	if(database.containsKey(name)&& pass==pin)
                {
                  EmailsOptions accesEmialOptions=new EmailsOptions();
                  accesEmialOptions.Option(name);
                }
                else
                {   retry_Login_Page++;
                   if(retry_Login_Page==3) 
			         {   
		    	       System.out.println(" [  many more attempt !!! ]");	    	 
		               HomePageMail returnHomepage=new HomePageMail();
		                  retry_Login_Page=0; 
		                 returnHomepage.homepage();
			          }
                	System.out.println("           *check password and username  !!!");
                    this.login_Account();
                }	
			} catch (Exception e) {
			       HomePageMail returnHomepage=new HomePageMail();
			       System.out.println("  [ Create Account ... or check username or password !!! ] ");
                   returnHomepage.homepage();  
			      	
			}
            
	}


}

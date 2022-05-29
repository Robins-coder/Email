package xmail3.xmail3;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EmailsOptions {


	public EmailsOptions() {}


	public void Option(String name) {
        Scanner input=new Scanner(System.in);
        System.out.println("..............Email Options.............");
        System.out.println(" 1.Compose \n 2.Mails \n 3.Received Mails \n 4.Exit ");
        int ch=input.nextInt();
        switch (ch) {
		case 1: {
		    	Compose(name);
			break;
		}
		case 2:{
    			  Mails(name);
			break;
		}
		case 3:{
	    		ReceivedMails(name);
			break;
		}
		case 4:{
		    	HomePageMail returnHomePage=new HomePageMail();
		        returnHomePage.homepage();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + ch);

		}
	}


	
	private void ReceivedMails(String name) {
       System.out.println();
      System.out.println(); 
      System.out.println("  [       -----> Received mails  Box <-------  ]");
        System.out.println();
		LinkedHashMap mails=new Loginpage().database.get(name).received_mails;
   
         boolean checkReceivedMailBoxEmpty=mails.isEmpty();
         
         if(checkReceivedMailBoxEmpty==true) 
         {
        	   System.out.println();
        	   System.out.println("   [ *Received Mail Box Is Empty ]   ");
               System.out.println("--------------------------------------------------------------");
        	   System.out.println();
   
        	   Option(name);
         }
                  
         Iterator<Integer> itr=mails.keySet().iterator();
         while(itr.hasNext())
         {
        	 int key=itr.next();
        	// System.out.println(key);
        	 Modelmail m= (Modelmail) mails.get(key);
        	 System.out.println("******************");
        	 System.out.println("[ Message ID ]  ::  "+m.messageId);
        	 System.out.println("[    from    ]  ::  "+m.fromname);
        	 System.out.println("[   Subject  ]  ::  "+m.Subject);
        	 System.out.println("[   Message  ]  ::  "+m.Message);
        	 
         }
         Option(name);

	}

	private void Mails(String name) {
        
        LinkedHashMap mails=new Loginpage().database.get(name).mails;

        System.out.println();
        System.out.println();
        System.out.println("           [--------> Send mail Box <----------]     ");
        System.out.println();
        
        boolean checkTotalMailBoxEmpty=mails.isEmpty();
                  if(checkTotalMailBoxEmpty==true) 
         {
        	   System.out.println();
        	   System.out.println("    [ Mail Box Is Empty ]   ");
System.out.println("---------------------------------------------------------------------------");
        	   System.out.println();
        	   Option(name);
         }
           
          
         Iterator<Integer> itr=mails.keySet().iterator();
         while(itr.hasNext())
         {
        	 int key=itr.next();
        	 //System.out.println(key);
        	 Modelmail m= (Modelmail) mails.get(key);
        	 System.out.println("******************");
        	 System.out.println("[ Message ID ]  ::  "+m.messageId);
        	 System.out.println("[    From    ]  ::  "+m.fromname);
        	 System.out.println("[     To     ]  ::  "+m.toname);
        	 System.out.println("[   Subject  ]  ::  "+m.Subject);
        	 System.out.println("[   Message  ]  ::  "+m.Message);
         }
         Option(name);

	}

	private void Compose(String fromName) {
         System.out.println();
		System.out.println("........Compose Mail Section.......");
             Scanner input=new Scanner(System.in);

             System.out.println("From : "+fromName);
             System.out.println("TO : ");
             String toName=input.nextLine();
             
             //check 'To' address after send msg
             
                 boolean checkToaddress=Loginpage.database.containsKey(toName);
             
                 if(checkToaddress==false) 
                 {
                	 System.out.println("        [   *This username [ "+toName+" ] cannot found  ]     ");
                     Option(fromName);      
                 }
             
             System.out.println("Subject : ");
             String Subject=input.nextLine();
             System.out.println("Message : ");
             String Message =input.nextLine();
             int MessageID=(int)(Math.random()*100+100);
             Modelmail composeDetails=new Modelmail(fromName,toName,Subject,Message,MessageID);

             boolean msgSendOrNot=SendorNot(toName,composeDetails,MessageID);
             if(msgSendOrNot) {
              LinkedHashMap mail=new Loginpage().database.get(fromName).mails;
              mail.put(MessageID, composeDetails);
              System.out.println("     [  Message Added mailbox  ]   ");
             }
             Option(fromName);
	}

	private boolean SendorNot(String toname,Modelmail composedetails,int MessageID) {
         LinkedHashMap toReceivedMail=new Loginpage().database.get(toname).received_mails;
         toReceivedMail.put(MessageID, composedetails);
         System.out.println();
         System.out.println("        [  Message Succesfully Send to  "+toname+"       ]");
         System.out.println();
         return true;
	}




}

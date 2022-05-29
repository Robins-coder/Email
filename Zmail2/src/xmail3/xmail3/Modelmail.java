package xmail3.xmail3;

public class Modelmail {
       String fromname;
       String toname;
       String Subject;
       String Message;
       long messageId;
	Modelmail(String fromName,String toName,String Subject,String Message,long MessageId)
	{
		this.fromname=fromName;
		this.toname=toName;
		this.Subject=Subject;
		this.Message=Message;
        this.messageId=MessageId;
	}
}

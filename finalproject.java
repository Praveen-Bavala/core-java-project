import java.util.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
interface GenerateOTP 
{
	static Scanner sc=new Scanner(System.in);
	static String bgred="\u001B[41m";
 	static String bgblue="\u001B[44m";
    static String bgmegenta="\u001B[45";
    static String bggreen="\u001B[42m";
  	static String bgyellow="\u001B[43m";
    static String SET_BOLD_TEXT = "\033[0;1m";
	static String REDBRI= "\033[1;91m";
	static String increaseFontSize = "\033[1;31m";
	static String resetFormatting = "\033[0m";
	static String BOLD="\u001B[1m";
	static String BLINK ="\u001B[5m";
	static String whitebg="\u001B[47m";
	static String black ="\u001B[30m";
	String skblue = "\u001B[36m";
	static String magent = "\u001B[95m";
	static final String ital = "\u001B[3m";
	static String ul = "\u001B[4m";
	static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";
    static String GREEN = "\u001B[32m";
    static String YELLOW = "\u001B[33m";
	static String BLUE="\u001B[34m";
	static String PURPLE="\u001B[35m";
	static String WHITE="\u001B[37m";
	static String CYAN="\u001B[36m";
	

	
	default  void mobile()
	{
		long Number;
		while(true)
		{
			System.out.println(" "+whitebg+black+"  Enter Mobile Number For Login To Your Account  "+RESET);
			System.out.println("                                          ");
			try
			{
			    Number=sc.nextLong();
				break;
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println("Enter Valid Mobile Number!");
				sc.nextLine();
			}
		}
		long temp=Number;
		int c=0;
		long rev=0l;
		while(Number >0)
		{
			Number =Number/10;
			c++;
		}
	    Number=temp;
		while(Number >0)
		{
			long r=Number%10;
			Number=Number/10;
			rev=rev*10+r;
		}
		long rem=rev%10;
		
		if(c<10 || c>10 || rem==1 || rem==2 || rem==3 || rem==4 || rem==5)
		{
			System.out.println(RED+"Number Should contains 10 Charters and Starts With 6 To 9"+RESET);
			System.out.println();
			mobile();
		} 
		else
		{
			generateOTP();
		}
	}
	static void generateOTP()  
    {  
        int randomPin=(int) (Math.random()*9000);
		System.out.println("your generatedOTP is : "+GREEN+randomPin+RESET);
		int count =0;
		otpp(randomPin,count);
	}
	static void otpp(int randomPin, int count)
	{
	
		System.out.println();
		System.out.println(" "+whitebg+black+"  Enter OTP  "+RESET);
		
		
			
			int otp=sc.nextInt();
			System.out.println();
			if(randomPin==otp)
			{
				System.out.println(GREEN+"**  Login Sucessful  **"+RESET);
				System.out.println(" ");
				System.out.println(GREEN+"**  Bank   Added   Sucessful **"+RESET);
			}
			else
			{
				count++;
				System.out.println(RED+"Invalid OTP"+RESET);
				if(count<=2)
				{
					otpp(randomPin,count);
				}
				else if(count ==3)
				{
				generateOTP();
			    }
				
			}	
		
    } 
}   

/* abstract class wallet                                                                      
{                   
		abstract void wallet_money(int a); 
} */


class balance implements GenerateOTP                                       
{
	static Scanner sc=new Scanner(System.in);
	static double balance=120000000.78;
	static double wallet_money=100;
	private static int upi=1234;
	static String success="";
	static Date dt = new Date();
	static SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy HH:MM:SS");
	static String date = sf.format(dt);
	void balanceEnquiry()
	{
		System.out.println(" "+whitebg+black+" Enter your pin "+RESET);
		System.out.println();
		int pin =sc.nextInt();
		if(pin==upi)
		{
			System.out.println();
			System.out.printf(PURPLE+"BANK BALANCE : "+RESET+GREEN+balance+RESET);
		}
		else
		{
			System.out.println(RED+"Incorrect pin"+RESET);
			balanceEnquiry();
		}
	}
	
	/*void wallet_money(int a)
	{
       withdraw(a);
	   wallet_money=wallet_money+a; 
	   
	   System.out.println("Money  successfully added to your wallet");
	   System.out.println();
       	   
	} */
	
	void withdraw(double Amount)
	{
		System.out.println();
		System.out.println(" "+whitebg+black+" Enter your pin "+RESET);
		int pin=sc.nextInt();
		if(upi==pin)
		{
			if(Amount<balance)
			{
				balance=balance-Amount;
				int randomPin   =(int) (Math.random()*90000000);
				this.success=this.success+"          -------------------------------- \n"+"          Rs. "+Amount+GREEN+" Payment successful \n"+RESET+"          Transaction ID "+GREEN+"IBO018"+randomPin+"\n"+RESET+"          "+GREEN+date+RESET+"\n"+"          --------------------------------\n"+"\n"+"\n";
				System.out.println();
				System.out.println("Rs. "+Amount +GREEN+BLINK+" PaYmeNt SucCesFullY "+RESET);
			}
			else  
			{
				System.out.println(RED+BLINK+"Insufficient Funds"+RESET);
			}
		}
		else
		{
			System.out.println(RED+BLINK+"Incorrect pin"+RESET);
			withdraw(Amount);
		}
	}
	void setta(int old_upi)
	{
		
		if(upi==old_upi)
		{
			System.out.println(" "+whitebg+black+" Enter New UPI ID "+RESET);
			int new_upi =sc.nextInt();
			System.out.println();
			upi=new_upi;
		}
		else
		{
		    upi_change upi = new upi_change();
			System.out.println(" "+whitebg+black+" Enter correct UPI "+RESET);
			upi.method();
		}
	}
	String getta()
	{
		return GREEN+"UPI pin succesfully change"+RESET;
	}
}
class upi_change extends balance                                                                          
{
		void method()
		{
			System.out.println(RED+"Enter Old UPI ID"+RESET);
			int old_upi=sc.nextInt();
			setta(old_upi);
			System.out.println(getta());
		}
}
class transaction extends upi_change 
{
	static Scanner sc=new Scanner(System.in);
	static transaction obj=new transaction();
	static test test2 = new test();
	int c=0;
	void sendingMoney()
	{
		System.out.println();	
		System.out.println(" "+whitebg+black+" Enter Amount "+RESET);
		double Amount =sc.nextInt();
		obj.withdraw(Amount);		
	}
	void NumberChecking()
	{	
	
		System.out.println(" "+whitebg+black+" Enter Mobile Number "+RESET);
		System.out.println();
		String Number=sc.next();
		System.out.println();
		System.out.println();
		if(c<=2)
		{
			
			if(Number.length()==10 && Number.charAt(0)!=0)
			{
						
				System.out.println(GREEN+"** Money Is  Transfering TO This Person **"+RESET);
				String[] firstName = {"Uma ","Praveen","Surekha","sudha Rani","Tanuja","sathvika"};
				String[] lastName = {"Nakka","Adhikari","konidela","pulii","Kamma","Chavala","vaddi","Duvva"};
				Random random = new Random();
				System.out.println(firstName[random.nextInt(firstName.length)]+" "+lastName[random.nextInt(lastName.length)]);
				sendingMoney();	
				
			}
			else
			{
				c++;
				System.out.println(RED+BLINK+"Invalid Mobile Number"+RESET);
				System.out.println();
				System.out.println("You have only "+(3-c)+" attempts left");
				System.out.println();
				NumberChecking();
				
			}
		}
		else
		{
			c=0;
			test2.module();
		}
	}
	
}
class mobile_recharge extends transaction
{
	static Scanner sc=new Scanner(System.in);
	static mobile_recharge obj=new mobile_recharge();
	static test test1 = new test();
	
	static int c=0;
	static ArrayList list=new ArrayList();
	static String success;
	
	static void number() 
	{
		System.out.println("                                            ");
		System.out.println("                                            ");
		System.out.println(" "+whitebg+black+"  Enter Mobile Number For Recharge  "+RESET);
		System.out.println();
		long Number;
		while(true)
		try
		{
			Number = GenerateOTP.sc.nextLong();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
			GenerateOTP.sc.nextLine();
		}
			long tempo=Number;
			int i=0;
			if(c<=3)   
			{
				while(Number>0)
				{
					Number=Number/10;
					i++;
				}
				Number =tempo;
				long reverse=0;
				while(Number >0)
				{
					long re=Number%10;
					Number=Number/10;
					 reverse=reverse*10+re;
				}
				Number=tempo;
				long we =reverse%10;
					
				if(i<10 || i>10 || we==1 || we==2 || we==3 || we==4 || we==5)
				{
							System.out.println(RED+BLINK+"Number must contain 10 characters and should Starts With 6 To 9 ! "+RESET);
							c++;
							System.out.println();
							System.out.println("You have only "+(4-c)+" attempts left");
							number();
				}
				else
				{
					obj.network(Number);
				}
			}
			else
			{
				System.out.println(RED+BLINK+" limit have been exceeded try again after sometime..... "+RESET);
				c=0;
				test1.module();
				
			} 
	}
	void network(long Number)
	{
		System.out.println();
		System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" SeLect Your NetWork "+RESET+BLINK+"  -------------"+RESET);
		System.out.println();
		System.out.println("-->"+skblue+ "  1.Airtel "+RESET);
		System.out.println("-->"+skblue+ "  2.Jio "+RESET);
		System.out.println("-->"+skblue+ "  3.Idea "+RESET);
		System.out.println();
		int network;
		while(true)
		try
		{
			network = GenerateOTP.sc.nextInt();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
			GenerateOTP.sc.nextLine();
		}
		
		
		if(network<=3)
		{
			obj.planSelection(Number);
		}
		else
		{
			System.out.println(RED+BLINK+" Invalid selection"+RESET);
			network(Number); 
		}
	}
	
	void planSelection(long Number)
	{
		System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Enter Respective Key Show Plans On Your NuMber "+RESET+BLINK+"  -------------"+RESET);
		System.out.println();
		System.out.println("-->"+skblue+ "  1. View special offer's"+RESET);
		System.out.println("-->"+skblue+ "  2. Unlimited packs"+RESET);
		System.out.println("-->"+skblue+ "  3. Data packs"+RESET);
		System.out.println();
		int pack;
		while(true)
		try
		{
			pack = GenerateOTP.sc.nextInt();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
			GenerateOTP.sc.nextLine();
		}
		switch(pack)
		{
			case 1:
				offers(Number);
				break;
			case 2:
				unlimited(Number);
				break;
			case 3:
				data(Number);
				break;
			default:
				System.out.println(RED+"Invalid option"+RESET);
				planSelection(Number);
				break;	
		}
	}
	void unlimited(long Number)
	{
		System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Pack "+RESET+BLINK+"  -------------"+RESET);
		System.out.println();
		System.out.println("-->  24  Days  pack 1gb Data : "+skblue+"159/-"+RESET);
		System.out.println("-->  One Month pack With 1gb Data : "+skblue+"199/-"+RESET);
		System.out.println("-->  One Month pack with 1.5gb Data : "+skblue+"239/-"+RESET);
		System.out.println("-->  One Month pack with 2gb Data : "+skblue+"299/-"+RESET);
		System.out.println("-->  TWO Month pack with 2gb Data : "+skblue+"459/-"+RESET);
		System.out.println("-->  Three Month pack with 2gb Data : "+skblue+"779/-"+RESET);
		System.out.println("-->  One Year pack : "+skblue+"3359/-"+RESET);
		System.out.println();
		System.out.println("-->  press 1 to "+RED+ " Exit.. "+RESET);
		System.out.println("-->  press 2 to "+GREEN+ " Continue.. "+RESET);
		System.out.println();
		int n;
		while(true)
		try
		{
			n = GenerateOTP.sc.nextInt();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
			GenerateOTP.sc.nextLine();
		}
		if(n==1)
			planSelection(Number);
		else if(n==2)
		{
			System.out.println(" "+whitebg+black+" Enter Amount "+RESET);
			int Amount=sc.nextInt();
			obj.withdraw(Amount);
		}
		else 
		{
			System.out.println(RED+"Invalid option"+RESET);
			planSelection(Number);
		}
			System.out.println();
			System.out.println(GREEN+" Recharge Successful on this Number : "+RESET+Number);
			System.out.println(" "+date);	
			
			//success=GREEN+"** Recharge successful on this Number **"+Number+RESET;
		    //list.add(success);
	}
	
		void offers(long Number)
		{
			System.out.println();
			System.out.println("-->  23  Days  pack 1.5 GB Data + (Disney Hotstar): "+skblue+"169/-"+RESET);
			System.out.println();
			System.out.println("-->  84 days pack 1 GB data +(Netflix): "+skblue+"699/-"+RESET);
			System.out.println();
			System.out.println("-->  press 1 to"+RED+ " Exit.. " +RESET);
			System.out.println("-->  press 2 to"+GREEN+ " Continue.. " +RESET);
			System.out.println();
			int n;
			while(true)
			try
			{
				n = GenerateOTP.sc.nextInt();
				break;
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
				GenerateOTP.sc.nextLine();
			}
			if(n==1)
			planSelection(Number);
			else if(n==2)
			{
				System.out.println(" "+whitebg+black+" Enter Amount "+RESET);
				int Amount=sc.nextInt();
			    obj.withdraw(Amount);
			}
			else 
			{
				System.out.println(RED+"Invalid option"+RESET);
				planSelection(Number);
			}
				//success=GREEN+"** Recharge successful on this Number **"+Number+RESET;
				System.out.println();
				System.out.println(GREEN+BLINK+" Recharge successful : "+RESET+Number);
				System.out.println(" "+date);
				//list.add(success);
					
		}
		void data(long Number)
		{
			System.out.println("-->  validity for 1 day 1GB/pack: "+skblue+"19/-"+RESET);
			System.out.println("-->  One day Data addition with 2gb Data: "+skblue+"29/-"+RESET);
			System.out.println("-->  Two day Data addition with Unlimited Data : "+skblue+"99/-"+RESET);
			System.out.println();
			System.out.println("-->  press 1 to"+RED+ " Exit.. "+RESET);
			System.out.println("-->  press 2 to"+GREEN+ " Continue.. "+RESET);
			System.out.println();
			int n;
		    while(true)
			try
			{
				n = GenerateOTP.sc.nextInt();
				break;
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
				GenerateOTP.sc.nextLine();
			}
			if(n==1)
				planSelection(Number);
			else if(n==2)
			{
		
				System.out.println(" "+whitebg+black+" Enter Amount "+RESET);
				int Amount=sc.nextInt();
				obj.withdraw(Amount);
			
			}
			else 
			{
				System.out.println(RED+"Invalid option"+RESET);
				planSelection(Number);
			}
					System.out.println();	
					System.out.println(GREEN+BLINK+" Recharge successful on this Number: "+Number+RESET);
				    System.out.println(" "+date);
					
				//success=GREEN+"** Recharge successful on this Number **"+Number+RESET;
				//list.add(success);	
		}
		
	
	
}
class movie extends mobile_recharge
{
	static movie obj=new movie();
	static Scanner sc = new Scanner(System.in);
	static int a=10;
	static String date1;
	static String month1;
	static void locationSelect()
	{
		System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Location "+RESET+BLINK+"  -------------"+RESET);
			System.out.println();
			System.out.println("-->  1 For "+REDBRI+" Hyderabad"+RESET);
			System.out.println("-->  2 For "+REDBRI+" Banglore "+RESET);
			System.out.println("-->  3 For "+REDBRI+" Kakinada"+RESET);
			System.out.println("-->  4 Back To"+GREEN+BLINK+" Main Page"+RESET);
			System.out.println();
			int a;
			while(true)
			try
			{
			a = GenerateOTP.sc.nextInt();
			break;
			}
			catch (Exception e)
			{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
			GenerateOTP.sc.nextLine();
			}
			switch(a)
{
				case 1:
				hyderabad();
				break;
				case 2:
				banglore();
				break;
				case 3:
				kakinada();
				break;
				case 4:
				test1.module();
				break;
			}		
	}
	static void hyderabad()
	{
		System.out.println("-->  press 1 proceed to "+CYAN+"       Booking"+RESET);
		System.out.println("-->  press Any Key Back To "+CYAN+"    Locations"+RESET);
		System.out.println();
		int n;
		while(true)
		try
		{
			n = GenerateOTP.sc.nextInt();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+" Enter Valid  Number !"+RESET);
			GenerateOTP.sc.nextLine();
		}
		if(n==1)
		{
			System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Movie "+RESET+BLINK+"  -------------"+RESET);
			System.out.println();
			System.out.println("-->  press 1 for "+REDBRI+"Salar"+RESET);
			System.out.println("-->  press 2 for "+REDBRI+"Berlin"+RESET);
			System.out.println("-->  press 3 for "+REDBRI+"Pk"+RESET);
			System.out.println();
			int a;
			while(true)
			try
			{
				a = GenerateOTP.sc.nextInt();
				break;
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
				GenerateOTP.sc.nextLine();
			}
			switch(a)
			{                                                                   
				case 1:      
				salar();
				break;
				case 2:
				berlin();
				break;
				case 3:
				pk();
				break;
			} 
		}
		else
		{
			locationSelect();
		}
	}
	static void banglore()
	{
		System.out.println("-->  press 1 proceed to "+CYAN+"      Booking"+RESET);
		System.out.println("-->  press Any Key Back To"+CYAN+"    Locations"+RESET);
		System.out.println();
		int n;
		while(true)
		try
		{
			n = GenerateOTP.sc.nextInt();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Number !"+RESET);
			GenerateOTP.sc.nextLine();
		}
		if(n==1)
		{
			System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Movie "+RESET+BLINK+"  -------------"+RESET);
			System.out.println();
			System.out.println("-->  press 1 for "+REDBRI+"Salar"+RESET);
			System.out.println("-->  press 2 for "+REDBRI+"Berlin"+RESET);
			System.out.println("-->  press 3 for "+REDBRI+"Pk"+RESET);
			System.out.println();
			int a;
			while(true)
			try
			{
				a = GenerateOTP.sc.nextInt();
				break;
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
				GenerateOTP.sc.nextLine();
			}
			switch(a)
			{                                                                   
				case 1:      
				salar();
				break;
				case 2:
				berlin();
				break;
				case 3:
				pk();
				break;
				
			} 
		}
		else
		{
			locationSelect();
		}
	}		
	static void kakinada()
	{
		System.out.println("-->  press 1 proceed to "+CYAN+"    Booking"+RESET);
		System.out.println("-->  press Any Key Back To "+CYAN+" Locations"+RESET);
		System.out.println();
		int n;
		while(true)
		try
		{
			n = GenerateOTP.sc.nextInt();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
			GenerateOTP.sc.nextLine();
		}
		if(n==1)
		{
			System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Movie "+RESET+BLINK+"  -------------"+RESET);
			System.out.println();
			System.out.println("-->  press 1 for "+REDBRI+"Salar"+RESET);
			System.out.println("-->  press 2 for "+REDBRI+"Berlin"+RESET);
			System.out.println("-->  press 3 for "+REDBRI+"Pk"+RESET);
			System.out.println();
			int a;
			while(true)
			try
			{
				a = GenerateOTP.sc.nextInt();
				break;
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
				GenerateOTP.sc.nextLine();
			}
			switch(a)
			{                                                                   
				case 1:      
				salar();
				break; 
				case 2:
				berlin();
				break;
				case 3:
				pk();
				break;
				case 4:
				
				
			}
		}
		else
		{
			locationSelect();
		}
	} 
	static void salar()
	{
		System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Date "+RESET+BLINK+"  -------------"+RESET);
		obj.date();
		System.out.println();
		System.out.println("-->  Press 1 proceed To "+CYAN+"Selected Movie"+RESET);
		System.out.println("-->  Press Any Key Back To "+CYAN+"Movies"+RESET);
		System.out.println();
		int n;
		while(true)
		try
		{
			n = GenerateOTP.sc.nextInt();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
			GenerateOTP.sc.nextLine();
		}
		if(n==1)
		{
			System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Selected Theater "+RESET+BLINK+"  -------------"+RESET);
			System.out.println();
			System.out.println("-->  press 1 for "+REDBRI+"Arjun theater"+RESET);
			System.out.println("-->  press 2 for "+REDBRI+" AAA   theater"+RESET);
			System.out.println();
			int a;
			while(true)
			try
			{
				a = GenerateOTP.sc.nextInt();
				break;
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
				GenerateOTP.sc.nextLine();
			}
			switch(a)
			{
				case 1:
				arjun();
				break;
				case 2:
				AAA();
				break;
			}
		}
		else
		{
			System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Movie "+RESET+BLINK+"  -------------"+RESET);
			System.out.println();
			System.out.println("-->  press 1 for "+REDBRI+"Salar movie"+RESET);
			System.out.println("-->  press 2 for "+REDBRI+"Brelin moive"+RESET);
			System.out.println("-->  press 3 for "+REDBRI+"Pk moive"+RESET);
			System.out.println();
			int x;
			while(true)
			try
			{
				x = GenerateOTP.sc.nextInt();
				break;
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
				GenerateOTP.sc.nextLine();
			}
			switch(x)
			{
				case 1:
				salar();
				break;
				case 2:
				berlin();
				break;
				case 3:
				pk();
			}
		}
	}
	static void berlin()
	{
		System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Date "+RESET+BLINK+"  -------------"+RESET);
		obj.date();
		System.out.println();
		System.out.println("-->  Press 1 proceed To "+CYAN+"Selected movie"+RESET);
		System.out.println("-->  Press Any Key Back To "+CYAN+"Movies"+RESET);
		System.out.println();
		int n;
		while(true)
		try
		{
			n = GenerateOTP.sc.nextInt();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
			GenerateOTP.sc.nextLine();
		}
		if(n==1)
		{
			System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Theater "+RESET+BLINK+"  -------------"+RESET);
			System.out.println();
			System.out.println("-->  press 1 for "+REDBRI+"Arjun theater"+RESET);
			System.out.println("-->  press Any Key Back To "+REDBRI+"AAA   theater"+RESET);
			System.out.println();
			int a =sc.nextInt();
			switch(a)
			{
				case 1:
				arjun();
				break;
				case 2:
				AAA();
				break;
			}
		}
		else
		{
			System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Movie "+RESET+BLINK+"  -------------"+RESET);
			System.out.println();
			System.out.println("-->  press 1 for "+REDBRI+"Salar movie"+RESET);
			System.out.println("-->  press 2 for "+REDBRI+"Brelin moive"+RESET);
			System.out.println("-->  press 3 for "+REDBRI+"Pk moive"+RESET);
			System.out.println();
			int x =sc.nextInt();
			switch(x)
			{
				case 1:
				salar();
				break;
				case 2:
				berlin();
				break;
				case 3:
				pk();
			}
		}
	}
	static void pk()
	{
		
		System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Date "+RESET+BLINK+"  -------------"+RESET);
		obj.date();
		System.out.println();
		System.out.println("-->  Press 1 proceed To "+CYAN+"Selected movie"+RESET);
		System.out.println("-->  Press Any Key Back To "+CYAN+"Movies"+RESET);
		System.out.println();
		int n;
		while(true)
		try
		{
			n = GenerateOTP.sc.nextInt();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
			GenerateOTP.sc.nextLine();
		}
		if(n==1)
		{
			System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Theater "+RESET+BLINK+"  -------------"+RESET);
			System.out.println();
			System.out.println("-->  press 1 for "+REDBRI+"Arjun theater"+RESET);
			System.out.println("-->  press Any Key Back To "+REDBRI+"AAA   theater"+RESET);
			System.out.println();
			int a =sc.nextInt();
			switch(a)
			{
				case 1:
				arjun();
				break;
				case 2:
				AAA();
				break;
			}
		}
		else
		{
			System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Movie "+RESET+BLINK+"  -------------"+RESET);
			System.out.println();
			System.out.println("-->  press 1 for "+REDBRI+"Salar movie"+RESET);
			System.out.println("-->  press 2 for "+REDBRI+"Brelin moive"+RESET);
			System.out.println("-->  press 3 for "+REDBRI+"Pk moive"+RESET);
			System.out.println();
			int x;
			while(true)
			try
			{
				x = GenerateOTP.sc.nextInt();
				break;
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
				GenerateOTP.sc.nextLine();
			}
			switch(x)
			{
				case 1:
				salar();
				break;
				case 2:
				berlin();
				break;
				case 3:
				pk();
			}
		}
		
	}
    void date()
   	{
    	System.out.print("\n-->  Enter a date in the format"+BLINK+" dd(01-30)"+RESET+" Or Enter 31.Back: ");
    	String date;
		while(true)
		try
		{
			date = GenerateOTP.sc.next();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Date Format!"+RESET);
			GenerateOTP.sc.nextLine();
		}
		switch(date)
		{
			case "01":
				this.date1=date;
				month();
				break;
			case "02":
				this.date1=date;
				month();
				break;
			case "03":
				this.date1=date;
				month();
				break;
			case "04":
				this.date1=date;
				month();
				break;
			case "05":
				this.date1=date;
				month();
				break;
			case "06":
				this.date1=date;
				month();
				break;
			case "07":
				this.date1=date;
				month();
				break;
			case "08":
				this.date1=date;
				month();
				break;
			case "09":
				this.date1=date;
				month();
				break;
			case "10":
				this.date1=date;
				month();
				break;
			case "11":
				this.date1=date;
				month();
				break;
			case "12":
				this.date1=date;
				month();
				break;
			case "13":
				this.date1=date;
				month();
				break;
			case "14":
				this.date1=date;
				month();
				break;
			case "15":
				this.date1=date;
				month();
				break;
			case "16":
				this.date1=date;
				month();
				break;
			case "17":
				this.date1=date;
				month();
				break;
			case "18":
				this.date1=date;
				month();
				break;
			case "19":
				this.date1=date;
				month();
				break;
			case "20":
				this.date1=date;
				month();
				break;
			case "21":
				this.date1=date;
				month();
				break;
			case "22":
				this.date1=date;
				month();
				break;
			case "23":
				this.date1=date;
				month();
				break;
			case "24":
				this.date1=date;
				month();
				break;
			case "25":
				this.date1=date;
				month();
				break;
			case "26":
				this.date1=date;
				month();
				break;
			case "27":
				this.date1=date;
				month();
				break;
			case "28":
				this.date1=date;
				month();
				break;
			case "29":
				this.date1=date;
				month();
				break;
			case "30":
				this.date1=date;
				month();
				break;
			case "31":
				this.date1=date;
				month();
				break;
			default:
				System.out.println(RED+"\n		Invalid Date"+RESET);
				date();
		}
   	}
	void month()
	{
		System.out.print("\n-->  Enter a Month in the format"+BLINK+" MM(01-12)"+RESET+" Or Enter 13.Back:");
		String mon;
		while(true)
		try
		{
			mon = GenerateOTP.sc.next();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
			GenerateOTP.sc.nextLine();
		}
		switch(mon)
		{
			case "01":
				this.month1=mon;
				
				break;
			case "02":
				this.month1=mon;
				
				break;
			case "03":
				this.month1=mon;
				break;
			case "04":
				this.month1=mon;
				break;
			case "05":
				this.month1=mon;

				break;
			case "06":
				this.month1=mon;
				break;
			case "07":
				this.month1=mon;
				break;
			case "08":
				this.month1=mon;
				break;
			case "09":
				this.month1=mon;
				break;
			case "10":
				this.month1=mon;
				break;
			case "11":
				this.month1=mon;
				break;
			case "12":
				this.month1=mon;
				break;
			default:
				System.out.println(RED+"\n		Invalid Month"+RESET);
				month();
		}
	}
	static void arjun()
	{
		System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Timings "+RESET+BLINK+"  -------------"+RESET);
		System.out.println();
		System.out.println("-->  press 1 for "+GREEN+BLINK+"11.00 Am"+RESET+" show");
		System.out.println("-->  press 2 for "+GREEN+BLINK+"02.00 pm"+RESET+" show");
		System.out.println("-->  press 3 for "+GREEN+BLINK+"06.00 pm"+RESET+" show");
		System.out.println("-->  press 4 for "+GREEN+BLINK+"09.00 pm"+RESET+" show");
		System.out.println();
		int n=sc.nextInt();
		System.out.println("Rs.200 for "+CYAN+"Gold"+RESET);
		System.out.println("Rs.150 for "+CYAN+"Executive"+RESET);
		System.out.println();
		System.out.println(" "+whitebg+black+"    Please Enter Amount    "+RESET);
		System.out.println();
		int rate;
		while(true)
		try
		{
			rate = GenerateOTP.sc.nextInt();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Rate!"+RESET);
			GenerateOTP.sc.nextLine();
		}
		if(rate==200 || rate==150)
		{
			System.out.println(RED+"Number of seats enter less than 30"+RESET);
			System.out.println();
			int seats=sc.nextInt();
			if(seats>0 || seats<=30)
			{
				payment(rate , seats);
				System.out.println(seats+" Seats  are booked this date "+date1+"/"+month1);
			}
			else
			{
				System.out.println(RED+"InValid seats selection"+RESET);
				arjun();
			}
		}
		else
		{
			System.out.println(RED+"Invalid Rate"+RESET);
			arjun();
		}
	}
	static void AAA()
	{
		System.out.println(BLINK+"-------------  "+RESET+whitebg+black+" Select Timings "+RESET+BLINK+"  -------------"+RESET);
		System.out.println();
		System.out.println("-->  press 1 for "+GREEN+BLINK+"11.00 Am"+RESET+" show");
		System.out.println("-->  press 2 for "+GREEN+BLINK+"02.00 pm"+RESET+" show");
		System.out.println("-->  press 3 for "+GREEN+BLINK+"06.00 pm"+RESET+" show");
		System.out.println("-->  press 4 for "+GREEN+BLINK+"09.00 pm"+RESET+" show");
		System.out.println();
		int n=sc.nextInt();
		System.out.println("Rs.200 for "+CYAN+"Gold"+RESET);
		System.out.println("Rs.150 for "+CYAN+"Executive"+RESET);
		System.out.println();
		System.out.println(" "+whitebg+black+"    Please Enter Amount    "+RESET);
		System.out.println();
		int rate;
		while(true)
		try
		{
			rate = GenerateOTP.sc.nextInt();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Rate !"+RESET);
			GenerateOTP.sc.nextLine();
		}
		if(rate==200 || rate==150)
		{
			System.out.println(RED+"Number of seats enter less than 30"+RESET);
			System.out.println();
			int seats=sc.nextInt();
			if(seats>0 || seats<=30)
			{
				payment(rate , seats);
				System.out.println(seats+" Seats  are booked this date "+date1+"/"+month1);
			}
			else
			{
				System.out.println(RED+"InValid seats selection"+RESET);
				AAA();
			}
		}
		else
		{
			System.out.println(RED+"Invalid Rate"+RESET);
			AAA();
		}
	}
	static void payment(int rate ,int seats)
	{
		System.out.println("ENTER 1 TO"+GREEN+BLINK+" Proceed to PAY"+RESET);
		System.out.println("ENTER Any Key TO"+RED+BLINK+" CANCEL"+RESET);
		System.out.println();
		int x;
		while(true)
		try
		{
			x = GenerateOTP.sc.nextInt();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
			GenerateOTP.sc.nextLine();
		}
		if(x==1)
		{
		  double Amount=rate*seats;
		  obj.withdraw(Amount);
		}
		else
		{
		  locationSelect();
		}
	}
}

class history extends movie 
 {
	 static balance bh=new balance();
	void history()
	{
			System.out.println(bh.success);
		
	} 

}      
 

class test
{
	static movie mov = new movie();
	static history his=new history();

			static String bgred="\u001B[41m";
			static String bgblue="\u001B[44m";
        		static String bgmegenta="\u001B[45";
        		static String bggreen="\u001B[42m";
			static String bgyellow="\u001B[43m";
    			static String SET_BOLD_TEXT = "\033[0;1m";
			static String REDBRI= "\033[1;91m";
			static String increaseFontSize = "\033[1;31m";
			static String resetFormatting = "\033[0m";
			static String BOLD="\u001B[1m";
			static String BLINK ="\u001B[5m";
			static String whitebg="\u001B[47m";
			static String black ="\u001B[30m";
			static String magent = "\u001B[95m";
			static final String ital = "\u001B[3m";
			static String ul = "\u001B[4m";
			static String skblue = "\u001B[36m";
			static String RESET = "\u001B[0m";
        		static String RED = "\u001B[31m";
        		static String GREEN = "\u001B[32m";
        		static String YELLOW = "\u001B[33m";
			static String BLUE="\u001B[34m";
			static String PURPLE="\u001B[35m";
			static String WHITE="\u001B[37m";
			static String CYAN="\u001B[36m";
	static void module()
	{
		System.out.println("                            ");
		System.out.println(" "+whitebg+black+"          HOME PAGE         "+RESET);
		System.out.println("                            ");
		System.out.println("----->  Enter 1 for"+ REDBRI+" Movie booking.. "+RESET);
		System.out.println("----->  Enter 2 for"+ REDBRI+" Mobile Recharge.."+ RESET);
		System.out.println("----->  Enter 3 for"+ REDBRI+" Transfer Money.."+RESET);
		System.out.println("----->  Enter 4 for"+ REDBRI+" Balance Enquiry.."+RESET);
		System.out.println("----->  Enter 5 for"+ REDBRI+" Change Your PIN.."+RESET);
		System.out.println("----->  Enter 6 for"+ REDBRI+" Payment History.."+RESET);
		System.out.println();
		int a;
		while(true)
		try
		{
			a = GenerateOTP.sc.nextInt();
			break;
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println(REDBRI+"Enter Valid  Number!"+RESET);
			GenerateOTP.sc.nextLine();
		}
		switch(a)
		{
			case 1:
			System.out.println(" <<<<<     "+bgblue+BLINK+ " Welcome to Movie booking " +RESET+"     >>>>>");
			System.out.println();
			mov.locationSelect();
			module();
			break;
			case 2 :
			System.out.println(" <<<<<     "+bgblue+BLINK+ " Welcome to Mobile Recharge " +RESET+"     >>>>>");
			System.out.println();
			System.out.println(RED+"You Have Only 4 attempts To Enter Mobile Number"+RESET);
			mov.number();
			module();
			break;
			case 3:
			System.out.println(" <<<<<     "+bgblue+BLINK+ " Welcome to Transfer Money " +RESET+"     >>>>>");
			System.out.println();
			System.out.println("YOU HAVE ONLY 3 ATTEMPTS TO ENTER VALID NUMBER");
			System.out.println();
			mov.NumberChecking();
			module();
			break;
			case 4:
			System.out.println(" <<<<<     "+bgblue+BLINK+ " Welcome to Balance Enquiry " +RESET+"     >>>>>");
			System.out.println();
			mov.balanceEnquiry();
			module();
			break;
			case 5:
			System.out.println(" <<<<<     "+bgblue+BLINK+ " Welcome to Change Your PIN " +RESET+"     >>>>>");
			System.out.println();
			mov.method();
			module();
			break;
			case 6:
			System.out.println(" <<<<<     "+bgblue+BLINK+ " Welcome to Payment HistorY " +RESET+"     >>>>>");
			System.out.println();
			his.history();
			module();
			break;
			default:
			System.out.println(RED+"Invalid Option"+RESET);
			System.out.println("Please Re-enter your Option");
			module();
		}
	}
	public static void main(String [] args)
	{
		
		System.out.println("             **********************************************************************************");
		System.out.println("");
		System.out.println(increaseFontSize+SET_BOLD_TEXT+BOLD+ital+BLINK+CYAN+"               ****   *****  *****  ***** *****     *      *         *****    *    *    *            "+RESET);		
		System.out.println(increaseFontSize+SET_BOLD_TEXT+BOLD+ital+BLINK+CYAN+"               *   *    *    *        *     *      * *     *         *   *   * *    *  *             "+RESET);
		System.out.println(increaseFontSize+SET_BOLD_TEXT+BOLD+ital+BLINK+CYAN+"               *   *    *    *  **    *     *     * * *    *         *****  * * *     *              "+RESET);
		System.out.println(increaseFontSize+SET_BOLD_TEXT+BOLD+ital+BLINK+CYAN+"               *   *    *    *   *    *     *    *     *   *         *     *     *    *              "+RESET);
		System.out.println(increaseFontSize+SET_BOLD_TEXT+BOLD+ital+BLINK+CYAN+"               ****   *****  *****  *****   *   *       *  ******    *    *       *   *              "+RESET);
		System.out.println(" ");
	    System.out.println("            ***********************************************************************************");

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("                           <<<<<     "+bgblue+" LOGIN to GET acceSs"+BLINK+ " DIGITAL PaY " +RESET+"     >>>>>                            ");
		System.out.println();
		System.out.println("                                                                                     ");
		mov.mobile();
		module();
	}
}
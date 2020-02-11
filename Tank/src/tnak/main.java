package tnak;

import java.io.IOException;

import tnakClient.jpanel;



public class main 
{
	public static void main(String[] args)  {
	//jpanel j=new jpanel();	
	int port = args.length==1?
			Integer.parseInt(args[0]): 1234;
			try{
				 new serverCor(port);
				 System.out.println(" c demaré !!");
				 
			}catch(IOException e){
				System.out.println("Error during initialisation:" +e.toString());
			}
	}
}

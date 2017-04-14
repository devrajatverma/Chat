package Client;

import java.net.*;
import java.io.*;
import java.util.Scanner;
class Client
{
public static void main(String arr[])
{
try
{
//A Socket object is created for the client.
//When a Socket object is created, a connection request
//is sent to the server. At the time of Socket creation
//Server host and port no need to be specified.
System.out.println("Client started, sending connection request...");
Socket socket=new Socket("localhost",5000);
System.out.println("Connection completed.");
//Obtaining OutputStream of the socket
OutputStream os=socket.getOutputStream();
//To write text messages, output stream is wrapped in
//PrintStream so that println() method can be used.
PrintStream ps=new PrintStream(os);

//Stream to read user input from keyboard
Scanner in=new Scanner(System.in);
//variable to control the execution of the loop.
boolean flag=true;
while(flag)
{
System.out.println("1. Text Message");
System.out.println("2. File");
System.out.println("3. Exit");
System.out.println("Enter Your Choice:");
int choice=in.nextInt();
in.nextLine(); //newline character which is left in the
//buffer after the integer is read, is removed.
String msg=null;
switch(choice)
{
case 1:
//A message is read from the keyboard
System.out.println("Enter Message:");
msg=in.nextLine();
//Message is written to the socket output stream
ps.println(msg);
ps.flush();
break;
case 2:
//File Name is read from the user
System.out.println("Enter File Name:");
String fn=in.nextLine();
//A FileInputStream is created for the file
FileInputStream fis=new FileInputStream(fn);
//Size of the file is obtained.
int size=fis.available();
//File Name and its size are sent on the server as message
msg=fn+"#"+size;
//The message is written to the server
ps.println(msg);
ps.flush();
//file contents are written in the block of 65535 bytes.
int sent=0; //variable to track how many bytes are sent
while(sent <size)
{
//A byte array of size 10000 is created
byte b[]=new byte[10000];
//bytes are read into the array
int s=fis.read(b);
sent=sent+s;
System.out.println(s+" bytes are written, total "+sent
+" bytes are sent."); 
//bytes are sent to the server
os.write(b);
os.flush();
}
//File stream is closed.
fis.close();
System.out.println("Successfully sent.");
break;
case 3:
flag=false; //loop will be terminated.
//exit is sent as message on the server so that server
//can terminate.
ps.println("exit");
ps.flush();
break;
default:
System.out.println("Invalid Choice");
}
}
System.out.println("Closing connection...");
Thread.sleep(1000);
socket.close();
System.out.println("Connection is closed.");
}catch(Exception e)
{
System.out.println(e);
}
}
}

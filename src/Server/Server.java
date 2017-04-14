package Server;

import java.net.*;
import java.io.*;

class Server
{
public static void main(String arr[])
{
try
{
//A ServerSocket object is created. ServerSocket object
//represents TCP/IP Server. The server is configured
//to receive request on a specific port. In this example
//We have used port 5000.
ServerSocket server=new ServerSocket(5000);
System.out.println("Server started, listening requests on port 5000...");
//Server object is asked to start listening request by 
//invoking its accept() method. This method will complete
//when a request is received for the connection
Socket socket=server.accept();
System.out.println("Request received, connection completed.");
System.out.println("Waiting for client's messages...");
//Stream to read bytes from the socket is obtained
InputStream is=socket.getInputStream();
BufferedInputStream bis=new BufferedInputStream(is);
//This stream is wrapped in BufferedReader so that 
//text messages can be read line by line
BufferedReader br=new BufferedReader(new InputStreamReader(is));
while(true)
{
//Reading a message from the socket.
String msg=br.readLine();
//if the message is exit, loop is breaked.
if(msg.equalsIgnoreCase("exit"))
break;
else if(msg.indexOf('#') >0)
{
//Is a file, Name and size are separated.
String fname=msg.substring(0,msg.indexOf('#'));
int size=Integer.parseInt(msg.substring(msg.indexOf('#')+1,msg.length()));
System.out.println("File Name: "+fname);
System.out.println("File Size: "+size);
//A FileOutputStream is created for the file
FileOutputStream fos=new FileOutputStream(fname);
int received=0; //variable to track how many bytes are read
while(received<size)
{
//A byte array of 10000 is created.
byte b[]=new byte[10000];
int r=bis.read(b);
received=received+r;
System.out.println("Received :"+r+" bytes, total "+received+" bytes are read.");
//Bytes which are read are saved in the file.
fos.write(b);
}
//file is closed
fos.close();
System.out.println("File received."); 
}
else
{
//The message is printed on the console.
System.out.println("Received: "+msg);
}
}
System.out.println("closing connection...");

Thread.sleep(1000);
server.close();
socket.close();
System.out.println("Connection is closed.");
}catch(Exception e)
{
System.out.println(e);
}
}
}

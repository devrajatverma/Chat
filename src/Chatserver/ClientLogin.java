package Chatserver;


import java.awt.*;
import java.awt.event.*;

class ClientLogin extends Frame implements ActionListener
{
Button a,b;
ClientThread th;
TextField one;
public ClientLogin(String t)
{
super(t);
a=new Button("Sign in");
b=new Button("Sign out");
one = new TextField();
Label x=new Label("User Name");
setLayout(null);
add(x);
add(one);
add(a);
add(b);
a.addActionListener(this);
b.addActionListener(this);
x.setBounds(10,50,80,30);
one.setBounds(115,50,120,30);
a.setBounds(25,100,80,30);
b.setBounds(125,100,80,30);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e)
{
//code to disconnect will be added.
System.exit(0);
}
});
}
public void actionPerformed(ActionEvent e)
{
String s=e.getActionCommand();
if (s.equals("Sign in"))
{
String uname=one.getText();
th=new ClientThread(uname);

}
else
{
th.disconnect();
}
}
public static void main(String arr[])
{
ClientLogin w = new ClientLogin("Open Chat");
w.setSize(255,250);
w.setVisible(true);

}

}



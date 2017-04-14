package ui;

import javax.swing.*;

import dao.GroupDao;
import entities.Group;

import java.awt.*;
import java.awt.event.*;

public class GroupSaver extends JFrame 
implements ActionListener
{
	JTextField txt1,txt2;
	JButton btn;
	public GroupSaver()
	{
		setLayout(new FlowLayout());
		add(new JLabel("Group Name:"));
		add(txt1=new JTextField(20));
		add(new JLabel("Description:"));
		add(txt2=new JTextField(20));
		add(btn=new JButton("Save"));
		btn.addActionListener(this);
		setTitle("Group Saver");
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
public void actionPerformed(ActionEvent e)
{
	Group g=new Group();
	g.setName(txt1.getText());
	g.setDescription(txt2.getText());
	System.out.println("Saving...");
	GroupDao dao=new GroupDao();
	try
	{
	dao.save(g);
	System.out.println("Saved.");
	}catch(Exception ex)
	{
		System.out.println(ex);
	}
}
	public static void main(String[] args) {
		new GroupSaver();

	}

}

package test;

import java.util.Scanner;

import dao.GroupDao;
import entities.Group;

public class GroupUpdater {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Group Id:");
		int id=in.nextInt(); 
		in.nextLine(); //to remove \n
		System.out.println("Loading group...");
		GroupDao dao=new GroupDao();
		try
		{
		Group g=dao.getById(id);
		System.out.println("Current Name: "+g.getName());
		System.out.println("Current Desc: "+g.getDescription());
		System.out.println("Enter New Name:");
		g.setName(in.nextLine());
		System.out.println("Enter New Description:");
		g.setDescription(in.nextLine());
		System.out.println("Updating...");
		dao.update(g);
		System.out.println("Updated.");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

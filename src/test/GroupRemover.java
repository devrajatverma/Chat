package test;

import java.util.Scanner;

import dao.GroupDao;
import entities.Group;

public class GroupRemover {

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
		System.out.println("Group Details:");
		System.out.println(g.getName()+"\t"
		+g.getDescription());
		System.out.println("Want to delete it, yes/no?");
		String ans=in.nextLine();
		if(ans.equalsIgnoreCase("yes"))
		{	
		System.out.println("Deleting...");
		dao.remove(g.getId());
		System.out.println("Deleted.");
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

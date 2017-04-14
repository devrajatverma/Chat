package test;

import java.util.Scanner;

import dao.GroupDao;
import entities.Group;

public class GroupSaver {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Group g=new Group();
		System.out.println("Enter group Name:");
		g.setName(in.nextLine());
		System.out.println("Enter Description:");
		g.setDescription(in.nextLine());
		System.out.println("Saving...");
		GroupDao dao=new GroupDao();
		try
		{
		dao.save(g);
		System.out.println("Saved.");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

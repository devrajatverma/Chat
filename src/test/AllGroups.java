package test;

import java.util.Iterator;
import java.util.List;

import dao.GroupDao;
import entities.Group;

public class AllGroups {

	public static void main(String[] args) {
		try
		{
			System.out.println("Loading all groups...");
			GroupDao dao=new GroupDao();
			List<Group> list=dao.getAll();
			System.out.println("Following Groups are loaded:");
			Iterator<Group> itr=list.iterator();
			while(itr.hasNext())
			{
				Group g=itr.next();
				System.out.println(g.getId()+"\t"+g.getName()
				+"\t"+g.getDescription());
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}

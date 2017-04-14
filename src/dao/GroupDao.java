package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entities.Group;

public class GroupDao extends AbstractDao {

	
	//To save a group
	public void save(Group g) throws Exception
	{
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement(
	"insert into GroupMaster (groupName,description) values(?,?)");
		stmt.setString(1, g.getName());
		stmt.setString(2, g.getDescription());
		stmt.executeUpdate();
		con.close();
	}
	//To update a group
		public void update(Group g) throws Exception
		{
			Connection con=getConnection();
			PreparedStatement stmt=con.prepareStatement(
"update GroupMaster set groupName=?, description=? where id=?");
			stmt.setString(1, g.getName());
			stmt.setString(2, g.getDescription());
			stmt.setInt(3, g.getId());
			stmt.executeUpdate();
			con.close();
		}
		//To remove a group
	public void remove(int id) throws Exception
			{
			Connection con=getConnection();
			PreparedStatement stmt=con.prepareStatement(
			"delete from GroupMaster where id=?");
					stmt.setInt(1, id);
					stmt.executeUpdate();
					con.close();
				}
	
	//To load a group using Id
	public Group getById(int id) throws Exception
			{
			Group g=null;
			Connection con=getConnection();
			PreparedStatement stmt=con.prepareStatement(
			"select * from GroupMaster where id=?");
					stmt.setInt(1, id);
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
				g=mapGroup(rset);
			con.close();
			return g;
				}
	
	//utility method to map a record to a Group object
	private Group mapGroup(ResultSet rset) throws Exception
	{
		Group g=new Group();
		g.setId(rset.getInt(1));
		g.setName(rset.getString(2));
		g.setDescription(rset.getString(3));
		return g;
	}
	
	//To load all groups
		public List<Group> getAll() throws Exception
				{
				ArrayList<Group> list=new ArrayList<Group>();
				Connection con=getConnection();
				PreparedStatement stmt=con.prepareStatement(
				"select * from GroupMaster");
					
				ResultSet rset=stmt.executeQuery();
				while(rset.next())
					list.add(mapGroup(rset));
				con.close();
				return list;
					}
	
}









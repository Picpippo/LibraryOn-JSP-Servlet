package libraryon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libraryon.form.RoleForm;
import libraryon.model.Role;
import utilities.DBUtil;

public class RoleDAO {

	/**
	 * method that shows the list of all roles
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Role> roleList() throws Exception {

		List<Role> roleList = new ArrayList();
		RoleDAO roleDAO = new RoleDAO();

		Connection conn = DBUtil.getConnection();
		String sql = "SELECT * FROM role";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				role.setId_role(rs.getLong("id_role"));
				role.setId_user(rs.getLong("id_user"));
				role.setId_profile(rs.getLong("id_profile"));

				roleList.add(role);
			}
			System.out.println(ps);
			ps.close();
			conn.close();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}

		return roleList;
	}

	/**
	 * 
	 * @param roleForm, the form where we insert the role fields
	 * @param id_user, the user id that we want to associate with the profile
	 * @throws Exception
	 */
	public static void createRole(RoleForm roleForm, Long id_user) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO role (id_user, id_profile) VALUES (?,?)";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id_user);
			ps.setLong(2, roleForm.getId_profile());

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * method that delete a role in database
	 * 
	 * @param id_role, the id of the role that we want delete
	 * @throws Exception
	 */
	public static void deleteRole(Long id_role) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "DELETE FROM role WHERE id_role = ?";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id_role);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * method that update a role in database
	 * 
	 * @param roleForm, the form where we insert the role fields
	 * @param id_role, the id of the role that we want update
	 * @throws Exception
	 */
	public static void updateRole(RoleForm roleForm, Long id_role) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE role SET id_profile = ? WHERE id_role = ?";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, roleForm.getId_profile());
			ps.setLong(2, id_role);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
}

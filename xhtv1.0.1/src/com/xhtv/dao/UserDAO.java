package com.xhtv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xhtv.entity.Liver;
import com.xhtv.entity.User;

/**
 * �û����ݿ��������
 * 
 * @author ����
 *
 */
public class UserDAO {

	private Connection conn = DBConn.getConnection();
	private User user;
	private Liver liver;

	/**
	 * �û���¼����
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            �û�����
	 * @return ����0��ʾ�˺Ų����ڣ�����1��ʾ�˺Ŵ��ڡ�����������󣬷���2��ʾ��½�ɹ�
	 */
	public int login(String username, String password) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "select pwd from user where uid = '" + username + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next())
				return 0;
			String pwd = rs.getString("pwd");
			if (pwd.equals(password))
				return 2;
			else
				return 1;
		} catch (SQLException e) {
			return -1;
		}
	}

	/**
	 * �����û�����ȡ�û�����
	 * 
	 * @param uid
	 * @return
	 */
	public User getUser(String uid) {
		try {
			user = new User();
			Statement stmt = conn.createStatement();
			String sql = "select * from user where uid = '" + uid + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				user.setUid(rs.getString("uid"));
				user.setPwd(rs.getString("pwd"));
				user.setNickname(rs.getString("nickname"));
				user.setBalance(rs.getInt("balance"));
				user.setLiver(rs.getInt("isLiver") == 1);
			}
		} catch (SQLException e) {
			return null;
		}
		return user;
	}

	/**
	 * ���ݷ���id��ȡ������Ϣ
	 * 
	 * @param roomid
	 * @return
	 */
	public Liver getLiver(int roomid) {
		try {
			user = new User();
			Statement stmt = conn.createStatement();
			String sql = "select * from liver where roomid = '" + roomid + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				liver = new Liver();
				liver.setRoomid(rs.getInt("roomid"));
				liver.setRoomtitle(rs.getString("roomtitle"));
				liver.setRoomimage(rs.getString("roomimage"));
				liver.setUid(rs.getString("uid"));
				liver.setClassification(rs.getString("classification"));
			}
		} catch (SQLException e) {
			return null;
		}
		return liver;
	}

	/**
	 * ע��
	 * 
	 * @param user
	 * @return
	 */
	public boolean doRegister(User user) {
		String sql = "insert into user values (?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUid());
			stmt.setString(2, user.getPwd());
			stmt.setString(3, user.getNickname());
			stmt.setInt(4, user.getBalance());
			stmt.setBoolean(5, user.isLiver());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ��ֵ
	 * 
	 * @param user
	 * @param money
	 * @return
	 */
	public boolean doRecharge(User user, int money) {
		String sql = "update user set balance = balance +'" + money + "' where uid = '" + user.getUid() + "'";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ��ó�ֵ��¼
	 * 
	 * @param user
	 * @return
	 */
	public List<String[]> getRechargeRecord(User user) {
		List<String[]> list = new ArrayList<>();
		String sql = "select * from recharge where uid = '" + user.getUid() + "' order by rechargedate desc";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String[] record = new String[3];
				record[0] = rs.getString("uid");
				record[1] = rs.getString("total");
				record[2] = rs.getDate("rechargedate").toString();
				list.add(record);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ��ȡ����ID
	 * 
	 * @param user
	 * @return
	 */
	public int getRoomId(User user) {
		String sql = "select roomid from liver where uid = '" + user.getUid() + "'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				return rs.getInt("roomid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @return
	 */
	public List<Liver> getAllLiver() {
		List<Liver> list = new ArrayList<>();
		String sql = "select * from liver order by roomid asc";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Liver liver = new Liver();
				liver.setRoomid(rs.getInt("roomid"));
				liver.setRoomtitle(rs.getString("roomtitle"));
				liver.setRoomimage(rs.getString("roomimage"));
				liver.setUid(rs.getString("uid"));
				liver.setClassification(rs.getString("classification"));
				list.add(liver);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	/**
	 * �޸�����
	 * 
	 * @param user
	 * @param oldpwd
	 * @param newpwd
	 * @return 0��ʾ�����쳣��1��ʾ�޸ĳɹ���2��ʾԭ�������
	 */
	public int alterpwd(User user, String oldpwd, String newpwd) {
		String query = "select pwd from user where uid = '" + user.getUid() + "'";
		String update = "update user set pwd = '" + newpwd + "' where uid = '" + user.getUid() + "'";
		System.out.println(user.getUid());
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			boolean isRight = false;
			while (rs.next()) {
				System.out.println(rs.getString("pwd"));
				if (oldpwd.equals(rs.getString("pwd"))) {
					isRight = true;
				}
			}
			if (isRight) {
				stmt.executeUpdate(update);
				return 1;
			} else {
				return 2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * �޸ķ�����Ϣ
	 * 
	 * @param liver
	 * @return 0��ʾ�����쳣��1��ʾ�޸ĳɹ�
	 */
	public int alterroom(Liver liver) {
		String sql = "update liver set roomtitle='" + liver.getRoomtitle() + "', roomimage='" + liver.getRoomimage()
				+ "',classification='" + liver.getClassification() + "' where roomid='" + liver.getRoomid() + "'";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}

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
 * 用户数据库操作对象
 * 
 * @author 先生
 *
 */
public class UserDAO {

	private Connection conn = DBConn.getConnection();
	private User user;
	private Liver liver;

	/**
	 * 用户登录处理
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            用户密码
	 * @return 返回0表示账号不存在，返回1表示账号存在、但是密码错误，返回2表示登陆成功
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
	 * 根据用户名获取用户对象
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
	 * 根据房间id获取主播信息
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
	 * 注册
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
	 * 充值
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
	 * 获得充值记录
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
	 * 获取房间ID
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
	 * 获取所有主播
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
	 * 修改密码
	 * 
	 * @param user
	 * @param oldpwd
	 * @param newpwd
	 * @return 0表示出现异常，1表示修改成功，2表示原密码错误
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
	 * 修改房间信息
	 * 
	 * @param liver
	 * @return 0表示出现异常，1表示修改成功
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

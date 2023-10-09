package Persistence;

// Persistance Logic using JDBC API
public class StudentDaoImpl implements IStudentDao {
	java.sql.Connection connection = null;
	java.sql.PreparedStatement pstmt = null;
	java.sql.ResultSet resultSet;
	DTO.Student student = null;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		String sqlQuery = "insert into student (`name`,`age`,`address`) values (?,?,?)";
		connection = JdbcUtil.JdbcUtil.getConnection();
		if (connection != null) {
			try {
				pstmt = connection.prepareStatement(sqlQuery);
				if (pstmt != null) {
					pstmt.setString(1, sname);
					pstmt.setInt(2, sage);
					pstmt.setString(3, saddress);
					int rows = pstmt.executeUpdate();
					if (rows == 1) {
						return "success";
					}
				}
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return "failure";
	}

	@Override
	public DTO.Student searchStudent(Integer sid) {
		connection = JdbcUtil.JdbcUtil.getConnection();
		try {
			if (connection != null) {
				pstmt = connection.prepareStatement("select id,name,age,address from student where id = ?");
			}
			if (pstmt != null) {
				pstmt.setInt(1, sid);
			}
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}
			/*
			 * Because ResultSet Object is not Serilizable (Not transportable over the
			 * Network)
			 * Copy the record from resultSet Objects and use Setters Methods of Student's
			 * Object
			 * and inject the values
			 */
			if (resultSet.next()) {
				// Student Object Created
				student = new DTO.Student();
				// Copy resultSet data to Student Object
				student.setSid(resultSet.getInt(1));
				student.setSname(resultSet.getString(2));
				student.setSage(resultSet.getInt(3));
				student.setSaddress(resultSet.getString(4));
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {

		connection = JdbcUtil.JdbcUtil.getConnection();
		try {
			if (connection != null)
				pstmt = connection.prepareStatement("update student set name='?',age=?,address='?'  where id=?");
				if (pstmt != null) {
					// pstmt.setInt(1, sid);
					pstmt.setString(1, sname);
					pstmt.setInt(2, sage);
					pstmt.setString(3, saddress);
					pstmt.executeUpdate();
				}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null || pstmt != null || resultSet != null) {
				try {
					connection.close();
					pstmt.close();
					resultSet.close();
				} catch (java.sql.SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "success";
	}

	@Override
	public String deleteStudent(Integer sid) {
		String sqlQuery = "delete from student where id = ?";
		connection = JdbcUtil.JdbcUtil.getConnection();

		if (connection != null) {

			try {
				pstmt = connection.prepareStatement(sqlQuery);
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
			if (pstmt != null) {
				try {
					pstmt.setInt(1, sid);
				} catch (java.sql.SQLException e) {
					e.printStackTrace();
				}
				try {
					int i = pstmt.executeUpdate();
					if (i == 1) {
						return "success";
					}
				} catch (java.sql.SQLException e) {
					e.printStackTrace();
					return "failure";
				}
			}
		}
		return "failure";
	}

}

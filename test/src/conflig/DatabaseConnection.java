package conflig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.SinhVien;

public class DatabaseConnection {
	public static void main(String[] args) {

		try {
			// Tải driver JDBCc
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// Chuỗi kết nối đến SQL Server
			String url = "jdbc:sqlserver://LAPTOP-Q3GN8B9U:1433;databaseName=QLSV;encrypt=true;trustServerCertificate=true;";
			String userName = "sa";
			String password = "123456789";

			// Kết nối đến SQL Server
			Connection connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Kết nối thành công!");
			// Truy vấn danh sách khách hàng
			String sqlSelect = "SELECT * FROM SinhVien";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);

			
			// Danh sách để lưu sinh viên
            List<SinhVien> danhSachSinhVien = new ArrayList<>();

            // Lặp qua từng dòng kết quả
            while (rs.next()) {
                SinhVien sv = new SinhVien(
                        rs.getString("MaSV"), 
                        rs.getNString("TenSV"), 
                        rs.getNString("DiaChi"), 
                        rs.getString("Phone"));
                danhSachSinhVien.add(sv);
            }

            // In danh sách sinh viên
            for (SinhVien sv : danhSachSinhVien) {
                System.out.println(sv.toString());
            }
			// In kết quả
//			while (rs.next()) {
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//				System.out.println(rs.getString(4));
//			}
			// Đóng tài nguyên
			rs.close();
			stmt.close();
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

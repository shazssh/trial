package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import constants.Constants;

// databaseに接続するためのクラス(super side)
public class DAO {
	
		// 戻り値Connectionクラス型 class Method getConnection() －接続を確立し、その接続情報を返す
		public static Connection getConnection() throws Exception {
		
		// DriverManagerクラスを使ったDB接続
		Class.forName(Constants.DRIVER_NAME);
		
		// DriverManagerを使い、Connectionを作る
		Connection con = DriverManager.getConnection(Constants.URL, Constants.USER_NAME, Constants.PASSWORD);
					
		// 接続情報を返す
		return con;			
	}

}
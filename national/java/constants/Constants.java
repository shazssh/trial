package constants;

// DriverManagerを使ったMySQL接続のための情報のクラス
public class Constants {

	// JDBCドライバのクラス名
//	final public static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final public static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	// DB接続のための文字列
	final public static String URL = "jdbc:mysql://localhost/training";
	
	// DBのユーザ名
	final public static String USER_NAME = "****";
	
	// DBのパスワード
	final public static String PASSWORD = "**********";
	
}

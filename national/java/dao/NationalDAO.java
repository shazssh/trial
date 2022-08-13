package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.National;

// Beanのオブジェクト(国の情報)を操作するためのクラス(sub side)
public class NationalDAO extends DAO {
	
		// Nationalクラス(集合)の集合(配列)を戻り値とするinstance Method search(String keyword)の写像を以下に定義する
		public List<National> search(String keyword) throws Exception {
		
		// Nationalクラスの配列変数listの参照先を、constructor ArrayList<>()による写像とする
		List<National> list = new ArrayList<>();
		
		// Connectionクラス型変数conにsuper sideのclass Method getConnection()による終集合(接続情報)を代入
		Connection con = getConnection();
		
		// PreparedStatementクラス型変数psにConnection conにおけるSQL文(EnglishName列の検索)の実行を代入
		PreparedStatement ps = con.prepareStatement("SELECT * FROM national WHERE EnglishName like ?");
		
		// ? の1番目は引数keywordの入れたものとする
		ps.setString(1, "%" + keyword + "%");
		
		// psにおけるResultSet型実行結果をrsに代入(ResultSet executeQuery())・・・検索
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {		// rs.next()==trueの限り(初期値0行目から1行進めたときに、そこに行がある限り)
			
			// Nationalクラス型変数nを生成し、参照先をNationalクラスのconstructor National()
			// －Nationalクラスのinstance variable(id,englishname,capital,ministry)を初期値に設定－とする
			National n = new National();
			
			// Nationalクラス型変数nにおいて、id,englishname,capital,ministryをそれぞれ
			// 検索から得たうち同一englishnameが存在する行の・・・
			n.setId(rs.getInt("id"));							// id列を取得して、idに設定
			
			n.setEnglishName(rs.getString("englishname"));		// EnglishName列を取得して、englishnameに設定
			
			n.setCapital(rs.getString("capital"));				// capital列を取得して、capitalに設定
			
			n.setMinistry(rs.getString("ministry"));			// ministry列を取得して、ministryに設定

			n.setMemo(rs.getString("memo"));					// memo列を取得して、memoに設定
			
			// ここでlistはArrayList<>()－つまりNationalクラス(集合)の集合の初期値を参照している
			// それにNationalクラス(集合)を加えていく－つまり検索で見つかった行が増えていく
			list.add(n);
		}
		// PreparedStatementを閉じてからConnectionを閉じる
		ps.close();
		con.close();
		
		// ループで出来上がったNationalクラスの配列変数listを返す－NationalテーブルのEnglishName列に
		// 検索値keywordと同一のものがあった場合の行を集めて集合にしたもの－
		return list;
	}
	
	// int型を戻り値とするinstance Method insert(National national)の写像を以下に定義する
	public int insert(National national) throws Exception {
		
		// Connectionクラス型変数conにsuper sideのclass Method getConnection()による終集合(接続情報)を代入
		Connection con = getConnection();
		
		// PreparedStatementクラス型変数psにConnection conにおけるSQL文(行の挿入)の実行を代入
		PreparedStatement ps = con.prepareStatement("INSERT INTO national VALUES(null, ?, ?, ?, ?)");
		
		// ? の1番目のNationalクラス型引数nationalにおいて、Nationalクラスのinstance Method getEnglishName()
		// －nationalに存在する終集合のうちenglishnameを入れる
		ps.setString(1, national.getEnglishName());
		
		// ? の2番目のNationalクラス型引数nationalにおいて、Nationalクラスのinstance Method getCapital()
		// －nationalに存在する終集合のうちcapitalを入れる
		ps.setString(2, national.getCapital());
		
		// ? の3番目のNationalクラス型引数nationalにおいて、Nationalクラスのinstance Method getMinistry()
		// －nationalに存在する終集合のうちministryを入れる		
		ps.setString(3, national.getMinistry());
		
		// ? の4番目のNationalクラス型引数nationalにおいて、Nationalクラスのinstance Method getMemo()
		// －nationalに存在する終集合のうちmemoを入れる		
		ps.setString(4, national.getMemo());
		
		// psに代入されたSQL文の実行を行い、それとともに変更された行の数をlineに代入
		int line = ps.executeUpdate();
		
		// PreparedStatementを閉じてから、Connectionを閉じる
		ps.close();
		con.close();
		
		// 変更された行の数lineを返す(このときには、変更が実行されている)
		return line;
	}
	
	// idを基準にcapital列を変更する
	// int型を戻り値とするinstance Method updateCapital(National national)の写像を以下に定義する
	public int updateCapital(National national) throws Exception {
		
		// Connectionクラス型変数conにsuper sideのclass Method getConnection()による終集合(接続情報)を代入
		Connection con = getConnection();
		
		// PreparedStatementクラス型変数psにConnection conにおけるSQL文(特定条件下におけるcapital列の変更)の実行を代入
		PreparedStatement ps = con.prepareStatement("UPDATE national SET capital = ? where id = ?");
		
		// ? の1番目のNationalクラス型引数nationalにおいて、Nationalクラスのinstance Method getCapital()
		// －nationalに存在する終集合のうちcapitalを入れる
		ps.setString(1, national.getCapital());
		
		// ? の2番目のNationalクラス型引数nationalにおいて、Nationalクラスのinstance Method getId()
		// －nationalに存在する終集合のうちidを入れる		
		ps.setInt(2, national.getId());
		
		// psに代入されたSQL文の実行を行い、それとともに変更された行の数をlineに代入
		int line = ps.executeUpdate();
		
		// PreparedStatementを閉じてから、Connectionを閉じる
		ps.close();
		con.close();
		
		// 変更された行の数lineを返す(このときには、変更が実行されている)
		return line;
	}
	
	// idを基準にministry列を変更する
	// int型を戻り値とするinstance Method updateMinistry(National national)の写像を以下に定義する
	public int updateMinistry(National national) throws Exception {
		
		// Connectionクラス型変数conにsuper sideのclass Method getConnection()による終集合(接続情報)を代入
		Connection con = getConnection();
		
		// PreparedStatementクラス型変数psにConnection conにおけるSQL文(特定条件下におけるministry列の変更)の実行を代入
		PreparedStatement ps = con.prepareStatement("UPDATE national SET ministry = ? where id = ?");
		
		// ? の1番目のNationalクラス型引数nationalにおいて、Nationalクラスのinstance Method getMinistry()
		// －nationalに存在する終集合のうちministryを入れる
		ps.setString(1, national.getMinistry());
		
		// ? の2番目のNationalクラス型引数nationalにおいて、Nationalクラスのinstance Method getId()
		// －nationalに存在する終集合のうちidを入れる	
		ps.setInt(2, national.getId());
		
		// psに代入されたSQL文の実行を行い、それとともに変更された行の数をlineに代入
		int line = ps.executeUpdate();
		
		// PreparedStatementを閉じてから、Connectionを閉じる
		ps.close();
		con.close();
		
		// 変更された行の数lineを返す(このときには、変更が実行されている)
		return line;
	}
	
	// idを基準にmemo列を変更する
	// int型を戻り値とするinstance Method updateMemo(National national)の写像を以下に定義する
	public int updateMemo(National national) throws Exception {
		
		// Connectionクラス型変数conにsuper sideのclass Method getConnection()による終集合(接続情報)を代入
		Connection con = getConnection();
		
		// PreparedStatementクラス型変数psにConnection conにおけるSQL文(特定条件下におけるmemo列の変更)の実行を代入
		PreparedStatement ps = con.prepareStatement("UPDATE national SET memo = ? where id = ?");
		
		// ? の1番目のNationalクラス型引数nationalにおいて、Nationalクラスのinstance Method getMemo()
		// －nationalに存在する終集合のうちmemoを入れる
		ps.setString(1, national.getMemo());
		
		// ? の2番目のNationalクラス型引数nationalにおいて、Nationalクラスのinstance Method getId()
		// －nationalに存在する終集合のうちidを入れる	
		ps.setInt(2, national.getId());
		
		// psに代入されたSQL文の実行を行い、それとともに変更された行の数をlineに代入
		int line = ps.executeUpdate();
		
		// PreparedStatementを閉じてから、Connectionを閉じる
		ps.close();
		con.close();
		
		// 変更された行の数lineを返す(このときには、変更が実行されている)
		return line;
	}
	
	// idを基準に行を削除する
	// int型を戻り値とするinstance Method delete(National national)の写像を以下に定義する
	public int delete(National national) throws Exception {
		
		// Connectionクラス型変数conにsuper sideのclass Method getConnection()による終集合(接続情報)を代入
		Connection con = getConnection();
		
		// PreparedStatementクラス型変数psにConnection conにおけるSQL文(特定条件下における行の削除)の実行を代入
		PreparedStatement ps = con.prepareStatement("DELETE FROM national where id = ?");
		
		// ? の1番目のNationalクラス型引数nationalにおいて、Nationalクラスのinstance Method getId()
		// －nationalに存在する終集合のうちidを入れる
		ps.setInt(1, national.getId());
		
		// psに代入されたSQL文の実行を行い、それとともに変更された行の数をlineに代入
		int line = ps.executeUpdate();
		
		// PreparedStatementを閉じてから、Connectionを閉じる
		ps.close();
		con.close();
		
		// 変更された行の数lineを返す(このときには、変更が実行されている)
		return line;
	}
	
}

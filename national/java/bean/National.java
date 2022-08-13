package bean;

// Bean － databaseのtable Nationalのオブジェクト、操作命令一覧のクラス
public class National implements java.io.Serializable {
	
	// instance variable
	private int id;
	private String englishname;
	private String capital;
	private String ministry;
	private String memo;
	
	// constructor
//	public National() {
//		// id,englishname,capital,ministry,memo・・・初期値
//	}
	
	// getter
	// instance Method
	public int getId(){
		return id;
	}
	public String getEnglishName() {
		return englishname;
	}
	public String getCapital() {
		return capital;
	}
	public String getMinistry() {
		return ministry;
	}
	public String getMemo() {
		return memo;
	}
	//
	// getter end

	// setter
	// instance Method
	public void setId(int id) {
		this.id = id;
	}
	public void setEnglishName(String englishname) {
		this.englishname = englishname;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public void setMinistry(String ministry) {
		this.ministry = ministry;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	//
	// setter end
}

package forwardToJSP_ver3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.National;
import dao.NationalDAO;
import tool.Page;

@WebServlet(urlPatterns={"/controlVer3_servlet"})
public class ControlVer3_servlet extends HttpServlet {
	
	// http://localhost:8080/creatures/controlVer3_servlet をたたいた時用
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/jsp/entranceVer3/entranceVer3.jsp").forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		Page.header(out);
		
		try {
			
			request.setCharacterEncoding("UTF-8");
			
			String strId = "";
			if (request.getParameter("id") == null) {		// name="id"があるフォームが選ばれないとき（つまりtop画面での選択のとき）
				strId = "-1";								// 文字列strIdを"-1"に変更する
			} else { 										// name="id"のvalue値が存在しているとき（つまり検索後の画面でidを入力し変更、削除を行うとき）
				strId = request.getParameter("id"); 		// 文字列strIdをname="id"があるフォームのvalue値（つまりID欄に入力された値）に書き換える
				}
			
			int id = Integer.parseInt(strId);				// 文字列strIDを整数idにする、id入力がない画面ではid=-1となる
//			out.println("id =" + id);
			String englishname = request.getParameter("englishname");
			String capital = request.getParameter("capital");
			String ministry = request.getParameter("ministry");
			String memo = request.getParameter("memo");			
			String keyword = request.getParameter("keyword");
			
			National n = new National();					// Nationalクラスのインスタンス変数を初期値に設定し、インスタンスメソッドを使えるようにする、そしてNationalクラス型変数nの参照先とする
			
			NationalDAO ndao = new NationalDAO();			// NationalDAOクラス（DAOクラスのsub）のインスタンス変数を初期値に設定し、インスタンスメソッドを使えるようにする、そしてNationalDAOクラス型変数ndaoの参照先とする

			n.setId(id);									// Nationalクラス型変数nに対してインスタンス変数を設定
			n.setEnglishName(englishname);
			n.setCapital(capital);
			n.setMinistry(ministry);
			n.setMemo(memo);

			request.setAttribute("national", n);			// name="national" object=（↑で設定した集合n） の組み合わせを設定する

			int line = -1;									// 唐突だが
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("#");		// 唐突だが発送先JSPを自身にしておく
			
			if (englishname != null && !(englishname.equals(""))) {		// つまりenglishnameが存在する（追加が選ばれる）、かつenglishnameが空白ではないとき
				
				dispatcher = request.getRequestDispatcher("/jsp/exitVer3/insertVer3_out.jsp");		// 発送先JSPの選択
				
				List<National> insertcheck = ndao.search("");			// まず全検索して
				for (National each : insertcheck) {
					if (each.getEnglishName().equals(englishname)) {	// EnglishName列にenglishname（入力値）と同じものがあれば
						dispatcher = request.getRequestDispatcher("/jsp/error/errorCapital2.jsp");			// 発送先JSPの選択
						dispatcher.forward(request, response);		// 宛先に発送
					}
					
				}

				line = ndao.insert(n);						// 追加の実行＋追加した行数の計上
//				out.println("englishnameが存在する（追加が選ばれる）、かつenglishnameが空白ではないときが選択された");
//				out.println("englishname =" + englishname);
//				out.println("keyword =" + keyword);
//				out.println("capital =" + capital);
//				out.println("ministry =" + ministry);
//				out.println("memo =" + memo);				
//				out.println("id =" + id);
			}else if (id == -1 && keyword == null){		// つまりenglishnameが選択されない（追加が選ばれない）、またはenglishnameが空白のうえときに、idが変更されてなくkeywordが存在しない（検索が選ばれない） → 即ち、top画面でenglishnameが空白で追加が選ばれるとき
				
				dispatcher = request.getRequestDispatcher("/jsp/error/errorCapital.jsp");		// 発送先JSPの選択
				dispatcher.forward(request, response);		// 宛先に発送
				
//				out.println("top画面でenglishnameが空白で追加が選ばれるときが選択された");
//				out.println("エラーページに行く処理を入れる");
			}
			
			if(keyword != null) {		// keyword == nullなら追加ボタンを押していなければ進めない
//				out.println("keyword != nullである項目（つまり検索）が選択された");
//				out.println("keyword =" + keyword);
//				out.println("englishname =" + englishname);		
//				out.println("capital =" + capital);
//				out.println("ministry =" + ministry);
//				out.println("memo =" + memo);				
//				out.println("id =" + id);
				dispatcher = request.getRequestDispatcher("/jsp/middleVer3/searchVer3_out.jsp");		// 発送先JSPの選択
				
				List<National> list = ndao.search(keyword);		// 検索の実行、Nationalクラスの集合（一つの行になる）の集合list（行列）を作る

				request.setAttribute("list", list);				// name="list" object=（↑で設定した集合list） の組み合わせを設定する 
				
				dispatcher.forward(request, response);			// 宛先に発送
			}
						
			if(id != -1 && capital != null) {		// idがある項目かつcapitalがある項目が選択されるとき（これは検索後にしかでてこない）
					
				dispatcher = request.getRequestDispatcher("/jsp/exitVer3/updateCapitalVer3_out.jsp");		// 発送先JSPの選択
			
				line = ndao.updateCapital(n);		// 更新の実行＋更新した行数の計上		
//				out.println("idがある項目かつcapitalがある項目が選択された");
//				out.println("capital =" + capital);
//				out.println("ministry =" + ministry);
//				out.println("memo =" + memo);				
//				out.println("id =" + id);
//				out.println("englishname =" + englishname);
//				out.println("keyword =" + keyword);				
			}
			if(id != -1 && ministry != null) {		// idがある項目かつministryがある項目が選択されるとき（これは検索後にしかでてこない）
				
				dispatcher = request.getRequestDispatcher("/jsp/exitVer3/updateMinistryVer3_out.jsp");		// 発送先JSPの選択
			
				line = ndao.updateMinistry(n);		// 更新の実行＋更新した行数の計上	
//				out.println("idがある項目かつministryがある項目が選択された");
//				out.println("ministry =" + ministry);
//				out.println("capital =" + capital);
//				out.println("memo =" + memo);				
//				out.println("id =" + id);
//				out.println("englishname =" + englishname);
//				out.println("keyword =" + keyword);				
			}
			if(id != -1 && memo != null) {		// idがある項目かつmemoがある項目が選択されるとき（これは検索後にしかでてこない）
				
				dispatcher = request.getRequestDispatcher("/jsp/exitVer3/updateMemoVer3_out.jsp");		// 発送先JSPの選択
			
				line = ndao.updateMemo(n);		// 更新の実行＋更新した行数の計上
//				out.println("idがある項目かつmemoがある項目が選択された");
//				out.println("memo =" + memo);		
//				out.println("capital =" + capital);
//				out.println("ministry =" + ministry);				
//				out.println("id =" + id);
//				out.println("englishname =" + englishname);
//				out.println("keyword =" + keyword);				
			}
			if(id != -1 && capital == null && ministry == null && memo == null) {		// idがある項目かつcapital,ministry,memoがない項目が選択されるとき（これは検索後にしかでてこない）
				
				dispatcher = request.getRequestDispatcher("/jsp/exit/delete_out.jsp");		// 発送先JSPの選択
			
				line = ndao.delete(n);		// 削除の実行＋削除した行数の計上
//				out.println("idがある項目かつcapital,ministry,memoがない項目が選択された");
//				out.println("id =" + id);
//				out.println("capital =" + capital);
//				out.println("ministry =" + ministry);				
//				out.println("memo =" + memo);
//				out.println("englishname =" + englishname);
//				out.println("keyword =" + keyword);
			}
			
			if (line > 0) {		
			dispatcher.forward(request, response);		// 宛先に発送
			}			

			}catch (Exception e) {
				e.printStackTrace(out);
			}
			Page.footer(out);
	}
	
}

//　課題
//　entranceのJSPを一つにまとめる → 完了(ver3)
//　Bean-Nationalクラスを使ったコードに書き換える → 完了
//　useDAOフォルダのDelete_confer.java ～ UpdateMinistry_confer.javaの6つのservletファイルはDAO,NationalDAOクラスを使う方法に変更する → DAOまで完了 → NationalDAOまで完了
//　NatioinalDAOが正常に働くことを確認する → 確認済み
//　setAttributeでrequest(session)の中にnameとobjectの組を作り、それらをexitの(一つの？)jspに発送する　→ jsp側でgetAttribute → requestを発送出来た
//　エラーページの作成、他の処理方法

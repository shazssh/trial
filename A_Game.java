package a_game;

// 以下のゲームを考える
//　次の条件を元に４つの区分いずれかに投票せよ
//
//　区分A　・・・Aの投票者数が単独で最大の場合、最終結果のCの投票者数を10％増やす
//　区分B ・・・Bの投票者数が単独で最大の場合、最終結果のCの投票者数を25％増やす
//　区分境界線 ・・・どこも変化させない
//　区分C ・・・Cの投票者数が単独で最大の場合、最終結果のCの投票者数を15％減らす
//
//　勝利条件： A,B,Cの最も投票数の多い区分に投票した者とする。
//　但し、Aの投票者数＋Bの投票者数＞Cの投票者数であれば、全員勝利とし
//　４つの区分いずれかの投票率が9％以下、もしくは61％以上であれば、全員敗北とする


// まずは、意思決定論的考察を外す
// 骨格を作成するために、まず1人でプレイする状態で考える

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/a_Game")
public class A_Game extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		// ↓ 選択されたものからname="choiceを持つタグのvalue値"A","B","Other","C"をgetし、それぞれに対して各項目の数値a,b,other,cを増やす
		
		String choice = request.getParameter("choice");
		double a, b, other, c;
		a = b = other = c = 0;
		int count = 0;
		if (choice.equals("A")) {
			a++;
		}else if (choice.equals("B")) {
			b++;
		}else if (choice.equals("Other")) {
			other++;
		}else if (choice.equals("C")) {
			c++;
		}
		count++;
		int i = count;
		out.println("<p>現在までの投票数" + i + "</p>");
		out.println("<p>【A】 : " + a + "票 ("+ 100 * a / i + "%)</p>");
		out.println("<p>【B】 : " + b + "票 ("+ 100 * b / i + "%)</p>");
		out.println("<p>区切り線 : " + other + "票 ("+ 100 * other / i + "%)</p>");
		out.println("<p>【C】 : " + c + "票 ("+ 100 * c / i + "%)</p><br>");
		
		// ↑ ここまでを複数の人間が触れるようにする
		
		
		if (a > b && a > other && a > c) {
			c *= 1.1;
		}else if (b > a && b > other && b > c) {
			c *= 1.25;
		}else if (c > a && c > b && c > other) {
			c *= 0.85;
		}
		
		String message;
		if (a <= 0.09 * i || b <= 0.09 * i || other <= 0.09 * i || c <= 0.09 * i
				|| a >= 0.61 * i || b >= 0.61 * i || other >= 0.61 * i || c >= 0.61 * i) {
			message = "All_lose";
		}else if (a + b > c) {
			message = "All_win";
		}else if (a == b && a == c) {
			if(a  >= other) {
				message = "AとBとCは同率勝利";
			}else {
				message = "勝者なし";
			}
		}else if (a == b) {
			if (a > other && a > c) {
				message = "AとBは同率勝利";
			}else if (c > a && c > other) {
				message = "Cの勝利";
			}else {
				message = "勝者なし";
			}
		}else if (b == c) {
			if (b > other && b > c) {
				message = "BとCは同率勝利";
			}else if (a > b && a > other) {
				message = "Aの勝利";
			}else {
				message = "勝者なし";
			}
		}else if (c == a) {
			if (c > other && c > b) {
				message = "AとCは同率勝利";
			}else if (b > a && b > other) {
				message = "Bの勝利";
			}else {
				message = "勝者なし";
			}
		}else if (a > b && a > other && a > c) {
			message = "Aの勝利";
		}else if (b > a && b > other && b > c) {
			message = "Bの勝利";
		}else if (c > a && c > b && c > other) {
			message = "Cの勝利";
		}else {
			message = "勝者なし";
		}
		
		
		// ↓ 総応答回数や時間制限を設けて全員の結果を出したい
		
		if (i >= 1) { 
			out.println("<p>最終結果</p>");
			out.println("<p>総投票数" + i + "</p>");
			out.println("<p>【A】 : " + a + "票 ("+ 100 * a / i + "%)</p>");
			out.println("<p>【B】 : " + b + "票 ("+ 100 * b / i + "%)</p>");
			out.println("<p>区切り線 : " + other + "票 ("+ 100 * other / i + "%)</p>");
			out.println("<p>【C】 : " + c + "票 ("+ 100 * c / i + "%)</p><br>");
			out.println("<p>" + message + "</p>");
		}			
	}

}

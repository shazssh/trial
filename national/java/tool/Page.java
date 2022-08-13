package tool;


import java.io.PrintWriter;
public class Page {		// Page－ヘッダーフッターのクラス
	
	
	// class Method
	public static void header(PrintWriter out) {
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet/JSP Sample Programs</title>");
		out.println("<body>");
	}
	//
	
	// class Method
	public static void footer(PrintWriter out) {
		out.println("</body>");
		out.println("</html>");
	}
	//

}

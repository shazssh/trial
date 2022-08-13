package method_i_create;

import java.util.Arrays;
import java.util.Scanner;

		public class SomeOfMethod {
			
		 
		// class Method putChas(char c, int n) ―文字（char c）をn回連続表示
		public static void putChars(char c, int n) {
			while (n-- > 0) {
				System.out.print(c);
			}
		}
		//
				
		// class Method max(double a, double b) ―実数a,bの小さくない方
		public static double max(double a, double b) {
			return a >= b ? b : a;
		}
		//
		
		// class Method min(double a, double b) ―実数a,bの大きくない方
		public static double min(double a, double b) {
			return a <= b ? a : b;
		}
		//
		
		// class Method gcd2(int a, int b) ―自然数a,bの最大公約数
		public static int gcd2(int a, int b) {
			int c = 10000;
			do {
				c = a % b;
				a = b;
				b = c;
			}while (c != 0);
			return a;
		}
		//
	
		// class Method gcd(int a0, int a1, int... a) ―自然数a0,a1,…の最大公約数
		public static int gcd(int a0, int a1, int... a) {
			int g = gcd2(a0,a1);
			for (int i = 0; i < a.length; i++) {	// この書き方はi=0から始めないと上手くいかない！！
				g = gcd2(g,a[i]);
			}
			return g;
		}
		//
		
		// class Method lcm2(int a, int b) ―自然数a,bの最小公倍数
		public static int lcm2(int a, int b) {
			int l = a * b / gcd2(a, b);
			return l;
		}
		//

		// class Method lcm(int a0, int a1, int... a) ―自然数a0,a1,…の最小公倍数
		public static int lcm(int a0, int a1, int... a) {
			int l = lcm2(a0,a1);
			for (int i = 0; i < a.length; i++) {	// この書き方はi=0から始めないと上手くいかない！！
				l = lcm2(l,a[i]);
			}
			return l;
		}
		//
				
		// class Method sum(double a0, double a1, double... a) ―2つ以上の実数の和
		public static double sum(double a0, double a1, double... a) {
			double sum = a0 + a1;
			for (int i = 0; i < a.length; i++) {	// この書き方はi=0から始めないと上手くいかない！！
				sum += a[i];
			}
			return sum;
		}
		//		
		
		// class Method pdt(double a0, double a1, double... a) ―2つ以上の実数の積
		public static double pdt(double a0, double a1, double... a) {
			double pdt = a0 * a1;
			for (int i = 0; i < a.length; i++) {	// この書き方はi=0から始めないと上手くいかない！！
				pdt *= a[i];
			}
			return pdt;
		}
		//
		
		// class Method power(double x, int n) ―xのn乗: ∃x∈R [0,+∞)、∃n∈Z
		public static double power(double x, int n) {
			double pwr = 1;
			int m = n < 0 ? -n : n;
			if (x != 0) {
				for (int i = 0; i < m; i++) {
					pwr *= x;
				}
			}
			double power;
			return power = n < 0 ? 1 / pwr : pwr;
		}
		//
		
		// class Method ftr(int n) ―nの階乗: ∃n∈Z [0,+∞)
		public static long ftr(int n) {
			long ftr = 1;
			if (n != 0) {
				for (int i = 1; i <= n; i++) {
					ftr *= i;
				}
			}
			return ftr;
		}
		//
		
		// class Method ftr(long n) ―nの階乗: ∃n∈Z [0,+∞)
		public static long ftr(long n) {
			long ftr = 1;
			if (n != 0) {
				for (int i = 1; i <= n; i++) {
					ftr *= i;
				}
			}
			return ftr;
		}
		//	
		
		// class Method reverseInt(int n) ―整数値を逆向きに並べた整数値: ∃n∈Z [0,+∞)
		public static int reverseInt(int n) {
			int n2 = n;				
			int y = n;		
			double z = n;	
			int i = 0;	
			do {
				n = y % 10;
				y = y / 10;
				z = z / 10;
				i++;
			}while(z >= power(10, -1));
			int y2 = n2;	
			double z2 = n2;
			int j = 0;
			int nrev = 0;		
			int pw10n2 = 0;		
			do {
				n2 = y2 % 10;
				y2 = y2 / 10;
				z2 = z2 / 10;
				pw10n2 = (int)power(10, i-1-1-j);
				nrev += n2 * pw10n2;	
				j++;
			}while (i-1-j >= 0);	
			return nrev;
		}
		//
	
		// class Method sqr(double x) ―非負実数xの平方根を求める
		public static double sqr(double x) {
			double x0 = x;
			if (x != 0) {
				for (int i = 0; i < 100; i++) {
					x = (1 / 2.0) * (x + x0 / x);
				}
			}else {
				x = x0;
			}
			return x;
		}
		//
		
		// class Method maxElement(int[] a) ―aが参照する配列の構成要素から最大のものを取り出す
		public static int maxElement(int[] a) {
			int max = a[0];
			for (int i = 0; i < a.length; i++) {
				if (a[i] >= max){
					max = a[i];
				}
			}
			return max;
		}
		//
		
		// class Method minElement(int[] a) ―aが参照する配列の構成要素から最小のものを取り出す
		public static int minElement(int[] a) {
			int min = a[0];
			for (int i = 0; i < a.length; i++) {
				if (a[i] <= min) {
					min = a[i];
				}
			}
			return min;
		}
		//
		
		// class Method aveElement(int[] a) ―aが参照する配列の構成要素の平均値を取り出す
		public static double aveElement(int [] a) {
			int sum = 0;
			for (int i = 0; i < a.length; i++) {
				sum += a[i];
			}
			double ave = (double)sum/a.length;
			return ave;
		}
		//
		
		// class Method swapElement(int[] a, int i, int j) ―aが参照する配列のa[i]とa[j]を交換
		public static void swapElement(int[] a, int i, int j) {
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
		//

		// class Method reverseElement(int[] a) ―aが参照する配列の構成要素を逆順に並べ替える
		public static void reverseElement(int[] a) {
			for (int i = 0; i < a.length/2; i++) {
				swapElement(a, i, a.length-1-i);
			}
		}
		//
		
		// class Method sumElement(int[] a) ―aが参照する配列の構成要素の和
		public static int sumElement(int[] a) {
			int sum = 0;
			for (int i = 0; i< a.length; i++) {
				sum += a[i];
			}
			return sum;
		}
		//
		
		// class Method linearSearch(int[] a, int key) ―aが参照する配列の構成要素の値でkeyと一致するものがあれば、
		//											そのうち最初のもののindexを表示させる
		//											（少なくとも1つあるかの調査、失敗で-1を表示）
		public static int linearSearch(int[] a, int key) {
			for (int i = 0; i < a.length; i++) {
				if (a[i] == key) {
					return i;
				}
			}
			return -1;
		}
		//
		
	// class Method Matrix	
		
		// class Method cloneMatrix(double[][] a) ―aが参照する行列の全構成要素をコピーした行列を作る
		public static double[][] cloneMatrix(double[][] a){
			double[][] b = new double[a.length][];
			for (int i = 0; i < a.length; i++) {
				b[i] = new double[a[i].length];
				for (int j = 0; j < b[i].length; j++) {
					b[i][j] = a[i][j];
				}
			}
			return b;
		}
		//
		
		// class Method sumElement(double[][] a) ―aが参照する行列の全構成要素の和を求める
		public static double sumElement(double[][] a) {
			int sum = 0;
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					sum += a[i][j];
				}
			}
			return sum;
		}
		//
		
		// class Method maxElement(double[][] a) ―aが参照する行列の全構成要素から最大のものを取り出す
		public static double maxElement(double[][] a) {
			double max = a[0][0];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					if (a[i][j] >= max) {
						max = a[i][j];
					}
				}
			}
			return max;
		}
		//		
		
		// class Method minElement(double[][] a) ―aが参照する行列の全構成要素から最小のものを取り出す
		public static double minElement(double[][] a) {
			double min = a[0][0];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					if (a[i][j] <= min) {
						min = a[i][j];
					}
				}
			}
			return min;
		}
		//
		
		// class Method aveElement(double[][] a) ―aが参照する行列の全構成要素の平均値を取り出す
		public static double aveElement(double[][] a) {
			int potency = 0;
			for (int i = 0; i < a.length; i++) {
				potency += a[i].length;
			}
			double ave = sumElement(a)/potency;
			return ave;
		}
		//
		
		
		// class Method sumMatrix(double[][] a, double[][] b) ―行列a(m*n)と行列b(m*n)の和を求める 
		public static double[][] sumMatrix(double[][] a, double[][] b){
			double[][] c = new double[a.length][];
			for (int i = 0; i < a.length; i++) {
				c[i] = new double[a[i].length];
				for (int j = 0; j < c[i].length; j++) {
					c[i][j] = a[i][j] + b[i][j];
				}
			}
			return c;
		}
		//	
		
		// class Method pdtMatrix(double[][] a, double[][] b) ―行列a(l*m)と行列b(m*n)の積を求める
		public static double[][] pdtMatrix(double[][] a, double[][] b){
//			double[][] c = new double[a.length][];
//			for (int i = 0; i < a.length; i++) {
//				for (int k = 0; k < a[i].length; k++) {
//				c[i] = new double[b[k].length];
//				}
//			}
//			
			// もっと簡単な宣言でいいなら
			double[][] c = new double[a.length][b[0].length];
			
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b[0].length; j++) {
					c[i][j] = 0;
					for (int k = 0; k < b.length; k++) {
						c[i][j] += a[i][k] * b[k][j];
					}
				}
			}
			return c;
		}
		//
		
		// class Method transposeMatrix(double[][] a) ―行列a(m*n)の転置行列ta(n*m)を求める
		public static double[][] transposeMatrix(double[][] a){
			double[][] ta = new double[a[0].length][a.length];
			
			for (int i = 0; i < a[0].length; i++) {
				for (int j = 0; j < a.length; j++) {
					ta[i][j] = a[j][i];
				}
			}
			return ta;
		}
		//
		
		// class Method copyMatrix(double[][] a) ―行列のコピーを作る
		public static double[][] copyMatrix(double[][] a){
			double[][] b = new double[a.length][];
			for (int i = 0; i < a.length; i++) {
				b[i] = new double[a[i].length];
				for (int j = 0; j < a[i].length; j++) {
					b[i][j] = a[i][j];
				}
			}
			return b;
		}
		//
		
		// class Method showMatrix(double[][] a) ―行列を文字列表示する
		public static void showMatrix(double[][] a) {
			for (int i = 0; i < a.length; i++) {
				System.out.println(Arrays.toString(a[i]));
			}
		}
		//
		
		//
		public static double PiByRamanujan(){		// class Method PiByRamanujan() －πの近似値（Ramanujanによる)			
				double pi0 = 0;
				for (int n = 0; n < 2; n++ ) {		//　近似精度が高く収束が極めて速いが工夫をしないとコンピュータでは活かしきれない
					pi0 += (ftr(4L * n) * (1103 + 26390L * n))/power((double)(power(4, n) * power(99, n) * ftr((long)n)), 4);
				}
				double pi1 = (2 * sqr(2) / power(99, 2)) * pi0;
				return 1 / pi1;
		}
		//
		
		//
		public static double PiByMachin(){			// class Method PiByMachin() －πの近似値(Machinによる)
				int k = 1;
				double p = 0;
				double t = 16 / 5.0;
				double last;
				
				do {
					last = p;
					p += t / k;
					t /= -239 * 239.0;
					k += 2;
				}while(p != last);					// 収束率が悪い
				return p;
		}
		//
		
		//
		public static double PiByAGM(){			// class Method PiByAGM() －πの近似値(相加相乗平均による)
				double a = 1;
				double b = 1 / sqr(2);
				double s = 1;
				double t = 4;
				
				for (int i = 0; i < 3; i++) {		// i=4に入ると大きく乖離する
					double last = a;
					a = (a + b) / 2;
					b = sqr(last * b);
					s -= t * power((a - last), 2);
					t *= 2;
				}
				return power((a + b), 2) / s;
		}
		//
		
		
		
		
		
		
		// 動作確認用
		public static void main(String[] args) {
			Scanner stdIn = new Scanner(System.in);
			
			int retry;
			roopTest:	
			do {
			retry = -1;								
				
			
			
			// 動作確認領域ここから
			
			
//			System.out.println("aとbの最大公約数gcd、最小公倍数lcmを求める");
//			System.out.println("自然数a,bをそれぞれ入力↓");
//			int a = stdIn.nextInt();
//			int b = stdIn.nextInt();
//			System.out.println(gcd(a,b));
//			System.out.println(lcm(a,b));
//			
//			System.out.println("非負実数xのn(整数)乗を求める");
//			System.out.println("x(double)とn(int)をそれぞれ入力↓");
//			double x = stdIn.nextDouble();
//			int n = stdIn.nextInt();
//			System.out.println(power(x, n));
//	
//			System.out.println("n(非負整数≦20)の階乗を求める");
//			System.out.println("n(int)を入力↓");
//			int n = stdIn.nextInt();
//			System.out.println(ftr(n));
//			
//			System.out.println("非負整数を入力してください↓");
//			int n = stdIn.nextInt();
//			System.out.println("逆に並べた数値は" + reverseInt(n));
//			
//			int[] a = {3,7,-8,10,8,7};
			
//			
//			int a = stdIn.nextInt();
//			int b = stdIn.nextInt();
//			int c = stdIn.nextInt();
//			int d = stdIn.nextInt();
//			System.out.println(lcm(a,b,c,d));
//			System.out.println(gcd(a,b,c,d));

			double[][] a = {
					{1,2},
					{3,4},
					{5,6},
			};
			double[][] b = {
					{10,-10,10,}
					};
			double[][] ta = transposeMatrix(b);
			for (int i = 0; i < ta.length; i++) {
				System.out.println(Arrays.toString(ta[i]));
			}
			
			System.out.println(PiByMachin());
			
			
			// 動作確認領域ここまで

			
			
			while(!(0 <= retry && retry <= 1)) {
				System.out.println("\nもう一度確認しますか？(Yes → y / No → n)");
				char question = stdIn.next().charAt(0);
				retry = question == 'y' ? 1 : question == 'n' ? 0 : -1; 
			}
			System.out.println();
			}while (retry == 1);
		}
}

		



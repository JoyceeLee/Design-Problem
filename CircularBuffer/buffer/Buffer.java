package buffer;
import parsers.Parser;
import commands.Command;

public class Buffer {
	static Parser pas;
	static int cap;
	static String[] buf;
	static int pta = 0, ptr = 0, pt = 0;
	static int numa = 0, numr = 0;
	
	public static void setBuf(Parser p, int c) {
		pas = p;
		cap = c;
		buf = new String[cap];
	}
	
	public static void execute(String input) {
		Command cmd = pas.getCommand(input);
		cmd.run();
	}
	
	public static void add(String str) {
		buf[pta] = str;
		if (numa>=cap && pta==pt) {
			pt++;
			if (pta==ptr) {
				ptr++;
				++numr;
			}
		}
		pta = (++numa) % cap;
	}
	
	public static String remove() {
		if (numa<=numr) {
			System.err.println("there is no element in the buffer, remove failed");
			System.exit(1);
		}
		String str = buf[ptr];
		if (str==null) return null;
		buf[ptr] = null;
		if (ptr==pt) {
			pt++;
		}
		ptr = (++numr) % cap;
		return str;
	}
	
	public static void list() {
		if (numa<=numr) {
			return;
		}
		int n = cap, iter = pt;
		while (n>0) {
			if (buf[iter]!=null) {
				System.out.println(buf[iter]);
			}
			iter = (iter+1)%cap;
			n--;
		}
	}
}

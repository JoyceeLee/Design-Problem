package buffer;

import parsers.*;

public class Main {
	public static void main(String[] args) {
		int cap = Integer.parseInt(CMDReader.readCmd().trim());
		if (cap<=0) {
			System.err.println("wrong size of the buffer");
			System.exit(1);
		}
		Buffer.setBuf(new MyParser(), cap);
		while(true) {
			String cmd = CMDReader.readCmd();
			Buffer.execute(cmd);
		}
	}
}
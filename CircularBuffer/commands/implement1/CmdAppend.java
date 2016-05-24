package commands.implement1;

import buffer.Buffer;
import buffer.CMDReader;
import commands.Command;

public class CmdAppend extends Command {
	private int linenum;
	
	public void setArg(int n) {
		this.linenum = n;
	}
	
	public void run() {
		while(linenum > 0) {
			String string = CMDReader.readCmd();
			Buffer.add(string);
			linenum--;
		}
	}
}

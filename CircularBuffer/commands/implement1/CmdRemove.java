package commands.implement1;

import buffer.Buffer;
import commands.Command;

public class CmdRemove extends Command {
	private int linenum;
	
	public void setArg(int n) {
		this.linenum = n;
	}
	
	public void run() {
		while(linenum > 0) {
			Buffer.remove();
			linenum--;
		}
	}
}

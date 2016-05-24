package commands.implement1;

import buffer.Buffer;
import commands.Command;

public class CmdList extends Command {
	public void run() {
		Buffer.list();
	}
}

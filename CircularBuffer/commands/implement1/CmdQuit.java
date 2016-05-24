package commands.implement1;

import commands.Command;

public class CmdQuit extends Command {
	public void run() {
		System.exit(1);
	}
}

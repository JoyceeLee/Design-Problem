package parsers;

import commands.*;
import commands.implement1.*;

public class MyParser extends Parser {
	String[] str;
	Command cmd;
	
	@Override
	public Command getCommand(String input) {
		validCommand(input);
		return cmd;
	}

	private void validCommand(String input) {
		str = input.trim().split(" ");
		if (str.length<1) {
			System.err.println("no command.");
			return;
		}
		switch (CmdType.stringToCommand(str[0])) {
		case A : 
			if (str.length!=2) {
				System.err.println("invalid command");
				System.exit(1);
			} else {
				int n = Integer.parseInt(str[1]);
				cmd = new CmdAppend();
				cmd.setArg(n);
				break;
			}
		case R : 
			if (str.length!=2) {
				System.err.println("invalid command");
				System.exit(1);
			} else {
				int n = Integer.parseInt(str[1]);
				cmd = new CmdRemove();
				cmd.setArg(n);
				break;
			}
		case L : 
			if (str.length!=1) {
				System.err.println("invalid command");
				System.exit(1);
			} else {
				cmd = new CmdList();
				break;
			}
		case Q : 
			if (str.length!=1) {
				System.err.println("invalid command");
				System.exit(1);
			} else {
				cmd = new CmdQuit();
				break;
			}
		default:
			System.err.println("invalid command");
			System.exit(1);
		}
	}



}

package commands.implement1;

public enum CmdType {
	A("A"), R("R"), L("L"), Q("Q");
	String val;
	
	private CmdType(String val) {
		this.val = val;
	}
	
	public static CmdType stringToCommand(String string) {
		for (CmdType ct : CmdType.values()) {
			if (ct.val.equals(string))
				return ct;
		}
		return null;
	}
}

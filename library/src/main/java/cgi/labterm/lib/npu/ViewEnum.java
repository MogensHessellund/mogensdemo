package cgi.labterm.lib.npu;

public enum ViewEnum {
	ORGANISATION("ORGANISATION"), 
	NPUBEGREB("NPUBEGREB"), 
	ELEMENTBEGREB("ELEMENTBEGREB"), 
	BRUGSNAVN("BRUGSNAVN"),
	SOEGETERM("SOEGETERM"), 
	TERMINOLOGIRELATION("TERMINOLOGIRELATION"),
	UNKNOWN("UNKNOWN"),
	;

	public final String label;

	private ViewEnum(String label) {
		this.label = label;
	}

}

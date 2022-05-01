package mogens.demo.lib.demo;

public enum ViewEnum {
	ORGANISATION("ORGANISATION"), 
	DEMOBEGREB("DEMOBEGREB"), 
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

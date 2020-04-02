package net.hawksvale.src.modulehandler;

/**
 * The name for commands, containing a String and tabbing data
 * @author LeoDog896
 *
 */

public class CommandName {

	/**
	 * The name of the command
	 */
	private String name;
	
	/**
	 * If the command should be applied on a tabbing function.
	 */
	private Boolean isForTabbing;
	
	public CommandName(String name, Boolean isForTabbing) {
		this.name = name;
		this.isForTabbing = isForTabbing;
	}
	
	public String getName() {
		return name;
	}
	
	public Boolean isForTabbing() {
		return isForTabbing;
	}
	
}

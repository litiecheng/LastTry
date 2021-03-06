package org.egordorichev.lasttry.entity.entities.ui.console;

/**
 * Represents one console command
 */
public class ConsoleCommand {
	/**
	 * The name of the command
	 */
	private String name;
	/**
	 * The hint for the command
	 */
	private String description;

	public ConsoleCommand(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**
	 * Runs the command
	 *
	 * @param console Link to the console
	 * @param args Command args
	 */
	public void run(UiConsole console, String[] args) {

	}

	/**
	 * @return Command name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return Command hint
	 */
	public String getDescription() {
		return this.description;
	}
}
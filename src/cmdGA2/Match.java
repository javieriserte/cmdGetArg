/*
 *  You may not change or alter any portion of this comment or credits
 * of supporting developers from this source code or any supporting source code
 * which is considered copyrighted (c) material of the original comment or credit authors.
 * This program is distributed WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 */

package cmdGA2;

/**
 * This class represents a match between a String and an Option object.
 * Contains information the site of the match in the String (position and
 * ending) and the option of reference.
 *
 * @author Javier Iserte <jiserte@unq.edu.ar>
 *
 */
public class Match{
	private int position;                                  // Starting position of the match
	private int ending;                                    // Ending position of the match
	private ArgOption<? extends Object> option;            // Option which is compared to String.
	private boolean matchToAlias = false;                  // The match is against to the option.name or option.alias
	/**
	 * Create a new Match instance.
	 * @param position The starting position match.
	 * @param ending The ending position of the match.
	 * @param option An instance of Option that matched.
	 * @param matchToAlias If the match is with the name or the alias of the option.
	 */
	public Match(int position, int ending, ArgOption<? extends Object> option, boolean matchToAlias) {
		super();
		this.setPosition(position);
		this.setEnding(ending);
		this.setOption(option);
		this.setMatchToAlias(matchToAlias);
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getEnding() {
		return ending;
	}
	public void setEnding(int ending) {
		this.ending = ending;
	}
	protected void setOption(ArgOption<? extends Object> option) {
		this.option = option;
	}
	public ArgOption<? extends Object> getOption() {
		return this.option;
	}
	public void setMatchToAlias(boolean matchToAlias) {
		this.matchToAlias = matchToAlias;
	}
	public boolean matchToAlias() {
		return this.matchToAlias;
	}
}

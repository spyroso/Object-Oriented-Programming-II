package package1;

public class Game {
	
	/** Declaring Instance Variables */
	private String name;
	private int numPlayers;
	private int gameTime; 

	/** Default constructor for the Game class. */
	public Game() {
		name = "NAME?";
		numPlayers = 0;
		gameTime = 0;
	}
	
	/** Parametrized constructor for the Game class.
	 * 	@param theName The name of the game. 
	 * 	@param nbPlayers The number of players. 
	 *  @param gameTime The time in minutes to play the game.
	 */
	public Game(String theName, int nbPlayers, int theGameTime) {
		this.name = theName;
		this.numPlayers = nbPlayers;
		this.gameTime = theGameTime;
	}
	
	/** Copy constructor for the Game class.
	 *  @param otherGame The Game to be copied. 
	 */
	public Game(Game otherGame) {
		name = otherGame.name;
		numPlayers = otherGame.numPlayers;
		gameTime = otherGame.gameTime;
	}
	
	/** toString method for the Game class. */
	public String toString() {
		return("\nName: " + name + "\nNumber of Players: " + numPlayers + "\nGame Time: " + gameTime + " minutes");
		//return (name + " is a Game. " + numPlayers + " can enjoy this game. The game time is " + gameTime + " minutes.");
	}

	/** Tests the equality of a Game with another Game. Returns true if both Game objects have the same name, number of players, and game time.
	 *	@return boolean True if both Game objects have the same name, number of players, and game time. False otherwise. 
	 */
	public boolean equals(Object otherGame) {
		
		//
		if (otherGame == null)
			return false;
		//
		if (getClass() != otherGame.getClass())
			return false;
		//
		Game oG = (Game) otherGame;
		return(name.equalsIgnoreCase(oG.name) && numPlayers == oG.numPlayers && gameTime == oG.gameTime);
	}
	
	
	/** accessor method to return name of Game. */
	public String getName() {
		return name;
	}

	/** accessor method to return the number of players of Game. 
	 * @return numPlayers the number of players 
	 */
	public int getNumPlayers() {
		return numPlayers;
	}

	/** accessor method to return the game time. 
	 * @return gameTime The game time
	 */
	public int getGameTime() {
		return gameTime;
	}

	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}
	
	
	
	
	
	
	
}

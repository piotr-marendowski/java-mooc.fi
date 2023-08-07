public class Team {
    private String name;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;

    public Game(String name, int gamesPlayed, int gamesWon, int gamesLost) {
        this.name = name;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.gamesPlayed = gamesPlayed;
    }

    public String getName() {
        return this.name;
    }
    public int getGames() {
        return this.gamesPlayed;
    }
    public int getWon() {
        return this.gamesWon;
    }
    public int getLost() {
        return this.gamesLost;
    }
}

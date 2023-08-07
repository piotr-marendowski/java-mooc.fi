import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("File:");
        String filename = reader.nextLine();
        System.out.println("Team:");
        String teamname = reader.nextLine();

        ArrayList<Integer> team = process(filename, teamname);

        System.out.println("Games: " + team.get(0));
        System.out.println("Wins: " + team.get(1));
        System.out.println("Losses: " + team.get(2));
    }

    public static ArrayList<Integer> process(String filename, String teamname) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);    // games played
        list.add(0);    // games won
        list.add(0);    // games lost

        try (Scanner scanner = new Scanner(Paths.get(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");
                String homeName = parts[0];
                String visitName = parts[1];
                int homePoints = Integer.valueOf(parts[2]);
                int visitPoints = Integer.valueOf(parts[3]);

                /* if home team is our team */
                if (homeName.equals(teamname)) {
                    /* add games played */
                    int gamesPlayed = list.get(0);
                    gamesPlayed++;
                    list.set(0, gamesPlayed);

                    /* if won or lost => increment */
                    if (homePoints > visitPoints) {
                        int won = list.get(1);
                        won++;
                        list.set(1, won);
                    } else {
                        int lost = list.get(2);
                        lost++;
                        list.set(2, lost);
                    }
                }
                /* if visiting team is our team */
                if (visitName.equals(teamname)) {
                    /* add games played */
                    int gamesPlayed = list.get(0);
                    gamesPlayed++;
                    list.set(0, gamesPlayed);

                    /* if won or lost => increment */
                    if (visitPoints > homePoints) {
                        int won = list.get(1);
                        won++;
                        list.set(1, won);
                    } else {
                        int lost = list.get(2);
                        lost++;
                        list.set(2, lost);
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("Reading the file " + filename + " failed");
            return list;
        }

        return list;
    }
}

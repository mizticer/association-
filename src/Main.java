import model.Player;
import model.Season;
import model.Tournament;

public class Main {
    /*
		 * Ok to masz graczy ktorzy graja w turniejach. Turniej ma nazwe i miesiac. Gracz ma imie i nazwisko. Gracz zdobywa punkty za udzial w turnieju, za 1 miejsce 100, za 2 80 ... za 5 20 za 6 i dalej nic.

			0) UZYWAJ WYJATKOW GDZIE SIE DA:)

			1) chcemy przechowywac dla kazdego gracza jakie pozycje zajmowal w jakim turnieju

			2) tak samo punkty jakie zdobyl z dnaego turnieju

			3) znajdz gracsa ktory byl najlepeszt w turniejach o danej nazwie, jesli nie ma to rzuc wyjatkiem

			4) znajdz gracza ktory zodbyl najwiecej 1 miejsc ze wszystkich turniejow

			5) znajdz gracza ktory ma najwyzsyz ranking z turrniejow ale nigdycnie mial 1 miejsca
		 */
    public static void main(String[] args) {

        Season season = new Season();

        Tournament tournament1 = new Tournament("Tournament A", "January");
        Tournament tournament2 = new Tournament("Tournament B", "February");
        season.addTournament(tournament1);
        season.addTournament(tournament2);


        Player player1 = new Player("John", "Doe");
        player1.addResult(tournament1, 1);
        player1.addResult(tournament2, 3);

        Player player2 = new Player("Jane", "Smith");
        player2.addResult(tournament1, 2);
        player2.addResult(tournament2, 1);

        Player player3 = new Player("Bob", "Johnson");
        player3.addResult(tournament1, 3);
        player3.addResult(tournament2, 2);
        String tournamentNameToTest = "Tournament A";

        Player bestPlayerInTournament = season.getBestPlayerInTournaments(tournamentNameToTest);
        System.out.println("Best player " + bestPlayerInTournament.toString() + " in" + tournamentNameToTest + ": " + bestPlayerInTournament.getTotalPoints());

        Player mostFirstPlacesPlayer = season.getPlayerWithMostFirstPlaces();
        System.out.println(mostFirstPlacesPlayer.toString() + " with most first places: " + mostFirstPlacesPlayer.getTotalPoints());

        Player mostPointsWithoutWinningPlayer = season.getPlayerWithMostPointsWithoutWinning();
        System.out.println(mostPointsWithoutWinningPlayer + " with most points without winning: " +
                mostPointsWithoutWinningPlayer.getTotalPoints());

    }
}
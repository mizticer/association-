import model.Player;
import model.Tournament;

import java.util.*;

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
        Tournament pingpong = new Tournament("PingPong", "February");
        Tournament pingpong2 = new Tournament("PingPong", "March");
        Tournament pingpong3 = new Tournament("PingPong", "March");
        Player playerOne = new Player("Sylwek", "Wojcik");
        Player playerTwo = new Player("Michal", "Wojcik");
        Player playerThree = new Player("Kacper", "Wojcik");
        pingpong.addPlayer(playerOne, 1);
        pingpong.addPlayer(playerTwo, 2);
        pingpong.addPlayer(playerThree, 3);
        pingpong2.addPlayer(playerOne, 1);
        pingpong2.addPlayer(playerTwo, 2);
        pingpong2.addPlayer(playerThree, 3);
        pingpong3.addPlayer(playerOne, 2);
        pingpong3.addPlayer(playerTwo, 1);
        pingpong3.addPlayer(playerThree, 3);

        System.out.println(findBestPlayerInTournamentsWithSpecificName(Arrays.asList(pingpong, pingpong2, pingpong3), "PingPong"));
        System.out.println(findPlayerWithTheMostWins(Arrays.asList(pingpong, pingpong2, pingpong3)));
        System.out.println(findPlayerWithTheMostPoints(Arrays.asList(pingpong, pingpong2, pingpong3)));

    }

    private static Player findBestPlayerInTournamentsWithSpecificName(List<Tournament> tournamentList, String name) {
        if (tournamentList.isEmpty()) {
            throw new IllegalStateException("Tournament list is empty");
        }
        List<Tournament> tournamentsWithSpecificName = tournamentList.stream()
                .filter(tournament -> tournament.getName().equals(name))
                .toList();
        if (tournamentsWithSpecificName.isEmpty()) {
            throw new NoSuchElementException("No tournaments with the specified name.");
        }
        Map<Player, Integer> playerWinsCount = new HashMap<>();
        for (Tournament tournament : tournamentsWithSpecificName) {
            Player winner = tournament.findBestPlayer();
            playerWinsCount.put(winner, playerWinsCount.getOrDefault(winner, 0) + 1);
        }
        return playerWinsCount.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new NoSuchElementException("No winner found."));
    }

    private static Player findPlayerWithTheMostWins(List<Tournament> tournamentList) {
        if (tournamentList.isEmpty()) {
            throw new IllegalStateException("Tournament list is empty");
        }
        Map<Player, Integer> playerWinsCount = new HashMap<>();
        for (Tournament tournament : tournamentList) {
            Player winner = tournament.findBestPlayer();
            playerWinsCount.put(winner, playerWinsCount.getOrDefault(winner, 0) + 1);
        }
        return playerWinsCount.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new NoSuchElementException("No winner found."));
    }

    private static Player findPlayerWithTheMostPoints(List<Tournament> tournamentList) {
        if (tournamentList.isEmpty()) {
            throw new IllegalStateException("Tournament list is empty");
        }
        Map<Player, Integer> playerPoints = new HashMap<>();

        for (Tournament tournament : tournamentList) {
            for (Player player : tournament.getPlayerList()) {
                if (!player.hasFirstPlace()) {
                    int tournamentPoints = player.getPointsForTournament(tournament);
                    playerPoints.put(player, playerPoints.getOrDefault(player, 0) + tournamentPoints);
                }
            }
        }
        return playerPoints.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new NoSuchElementException("No player found."));

    }
}
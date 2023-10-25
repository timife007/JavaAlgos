package linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TournamentWinner {
    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results
    ) {
        // Write your code here.
        Map<String, Integer> teams = new HashMap<>();

        for(int i = 0; i < results.size(); i++){
            if(results.get(i) == 1){
                String winner = competitions.get(i).get(0);
                Integer points = teams.getOrDefault(winner, 0) + 3;
                teams.put(winner, points);
            }else {
                String winner = competitions.get(i).get(1);
                Integer points = teams.getOrDefault(winner, 0) + 3;
                teams.put(winner, points);
            }
        }
        Integer winnerScore = 0;
        String winner = "";
        for(Map.Entry<String, Integer> i: teams.entrySet() ){
            if(i.getValue() > winnerScore){
                winnerScore = i.getValue();
                winner = i.getKey();
            }
        }
        return winner;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<String>> teamsList = new ArrayList<>();

        teamsList.add(new ArrayList<>(List.of("AlgoMasters", "FrontPage Freebirds")));
        teamsList.add(new ArrayList<>(List.of("Runtime Terror", "Static Startup")));
        teamsList.add(new ArrayList<>(List.of("WeC#", "Hypertext Assassins")));
        teamsList.add(new ArrayList<>(List.of("AlgoMasters", "WeC#")));
        teamsList.add(new ArrayList<>(List.of("Static Startup", "Hypertext Assassins")));
        teamsList.add(new ArrayList<>(List.of("Runtime Terror", "FrontPage Freebirds")));
        teamsList.add(new ArrayList<>(List.of("AlgoMasters", "Runtime Terror")));
        teamsList.add(new ArrayList<>(List.of("Hypertext Assassins", "FrontPage Freebirds")));
        teamsList.add(new ArrayList<>(List.of("Static Startup", "WeC#")));
        teamsList.add(new ArrayList<>(List.of("AlgoMasters", "Static Startup")));
        teamsList.add(new ArrayList<>(List.of("FrontPage Freebirds", "WeC#")));
        teamsList.add(new ArrayList<>(List.of("Hypertext Assassins", "Runtime Terror")));
        teamsList.add(new ArrayList<>(List.of("AlgoMasters", "Hypertext Assassins")));
        teamsList.add(new ArrayList<>(List.of("WeC#", "Runtime Terror")));
        teamsList.add(new ArrayList<>(List.of("FrontPage Freebirds", "Static Startup")));

        ArrayList<Integer> scores = new ArrayList<>(List.of(1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0));
        System.out.println(tournamentWinner(teamsList, scores));

    }
}
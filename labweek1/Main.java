import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String[] teamNames = {"Team A", "Team B", "Team C", "Team D"};
        int[] homeTeam = {0, 0, 0, 1, 1, 2};
        int[] visitorTeam = {1, 2, 3, 2, 3, 3};
        final int MATCH_COUNT = 6;        
        int[] homeGoals = new int[MATCH_COUNT];
        int[] visitorGoals = new int[MATCH_COUNT];
        int[] points = new int[4];
        int[] wins = new int[4];
        int[] draws = new int[4];
        int[] lose = new int[4];
        int[] played = new int[4];
        int[] goalsFor = new int[4];
        int[] goalsAgainst = new int[4];
        int[] average = new int[4];
        int[] order = {0, 1, 2, 3};
        
        for (int i = 0; i < MATCH_COUNT; i++){
            System.out.println("Match " + (i+1) + ": " + teamNames[homeTeam[i]] + " vs " + teamNames[visitorTeam[i]]);
        }
        
        for (int i = 0; i < MATCH_COUNT; i++){
            System.out.println("Match " + (i+1) + ": " + teamNames[homeTeam[i]] + " vs " + teamNames[visitorTeam[i]]);
            System.out.print(teamNames[homeTeam[i]] + " goals: ");
            homeGoals[i] = scan.nextInt();
            System.out.print(teamNames[visitorTeam[i]] + " goals: ");
            visitorGoals[i] = scan.nextInt();
        }
        
        for (int i = 0; i < MATCH_COUNT; i++){
            System.out.println("Match " + (i+1) + ": " + teamNames[homeTeam[i]] + " - " + homeGoals[i] + " vs " + visitorGoals[i] + " - " + teamNames[visitorTeam[i]]);
        }
        
        for (int i = 0; i < MATCH_COUNT; i++){
            int home = homeTeam[i];
            int visitor = visitorTeam[i];
            
            played[home]++;
            played[visitor]++;
 
            if (homeGoals[i] == visitorGoals[i]){
                points[home] += 1;
                points[visitor] += 1;
                draws[home]++;
                draws[visitor]++;
                
            }else if (homeGoals[i] > visitorGoals[i]){
                points[home] += 3;
                wins[home]++;
                lose[visitor]++;
            }else{
                points[visitor] += 3;
                wins[visitor]++;
                lose[home]++;
            }
            goalsFor[home] += homeGoals[i];
            goalsAgainst[home] += visitorGoals[i];
            goalsFor[visitor] += visitorGoals[i];
            goalsAgainst[visitor] += homeGoals[i];
            
            
            }
        
            for (int i = 0; i < 4; i++){
            average[i] = goalsFor[i] - goalsAgainst[i];
            }
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if (points[order[j]] < points[order[j+1]]){
                        int temp = order[j];
                        order[j] = order[j+1];
                        order[j+1] = temp;
                    } else if (points[order[j]] == points[order[j+1]] && average[order[j]] < average[order[j+1]]){
                        int temp = order[j];
                        order[j] = order[j+1];
                        order[j+1] = temp;
                    }
                }
            }
            
            System.out.println("Team       Played  Wins  Draws  Lose  Points  Average");
            for (int i = 0; i < 4; i++){
                int t = order[i];
                System.out.println(teamNames[t] + "       " + played[t] + "       " + wins[t] + "     " + draws[t] + "    " + lose[t] + "       " + points[t] + "       " + average[t]);
            }
        
            System.out.println("***CHAMPION***\n    " + teamNames[order[0]]);
    }
    
}

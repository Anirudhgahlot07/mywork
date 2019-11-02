package com.Driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.IplProblem_Apr.VOFiles.BowlersSet;
import com.IplProblem_Apr.VOFiles.DeliveriesVO;
import com.IplProblem_Apr.VOFiles.MatchIdMapping;
import com.IplProblem_Apr.VOFiles.MatchVO;
import com.IplProblem_Apr.VOFiles.SeasonsSet;
import com.IplProblem_Apr.VOFiles.TeamsSet;
import com.IplProblem_Apr.service.DeliveriesCSVReadService;
import com.IplProblem_Apr.service.MatchCSVReadService;

public class IplMainApplication {

	// prob 1
	private Set<Integer> seasonSet = new HashSet<Integer>();
	private Map<Map<String, Integer>, Integer> tossWinnerMap;
	private Set<String> teamSet = new HashSet<String>();
	private Map<String, Integer> seasonTeamMap;

	private int count;
	private int countDecision;
	private int season;
	private String team;

	/// prob2

	private Map<Integer, List<Integer>> matchIdMap = new HashMap<Integer, List<Integer>>();

	private int matchId;

	private int totalRuns;
	private int numberOfSix;
	private int numberOfFour;
	private int totalSix;
	private int totalFours;
	private float totalRunsScored;

	// prob 3

	private Set<String> bowlerSet = new HashSet<String>();
	private Map<Map<String, Integer>, Float> economyMap;
	private Map<String, Integer> seasonBowlerMap;
	private Set<Integer> oversBowledSet;
	private String bowler;
	private int overBowled;
	private int bowlerRuns;
	private float totalRunsConceded;
	private float totalOverBowled;
	private float economy;

	// prob4

	private Map<Map<String, Integer>, Float> runRateMap;
	private float netRunRate;
	private float overPlayed;
	private float totalOverPlayed;
	private float totalBattingTeamRuns;
	private float totalBowlingTeamRuns;
	private float battingTeamRate;
	private float bowlingTeamRate;

	public static void main(String[] args) throws IOException {
		MatchCSVReadService matchDataReaderService = new MatchCSVReadService();
		DeliveriesCSVReadService deliveriesDataReaderService = new DeliveriesCSVReadService();
		matchDataReaderService.readDataOfCsv();
		deliveriesDataReaderService.readDataOfCsv();

		
		System.out.println("Question 1");
		System.out.println();
		IplMainApplication main1 = new IplMainApplication();
		main1.tellTopFourTeam();

		System.out.println();
		System.out.println("Question 2");
		System.out.println();
		IplMainApplication main2 = new IplMainApplication();
		main2.tellListOfFourAndSixes();

		System.out.println();
		System.out.println("Question 3");
		System.out.println();
		IplMainApplication main3 = new IplMainApplication();
		main3.tellTopTenEcoBowler();

		System.out.println();
		System.out.println("Question 4");
		System.out.println();
		IplMainApplication main4 = new IplMainApplication();
		main4.tellHighestRunRateTeam();

	}

	// P1 here

	public void tellTopFourTeam() {

		SeasonsSet seasonsSet = new SeasonsSet();
		seasonSet = seasonsSet.getSeasons();

		TeamsSet teamsSet = new TeamsSet();
		teamSet = teamsSet.getTeams();

		Iterator<Integer> itSeason = seasonSet.iterator();

		while (itSeason.hasNext()) {
			season = itSeason.next();

			tossWinnerMap = new HashMap<Map<String, Integer>, Integer>();
			if (season == 2016 || season == 2017) {

				Iterator<String> itTeam = teamSet.iterator();

				while (itTeam.hasNext()) {
					team = itTeam.next();

					count = 0;
					countDecision = 0;

					seasonTeamMap = new HashMap<String, Integer>();
					seasonTeamMap.put(team, season);

					ListIterator<MatchVO> it = MatchCSVReadService.matchesData.listIterator();
					int i = 0;
					while (it.hasNext()) {

						if ((MatchCSVReadService.matchesData.get(i).getSeason() == season)
								&& (MatchCSVReadService.matchesData.get(i).getTossWinner().equals(team))) {

							if (MatchCSVReadService.matchesData.get(i).getTossDecision().equals("field"))
								count++;

							countDecision = count;
						}
						it.next();
						i++;

					}

					tossWinnerMap.put(seasonTeamMap, countDecision);

				}
				for (int j = 0; j < 4; j++) {

					Entry<Map<String, Integer>, Integer> firstEntry = tossWinnerMap.entrySet().iterator().next();
					Map<String, Integer> endGame = firstEntry.getKey();
					Integer endGameValue = firstEntry.getValue();

					for (Entry<Map<String, Integer>, Integer> map : tossWinnerMap.entrySet()) {
						Integer value = map.getValue();
						if (value > endGameValue) {
							endGameValue = value;
							endGame = map.getKey();
						}
					}
					String key = "";
					
					Iterator<String> itr = endGame.keySet().iterator();
					while (itr.hasNext()) {
						key = itr.next();
					}
					if (j == 0) {
						System.out.println("Year: " + endGame.get(key));
					}
					
					
					System.out
							.println("" + key + ": " + endGameValue + "");
					tossWinnerMap.remove(endGame);
				}

			}
		}
	}

	public void tellListOfFourAndSixes() {

		SeasonsSet seasonsSet = new SeasonsSet();
		seasonSet = seasonsSet.getSeasons();

		TeamsSet teamsSet = new TeamsSet();
		teamSet = teamsSet.getTeams();

		MatchIdMapping matchIdMappings = new MatchIdMapping();
		matchIdMap = matchIdMappings.getMatchIdAndSeasonMap();

		Iterator<String> itTeam = teamSet.iterator();

		while (itTeam.hasNext()) {
			String team = itTeam.next();

			Iterator<Integer> itSeason = seasonSet.iterator();

			while (itSeason.hasNext()) {
				season = itSeason.next();
				totalRuns = 0;
				numberOfSix = 0;
				numberOfFour = 0;
				totalSix = 0;
				totalFours = 0;
				totalRunsScored = 0;

				List<Integer> reqMatchIdsList = new ArrayList<Integer>();
				reqMatchIdsList = matchIdMap.get(season);

				Iterator<Integer> itMatchId = reqMatchIdsList.iterator();

				while (itMatchId.hasNext()) {

					matchId = itMatchId.next();
					ListIterator<DeliveriesVO> itDeliveries = DeliveriesCSVReadService.deliveriesData.listIterator();

					int i = 0;
					while (itDeliveries.hasNext()) {

						if (team.equals(DeliveriesCSVReadService.deliveriesData.get(i).getBattingTeam())
								&& matchId == DeliveriesCSVReadService.deliveriesData.get(i).getMatchId()) {

							totalRuns = DeliveriesCSVReadService.deliveriesData.get(i).getTotalRuns();
							totalRunsScored = totalRunsScored + totalRuns;

							if (DeliveriesCSVReadService.deliveriesData.get(i).getBatsmanRuns() == 6)
								numberOfSix++;
							totalSix = numberOfSix;

							if (DeliveriesCSVReadService.deliveriesData.get(i).getBatsmanRuns() == 4)
								numberOfFour++;
							totalFours = numberOfFour;
						}
						i++;
						itDeliveries.next();

					}

				}

				System.out.println("YEAR  " + season + "   TEAM_NAME  " + team + " FOURS_COUNT " + totalFours
						+ "  SIXES_COUNT " + totalSix + " TOTAL_SCORE " + totalRunsScored + " ");
			}

		}
	}

	// end before
	public void tellTopTenEcoBowler() {

		SeasonsSet seasonsSet = new SeasonsSet();
		seasonSet = seasonsSet.getSeasons();

		MatchIdMapping matchIdMappings = new MatchIdMapping();
		matchIdMap = matchIdMappings.getMatchIdAndSeasonMap();

		BowlersSet bowlersSet = new BowlersSet();
		bowlerSet = bowlersSet.getBowlers();

		Iterator<Integer> itSeason = seasonSet.iterator();

		while (itSeason.hasNext()) {

			season = itSeason.next();

			economyMap = new HashMap<Map<String, Integer>, Float>();

			Iterator<String> itBowler = bowlerSet.iterator();

			while (itBowler.hasNext()) {
				bowler = itBowler.next();

				overBowled = 0;
				bowlerRuns = 0;
				totalRunsConceded = 0;
				totalOverBowled = 0;

				seasonBowlerMap = new HashMap<String, Integer>();
				seasonBowlerMap.put(bowler, season);

				List<Integer> reqMatchIdsList = new ArrayList<Integer>();
				reqMatchIdsList = matchIdMap.get(season);

				Iterator<Integer> itMatchId = reqMatchIdsList.iterator();

				oversBowledSet = new HashSet<Integer>();

				while (itMatchId.hasNext()) {

					matchId = itMatchId.next();

					ListIterator<DeliveriesVO> itDeliveries = DeliveriesCSVReadService.deliveriesData.listIterator();

					int i = 0;
					while (itDeliveries.hasNext()) {

						if (matchId == DeliveriesCSVReadService.deliveriesData.get(i).getMatchId()) {

							if (bowler.equals(DeliveriesCSVReadService.deliveriesData.get(i).getBowlerName())) {

								oversBowledSet.add(DeliveriesCSVReadService.deliveriesData.get(i).getOver());
								overBowled = Collections.max(oversBowledSet);

								bowlerRuns = DeliveriesCSVReadService.deliveriesData.get(i).getTotalRuns();
								totalRunsConceded = totalRunsConceded + bowlerRuns;

							}
						}

						i++;
						itDeliveries.next();
					}

					totalOverBowled = totalOverBowled + overBowled;
				}
				if (totalOverBowled >= 10) {
					economy = (totalRunsConceded / totalOverBowled);

					economyMap.put(seasonBowlerMap, economy);

				}
			}

			for (int j = 0; j < 10; j++) {

				Entry<Map<String, Integer>, Float> firstEntry = economyMap.entrySet().iterator().next();
				Map<String, Integer> largestKey = firstEntry.getKey();
				float largestKeyValue = firstEntry.getValue();

				for (Entry<Map<String, Integer>, Float> map : economyMap.entrySet()) {
					float value = map.getValue();
					if (value > largestKeyValue) {
						largestKeyValue = value;
						largestKey = map.getKey();
					}
				}
				
				String key = "";
				
				Iterator<String> itr = largestKey.keySet().iterator();
				while (itr.hasNext()) {
					key = itr.next();
				}
				if (j == 0) {
					System.out.println("Year: " + largestKey.get(key));
				}
				
				System.out.println("" + key + ": " + largestKeyValue + "");
				economyMap.remove(largestKey);
			}

		}
	}

	public void tellHighestRunRateTeam() {

		SeasonsSet seasonsSet = new SeasonsSet();
		seasonSet = seasonsSet.getSeasons();

		TeamsSet teamsSet = new TeamsSet();
		teamSet = teamsSet.getTeams();

		MatchIdMapping matchIdMappings = new MatchIdMapping();
		matchIdMap = matchIdMappings.getMatchIdAndSeasonMap();

		Iterator<Integer> itSeason = seasonSet.iterator();

		while (itSeason.hasNext()) {
			season = itSeason.next();

			Iterator<String> itTeam = teamSet.iterator();

			runRateMap = new HashMap<Map<String, Integer>, Float>();

			while (itTeam.hasNext()) {

				team = itTeam.next();

				netRunRate = 0;
				overPlayed = 0;
				overBowled = 0;
				totalOverPlayed = 0;
				totalOverBowled = 0;
				totalBattingTeamRuns = 0;
				totalRunsScored = 0;
				totalBowlingTeamRuns = 0;
				totalRunsConceded = 0;
				battingTeamRate = 0;
				bowlingTeamRate = 0;

				seasonTeamMap = new HashMap<String, Integer>();
				seasonTeamMap.put(team, season);

				List<Integer> reqMatchIdsList = new ArrayList<Integer>();
				reqMatchIdsList = matchIdMap.get(season);

				Iterator<Integer> itMatchId = reqMatchIdsList.iterator();

				Set<Integer> oversPlayedSet = new HashSet<Integer>();
				Set<Integer> oversBowledSet = new HashSet<Integer>();

				while (itMatchId.hasNext()) {

					int matchId = itMatchId.next();

					ListIterator<DeliveriesVO> itDeliveries = DeliveriesCSVReadService.deliveriesData.listIterator();

					int i = 0;
					while (itDeliveries.hasNext()) {

						if (matchId == DeliveriesCSVReadService.deliveriesData.get(i).getMatchId()) {

							if (team.equals(DeliveriesCSVReadService.deliveriesData.get(i).getBattingTeam())) {

								totalBattingTeamRuns = DeliveriesCSVReadService.deliveriesData.get(i).getTotalRuns();
								totalRunsScored = totalRunsScored + totalBattingTeamRuns;

								oversPlayedSet.add(DeliveriesCSVReadService.deliveriesData.get(i).getOver());
								overPlayed = Collections.max(oversPlayedSet);
							}

							if (team.equals(DeliveriesCSVReadService.deliveriesData.get(i).getBowlingTeam())) {

								totalBowlingTeamRuns = DeliveriesCSVReadService.deliveriesData.get(i).getTotalRuns();
								totalRunsConceded = totalRunsConceded + totalBowlingTeamRuns;

								oversBowledSet.add(DeliveriesCSVReadService.deliveriesData.get(i).getOver());
								overBowled = Collections.max(oversBowledSet);
							}
						}
						i++;
						itDeliveries.next();
					}

					System.out.println(overPlayed);

					totalOverPlayed = totalOverPlayed + overPlayed;
					totalOverBowled = totalOverBowled + overBowled;

				}

				battingTeamRate = totalRunsScored / overPlayed;
				bowlingTeamRate = totalRunsConceded / overBowled;
				netRunRate = battingTeamRate - bowlingTeamRate;

				runRateMap.put(seasonTeamMap, netRunRate);
			}

			Entry<Map<String, Integer>, Float> firstEntry = runRateMap.entrySet().iterator().next();
			Map<String, Integer> largestKey = firstEntry.getKey();
			Float largestKeyValue = firstEntry.getValue();

			for (Entry<Map<String, Integer>, Float> map : runRateMap.entrySet()) {
				Float value = map.getValue();
				if (value > largestKeyValue) {
					largestKeyValue = value;
					largestKey = map.getKey();
				}
			}
			System.out.println("" + largestKey + " " + largestKeyValue + "");

		}
	}

}

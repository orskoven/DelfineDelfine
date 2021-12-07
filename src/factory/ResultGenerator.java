package factory;

import persons.Result;

public class ResultGenerator {
    private Result result = new Result();

    public String writeTrainingToCsv() {
        result.addMemberIdAndNameToResult();
        result.chooseDisciplineName();
        result.getTimestamp();
        result.chooseTimeResult();
        result.setTournamentNameToNull();
        result.setRankTo0();
        return result.toStringCsv();
    }

    public String writeCompetitionToCsv() {
        result.addMemberIdAndNameToResult();
        result.chooseDisciplineName();
        result.getTournamentName();
        result.chooseRank();
        result.getTimestamp();
        result.chooseTimeResult();
        return result.toStringCsv();
    }
}

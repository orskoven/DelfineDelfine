package disciplines;

import java.util.Scanner;

public class Discipline implements Comparable <Discipline> {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int id;
    private int time;
    private String location;
    private String date;
    private String tournament;
    private int rank;

    public Discipline(String name, int id, int time, String location, String date, String tournament, int rank) {
        this.name = name;
        this.id = id;
        this.time = time;
        this.location = location;
        this.date = date;
        this.tournament = tournament;
        this.rank = rank;
    }

    @Override
    public int compareTo(Discipline disciplineToCompareTo) {
        if (this.rank < disciplineToCompareTo.rank) {
            return -1;
        }
        if (this.rank > disciplineToCompareTo.rank) {
            return 1;
        } else {
            if (this.time < disciplineToCompareTo.time) {
                return -1;
            } else if (this.time > disciplineToCompareTo.time) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", tournament='" + tournament + '\'' +
                ", rank=" + rank +
                '}';
    }
    public String toStringConsole() {
        return
                "Name: " + name +
                " | ID: " + id +
                " | TIME: " + time +
                " | LOCATION: " + location  +
                " | DATE: "+ date  +
                " | TOURNAMENT: " + tournament +
                " | RANK: " + rank;
    }
    public String toStringConsoleTraining() {
        return
                "Name: " + name +
                        " | ID: " + id +
                        " | TIME: " + time +
                        " | DATE: "+ date;
    }
}

package database;

import disciplines.Discipline;
import persons.Member;

import java.io.File;
import java.util.*;

public class ReadResults {
    private Discipline discipline;
    private ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
    private ArrayList<Discipline> disciplinesTraining = new ArrayList<Discipline>();
    private String name;
    private int id;
    private int time;
    private String location;
    private String date;
    private String tournament;
    private int rank;
    private  Scanner fileReading;
    private String[] stringToArray;
    private int counter = 0;
    private int comparable = 0;
    private Discipline disciplineToCheck;
    private Discipline disciplineTop;

    public void getTop5(String filePath) {
        try {
            File file = new File(filePath);
            fileReading = new Scanner(file);
            while (fileReading.hasNextLine()) {
                stringToArray = fileReading.next().split("=");
                if (counter == 0) {
                    String[] nameArray = stringToArray[1].toString().split(" ");
                    name = "";
                    for (char i = 2; i < Arrays.toString(nameArray).length() - 2; i++) {
                        name += Arrays.toString(nameArray).charAt(i);
                    }
                }
                if (counter == 1) {
                    String[] idArray = stringToArray[1].toString().split(" ");
                    String idString = "";
                    for (char i = 1; i < Arrays.toString(idArray).length() - 1; i++) {
                        idString += Arrays.toString(idArray).charAt(i);
                    }
                    id = Integer.parseInt(idString);
                }
                if (counter == 2) {
                    String[] timeArray = stringToArray[1].toString().split(" ");
                    String timeString = "";
                    for (char i = 1; i < Arrays.toString(timeArray).length() - 1; i++) {
                        timeString += Arrays.toString(timeArray).charAt(i);
                    }
                    time = Integer.parseInt(timeString);
                }
                if (counter == 3) {
                    String[] locationArray = stringToArray[1].toString().split(" ");
                    String locationString = "";
                    for (char i = 2; i < Arrays.toString(locationArray).length() - 2; i++) {
                        locationString += Arrays.toString(locationArray).charAt(i);
                    }
                    location = locationString;
                }
                if (counter == 4) {
                    String[] dateArray = stringToArray[1].toString().split(" ");
                    String dateString = "";
                    for (char i = 2; i < Arrays.toString(dateArray).length() - 2; i++) {
                        dateString += Arrays.toString(dateArray).charAt(i);
                    }
                    date = dateString;
                }
                if (counter == 5) {
                    String[] tournamentArray = stringToArray[1].toString().split(" ");
                    String tournamentString = "";
                    for (char i = 2; i < Arrays.toString(tournamentArray).length() - 2; i++) {
                        tournamentString += Arrays.toString(tournamentArray).charAt(i);
                    }
                    tournament = tournamentString;
                }
                if (counter == 6) {
                    String[] rankArray = stringToArray[1].toString().split(" ");
                    String rankString = "";
                    for (char i = 1; i < Arrays.toString(rankArray).length() - 2; i++) {
                        rankString += Arrays.toString(rankArray).charAt(i);
                    }
                    rank = Integer.parseInt(rankString);
                    disciplines.add(new Discipline(name, id, time, location, date, tournament, rank));
                }


                counter++;
                if (counter == 7) {
                    counter = 0;
                }

            }
                Collections.sort(disciplines);
                for (int i = 0; i < disciplines.size(); i++) {
                    if (disciplines.get(i).getLocation().equals("null")) {
                        System.out.println(disciplines.get(i).toStringConsoleTraining());
                    } else {
                        System.out.println(disciplines.get(i).toStringConsole());


                }
            }
            } catch(Exception e){
                System.out.println("File couldn't read");
            }
       // disciplines = new ArrayList<Discipline>();
        }

        }





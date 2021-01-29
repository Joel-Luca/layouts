package teil1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class TeamDao {
    private static String[] teamNames = new String[]{"Team A", "Team B", "Team C", "Team D", "Team E", "Team F", "Team ZH"};
    private static String[] names = new String[]{"Grant Marshall", "Pena Valdez", "Jessica Miles", "Kerri Barber", "Natasha Gamble", "White Castaneda", "Vanessa Ryan", "Meredith Hendricks", "Carol Kelly", "Barrera Ramsey", "Julia Petersen", "Holman Valencia", "Marisa Cain", "Dejesus Norris", "Gayle Gaines", "Prince Phelps", "Keri Hudson", "Duran Clayton", "Schmidt English", "Lara Lynn", "Perry Bradley", "Randall Hurley", "Josefa Gardner", "Vega Hayes", "Fitzgerald Stanton", "Burns Marks", "Byrd Hewitt", "Guerrero Woodard", "Solis Mullen", "Lottie Stone", "Bates Dunn", "Benton Willis", "Barbara Bernard", "Megan Singleton", "Guy Mccoy", "Cline Lindsay", "Juliette Medina", "Susanna Simmons", "Mildred Clark", "Valdez Bruce", "Wilkerson Hardin", "Daisy Mcintyre", "Lucile Mccormick", "Savage Mayer", "Mann Cox", "Adrienne Miller", "Compton Dejesus", "Britney Soto", "Gill Hansen", "Russo Mccray", "Bryan Conway", "Parsons Mcfadden", "Burt Hawkins", "Sherri Stokes", "Dawn Bauer", "Pruitt Acevedo", "Reyes Riggs", "Munoz Buckley", "Middleton Sawyer", "Cathy Guzman", "Wendi Michael", "Crawford Odom", "Sophia Cochran", "Petra Brewer", "Lucy Bender", "Sadie Frazier", "Crosby Meadows", "Jean Wiley", "Blevins Fletcher", "Moses Kirk", "Berg Davidson", "Rivas Bartlett", "Flossie Holland", "Cook Rodgers", "Black Golden", "Swanson Clarke", "Lindsey Mcgowan", "Soto Edwards", "Marcia Greer", "Mendoza Carver", "Drake Morin", "Stafford Carrillo", "Janice Wilder", "Douglas Burks", "Kerry Herrera", "Ines Campbell", "Martin Peck", "Combs Juarez", "Roxie Dominguez", "Michele Henderson", "Tricia Yang", "Cohen Oneil", "Erna Alexander", "Shawna Norman", "Gail Harrington", "Sherry Hale", "Jensen Wade", "Branch Hines", "Terrell Murray", "Graciela Mitchell"};
    private static String desscription = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.";
    private static Random random = new Random();

    /**
     * Simulates access to a Database
     * @return
     */
    public static List<Team> getTeams() {
        List<Team> teamList = new ArrayList<>();


        for(String teamName : teamNames) {
            Team team = new Team(teamName);
            team.setDescription(desscription);
            int randomAmountOfTeamMembers = getRandomNumberBetweenInterval(12, 16);
            for (int i = 0; i < randomAmountOfTeamMembers; i++) {
                int randomNameIndex = random.nextInt(names.length);
                Person person = new Person(names[randomNameIndex]);
                person.setTeam(team);
                person.setDescription(desscription);
                team.addMember(person);
            }
            teamList.add(team);
        }
        teamList.sort(new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return teamList;
    }

    private static int getRandomNumberBetweenInterval(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min must be greather than Max.");
        }

        return random.nextInt((max - min) + 1) + min;
    }
}


class Team    {
    private List<Person> members = new ArrayList<>();
    private String description;
    private String name;

    public Team(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getMembers() {
        members.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        return members;
    }

    public void addMember(Person person) {
        members.add(person);
    }

    public void removeMember(Person person) {
        members.remove(person);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class Person {

    private String fullName;
    private String description;
    private Team team;

    public Person(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}



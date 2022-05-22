package NormanManley;

import java.util.Random;

public class Travelers {
    // Attributes
    private int trn;
    private String fName;
    private String lName;
    private String gender;
    private String flightNo;
    private int priority;
    private int arrival;
    private int time;


    Random rand = new Random();

    // Default constructor
    public Travelers() {
        this.trn = 0;
        this.fName = "null";
        this.lName = "null";
        this.gender = "null";
        this.flightNo = "null";
        this.priority = 0;
        this.arrival = 0;
        this.time = 0;
    }

    // Primary constructor
    public Travelers(int trn, String fName, String lName, String gender,
                     String flightNo, int priority, int arrival, int time) {
        this.trn = trn;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.flightNo = flightNo;
        this.priority = priority;
        this.arrival = arrival;
        this.time = time;
    }

    //Copy constructor
    public Travelers(Travelers p) {
        this.trn = p.trn;
        this.fName = p.fName;
        this.lName = p.lName;
        this.gender = p.gender;
        this.flightNo = p.flightNo;
        this.priority = p.priority;
        this.arrival = p.arrival;
        this.time = p.time;
    }

    // Setters and Getters
    public int getTrn() {
        return trn;
    }

    public void setTrn(int trn) {
        this.trn = trn;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getGender() {

        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public int getPriority() {

        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getArrival() {
        // generate random number from 1 to 6
        arrival = rand.nextInt(1, 7);
        return arrival;
    }

    public void setArrival(int arrival) {
        this.arrival = arrival;
    }

    public int getTime(){
        return time;
    }

    public void setTime(int time){
        this.time = time;
    }

    //Tostring method
    @Override
    public String toString() {
        return "{TRN#: " + getTrn() + ',' +
                " Fist Name: " + getfName() + ',' +
                " Last Name: " + getlName() + ',' +
                " Gender: " + getGender() + ',' +
                " Flight Number: " + getFlightNo() + ',' +
                " Priority: " + getPriority() + "}=" +
                " Arrival Time: " + getTime();
    }
}

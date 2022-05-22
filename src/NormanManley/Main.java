package NormanManley;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu();// function call
    }

    public static Random rand = new Random();// Random generator object


    public static void Menu() {
        Scanner userInput = new Scanner(System.in);
        Travelers person = new Travelers();
        LinkedList personList = new LinkedList();// create a LinkedList to store the data..
        int option = 0;
        int position1 = 0, position2 = 0, position3 = 0, position4 = 0, position5 = 0, position6 = 0;

        while (option != 5) {
            System.out.println("\n\t\t\t\t\t\tWelcome to Norman Manley Airport");
            System.out.println(" 1 * Add Passengers\n 2 * Display Passengers Info\n 3 * Generate Reports\n 4 * Remove Old passengers\n 5 * Exit");
            System.out.print("Enter Choice: ");
            option = userInput.nextInt();
            System.out.println("\n\n");

            if (1 == option) {

                String Gender = "";
                final String[] femaleFirstName = {"Lorna", "Nansi", "Annabelle", "Samira", "Sally",
                        "Remy", "Catrin", "Anastasia", "Honey", "Shayla", "Theia", "Marie", "Victoria", "Jessica", "Elaine"};
                final String[] maleFirstName = {"Aiden", "Jacob", "John", "Brian", "Thomas", "Chris", "Murat",
                        "William", "Andrew", "Saeed", "Abdullah", "Jian", "Howard", "Siamun", "Dylan"};
                final String[] lastName = {"Cummings", "Smith", "Flowers", "Foley", "Oconnell", "Lang", "Kirkpatrick", "Adkins",
                        "Booth", "Le", "Dominguez", "Mora", "Calvert", "Luna", "Park", "Strange", "Farrell", "Reyes", "Durand", "Blanc"};
                String randomStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                for (int t = 0; t < 3; ++t) {
                    System.out.println("\nTime: " + t);
                    for (int i = 0; i < person.getArrival(); i++) {
                        //Randomize the fight number for each traveler.
                        String flightNumber = generateFlightNumber(randomStr);
                        // generate random number from 1000 to 4999
                        int iD = rand.nextInt(1000, 5000);
                        // generate random number from 1 to 4
                        int num = rand.nextInt(1, 5);
                        if (num == 1 || num == 3) {
                            Gender = "male";
                        } else if (num == 2 || num == 4) {
                            Gender = "female";
                        }

                        // generate random number from 1 to 2
                        int Priority = rand.nextInt(1, 3);

                        person.setTrn(iD);

                        // generate random array first name index from 0 to 14
                        int indexName = rand.nextInt(0, 15);
                        //If the gender is male
                        if(Gender.equals("male"))
                        {
                            //Generate a male name
                            person.setfName(maleFirstName[indexName]);
                        }
                        else
                        {
                            //Generate a female name
                            person.setfName(femaleFirstName[indexName]);
                        }
                        // generate random array last name index from 0 to 19
                        int lName = rand.nextInt(0, 20);
                        person.setlName(lastName[lName]);
                        person.setGender(Gender);
                        // generate random array flight number index from 0 to 14
                        int flight = rand.nextInt(0, 15);
                        person.setFlightNo(flightNumber);
                        person.setPriority(Priority);
                        person.setTime(t);

                        //Inserting into list based on given priority and time
                        if(Priority == 1 && t == 0)
                        {
                            //Add to the front of the list
                            position1++;
                            personList.insertPassengers(new Travelers(person), position1);
                        }
                        if(Priority == 1 && t == 1)
                        {
                            //Add behind priority 1 and time 0
                            position2++;
                            int insert = position2 + position1;
                            personList.insertPassengers(new Travelers(person), insert);
                        }
                        if(Priority == 1 && t == 2)
                        {
                            //Add behind priority 1 and time 1
                            position3++;
                            int insert = position3 + position2 + position1;
                            personList.insertPassengers(new Travelers(person), insert);
                        }
                        if(Priority == 2 && t == 0)
                        {
                            //Add behind priority 1 and time 2
                            position4++;
                            int insert = position4 + position3 + position2 + position1;
                            personList.insertPassengers(new Travelers(person), insert);
                        }
                        if(Priority == 2 && t == 1)
                        {
                            //Add behind priority 2 and time 0
                            position5++;
                            int insert = position5 + position4 + position3 + position2 + position1;
                            personList.insertPassengers(new Travelers(person), insert);
                        }
                        if(Priority == 2 && t == 2)
                        {
                            //Add behind priority 2 and time 1
                            position6++;
                            int insert = position6 + position5 + position4 + position3 + position2 + position1;
                            personList.insertPassengers(new Travelers(person), insert);
                        }


                        //
                        System.out.println("{TRN#: " + person.getTrn() + ',' +
                                " First Name: " + person.getfName() + ',' +
                                " Last Name: " + person.getlName() + ',' +
                                " Gender: " + person.getGender() + ',' +
                                " Flight Number: " + person.getFlightNo() + ',' +
                                " Priority: " + person.getPriority() + '}');
                    }
                }
            } else if (2 == option) {
                personList.flightDisplay();//Displays flight information
            } else if (3 == option) {
                System.out.println("\n\t\t\t\t\t\t\t---PASSENGER REPORTS---");
                System.out.println("\n1 - Number of level 1 males on each flight");
                System.out.println("\n2 - Number of level 1 females on each flight");
                System.out.println("\n3 - Number of level 2 males on each flight");
                System.out.println("\n4 - Number of level 2 females on each flight");
                System.out.print("Enter Choice: ");
                int select = userInput.nextInt();
                switch (select) {
                    case 1:// lvl 1 males
                        System.out.println("\n\t\t\t\t\t\t\t\t\tREPORT SHOWING DEPARTURE INFORMATION FOR LEVEL 1 MALES\n");
                        personList.Reports(1, "male");
                        break;
                    case 2:// lvl 1 females
                        System.out.println("\n\t\t\t\t\t\t\t\t\tREPORT SHOWING DEPARTURE INFORMATION FOR LEVEL 1 FEMALES\n");
                        personList.Reports(1, "female");
                        break;
                    case 3:// lvl 2 males
                        System.out.println("\n\t\t\t\t\t\t\t\t\tREPORT SHOWING DEPARTURE INFORMATION FOR LEVEL 2 MALES\n");
                        personList.Reports(2, "male");
                        break;
                    case 4:// lvl 2 females
                        System.out.println("\n\t\t\t\t\t\t\t\t\tREPORT SHOWING DEPARTURE INFORMATION FOR LEVEL 2 FEMALES\n");
                        personList.Reports(2, "female");
                        break;
                    default:
                        System.err.println("");
                        break;
                }
            } else if (4 == option) {
                personList.removePassenger();// function call
            } else if (5 == option) {
                System.out.println("Thanks for making it at Norman Manley Airport\n" +
                        "\t\t\t\tSafe Journey!!!");
                System.exit(0);

            }
        }
    }

    //This method for generating random strings.
    private static String generateFlightNumber(String pFN) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            int randIndex = rand.nextInt(pFN.length());
            res.append(pFN.charAt(randIndex));
        }
        return res.toString();
    }
}


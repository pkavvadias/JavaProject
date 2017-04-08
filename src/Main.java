import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;



public class Main {

    public static void main(String[] args) {
        String clientName;
        int number;
        int arrivalDay;
        int daysToStay;
        int roomiddecider;
        int roomid;
        Hotel hotel = new Hotel();
        hotel.HotelName = "Hotel";
        Random random = new Random();
        int userinput;//Will be used for scanner
        //First names taken from wikipedia's list of most common names in Greece
        String firstNames[] = {"George", "Giannis", "Konstantinos", "Kostas", "Dimitris", "Nikos", "Panagiotis", "Vasilis",
                "Christos", "Thanasis", "Michalis", "Maria", "Eleni", "Vasiliki", "Sofia", "Aggeliki", "Dimitra", "Kwstantina"};
        //Last names taken from wikipedia's list of most common last names in Greece
        String lastNames[] = {"Papadopoulos", "Vlachos", "Angelopoulos", "Nikolaidis", "Georgiou", "Athanasiadis",
                "Dimitriadis", "Papadakis", "Panagiotopoulos", "Antoniou", "Papantoniou", "Petridis"};


        //Block for first room
        {
            Room room1 = new Room();
            room1.setPricePerPerson(20);
            room1.setMaxCapacity(4);
            //room1.RoomNumber=2;
            hotel.rooms.add(room1);

        }
        //Block for second room
        {
            Room room2 = new Room();
            room2.setPricePerPerson(15);
            room2.setMaxCapacity(2);
            hotel.rooms.add(room2);
        }
        //Block for third room
        {
            RoomTypeA room3 = new RoomTypeA();
            room3.setPricePerDay(10);
            room3.setPricePerPerson(5);
            room3.setMaxCapacity(2);
            hotel.rooms.add(room3);
        }
        //Block for forth room
        {
            RoomTypeB room4 = new RoomTypeB();
            room4.setDiscountPerDay(5);
            room4.setPricePerDay(15);
            room4.setPricePerPerson(25);
            room4.setMaxCapacity(4);
            hotel.rooms.add(room4);
        }
        //Block for fifth room
        {
            RoomTypeC room5 = new RoomTypeC();
            room5.setMinimumDays(4);
            room5.setMinimumPeople(5);
            room5.setMaxCapacity(6);
            room5.setPricePerPerson(20);
            hotel.addRoom(room5);
        }
        //Block for sixth room
        {
            RoomTypeD room6 = new RoomTypeD();
            room6.setNumberOfChildrenBeds(2);
            room6.setPricePerPerson(14);
            room6.setMaxCapacity(5);
            hotel.addRoom(room6);
        }
        //Block for seventh room
        {
            RoomTypeE room7 = new RoomTypeE();
            room7.setPricePerPerson(19);
            room7.setMaxCapacity(4);
            room7.setCancellationPermittedThreshold(3);
            room7.setCurrentDate(5);
            hotel.addRoom(room7);
        }
        //Block for eighth room
        {
            Room room8 = new Room();
            room8.setPricePerPerson(8);
            room8.setMaxCapacity(2);
            hotel.addRoom(room8);
        }
        //Block for ninth room
        {
            RoomTypeA room9 = new RoomTypeA();
            room9.setPricePerDay(30);
            room9.setPricePerPerson(15);
            room9.setMaxCapacity(2);
            hotel.addRoom(room9);
        }
        //Block for tenth room
        {
            RoomTypeB room10 = new RoomTypeB();
            room10.setDiscountPerDay(3);
            room10.setPricePerPerson(10);
            room10.setPricePerDay(30);
            room10.setMaxCapacity(3);
            hotel.addRoom(room10);
        }
        int k=0;
        int random_cancel;
        for (int i = 0; ; i++) {
            while(k==0) {
                String fullName = firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];
                Reservation reservation = new Reservation();
                reservation.setClient(fullName);
                reservation.setArrival(random.nextInt(30));//Sets random values
                reservation.setDaysOfStay(random.nextInt((30 - reservation.getArrival())));
                //App supports only one month so if if DaysofStay+Arrival>30 a crash will occur
                reservation.setNumberOfPeople(random.nextInt(6));
                hotel.addReservationToFirstRoom(reservation);
                //hotel.addReservationToRoom(reservation,2);
                hotel.reservations.add(reservation);
                random_cancel=random.nextInt(4);//Gives a random number between 0 and 3
                /**
                 * The try-catch block and the two if statements in the next while loop is a workaround
                 * Because of static method atomic integer in reservation class each reservation gets a unique id
                 * Even if eventually that reservation object is not saved not other Reservation object get same ID
                 * If by luck the while loop tried to delete a Reservation with that id(essentially a non existent reservation)
                 *a crash will occur.So we prevent that by ordering to delete the reservation with next ID
                 */
                if(random_cancel==2)
                {
                    int resget=random.nextInt(hotel.reservations.size());
                    try {
                        if (hotel.retrieveReservationFromNumber(resget).getRoom() == null) {
                            resget += 1;
                        }
                    }catch(NullPointerException e){resget+=1;}
                    hotel.cancelReservation(resget);
                    break;//hotel.reservations.get(resget);
                }
                k=1;
            }

            //The following code will have to be changed if/when i add a swing gui

            {
                System.out.println("Press 1 for next repeat(program continues)");
                System.out.println("Press 2 to add a reservation");
                System.out.println("Press 3 to cancel a reservation");
                System.out.println("Press 4 to view reservations");
                System.out.println("Press 5 to view rooms");
                System.out.println("Press 6 to view reservation plan");
                System.out.println("Press 7 to view income");
                System.out.println("Press any other number to exit");
                Scanner s = new Scanner(System.in);
                userinput = s.nextInt();
                if (userinput < 1 || userinput > 7) {
                    userinput = 8;
                }
                switch (userinput) {
                    case 1:
                        k=0;//Controls the while statement
                        break;
                    case 2:
                        s.nextLine();//Required to clear scanner's buffer
                        Reservation newres = new Reservation();
                        System.out.println("Insert name");
                        clientName = s.nextLine();
                        System.out.println("Insert arrival day");
                        arrivalDay = s.nextInt();
                        System.out.println("Insert days of stay");
                        daysToStay = s.nextInt();
                        System.out.println("Insert number of people");
                        number = s.nextInt();
                        System.out.println("Press 1 if you want to enter specific room id or press any other number to automatically assign it ");
                        roomiddecider = s.nextInt();
                        if (roomiddecider == 1) {
                            System.out.println("Insert room id");
                            roomid = s.nextInt();
                        } else {
                            roomid = -1;
                        }
                        newres.setArrival(arrivalDay);
                        newres.setDaysOfStay(daysToStay);
                        newres.setClient(clientName);
                        newres.setNumberOfPeople(number);
                        if (roomid != -1) {
                            hotel.addReservationToRoom(newres, roomid);
                        } else {
                            hotel.addReservationToFirstRoom(newres);
                            hotel.reservations.add(newres);
                        }
                        break;
                    case 3:
                        System.out.println("Insert reservation id to cancel");
                        hotel.cancelReservation(s.nextInt());
                        break;
                    case 4:
                        System.out.print("ID \t Client name \t     Room number \n");
                            for (Reservation r : hotel.reservations) {
                                //The above if statement is required to avoid exception if no room was available(so reservation not saved)
                                if(r.getRoom()==null){System.out.print("");}
                                else {

                                    System.out.print("" + r.getReservationNumber() + " \t " + r.getClient() + " \t " + r.getRoom().getRoomNumber() + "\n");

                                }
                            }

                       break;
                    case 5:
                        System.out.print("ID \t Fullness \t Income \t\n");
                        DecimalFormat df = new DecimalFormat();
                        df.setMaximumFractionDigits(2);
                        for(Room r:hotel.rooms)
                        {
                            System.out.println(""+r.getRoomNumber()+ " \t " +df.format(r.occupiedPercentage())+ " \t " +hotel.incomeCalculate(r.getRoomNumber())+ " \t ");

                        }
                        break;
                        //occupiedpercentage not displayed properly
                    case 6:
                        hotel.reservationPlan();
                        break;
                    case 7:

                        int roomind;
                        System.out.println("Press 1 if you want to search inclome of specific room or an other number to find total income");
                        roomind=s.nextInt();

                                if(roomind==1)
                                {
                                    int roomnumb;
                                    System.out.println("Enter room number");
                                    roomnumb=s.nextInt();
                                    try {
                                        System.out.println("Income of room with room number " + roomnumb + " is " + hotel.incomeCalculate(roomnumb) + " euros");
                                    }catch(NullPointerException e){System.out.println("Room with id " +roomnumb+ " does not exist");}
                                }
                                else {

                                    System.out.println("Total income is " + hotel.incomeCalculate()+ " ");

                                    }

                        break;

                    default:
                        break;

                }
                if (userinput == 8) {
                    break;
                }
            }
        }
    }
}



import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
import java.util.Iterator;


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
            room1.PricePerPerson = 20;
            room1.MaxCapacity = 4;
            //room1.RoomNumber=2;
            hotel.rooms.add(room1);

        }
        //Block for second room
        {
            Room room2 = new Room();
            room2.PricePerPerson = 15;
            room2.MaxCapacity = 2;
            hotel.rooms.add(room2);
        }
        //Block for third room
        {
            RoomTypeA room3 = new RoomTypeA();
            room3.PricePerDay = 10;
            room3.PricePerPerson = 5;
            room3.MaxCapacity = 2;
            hotel.rooms.add(room3);
        }
        //Block for forth room
        {
            RoomTypeB room4 = new RoomTypeB();
            room4.DiscountPerDay = 5;
            room4.PricePerDay = 15;
            room4.PricePerPerson = 25;
            room4.MaxCapacity = 4;
            hotel.rooms.add(room4);
        }
        //Block for fifth room
        {
            RoomTypeC room5 = new RoomTypeC();
            room5.MinimumDays = 4;
            room5.MinimumPeople = 5;
            room5.MaxCapacity = 6;
            room5.PricePerPerson = 20;
            hotel.addRoom(room5);
        }
        //Block for sixth room
        {
            RoomTypeD room6 = new RoomTypeD();
            room6.numberOfChildrenBeds = 2;
            room6.PricePerPerson = 14;
            room6.MaxCapacity = 5;
            hotel.addRoom(room6);
        }
        //Block for seventh room
        {
            Room room7 = new Room();
            room7.PricePerPerson = 19;
            room7.MaxCapacity = 4;
            hotel.addRoom(room7);
        }
        //Block for eighth room
        {
            Room room8 = new Room();
            room8.PricePerPerson = 8;
            room8.MaxCapacity = 2;
            hotel.addRoom(room8);
        }
        //Block for ninth room
        {
            RoomTypeA room9 = new RoomTypeA();
            room9.PricePerDay = 30;
            room9.PricePerPerson = 15;
            room9.MaxCapacity = 2;
            hotel.addRoom(room9);
        }
        //Block for tenth room
        {
            RoomTypeB room10 = new RoomTypeB();
            room10.DiscountPerDay = 3;
            room10.PricePerPerson = 10;
            room10.PricePerDay = 30;
            room10.MaxCapacity = 3;
            hotel.addRoom(room10);
        }
        int k=0;
        int random_cancel;
        for (int i = 0; ; i++) {
            while(k==0) {
                String fullName = firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];
                Reservation reservation = new Reservation();
                reservation.Client = fullName;
                reservation.Arrival = random.nextInt(30);//Sets random values
                reservation.DaysOfStay = random.nextInt((30 - reservation.Arrival));
                //App supports only one month so if if DaysofStay+Arrival>30 a crash will occur
                reservation.NumberOfPeople = random.nextInt(6);
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
                        if (hotel.retrieveReservationFromNumber(resget).room == null) {
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
                        newres.Arrival = arrivalDay;
                        newres.DaysOfStay = daysToStay;
                        newres.Client = clientName;
                        newres.NumberOfPeople = number;
                        if (roomid != -1) {
                            hotel.addReservationToRoom(newres, roomid);
                        } else {
                            hotel.addReservationToFirstRoom(newres);
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
                                if(r.room==null){System.out.print("");}
                                else {

                                    System.out.print("" + r.ReservationNumber + " \t " + r.Client + " \t " + r.room.RoomNumber + "\n");

                                }
                            }

                       break;
                    case 5:
                        System.out.print("ID \t Fullness \t Income \t\n");
                        DecimalFormat df = new DecimalFormat();
                        df.setMaximumFractionDigits(2);
                        for(Room r:hotel.rooms)
                        {
                            System.out.println(""+r.RoomNumber+ " \t " +df.format(r.occupiedPercentage())+ " \t " +hotel.incomeCalculate(r.RoomNumber)+ " \t ");
                            //System.out.println(""+r.occupiedPercentage()+ "");

                        }
                        //Occupied still has issues
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



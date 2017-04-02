import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Random random = new Random(); // just create one and keep it around
        //First names taken from wikipedia's list of most common names in Greece
        String firstNames []={"George","Giannis","Konstantinos","Kostas","Dimitris","Nikos","Panagiotis","Vasilis",
        "Christos","Thanasis","Michalis","Maria","Eleni","Vasiliki","Sofia","Aggeliki","Dimitra","Kwstantina"};
        //Last names taken from wikipedia's list of most common last names in Greece
        String lastNames[]={"Papadopoulos","Vlachos","Angelopoulos","Nikolaidis","Georgiou","Athanasiadis",
        "Dimitriadis","Papadakis","Panagiotopoulos","Antoniou","Papantoniou","Petridis"};


        //Block for first room
        {
            Room room1 = new Room();
            room1.PricePerPerson = 20;
            room1.MaxCapacity = 4;
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
            hotel.rooms.add(room5);
        }
        //Block for sixth room
        {
            RoomTypeD room6 = new RoomTypeD();
            room6.numberOfChildrenBeds=2;
            room6.PricePerPerson=14;
            room6.MaxCapacity=5;
            hotel.rooms.add(room6);
        }
        //Block for seventh room
        {
            Room room7=new Room();
            room7.PricePerPerson=19;
            room7.MaxCapacity=4;
            hotel.rooms.add(room7);
        }
        //Block for eighth room
        {
            Room room8=new Room();
            room8.PricePerPerson=8;
            room8.MaxCapacity=2;
            hotel.rooms.add(room8);
        }
        //Block for ninth room
        {
            RoomTypeA room9=new RoomTypeA();
            room9.PricePerDay=30;
            room9.PricePerPerson=15;
            room9.MaxCapacity=2;
            hotel.rooms.add(room9);
        }
        //Block for tenth room
        {
            RoomTypeB room10=new RoomTypeB();
            room10.DiscountPerDay=3;
            room10.PricePerPerson=10;
            room10.PricePerDay=30;
            room10.MaxCapacity=3;
            hotel.rooms.add(room10);
        }
        for(int i=0;;i++)
        {
        String fullName=firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];
        Reservation reservation=new Reservation();
        reservation.Arrival=random.nextInt(30-1)+1;//Sets random values between 1 and 30
        reservation.DaysOfStay=random.nextInt(31-reservation.Arrival);
        //App supports only one month so if if DaysofStay+Arrival>30 a crash will occur
        reservation.NumberOfPeople=random.nextInt(6-1)+1;
        //Maximum number of people is 6 as no room supports more than 6
        hotel.addReservationToFirstRoom(reservation);
        hotel.reservations.add(reservation);
        //The following code will have to be changed if/when i add a swing guif
        System.out.println("Press 1 for next repeat(programm continues");
        System.out.println("Press 2 to add a reservation");
        System.out.println("Press 3 to cancel a reservation");
        System.out.println("Press 4 to view reservations");
        System.out.println("Press 5 to view rooms");
        System.out.println("Press 6 to view reservation plan");
        System.out.println("Press 7 to view income");
        System.out.println("Press any other key to exit");

        }
    }
}


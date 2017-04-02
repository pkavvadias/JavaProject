import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

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
    }
}


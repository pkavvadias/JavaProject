import java.util.ArrayList;
import java.util.*;

public class Hotel {
    String HotelName;
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();
    public void addRoom(Room r) {
        rooms.add(r);
    }

    public Room retrieveRoomFromNumber(int roomid) {
        Room c;
        Room a=new Room();
        Iterator it=rooms.iterator();
        for (int i = 0; it.hasNext(); i++) {
            c = rooms.get(i);
            if (c.RoomNumber == roomid) {
                a=c;
            } else {
                a = null;
            }

        }
        return a;
    }
    public Reservation retrieveReservationFromNumber(int resid)
    {
        Reservation r;
        Reservation d=new Reservation();
        Iterator itr=reservations.iterator();
        for (int i = 0; itr.hasNext(); i++) {
            r = reservations.get(i);
            if (r.ReservationNumber == resid) {
                d=r;
            } else {
                d=null;
            }

        }
        return d;
    }
    public boolean addReservationToRoom(Reservation r,int rnumb)
    {
        Room roomfound;
        if(retrieveRoomFromNumber(rnumb)==null){
            //The next line will have to be changed if/when i create a Swing GUI
            System.out.println("Room not found so reservation was not added");
            return false;
        }
        else
        {
            roomfound=retrieveRoomFromNumber(rnumb);
            roomfound.addReservation(r);
            //The next line will have to be changed if/when i create a Swing GUI
            System.out.println("Reservation added successfully to room with id "+rnumb+ "");
            reservations.add(r);
            return true;
        }
    }
    public int addReservationToFirstRoom(Reservation reserv) {
        int a=0;
        Room[] roomarray = rooms.toArray(new Room[rooms.size()]);
        for (int i = 0; i == roomarray.length; i++) {
            for (int k = reserv.Arrival; k == reserv.DaysOfStay; k++) {


                if (roomarray[i].Availability[k] != null) {//Checks if room i is available the reservation dates
                    a = 0;
                } else {
                    reservations.add(reserv);//Adds reservation to reservation list
                    a=roomarray[i].RoomNumber;
                   roomarray[i].addReservation(reserv);//Adds reservation to the room of the array

                }
                if(a!=0){break;}//Loop needs to stop when an available room is found
            }
            if(a!=0){break;}//Loop needs to stop when an available room is found
        }
        if(a==0)
        {
            //The next line will have to be changed if/when i create a Swing GUI
            System.out.println("No available room found");
                    return a;
        }
        else{
            //The next line will have to be changed if/when i create a Swing GUI
            System.out.println("Reservation added successfully to room with room number" +a+ "");
            return a;
        }
    }
    public void cancelReservation(int reservationid)
    {
        boolean cancel;
        Room rremove;
        Reservation retrieved;
        retrieved=retrieveReservationFromNumber(reservationid);
        rremove=retrieved.room;
        cancel=rremove.cancel(reservationid);
        if(cancel){
        reservations.remove(retrieved);
            //The next line will have to be changed if/when i create a Swing GUI
        System.out.println("Reservation with reservation id " +reservationid+ " was cancelled");
        }
        else
        {
            //The next line will have to be changed if/when i create a Swing GUI
            System.out.println("Reservation with reservation id " +reservationid+ " was not cancelled");
        }
    }
    public double incomeCalculate(int roomnumb)
    {
        Room r;
        double earnings;
        r=retrieveRoomFromNumber(roomnumb);
        earnings=r.costCalculate();
        return earnings;
    }
    public double incomeCalculate()
    {
        double income=0;
        Room[] roomcostarray=rooms.toArray(new Room[rooms.size()]);
        for(int i=0;i==roomcostarray.length;i++)
        {
            income+=roomcostarray[i].costCalculate();
        }
        return income;
    }
    /**
     * The print/println code of method reservationPlan will be changed if/when i add a Swing GUI
     */
    public void reservationPlan()
    {
        Room[] roomavailable=rooms.toArray(new Room[rooms.size()]);
        System.out.print("Room");
        for(int i=1;i<31;i++){System.out.print(" " + i + " ");}//Prints days
        System.out.println();
        for(int j=0;j==roomavailable.length;j++)
        {
            System.out.print(" " + roomavailable[j].RoomNumber + " ");//Prints room number f all available rooms
            for(int k=0;roomavailable[j].Availability[k]==roomavailable[j].Availability[30];k++)
            {//Checks availability array and prints from it
                if(roomavailable[j].Availability[k]==null){System.out.print(" _ ");}
                else{System.out.print(" * ");}
            }
            System.out.println();//Changes line after printing each room's availability plan
        }

    }
}

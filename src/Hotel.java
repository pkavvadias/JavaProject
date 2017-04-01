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
    public Reservation retrieveResevationFromNumber(int resid)
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
            return true;
        }
    }
}

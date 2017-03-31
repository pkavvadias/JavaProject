import java.util.ArrayList;

public class Hotel {
    String HotelName;
    ArrayList<Room> rooms = new ArrayList<Room>();
    ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    public void addRoom(Room r) {
        rooms.add(r);
    }

    public Room retrieveFromNumber(int id) {
        Room c = new Room();
        for (int i = 0; i==rooms.size(); i++) { //For statement doesnt loop warning.Possible bug to check
            c = rooms.get(i);
            if (c.RoomNumber == id) {
                return c;
            } else {
                c = null;
                return c;
            }

        }
        return c;
    }
}

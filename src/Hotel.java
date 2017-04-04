import java.util.ArrayList;
import java.util.*;

public class Hotel {

    String HotelName;
    ArrayList<Room> rooms = new ArrayList<>();
    //Room[] roomarray = rooms.toArray(new Room[rooms.size()]);
    ArrayList<Reservation> reservations = new ArrayList<>();
    //Reservation[] restoappear=new Reservation[reservations.size()];

    public void addRoom(Room r) {
        rooms.add(r);
    }

    public Room retrieveRoomFromNumber(int roomid) {
        Room c=null;
             for(Room rg:rooms){
            if(rg.RoomNumber==roomid)
            {c= rg;break;}
            else {

                c=null;
            }
        }

       return c;
    }
    public Reservation retrieveReservationFromNumber(int resid)
    {
        int k=0;
        Reservation[] restoappear=new Reservation[reservations.size()];
       Reservation[] reservarray=reservations.toArray(new Reservation[reservations.size()]);
        for (int i = 0; i<reservarray.length; i++) {
            if (reservarray[i].ReservationNumber == resid) {
                restoappear[i]=reservarray[i];
                k=i;

            } else{
                restoappear[0]=null;
            }

        }
        return restoappear[k];

    }
    public boolean addReservationToRoom(Reservation r,int rnumb)
    {
        //Room[] roomarray = rooms.toArray(new Room[rooms.size()]);
        //Room roomfound;
        if(retrieveRoomFromNumber(rnumb)==null){
            //The next line will have to be changed if/when i create a Swing GUI
            System.out.println("Room not found so reservation was not added");
            return false;
        }
        else
        {

            r.setRoom(retrieveRoomFromNumber(rnumb));
            retrieveRoomFromNumber(rnumb).addReservation(r);
            //The next line will have to be changed if/when i create a Swing GUI
            System.out.println("Reservation with reservation id " +r.ReservationNumber+ "added successfully to room with id "+rnumb+ "");
            reservations.add(r);
            return true;
        }
    }
    public int addReservationToFirstRoom(Reservation reserv) {
        int a=0;
        //Room roomtoadd;
        Room[] roomarray = rooms.toArray(new Room[rooms.size()]);
        for (int i = 0; i<roomarray.length; i++) {
            for (int k = reserv.Arrival; k < (reserv.Arrival+reserv.DaysOfStay); k++) {


                if (roomarray[i].Availability[k] != null) {//Checks if room i is available the reservation dates
                    a = 0;
                } else {
                    //roomtoadd=retrieveRoomFromNumber(roomarray[i].RoomNumber);

                    //reserv.setRoom(retrieveRoomFromNumber(roomarray[i].RoomNumber));
                    reserv.setRoom(rooms.get(i));
                    //reservations.add(reserv);//Adds reservation to reservation list
                    a=roomarray[i].RoomNumber;
                    //for (int l = reserv.Arrival; l < (reserv.Arrival+reserv.DaysOfStay); l++)
                   //{retrieveRoomFromNumber(roomarray[i].RoomNumber).addReservation(reserv);}
                   roomarray[i].addReservation(reserv);//Adds reservation to the room of the arrayj


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
            System.out.println("Reservation with reservation id " +reserv.ReservationNumber+ " added successfully to room with room number " +a+ "");
            return a;
        }
    }
    public void cancelReservation(int reservationid)
    {

        try {
            if (retrieveReservationFromNumber(reservationid) != null)

            {

                Iterator itr=reservations.iterator();

                //Iterators are safer to use
                    while(itr.hasNext()) {
                        Object r = itr.next();
                        if (r.equals(retrieveReservationFromNumber(reservationid))) {
                            itr.remove();
                        }
                    }
                //}*/
                //else{reservations.remove(reservationid);}
                //The next line will have to be changed if/when i create a Swing GUI
                System.out.println("Reservation with reservation id " + reservationid + " was cancelled");
            } else {
                //The next line will have to be changed if/when i create a Swing GUI
                System.out.println("Reservation with reservation id " + reservationid + " was not cancelled");
            }
        }catch(ArrayIndexOutOfBoundsException e)
        {System.out.println("Reservation with reservation id " + reservationid + " was not cancelled");}
    }
    public double incomeCalculate(int roomnumb)
    {
        //Room r;
        double earnings;
        //r=retrieveRoomFromNumber(roomnumb);
        //System.out.println("" +retrieveRoomFromNumber(roomnumb)); This was used for debugging
        earnings=retrieveRoomFromNumber(roomnumb).costCalculate();
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

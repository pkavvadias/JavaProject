
import java.util.*;

public class Hotel {
    private String GUIString;//Required for printing in JOptionpane
    String HotelName;
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();


    public void addRoom(Room r) {
        rooms.add(r);
    }

    public Room retrieveRoomFromNumber(int roomid) {
        Room c=null;
             for(Room rg:rooms){
            if(rg.getRoomNumber()==roomid)
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
            if (reservarray[i].getReservationNumber() == resid) {
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
        if(retrieveRoomFromNumber(rnumb)==null){
            //The next line will have to be changed if/when i create a Swing GUI
            System.out.println("Room not found so reservation was not added");
            GUIString="Room not found so reservation was not added";
            return false;
        }
        else
        {

            r.setRoom(retrieveRoomFromNumber(rnumb));
            retrieveRoomFromNumber(rnumb).addReservation(r);
            //The next line will have to be changed if/when i create a Swing GUI
            System.out.println("Reservation with reservation id " +r.getReservationNumber()+ "added successfully to room with id "+rnumb+ "");
            GUIString="Reservation with reservation id " +r.getReservationNumber()+ "added successfully to room with id "+rnumb+ "";
            reservations.add(r);
            return true;
        }
    }
    public int addReservationToFirstRoom(Reservation reserv) {
        int a=0;
        //Room roomtoadd;
        Room[] roomarray = rooms.toArray(new Room[rooms.size()]);
        for (int i = 0; i<roomarray.length; i++) {
            for (int k = reserv.getArrival(); k < (reserv.getArrival()+reserv.getDaysOfStay()); k++) {


                if (roomarray[i].Availability[k] != null) {//Checks if room i is available the reservation dates
                    a = 0;
                } else {

                    reserv.setRoom(rooms.get(i));
                    //reservations.add(reserv);//Adds reservation to reservation list
                    a=roomarray[i].getRoomNumber();
                    //for (int l = reserv.Arrival; l < (reserv.Arrival+reserv.DaysOfStay); l++)
                   //{retrieveRoomFromNumber(roomarray[i].RoomNumber).addReservation(reserv);}
                   roomarray[i].addReservation(reserv);//Adds reservation to the room of the array
                   retrieveRoomFromNumber(roomarray[i].getRoomNumber()).addReservation(reserv);//Test for occupiedpercentage


                }
                if(a!=0){break;}//Loop needs to stop when an available room is found
            }
            if(a!=0){break;}//Loop needs to stop when an available room is found
        }
        if(a==0)
        {
            //The next line will have to be changed if/when i create a Swing GUI
            System.out.println("No available room found");
            GUIString="No available room found";
                    return a;
        }
        else{
            //The next line will have to be changed if/when i create a Swing GUI
            System.out.println("Reservation with reservation id " +reserv.getReservationNumber()+ " added successfully to room with room number " +a+ "");
           GUIString="Reservation with reservation id " +reserv.getReservationNumber()+ " added successfully to room with room number " +a+ "";
            //GUIString ="a";
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

                //The next line will have to be changed if/when i create a Swing GUI
                System.out.println("Reservation with reservation id " + reservationid + " was cancelled");
                    GUIString="Reservation with reservation id " + reservationid + " was cancelled";
            } else {
                //The next line will have to be changed if/when i create a Swing GUI
                System.out.println("Reservation with reservation id " + reservationid + " was not cancelled");
                GUIString="Reservation with reservation id " + reservationid + " was not cancelled";
            }
        }catch(ArrayIndexOutOfBoundsException e)
        {System.out.println("Reservation with reservation id " + reservationid + " was not cancelled");
        GUIString="Reservation with reservation id " + reservationid + " was not cancelled";
        }
    }
    public double incomeCalculate(int roomnumb)
    {
        double earnings;
        earnings=retrieveRoomFromNumber(roomnumb).costCalculate();
        return earnings;
    }
    public double incomeCalculate()
    {
        double income=0;
        for(Room r:rooms)
        {
            income+=r.costCalculate();
        }
        return income;
    }
    /**
     * The print/println code of method reservationPlan will be changed if/when i add a Swing GUI
     */
    public void reservationPlan()
    {
        System.out.print("Room\t");
        for(int i=1;i<31;i++){System.out.print(""+ i +"\t");}//Prints days
        System.out.println();
        for(Room roomavailable:rooms) {

                System.out.print(" " + roomavailable.getRoomNumber() + " \t");//Prints room number of all available rooms

            for (int k = 0; k < 30; k++) {//Checks availability array and prints from it
                    if (roomavailable.Availability[k] == null) {
                        System.out.print("-\t");
                    } else {
                        System.out.print("*\t");
                    }

            }

           System.out.println();//Changes line after printing each room's availability plan

        }

    }
    public String getGUIString(){
        return GUIString;
    }

}

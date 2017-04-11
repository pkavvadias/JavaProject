
import java.util.*;

public class Hotel {
    private String GUIString;//Required for printing in JOptionpane
    private String HotelName;
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();


    public void addRoom(Room r) {
        rooms.add(r);
    }
    public String getGUIString(){
        return GUIString;
    }
    public void setHotelName(String s){HotelName=s;}
    public String getHotelName(){return HotelName;}
    public ArrayList<Room> getRoom(){return rooms;}
    public void setReservations(Reservation r){reservations.add(r);}
    public ArrayList<Reservation> getReservations(){return reservations;}

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
    public boolean addReservationToRoom(Reservation r,int rnumb) {
        boolean a = true;

        if (retrieveRoomFromNumber(rnumb) == null) {

            System.out.println("Room not found so reservation was not added");
            GUIString = "Room not found so reservation was not added";
            a = false;
        } else {
            for (int k = r.getArrival(); k < (r.getArrival() + r.getDaysOfStay()); k++) {


                if (retrieveRoomFromNumber(rnumb).Availability[k] != null) {
                    System.out.println("Reservation was not added.Room is occupied");
                    GUIString="Reservation was not added.Room is occupied";
                    a = false;
                    break;
                } else {

                    r.setRoom(retrieveRoomFromNumber(rnumb));
                    retrieveRoomFromNumber(rnumb).addReservation(r);
                    if(retrieveRoomFromNumber(rnumb).addReservation(r)==false)
                    {
                        System.out.println("Reservation not added.Check room's special requirements");
                        GUIString="Reservation not added.Check room's special requirements";
                        break;
                    }

                    System.out.println("Reservation with reservation id " + r.getReservationNumber() + " added successfully to room with id " + rnumb + "");
                    GUIString = "Reservation with reservation id " + r.getReservationNumber() + " added successfully to room with id " + rnumb + "";
                    reservations.add(r);
                    break;
                }

            }

        }
        return a;
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
                        if(rooms.get(i).addReservation(reserv)==false){
                            if(i<roomarray.length+1){i=i+1;}
                            else{a=0;}
                            break;
                        }
                    else {
                            reserv.setRoom(rooms.get(i));
                            //reservations.add(reserv);//Adds reservation to reservation list
                            a = roomarray[i].getRoomNumber();
                            roomarray[i].addReservation(reserv);//Adds reservation to the room of the array
                            retrieveRoomFromNumber(roomarray[i].getRoomNumber()).addReservation(reserv);
                        }



                }
                if(a!=0){break;}//Loop needs to stop when an available room is found
            }
            if(a!=0){break;}//Loop needs to stop when an available room is found
        }
        if(a==0)
        {

            System.out.println("No available room found");
            GUIString="No available room found";
                    return a;
        }
        else{

            System.out.println("Reservation with reservation id " +reserv.getReservationNumber()+ " added successfully to room with room number " +a+ "");
           GUIString="Reservation with reservation id " +reserv.getReservationNumber()+ " added successfully to room with room number " +a+ "";

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
                            try {
                                retrieveReservationFromNumber(reservationid).getRoom().cancel(reservationid);
                                itr.remove();
                            }catch(NullPointerException s){continue;}
                        }
                    }

                System.out.println("Reservation with reservation id " + reservationid + " was cancelled");
                    GUIString="Reservation with reservation id " + reservationid + " was cancelled";
            } else {
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

}

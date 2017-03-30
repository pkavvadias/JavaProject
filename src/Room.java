import java.util.concurrent.atomic.AtomicInteger;

public class Room {
    int RoomNumber;
    int MaxCapacity;
    double PricePerPerson;
    Reservation Availability[] = new Reservation[30];
    //protected Object res=new Reservation();
    Reservation res;
    Room currentRoom=new Room();
    boolean a;//Used for addReservation method
    double cost=0;//Used for costCalculate method;
    static AtomicInteger Roomid = new AtomicInteger(100);
    //Reservation res=new Reservation();
    public Room() {
        RoomNumber = Roomid.incrementAndGet();
       // Reservation res=new Reservation();
    //}
   // public void setAvailability(Reservation res)
   // {
        for(int i=res.Arrival;i<(res.Arrival+res.DaysOfStay);i++)
        {
            Availability[i]=res;
        }

    }
    public boolean addReservation(Reservation res)
   {
        //boolean a,b;
       // boolean b;
        for(int i=res.Arrival;i<(res.Arrival+ res.DaysOfStay);i++)
        {
            if(Availability[i]!=null ||res.NumberOfPeople>MaxCapacity)
            {

                a=false;
            }
            else
            {
                Availability[i]=res;
                res.setRoom(currentRoom);
                a=true;
            }

        }
        return a;
    }
    public double costCalculate()
    {

        for(int i=0;i<31;i++)
        {
        if(Availability[i]==null)
        {

            cost +=0;
        }
        else
        {
            for(;Availability[i]==Availability[30];)
            {
                cost+=(res.NumberOfPeople*PricePerPerson);
            }
        }
        }
        return cost;
    }
}




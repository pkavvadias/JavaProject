import java.util.concurrent.atomic.AtomicInteger;

public class Room {
    protected int RoomNumber;
    protected int MaxCapacity;
    protected double PricePerPerson;
    protected Object Availability[] = new Reservation[30];
    //protected Object res=new Reservation();
    //Reservation res;
    protected Room currentRoom=new Room();
    protected boolean a;//Used for addReservation method
    protected double cost=0;//Used for costCalculate method;
    protected static AtomicInteger Roomid = new AtomicInteger(100);
    Reservation res=new Reservation();
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



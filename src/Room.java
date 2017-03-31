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
    static AtomicInteger Roomid = new AtomicInteger();
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
        double cost=0;
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
    public boolean cancel(int ReservationId)
    {
        for(int i=ReservationId;ReservationId==res.ReservationNumber;i++)
        {
         for(int j=0;Availability[j]==Availability[30];j++)
         {
             if(Availability[i]!=null)
             {
                 Availability[i]=null;
             }
         }
        }
        return true;
    }
    public float occupiedPercentage()
    {
        float percentage=0;
        int counter=0;
        for(int k=0;Availability[k]==Availability[30];k++)
        {
            while(Availability[k]!=null)
            {
                counter+=1;
                percentage=(counter/30)*100;
            }
        }
        return percentage;
    }
}




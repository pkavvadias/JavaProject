import java.util.concurrent.atomic.AtomicInteger;

public class Room {
    int RoomNumber;
    int MaxCapacity;
    double PricePerPerson;
    Reservation Availability[] = new Reservation[30];
    //protected Object res=new Reservation();
    //Reservation res;

   // Room CurrentRoom=new Room();
    //boolean a;//Used for addReservation method
    /**
     * Required to set AtomicInteger's initial value to 1 cause initialvalue=0 a problem would arise
     * in addReservationToFirstRoom method of class Hotel if there was a room with RoomNumber=0
     */
    static AtomicInteger Roomid = new AtomicInteger(1);
        //RoomNumber = Roomid.getAndIncrement();
    //}// = new AtomicInteger(1);

    //Reservation res=new Reservation();
    public Room()
    {
       RoomNumber = Roomid.getAndIncrement();
        // Reservation res=new Reservation();
    }
   // public void setAvailability(Reservation res)
   // {
      /** This is propably a leftover from an experiment.If everything works ok will be deleted in final version
       * for(int i=res.Arrival;i<(res.Arrival+res.DaysOfStay);i++)
        {
            Availability[i]=res;
        }
       */

    //}
    public boolean addReservation(Reservation res)
   {
        //boolean a,b;
       boolean a=true;
       for(int i=res.Arrival;i<(res.Arrival+ res.DaysOfStay);i++)
        {
            if(Availability[i]!=null ||res.NumberOfPeople>MaxCapacity)
            {

                a=false;
            }
            else
            {
                Availability[i]=res;
                Availability[i].ReservationNumber=res.ReservationNumber;
               res.setRoom(this);
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
            //for(;Availability[i]==Availability[30];)
            //{
                cost+=(Availability[i].NumberOfPeople*PricePerPerson);
            //}
        }
        }
        return cost;
    }



        public boolean cancel ( int ReservationId) {

            for (int j = 0; Availability[j] == Availability[29]; j++) {
                if (Availability[j].ReservationNumber == ReservationId)
                {
                    if (Availability[j] != null) {
                        Availability[j] = null;
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




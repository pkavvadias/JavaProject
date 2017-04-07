import java.util.concurrent.atomic.AtomicInteger;

public class Room {
    private int RoomNumber;
    private int MaxCapacity;
    private double PricePerPerson;
    Reservation Availability[] = new Reservation[30];

    /**
     * Atomic integer's initial value set to 100 just for style so that first room number starts from 100;)
     */
    private static AtomicInteger Roomid = new AtomicInteger(100);

    public Room()
    {
       RoomNumber = Roomid.getAndIncrement();
        // Reservation res=new Reservation();
    }

    public void setRoomNumber(int i){RoomNumber=i;}
    public int getRoomNumber(){return RoomNumber;}
    public void setMaxCapacity(int i){MaxCapacity=i;}
    public int getMaxCapacity(){return MaxCapacity;}
    public void setPricePerPerson(double i){PricePerPerson=i;}
    public double getPricePerPerson(){return PricePerPerson;}

    public boolean addReservation(Reservation res)
   {
        //boolean a,b;
       boolean a=true;
       for(int i=res.getArrival();i<(res.getArrival()+ res.getDaysOfStay());i++)
        {
            if(Availability[i]!=null ||res.getNumberOfPeople()>MaxCapacity)
            {

                a=false;
            }
            else
            {
                Availability[i]=res;
                Availability[i].setReservationNumber(res.getReservationNumber());
               res.setRoom(this);
                a=true;
            }

        }
        return a;
    }
    public double costCalculate()
    {
        double cost=0;
        for(int i=0;i<30;i++)
        {
        if(Availability[i]==null)
        {

            cost +=0;
        }
        else
        {
            cost+=(Availability[i].getNumberOfPeople()*PricePerPerson);

        }
        }
        return cost;
    }



        public boolean cancel ( int ReservationId) {

            for (int j = 0; Availability[j] == Availability[29]; j++) {
                if (Availability[j].getReservationNumber() == ReservationId)
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
        float percentage;
        float counter=0;

        for(int i=0;i<Availability.length;i++)
        {

            if(Availability[i]==null)
            {
                i+=1;}
            else{
                    counter++;

                }

        }
        percentage=(counter/30)*100;
        return percentage;

    }
}




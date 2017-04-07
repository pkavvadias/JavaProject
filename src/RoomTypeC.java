
public class RoomTypeC extends Room {
    private int MinimumDays;
    private int MinimumPeople;

    public void setMinimumDays(int i){MinimumDays=i;}
    public int getMinimumDays(){return MinimumDays;}
    public void setMinimumPeople(int i){MinimumPeople=i;}
    public int getMinimumPeople(){return MinimumPeople;}
    @Override
    public boolean addReservation(Reservation res)
    {
        //boolean a,b;
        boolean a=true;
        for(int i=res.Arrival;i<(res.Arrival+ res.DaysOfStay);i++)
        {
            if(Availability[i]!=null ||res.NumberOfPeople>getMaxCapacity()||res.DaysOfStay<MinimumDays||res.NumberOfPeople<MinimumPeople)
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
}

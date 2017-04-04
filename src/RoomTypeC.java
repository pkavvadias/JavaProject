
public class RoomTypeC extends Room {
    int MinimumDays;
    int MinimumPeople;
    @Override
    public boolean addReservation(Reservation res)
    {
        //boolean a,b;
        boolean a=true;
        for(int i=res.Arrival;i<(res.Arrival+ res.DaysOfStay);i++)
        {
            if(Availability[i]!=null ||res.NumberOfPeople>MaxCapacity||res.DaysOfStay<MinimumDays||res.NumberOfPeople<MinimumPeople)
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

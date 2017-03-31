
public class RoomTypeC extends Room {
    int minimumDays;
    int minimumPeople;
    @Override
    public boolean addReservation(Reservation res)
    {
        //boolean a,b;
        boolean a=true;
        for(int i=res.Arrival;i<(res.Arrival+ res.DaysOfStay);i++)
        {
            if(Availability[i]!=null ||res.NumberOfPeople>MaxCapacity||res.DaysOfStay<minimumDays||res.NumberOfPeople<minimumPeople)
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
}


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
        boolean a=true;
        for(int i=res.getArrival();i<(res.getArrival()+ res.getDaysOfStay());i++)
        {
            if(Availability[i]==null &&res.getNumberOfPeople()<=getMaxCapacity()&&res.getDaysOfStay()>=MinimumDays&&res.getNumberOfPeople()>=MinimumPeople)
            {

                Availability[i]=res;
                Availability[i].setReservationNumber(res.getReservationNumber());
                res.setRoom(this);
                a=true;
            }
            else
            {
                a=false;
            }

        }
        return a;
    }
}

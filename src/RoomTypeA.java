
public class RoomTypeA extends Room{
    private double PricePerDay;

    public void setPricePerDay(double i){PricePerDay=i;}
    public double getPricePerDay(){return PricePerDay;}
    @Override
    public double costCalculate()
    {
        double cost=0;
        for(Reservation r: Availability)
        {
            if(r!=null)
            {
                cost+=PricePerDay;
            }
        }
        return cost;
    }
}


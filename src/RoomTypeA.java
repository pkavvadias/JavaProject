
public class RoomTypeA extends Room{
    private double PricePerDay;

    public void setPricePerDay(double i){PricePerDay=i;}
    public double getPricePerDay(){return PricePerDay;}
    @Override
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
            cost+=PricePerDay;

        }
    }
    return cost;
}
}



public class RoomTypeB extends RoomTypeA {
    private int DiscountPerDay;
    private double FinalPricePerDay=getPricePerDay();
    private double cost=0;

    public void setDiscountPerDay(int i){DiscountPerDay=i;}
    public int getDiscountPerDay(){return DiscountPerDay;}


    @Override
    public double costCalculate()
    {
    for(int i=0;i<30;i++)
    {
        if(Availability[i]==null)
        {

            cost +=0;
        }
        else
        {
            cost+=FinalPricePerDay;
                if(FinalPricePerDay>=(0.5*getPricePerDay()))
                {
                    FinalPricePerDay=(FinalPricePerDay-DiscountPerDay);
                }
        }
    }
    return cost;
}
}

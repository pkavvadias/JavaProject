
public class RoomTypeB extends RoomTypeA {
    int DiscountPerDay;
    double FinalPricePerDay=PricePerDay;
    double cost=0;
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
            for(;Availability[i]==Availability[30];)
            {
                cost+=FinalPricePerDay;
                if(FinalPricePerDay>=(0.5*PricePerDay))
                {
                    FinalPricePerDay=(FinalPricePerDay-DiscountPerDay);
                }
            }
        }
    }
    return cost;
}
}

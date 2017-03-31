
public class RoomTypeB extends RoomTypeA {
    int discountPerDay;
    double finalPricePerDay=PricePerDay;
    double cost=0;
    public double costCalculate()
    {
    for(int i=0;i<31;i++)
    {
        if(Availability[i]==null)
        {

            cost +=0;
        }
        else
        {
            for(;Availability[i]==Availability[30];)
            {
                cost+=finalPricePerDay;
                if(finalPricePerDay>=(0.5*PricePerDay))
                {
                    finalPricePerDay=(finalPricePerDay-discountPerDay);
                }
            }
        }
    }
    return cost;
}
}


public class RoomTypeA extends Room{
    double PricePerDay;
@Override
    public double costCalculate()
{
double cost=0;
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
                cost+=(PricePerDay*PricePerPerson);
            }
        }
    }
    return cost;
}
}


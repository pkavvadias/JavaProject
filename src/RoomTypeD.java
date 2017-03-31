
public class RoomTypeD extends Room {
    int numberOfChildren;//Children pay half the price per person
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
                    cost+=((res.NumberOfPeople-numberOfChildren)*PricePerPerson)+(numberOfChildren)*(0.5*PricePerPerson);
                }
            }
        }
        return cost;
    }
}

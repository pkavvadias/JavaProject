
public class RoomTypeD extends Room {
    int numberOfChildrenBeds;//Children under 3 years pld have special beds and pay half the price per person
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
                    cost+=((Availability[i].NumberOfPeople-numberOfChildrenBeds)*PricePerPerson)+(numberOfChildrenBeds)*(0.5*PricePerPerson);
                }
            }
        }
        return cost;
    }
}

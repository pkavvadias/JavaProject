
public class RoomTypeD extends Room {
    private int numberOfChildrenBeds;//Children under 3 years pld have special beds and pay half the price per person

    public void setNumberOfChildrenBeds(int i){numberOfChildrenBeds=i;}
    public int getNumberOfChildrenBeds(){return numberOfChildrenBeds;}
    @Override
    public double costCalculate()
    {
        double cost=0;
        for(Reservation r: Availability)
        {
            if(r!=null)
            {
                cost+=((r.getNumberOfPeople()-numberOfChildrenBeds)*getPricePerPerson())+(numberOfChildrenBeds)*(0.5*getPricePerPerson());
            }
        }
        return cost;
    }
}

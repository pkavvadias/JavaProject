
public class RoomTypeD extends Room {
    private int numberOfChildrenBeds;//Children under 3 years pld have special beds and pay half the price per person

    public void setNumberOfChildrenBeds(int i){numberOfChildrenBeds=i;}
    public int getNumberOfChildrenBeds(){return numberOfChildrenBeds;}
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
                    cost+=((Availability[i].getNumberOfPeople()-numberOfChildrenBeds)*getPricePerPerson())+(numberOfChildrenBeds)*(0.5*getPricePerPerson());
            }
        }
        return cost;
    }
}

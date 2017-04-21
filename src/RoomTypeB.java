
public class RoomTypeB extends RoomTypeA {
    private int DiscountPerDay;
    private double cost=0;

    public void setDiscountPerDay(int i){DiscountPerDay=i;}
    public int getDiscountPerDay(){return DiscountPerDay;}


    @Override
    public double costCalculate()
    {
        double minimumPrice = getPricePerDay() / 2;
        double finalPricePerDay;
        int dayCounter=0;
        for(Reservation r : Availability)
    {
        if(r==null)
        {continue;}
        else
        {dayCounter++;}
        double priceReduction = dayCounter * DiscountPerDay;
        double dayPrice = getPricePerDay() - priceReduction;
        if(dayPrice<minimumPrice){
            finalPricePerDay =minimumPrice;}
        else{
            finalPricePerDay =dayPrice;}
        cost+= finalPricePerDay;

    }
    return cost;
    }

    @Override
    public boolean cancel ( int ReservationId) {
        return false;
    }
}

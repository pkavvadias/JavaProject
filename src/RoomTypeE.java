
public class RoomTypeE extends Room {
    /**
     * Reservation on this room cant be cancelled too close to scheduled arrival
     */
    private int CancellationPermittedThreshold;//How man days before arrival a reservation can be cancelled
    private int CurrentDate;

    public void setCancellationPermittedThreshold(int i){CancellationPermittedThreshold=i;}
    public int getCancellationPermittedThreshold(){return CancellationPermittedThreshold;}
    public void setCurrentDate(int i){CurrentDate=i;}
    public int getCurrentDate(){return CurrentDate;}

    @Override
    public boolean cancel(int ReservationId) {
        if (CurrentDate< CancellationPermittedThreshold) {
            return false;
        } else {
            for (int j = 0; j<Availability.length; j++) {
                try {
                    if (Availability[j].getReservationNumber() == ReservationId) {
                        if (Availability[j] != null) {
                            Availability[j] = null;
                        }
                    }
                }catch(NullPointerException ex){j=j+1;}
            }
            return true;
        }
    }
}

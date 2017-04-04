
public class RoomTypeE extends Room {
    /**
     * Reservation on this room cant be cancelled too close to scheduled arrival
     */
    int CancellationPermittedThreshold;//How man days before arrival a reservation can be cancelled
    int DaysToArrival;

    @Override
    public boolean cancel(int ReservationId) {
        if (DaysToArrival < CancellationPermittedThreshold) {
            return false;
        } else {
            for (int j = 0; Availability[j] == Availability[29]; j++) {
                if (Availability[j].ReservationNumber == ReservationId) {
                    if (Availability[j] != null) {
                        Availability[j] = null;
                    }
                }
            }

        }
        return true;
    }
}

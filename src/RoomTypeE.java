
public class RoomTypeE extends Room {
/**
 *Reservation on this room cant be cancelled too close to scheduled arrival
 */
int cancellationPermittedThreshold;//How man days before arrival a reservation can be cancelled
int daysToArrival;
@Override
    public boolean cancel(int ReservationId) {
    if (daysToArrival < cancellationPermittedThreshold) {return false;}
        else {
        for (int i = ReservationId; ReservationId == res.ReservationNumber; i++) {
            for (int j = 0; Availability[j] == Availability[30]; j++) {
                if (Availability[i] != null) {
                    Availability[i] = null;
                }
            }
        }
        return true;
    }
}
}

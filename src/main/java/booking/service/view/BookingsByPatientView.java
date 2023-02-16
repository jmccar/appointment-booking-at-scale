package booking.service.view;

import booking.service.domain.BookingServiceDomain.*;
import kalix.javasdk.view.View;
import kalix.javasdk.view.ViewContext;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the View Service described in your booking/service/view/bookings_by_patient.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class BookingsByPatientView extends AbstractBookingsByPatientView {

    public BookingsByPatientView(ViewContext context) {
    }

    @Override
    public BookingState emptyState() {
        return BookingState.getDefaultInstance();
    }

    @Override
    public View.UpdateEffect<BookingState> onBookingCreated(
            BookingState state, BookingAdded e) {
        return effects().updateState(BookingState
                .newBuilder()
                .setBookingId(e.getBookingId())
                .setPatientId(e.getPatientId())
                .setDate(e.getDate())
                .setType(e.getType())
                .build());
    }

    @Override
    public View.UpdateEffect<BookingState> onBookingDeleted(
            BookingState state, BookingRemoved e) {
        return effects().updateState(BookingState
                .newBuilder()
                .setBookingId(e.getBookingId())
                .build());
    }
}


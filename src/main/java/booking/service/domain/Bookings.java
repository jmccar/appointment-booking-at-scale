package booking.service.domain;

import booking.service.api.BookingServiceApi;

import com.google.protobuf.Empty;
import kalix.javasdk.eventsourcedentity.EventSourcedEntity;
import kalix.javasdk.eventsourcedentity.EventSourcedEntity.Effect;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityContext;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Event Sourced Entity Service described in your booking/service/api/booking_service_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class Bookings extends AbstractBookings {

  @SuppressWarnings("unused")
  private final String entityId;

  public Bookings(EventSourcedEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public BookingServiceDomain.BookingState emptyState() {
    return BookingServiceDomain.BookingState.getDefaultInstance();
  }

  @Override
  public Effect<Empty> createBooking(BookingServiceDomain.BookingState currentState,
                                     BookingServiceApi.AddBookingCommand command) {

    if (currentState.getType().isEmpty()) {
      return effects()
              .emitEvent(BookingServiceDomain.BookingAdded
                      .newBuilder()
                      .setBookingId(command.getBookingId())
                      .setPatientId(command.getPatientId())
                      .setDate(command.getDate())
                      .setType(command.getType())
                      .build())
              .thenReply(newState -> Empty.getDefaultInstance());
    } else {
      return effects().error(String.format("Booking '%s' already exists", currentState.getBookingId()));
    }
  }

  @Override
  public Effect<Empty> deleteBooking(BookingServiceDomain.BookingState currentState,
                                     BookingServiceApi.DeleteBookingCommand command) {

    return effects()
            .emitEvent(BookingServiceDomain.BookingRemoved
                    .newBuilder()
                    .setBookingId(command.getBookingId())
                    .build())
            .thenReply(newState -> Empty.getDefaultInstance());
  }

  @Override
  public Effect<BookingServiceApi.GetBookingDetails> getBooking(BookingServiceDomain.BookingState currentState,
                                                                BookingServiceApi.GetBookingRequest command) {

    return effects().reply(BookingServiceApi.GetBookingDetails
            .newBuilder()
            .setBookingId(currentState.getBookingId())
            .setPatientId(currentState.getPatientId())
            .setDate(currentState.getDate())
            .setType(currentState.getType())
            .build());
  }

  @Override
  public BookingServiceDomain.BookingState bookingAdded(BookingServiceDomain.BookingState currentState,
                                                        BookingServiceDomain.BookingAdded event) {
    return currentState.toBuilder()
            .setBookingId(event.getBookingId())
            .setPatientId(event.getPatientId())
            .setDate(event.getDate())
            .setType(event.getType())
            .build();
  }

  @Override
  public BookingServiceDomain.BookingState bookingRemoved(BookingServiceDomain.BookingState currentState,
                                                          BookingServiceDomain.BookingRemoved event) {
    return currentState.toBuilder()
            .setBookingId(event.getBookingId())
            .setType("Booking Removed")
            .build();
  }

}

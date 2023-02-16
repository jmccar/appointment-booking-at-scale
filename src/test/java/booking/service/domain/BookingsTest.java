package booking.service.domain;

import booking.service.api.BookingServiceApi;
import com.google.protobuf.Empty;
import kalix.javasdk.eventsourcedentity.EventSourcedEntity;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityContext;
import kalix.javasdk.testkit.EventSourcedResult;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class BookingsTest {

  @Test
  @Ignore("to be implemented")
  public void exampleTest() {
    BookingsTestKit service = BookingsTestKit.of(Bookings::new);
    // // use the testkit to execute a command
    // // of events emitted, or a final updated state:
    // SomeCommand command = SomeCommand.newBuilder()...build();
    // EventSourcedResult<SomeResponse> result = service.someOperation(command);
    // // verify the emitted events
    // ExpectedEvent actualEvent = result.getNextEventOfType(ExpectedEvent.class);
    // assertEquals(expectedEvent, actualEvent);
    // // verify the final state after applying the events
    // assertEquals(expectedState, service.getState());
    // // verify the reply
    // SomeReply reply = result.getReply();
    // assertEquals(expectedReply, reply);
  }

  @Test
  @Ignore("to be implemented")
  public void createBookingTest() {
    BookingsTestKit service = BookingsTestKit.of(Bookings::new);
    // AddBookingCommand command = AddBookingCommand.newBuilder()...build();
    // EventSourcedResult<Empty> result = service.createBooking(command);
  }


  @Test
  @Ignore("to be implemented")
  public void deleteBookingTest() {
    BookingsTestKit service = BookingsTestKit.of(Bookings::new);
    // DeleteBookingCommand command = DeleteBookingCommand.newBuilder()...build();
    // EventSourcedResult<Empty> result = service.deleteBooking(command);
  }


  @Test
  @Ignore("to be implemented")
  public void getBookingTest() {
    BookingsTestKit service = BookingsTestKit.of(Bookings::new);
    // GetBookingRequest command = GetBookingRequest.newBuilder()...build();
    // EventSourcedResult<GetBookingDetails> result = service.getBooking(command);
  }

}

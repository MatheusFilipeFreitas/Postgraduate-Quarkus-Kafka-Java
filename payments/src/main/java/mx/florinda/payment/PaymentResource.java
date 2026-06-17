package mx.florinda.payment;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.List;

@Path("/payments")
public class PaymentResource {

  @Inject
  @Channel("paymentsConfirmed")
  Emitter<PaymentConfirmedEvent> emitter;

  @GET
  public Uni<List<Payment>> list() {
    return Payment.listAll();
  }

  @GET
  @Path("/{id}")
  public Uni<Payment> byId(Long id) {
    return Payment.findById(id);
  }

  @PUT
  @Path("/{id}")
  public Uni<Payment> confirm(Long id) {
    return Panache.withTransaction(() ->
            Payment.<Payment>findById(id)
                    .onItem().ifNotNull().invoke(payment -> {
                      payment.status = PaymentStatus.CONFIRMED;

                      PaymentConfirmedEvent event =
                              new PaymentConfirmedEvent(payment.id, payment.orderId, payment.amount);
                      emitter.send(event);
                    }));
  }

}

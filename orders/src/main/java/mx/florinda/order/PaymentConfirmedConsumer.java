package mx.florinda.order;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class PaymentConfirmedConsumer {

  @Incoming("paymentsConfirmed")
  public Uni<Void> consume(PaymentConfirmedEvent event) {
    System.out.println(event);
    return Panache.withTransaction(() ->
            Order.<Order>findById(event.orderId)
                    .onItem().ifNotNull().invoke(order -> {
                      System.out.printf("Updating order: %s %n", order);
                      order.status = OrderStatus.PAID;
                    })).replaceWithVoid();
  }

}

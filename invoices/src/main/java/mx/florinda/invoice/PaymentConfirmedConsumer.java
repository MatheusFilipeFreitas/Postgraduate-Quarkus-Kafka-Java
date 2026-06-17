package mx.florinda.invoice;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class PaymentConfirmedConsumer {

  @RestClient
  OrderService orderService;

  @Incoming("paymentsConfirmed")
  public Uni<Void> consume(PaymentConfirmedEvent event) {
    System.out.println(event);
    return orderService.invoice(event.orderId, event.amount)
            .onItem().invoke(xml -> System.out.println(xml))
            .replaceWithVoid();
  }

}

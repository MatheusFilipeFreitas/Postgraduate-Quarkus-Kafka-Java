package mx.florinda.signer;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class PaymentConfirmedConsumer {

  @Inject
  Hash hash;

  @Incoming("paymentsConfirmed")
  public Uni<Void> consume(PaymentConfirmedEvent event) {
    System.out.println(event);
    String generatedHash = hash.generateHash(event.toString());
    System.out.println(generatedHash);
    return Uni.createFrom().voidItem();
  }

}

package mx.florinda.invoice;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.math.BigDecimal;

@Path("/orders")
@RegisterRestClient
public interface OrderService {

  @GET
  @Path("/{id}")
  Uni<OrderDto> getById(@PathParam("id") Long orderId);

  default Uni<String> invoice(Long orderId, BigDecimal amount) {
    return getById(orderId).onItem().transform(order -> """
            <xml>
              <amount>%s</amount>
              <customer>
                <name>%s</name>
                <cpf>%s</cpf>
                <phone>%s</phone>
                <address>%s</address>
              </customer>
            </xml>
            """.formatted(amount, order.customer.name, order.customer.cpf, order.customer.phone, order.customer.address));
  }
}

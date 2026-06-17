package mx.florinda.invoice;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;

@Path("/invoices")
public class InvoiceResource {

  @RestClient
  OrderService orderService;

  @GET
  @Path("/order/{orderId}")
  public Uni<String> byOrderId(@PathParam("orderId") Long orderId) {
    return orderService.invoice(orderId, new BigDecimal("9.99"));
  }

}

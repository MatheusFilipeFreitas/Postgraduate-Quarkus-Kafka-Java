package mx.florinda.order;

import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/orders")
public class OrderResource {

  @GET
  public Uni<List<Order>> list() {
    return Order.find("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.orderItems").list();
  }

  @GET
  @Path("/{id}")
  public Uni<Order> byId(Long id) {
    return Order.find("FROM Order o LEFT JOIN FETCH o.orderItems WHERE o.id = :id", Parameters.with("id", id))
            .firstResult();
  }

}

package mx.florinda.menuitem;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/menu-items")
public class MenuItemResource {

  @GET
  public Uni<List<MenuItem>> list() {
    return MenuItem.listAll();
  }

  @POST
  public Uni<RestResponse<MenuItem>> create(MenuItemRequest menuItemRequest) {
    MenuItem menuItem = menuItemRequest.toEntity();
    return Panache.<MenuItem>withTransaction(menuItem::persist)
            .map(item -> RestResponse.status(RestResponse.Status.CREATED, item));
  }

  @GET
  @Path("/by-category")
  public Uni<List<MenuItemsByCategoryResponse>> itemsByCategory() {
    return MenuItem.find("select mi.category, count(mi) from MenuItem mi group by mi.category")
            .project(MenuItemsByCategoryResponse.class)
            .list();
  }

}

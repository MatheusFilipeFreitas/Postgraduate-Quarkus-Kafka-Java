package mx.florinda.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import mx.florinda.menuitem.MenuItem;

import java.math.BigDecimal;

@Entity
public class OrderItem extends PanacheEntity {

  public Long quantity;
  public BigDecimal unitPrice;
  public String notes;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "order_id")
  public Order order;

  @ManyToOne
  @JoinColumn(name = "menu_item_id")
  public MenuItem menuItem;

}

package mx.florinda.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import mx.florinda.menuitem.MenuItem;

import java.math.BigDecimal;

@Entity
public class OrderItem extends PanacheEntity {

  @Column(nullable = false)
  public Long quantity;

  @Column(nullable = false)
  public BigDecimal unitPrice;

  public String notes;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "order_id", nullable = false)
  public Order order;

  @ManyToOne
  @JoinColumn(name = "menu_item_id", nullable = false)
  public MenuItem menuItem;

}

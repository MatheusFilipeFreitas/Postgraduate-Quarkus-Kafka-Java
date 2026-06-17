package mx.florinda.order;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "`Order`")
public class Order extends PanacheEntity {

  public LocalDateTime orderDateTime;

  @Enumerated(EnumType.STRING)
  public OrderStatus status;

  @Embedded
  public Customer customer;

  @OneToMany(mappedBy = "order")
  public List<OrderItem> orderItems;

  @Override
  public String toString() {
    return "Order{" +
            "id=" + id +
            ", status=" + status +
            '}';
  }
}

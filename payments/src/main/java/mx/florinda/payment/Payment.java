package mx.florinda.payment;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

@Entity
public class Payment extends PanacheEntity {

  @Column(nullable = false)
  public BigDecimal amount;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  public PaymentStatus status;

  @Column(nullable = false)
  public Long orderId;

  @Override
  public String toString() {
    return "Payment{" +
            "id=" + id +
            ", orderId=" + orderId +
            ", status=" + status +
            ", amount=" + amount +
            '}';
  }
}

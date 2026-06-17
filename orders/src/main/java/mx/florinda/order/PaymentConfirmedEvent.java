package mx.florinda.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentConfirmedEvent {

  public UUID eventId;
  public LocalDateTime eventTimestamp;

  public Long paymentId;
  public Long orderId;
  public BigDecimal amount;

  public PaymentConfirmedEvent(Long paymentId, Long orderId, BigDecimal amount) {
    this.eventId = UUID.randomUUID();
    this.eventTimestamp = LocalDateTime.now();
    this.paymentId = paymentId;
    this.orderId = orderId;
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "PaymentConfirmedEvent{" +
        "eventId=" + eventId +
        ", eventTimestamp=" + eventTimestamp +
        ", paymentId=" + paymentId +
        ", orderId=" + orderId +
        ", amount=" + amount +
        '}';
  }
}

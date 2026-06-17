package mx.florinda.invoice;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentConfirmedEvent {

  public UUID eventId;
  public LocalDateTime eventTimestamp;

  public Long paymentId;
  public Long orderId;
  public BigDecimal amount;

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

package mx.florinda.invoice;

import java.time.LocalDateTime;

public class OrderDto {

  public Long id;

  public LocalDateTime orderDateTime;

  public String status;

  public CustomerDto customer;

}

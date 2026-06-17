package mx.florinda.order;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Customer {

  @Column(name = "customerName", nullable = false)
  public String name;

  @Column(name = "customerCpf", nullable = false)
  public String cpf;

  @Column(name = "customerPhone", nullable = false)
  public String phone;

  @Column(name = "customerAddress", nullable = false)
  public String address;

}

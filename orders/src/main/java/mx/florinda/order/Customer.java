package mx.florinda.order;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Customer {

  @Column(name = "customerName")
  public String name;

  @Column(name = "customerCpf")
  public String cpf;

  @Column(name = "customerPhone")
  public String phone;

  @Column(name = "customerAddress")
  public String address;

}

package mx.florinda.menuitem;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class MenuItem extends PanacheEntity {

  @Column(nullable = false)
  public String name;
  public String description;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  public MenuCategory category;

  @Column(nullable = false)
  public BigDecimal price;
  public BigDecimal promotionalPrice;

}

package mx.florinda.menuitem;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class MenuItem extends PanacheEntity {

  public String name;
  public String description;

  @Enumerated(EnumType.STRING)
  public MenuCategory category;

  public BigDecimal price;
  public BigDecimal promotionalPrice;

}

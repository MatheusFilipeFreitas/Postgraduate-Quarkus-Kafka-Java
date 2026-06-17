package mx.florinda.menuitem;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class MenuItemRequest {

  @JsonProperty
  private String name;

  @JsonProperty
  private String description;

  @JsonProperty
  private MenuCategory category;

  @JsonProperty
  private BigDecimal price;

  public MenuItem toEntity() {
    MenuItem menuItem = new MenuItem();
    menuItem.name = this.name;
    menuItem.description = this.description;
    menuItem.category = this.category;
    menuItem.price = this.price;
    return menuItem;
  }

}

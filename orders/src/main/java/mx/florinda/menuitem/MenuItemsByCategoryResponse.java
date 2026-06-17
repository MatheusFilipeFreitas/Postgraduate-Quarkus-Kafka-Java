package mx.florinda.menuitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuItemsByCategoryResponse {

  @JsonProperty
  private final MenuCategory category;

  @JsonProperty
  private final Long count;

  public MenuItemsByCategoryResponse(MenuCategory category, Long count) {
    this.category = category;
    this.count = count;
  }
}

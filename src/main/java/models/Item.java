package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private String name;
    private String originalPrise;
    private String actualPrise;
    private String discount;
}

package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Seller {
    private String name;
    private String city;
}

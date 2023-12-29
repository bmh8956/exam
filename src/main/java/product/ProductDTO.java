package product;

import lombok.Data;

import java.util.Date;


@Data
public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private String content;
    private Date regdate;
}

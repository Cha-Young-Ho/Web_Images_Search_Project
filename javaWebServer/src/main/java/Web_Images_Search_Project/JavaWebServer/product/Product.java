package Web_Images_Search_Project.JavaWebServer.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Data
@Entity
@Table(name = "model")
public class Product {



    private String title;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String imageName;
    private String imagePath;
    private String price;
    private String link;
    private String data_type;


};
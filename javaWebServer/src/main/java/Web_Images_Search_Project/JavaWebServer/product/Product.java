package Web_Images_Search_Project.JavaWebServer.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Data
@Entity
@Table(name = "model")
public class Product {



    @Column(name="title")
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="image_name")
    private String imageName;

    @Column(name="image_path", length = 255)
    private String imagePath;

    @Column(length = 50)
    private String price;

    @Lob
    private String link;

    @Column(name= "data_type")
    private String dataType;


};
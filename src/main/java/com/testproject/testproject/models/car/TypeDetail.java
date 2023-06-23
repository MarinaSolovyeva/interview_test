package com.testproject.testproject.models.car;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "type_of_details")
public class TypeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column (name = "type_name")
    private String typeName;

    @OneToMany (mappedBy = "typeDetail",
            cascade = CascadeType.ALL)
    private List<CarDetail> carDetails;

}

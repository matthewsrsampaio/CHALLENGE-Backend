package sub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SUBSCRIPTION")
public class SubscriptionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;

//    public static Product of(ProductRequest productRequest,
//                             Supplier supplier,
//                             Category category){
//        return Product
//                .builder()
//                .name(productRequest.getName())
//                .quantityAvailable(productRequest.getQuantityAvailable())
//                .supplier(supplier)
//                .category(category)
//                .build();
//    }

    public void updateStatus(Boolean update) {
        setStatus(update);
    }



}

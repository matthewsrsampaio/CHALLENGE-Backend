package sub.dto;

import lombok.Data;

@Data
public class SubscriptionRequest {

    private Integer id;
    private String name;
    private Boolean status;

}

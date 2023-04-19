package sub.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sub.model.SubscriptionModel;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResponse {

    private Integer id;
    private String name;
    private Boolean status;
    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    public static SubscriptionResponse of(SubscriptionModel subscriptionModel) {
        return SubscriptionResponse
                .builder()
                .id(subscriptionModel.getId())
                .name(subscriptionModel.getName())
                .createdAt(subscriptionModel.getCreatedAt())
                .build();
    }

}

package com.example.subscriptionapi.sub.dto;

import com.example.subscriptionapi.sub.model.SubscriptionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResponse {

    private Integer id;
    private String name;
    private String status;
//    @JsonProperty("created_at")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
//    private LocalDateTime createdAt;

    //COPIES ALL MODEL TO RESPONSE
    public static SubscriptionResponse of(SubscriptionModel model) {
        var response = new SubscriptionResponse();
        BeanUtils.copyProperties(model, response);
        return response;
    }

}

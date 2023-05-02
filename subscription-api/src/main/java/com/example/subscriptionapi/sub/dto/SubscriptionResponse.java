package com.example.subscriptionapi.sub.dto;

import com.example.subscriptionapi.sub.model.SubscriptionModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data // <- Vai gerar os getters and setters
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class SubscriptionResponse {

    private Integer id;
    private String status;
    private String name;

    //Copiar os dados da model para response
    public static SubscriptionResponse of(SubscriptionModel model) {
        var response = new SubscriptionResponse();
        BeanUtils.copyProperties(model, response); //vai copiar o objeto de origem para o objeto de destino
        return response;
    }

}

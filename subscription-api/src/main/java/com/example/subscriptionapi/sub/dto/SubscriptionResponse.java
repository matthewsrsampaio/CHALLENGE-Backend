package com.example.subscriptionapi.sub.dto;

import com.example.subscriptionapi.sub.model.SubscriptionModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class SubscriptionResponse {

    //Não passar diretamente os objetos da model, por isso o description

    private Integer id;
    private String description;

    //converter essa model para response
    public static SubscriptionResponse of(SubscriptionModel model) {
        var response = new SubscriptionResponse();
        BeanUtils.copyProperties(model, response); //vai copiar o objeto de origem para o objeto de destino
        return response;
    }

}

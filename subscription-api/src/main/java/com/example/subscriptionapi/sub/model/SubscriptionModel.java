package com.example.subscriptionapi.sub.model;

import com.example.subscriptionapi.sub.dto.SubscriptionRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;


@Data //vai construir getter and setters, hashmaps e etc...
@Entity // informar ao jakarta que essa classe é uma identidade
@NoArgsConstructor //cria um construtor vazio
@AllArgsConstructor //cria todos os contrutores
@Table(name = "SUBS")
public class SubscriptionModel {

    @Id // indica que esse cara é um id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  //cria uma sequencia padrao para o hibernate
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // <-Cada vez que houver uma nova instancia, a CreatedAt
                                                            // recebera a data do momento de criação da instância

    //Converter a DTO para uma categoria do Banco de dados
    public static SubscriptionModel of(SubscriptionRequest request) {
        var subscriptionModel = new SubscriptionModel();
        BeanUtils.copyProperties(request, subscriptionModel); //vai copiar o objeto de origem para o objeto de destino
        return subscriptionModel;
    }

}

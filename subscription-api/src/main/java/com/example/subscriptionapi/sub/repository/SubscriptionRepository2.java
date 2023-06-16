package com.example.subscriptionapi.sub.repository;

import com.example.subscriptionapi.sub.dto.SubscriptionDTO;
import com.example.subscriptionapi.sub.model.SubscriptionModel;
import com.example.subscriptionapi.sub.model.SubscriptionModel2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository2 extends JpaRepository<SubscriptionModel2, Integer> {

//    SEARCH IN THE REPOSITORY THE NAME IGNORING THE CASE
    List<SubscriptionModel2> findByNameIgnoreCaseContaining (String name);


}

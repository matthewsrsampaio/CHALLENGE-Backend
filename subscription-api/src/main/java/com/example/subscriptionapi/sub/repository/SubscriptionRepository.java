package com.example.subscriptionapi.sub.repository;

import com.example.subscriptionapi.sub.model.SubscriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<SubscriptionModel, Integer> {

//    SEARCH IN THE REPOSITORY THE NAME IGNORING THE CASE
    List<SubscriptionModel> findByNameIgnoreCaseContaining (String name);


}

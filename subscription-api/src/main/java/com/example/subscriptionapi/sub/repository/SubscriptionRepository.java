package com.example.subscriptionapi.sub.repository;

//import com.example.subscriptionapi.sub.model.SubscriptionModel;
//import org.springframework.data.jpa.repository.JpaRepository;

import com.example.subscriptionapi.sub.model.SubscriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SubscriptionRepository extends JpaRepository<SubscriptionModel, Integer> {
//    List<SubscriptionModel> findById (Integer id);
//    List<SubscriptionModel> findByNameIgnoreCaseContaining (String name);

}
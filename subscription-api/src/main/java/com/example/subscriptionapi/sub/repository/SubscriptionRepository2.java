package com.example.subscriptionapi.sub.repository;

import com.example.subscriptionapi.sub.model.SubscriptionModel2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository2 extends JpaRepository<SubscriptionModel2, Integer> {

    List<SubscriptionModel2> findByNameIgnoreCaseContaining (String name);


}

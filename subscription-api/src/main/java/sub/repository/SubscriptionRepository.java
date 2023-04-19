package sub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sub.model.SubscriptionModel;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<SubscriptionModel, Integer> {
    List<SubscriptionModel> findBySubscriptionId (Integer id);
    List<SubscriptionModel> findByNameIgnoreCaseContaining (String name);

}

package mooon.service;

import mooon.model.Billionaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @date 2019/11/11.
 */
@Repository
public interface UserRepository extends JpaRepository<Billionaires, Integer> {
}

package com.retrowalk.repository;

import com.retrowalk.entities.User;
import com.retrowalk.entities.WebOrder;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

/**
 * Data Access Object to access WebOrder data.
 */
public interface WebOrderRepository extends ListCrudRepository<WebOrder, Long> {

    List<WebOrder> findByUser(User user);

}

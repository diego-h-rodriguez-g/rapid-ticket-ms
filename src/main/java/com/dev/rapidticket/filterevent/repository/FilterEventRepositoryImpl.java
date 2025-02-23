package com.dev.rapidticket.filterevent.repository;

import com.dev.rapidticket.filterevent.dto.FilterEventRequestDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.logging.Level;

@Repository
public class FilterEventRepositoryImpl implements FilterEventRepository {

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(String.valueOf(FilterEventRepositoryImpl.class));

    @PersistenceContext
    private final EntityManager entityManager;

    public FilterEventRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Object[]> getEvents(FilterEventRequestDTO filterEventRequestDTO) {
        Query query = entityManager.createNativeQuery(filterEventRequestDTO.getQuery());
        filterEventRequestDTO.getParameters().forEach(query::setParameter);
        List<Object[]> queryResponse = query.getResultList();
        log.log(Level.INFO, "A new response to the query get events has been completed with a total of records obtained: {0}", queryResponse.size());
        return queryResponse;
    }
}

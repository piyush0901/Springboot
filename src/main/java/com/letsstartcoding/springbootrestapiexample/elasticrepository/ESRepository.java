package com.letsstartcoding.springbootrestapiexample.elasticrepository;

import com.letsstartcoding.springbootrestapiexample.model.ESRecon;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ESRepository extends ElasticsearchRepository<ESRecon, Long> {
    List<ESRecon> findByName(String text);

    List<ESRecon> findBySalary(Long salary);
}

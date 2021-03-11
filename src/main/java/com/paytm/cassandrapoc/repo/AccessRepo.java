package com.paytm.cassandrapoc.repo;

import com.paytm.cassandrapoc.model.AccessToken;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepo extends CassandraRepository<AccessToken, String> {

}

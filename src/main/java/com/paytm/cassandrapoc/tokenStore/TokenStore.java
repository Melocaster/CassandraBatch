package com.paytm.cassandrapoc.tokenStore;

import com.paytm.cassandrapoc.model.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraBatchOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Component;

@Component
public class TokenStore {
  @Autowired
  private CassandraTemplate cassandraTemplate;

  public void storeAccessToken() {
    CassandraBatchOperations batchOps = cassandraTemplate.batchOps();
    batchOps.insert(new AccessToken("tokenId2", "oAuth2AccessToken2"));
    batchOps.insert(new AccessToken("tokenId3", "oAuth2AccessToken3"));
    batchOps.execute();
  }
}

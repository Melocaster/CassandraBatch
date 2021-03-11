package com.paytm.cassandrapoc.controller;

import com.paytm.cassandrapoc.model.AccessToken;
import com.paytm.cassandrapoc.repo.AccessRepo;
import com.paytm.cassandrapoc.tokenStore.TokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access")
public class AccessController {
  @Autowired
  AccessRepo accessRepo;

  @Autowired
  TokenStore tokenStore;

  @GetMapping("/save")
  public Boolean saveNewEntityAccessHandler(
      @RequestParam String tokenId, @RequestParam String oAuth2AccessToken) {
    accessRepo.insert(new AccessToken(tokenId, oAuth2AccessToken));
    return true;
  }

  @GetMapping("/saveBatch")
  public boolean saveBatchAccessHandler() {
    tokenStore.storeAccessToken();
    return true;
  }
}

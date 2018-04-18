package com.blogger.user.service;

import com.blogger.user.domain.User;

public interface CacheService {

    User getObj(String user) throws Exception;
}

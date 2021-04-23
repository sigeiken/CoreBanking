package io.kentec.CoreBanking.service;

import io.kentec.CoreBanking.entity.User;

public interface UserService {
    User findUserByUserNameAndPassword(String userName, String password) throws Exception;
}

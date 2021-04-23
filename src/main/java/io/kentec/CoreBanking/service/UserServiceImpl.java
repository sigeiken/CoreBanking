package io.kentec.CoreBanking.service;

import io.kentec.CoreBanking.controller.TransactionController;
import io.kentec.CoreBanking.entity.User;
import io.kentec.CoreBanking.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User findUserByUserNameAndPassword(String userName, String password) throws Exception {
        try {
            return userRepository.findUserByUserNameAndPassword(userName, password);
        }catch (Exception e){
            LOGGER.error("Failed to fetch user. Status = Fail, error {}", e.getMessage());
            throw new Exception("Error occurred " + e.getMessage());
        }
    }
}

package io.kentec.CoreBanking.controller;

import io.kentec.CoreBanking.entity.User;
import io.kentec.CoreBanking.request.TransactionRequest;
import io.kentec.CoreBanking.service.TransactionService;
import io.kentec.CoreBanking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/api/v1/corebanking/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody TransactionRequest payLoad) throws Exception {
        LOGGER.info("POST /api/v1/corebanking/transactions/deposit/{}", payLoad);
        HashMap<String, Object> responseMap = new LinkedHashMap<>();
        User user = userService.findUserByUserNameAndPassword(payLoad.getUserName(), payLoad.getPassword());
        if (user != null){
            try {
                transactionService.deposit(payLoad);
                responseMap.put("responseCode", "00");
                responseMap.put("responseMessage", "success");
                return new ResponseEntity<>(responseMap, HttpStatus.OK);
            }catch (Exception e){
                responseMap.put("responseCode", "01");
                responseMap.put("responseMessage", "failed");
                responseMap.put("errorMessage", e.getMessage());
                LOGGER.error("POST E|Msisdn={} /api/v1/corebanking/transactions/deposit/ responseMap= {}", payLoad.getParameters().getMsisdn(), responseMap);
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
        }else {
            responseMap.put("responseCode", "01");
            responseMap.put("responseMessage", "failed");
            responseMap.put("errorMessage", "unknown user");
            return new ResponseEntity<>(responseMap, HttpStatus.UNAUTHORIZED);
        }

    }
}

package io.kentec.CoreBanking.service;

import io.kentec.CoreBanking.request.TransactionRequest;

public interface TransactionService {
    void deposit(TransactionRequest payLoad) throws Exception;
}

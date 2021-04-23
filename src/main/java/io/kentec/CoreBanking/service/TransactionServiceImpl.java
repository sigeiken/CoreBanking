package io.kentec.CoreBanking.service;

import io.kentec.CoreBanking.entity.Account;
import io.kentec.CoreBanking.entity.Transaction;
import io.kentec.CoreBanking.repository.AccountRepository;
import io.kentec.CoreBanking.repository.TransactionRepository;
import io.kentec.CoreBanking.request.TransactionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Override
    @Transactional
    public void deposit(TransactionRequest payLoad) throws Exception {
        try {
            Account account = accountRepository.findCustomerAccount(payLoad.getParameters().getAccount());
            LOGGER.info("Account " + account);
            if (account != null){

                BigDecimal initialBalance = account.getAccountBalance();
                BigDecimal deposit = new BigDecimal(payLoad.getParameters().getAmount());
                BigDecimal updatedBalance = initialBalance.add(deposit);
                LOGGER.info("Updating balance for account {}...", payLoad.getParameters().getAccount());
                accountRepository.updateBalance(updatedBalance, account.getAccountNo());

                //Log the transaction
                Transaction transaction = new Transaction();
                transaction.setTransactionType(payLoad.getAction());
                transaction.setAmount(new BigDecimal(payLoad.getParameters().getAmount()));
                transaction.setProcessingStatus("4");
                transaction.setDescription("COMPLETE");
                transaction.setCustomerId(account.getCustomer());
                transaction.setTimeProcessed(Instant.now());

                transactionRepository.save(transaction);
            }else {
                LOGGER.error("Account Number " + payLoad.getParameters().getAccount() + " does not exist");
                throw new Exception("Account Number " + payLoad.getParameters().getAccount() + " does not exist");
            }

        }catch (Exception e){
            LOGGER.error("Error occurred trying to make deposit to ACCOUNT {}. Status = FAIL {} ", payLoad.getParameters().getAccount(), e.getMessage());
            throw new Exception("Error occurred " + e.getMessage());
        }
    }
}

package io.kentec.CoreBanking.repository;

import io.kentec.CoreBanking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.accountNo = :account")
    Account findCustomerAccount(@Param("account") String account);

    //@Query("update User u set u.active = false where u.lastLoginDate < :date")
    @Modifying
    @Query("UPDATE Account a SET a.accountBalance = :updatedBalance WHERE a.accountNo = :accountNo")
    void updateBalance(@Param("updatedBalance") BigDecimal updatedBalance, @Param("accountNo") String accountNo);
}

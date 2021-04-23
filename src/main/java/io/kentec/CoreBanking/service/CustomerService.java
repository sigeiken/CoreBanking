package io.kentec.CoreBanking.service;

import io.kentec.CoreBanking.request.OnboardCustomerRequest;

public interface CustomerService {
    void onboardCustomer(OnboardCustomerRequest payload) throws Exception;
}

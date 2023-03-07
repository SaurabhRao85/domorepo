package com.axis.service;

import java.util.List;

import com.axis.dto.CreditCardDto;

public interface CreditCardService {

	CreditCardDto addCreditCard(CreditCardDto creditCardDto);
	List<CreditCardDto> getAllCreditCard();
	CreditCardDto getCreditCardById(int id);
	CreditCardDto updateCreditCardById(int id, CreditCardDto creditCardDto);
    void deleteCreditCardById(int id);

	/* CreditCardDto getCreditCardByCardNumber(String cardNumber); */
    CreditCardDto getCreditCardByDailyLimit(double dailyLimit);
  //  CreditCardDto updateCreditCardByCardNumber(long cardNumber, CreditCardDto creditCardDto);
    CreditCardDto activate(long cardNumber,CreditCardDto creditCardDto);
    CreditCardDto deactivate(long cardNumber,CreditCardDto creditCardDto);
    
    
}

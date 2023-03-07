package com.axis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.axis.dto.CreditCardDto;
import com.axis.model.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

	/*
	 * @Query("select * from CreditCard where cardNumber=?1") Optional<CreditCard>
	 * findByCardNumber(String cardNumber);
	 */

	@Query("select * from CreditCard where dailyLimit=?1")
	Optional<CreditCard> findByDailyLimit(double dailyLimit);
	
	@Modifying
	@Query("update CreditCard set cardNumber=?1,holderName=?2,cardType=?3,balance=?4,expireDate=?5,csv=?6,dailyLimit=?7,status=?8 where cardNumber=?9")
	CreditCard updateCreditCardByCardNumber(long cardNumber);

//	CreditCard findByStatus(boolean status);

	@Modifying
	@Query("update CreditCard c set c.status=?1 where c.status=?2")
	CreditCard findByCardNumber(long cardNumber);
    

	@Query("select * from CreditCard where cardNumber=?1")
	Optional<CreditCard> findByCreditCard(CreditCard creditCard);
	
	

	
	

	
	

}

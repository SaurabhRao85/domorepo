package com.axis.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.CreditCardDto;
import com.axis.dto.UserDto;
import com.axis.exception.CardNumberNotFoundException;
import com.axis.exception.CardStatusException;
import com.axis.exception.IdNotFoundException;
import com.axis.exception.InValidDailyLimitException;
import com.axis.model.CreditCard;
import com.axis.model.User;
import com.axis.repository.CreditCardRepository;
import com.axis.repository.UserRepository;
import com.axis.utility.AppConstant;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	CreditCardRepository creditCardRepository;
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public CreditCardDto addCreditCard(CreditCardDto creditCardDto) {
		
		return convertToDto(creditCardRepository.save(convertToEntity(creditCardDto)));
	}

	@Override
	public List<CreditCardDto> getAllCreditCard() {
		
		List<CreditCard> creditCards=	creditCardRepository.findAll();
		
		List<CreditCardDto> creditCardDtos = new ArrayList<CreditCardDto>();
		
		for(CreditCard creditCard :creditCards)
		{
			creditCardDtos.add(convertToDto(creditCard));
		}
			
		return creditCardDtos;
	}

	@Override
	public CreditCardDto getCreditCardById(int id) {
		Optional<CreditCard> optCreditCard = creditCardRepository.findById(id);
	     
		   if(optCreditCard.isPresent())
			   return convertToDto(optCreditCard.get());
		   else   
		      throw new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
		   
	}
	
	@Override
	public CreditCardDto updateCreditCardById(int id, CreditCardDto creditCardDto) {
		CreditCard creditCard =  creditCardRepository.findById(id).
				orElseThrow(() -> new IdNotFoundException(AppConstant.NOT_FOUND_MESSAGE +"To Update With Id " +id));
		
		creditCard.setId(creditCardDto.getId());
		creditCard.setCardNumber(creditCardDto.getCardNumber());
		creditCard.setHolderName(creditCardDto.getHolderName());
		creditCard.setCardType(creditCardDto.getCardType());
		creditCard.setAccountNo(creditCardDto.getAccountNo());
		creditCard.setBank(creditCardDto.getBank());
		creditCard.setBranchName(creditCardDto.getBranchName());
		creditCard.setCvv(creditCardDto.getCvv());
		creditCard.setDailyLimit(creditCardDto.getDailyLimit());
		creditCard.setBalance(creditCardDto.getBalance());
		creditCard.setExpireDate(creditCardDto.getExpireDate());
		creditCard.setStatus(creditCardDto.getStatus());
		

            User user = new User();
            user.setId(creditCardDto.getUserDto().getId());
	         user.setHolderName(creditCardDto.getUserDto().getHolderName());
	 		user.setAge(creditCardDto.getUserDto().getAge());
	 		user.setPhoneNumber(creditCardDto.getUserDto().getPhoneNumber());
	 		user.setPassword(creditCardDto.getUserDto().getPassword());
	 		user.setRole(creditCardDto.getUserDto().getRole());
	 		user.setEmail(creditCardDto.getUserDto().getEmail());
	 		user.setAddress(creditCardDto.getUserDto().getAddress());
	 		user.setCity(creditCardDto.getUserDto().getCity());
	 		user.setState(creditCardDto.getUserDto().getState());
	 		user.setCountry(creditCardDto.getUserDto().getCountry());
	 		user.setPincode(creditCardDto.getUserDto().getPincode());
	 		user.setCreatedAt(creditCardDto.getUserDto().getCreatedAt());
        
        creditCard.setUser(user);
        
		return convertToDto(creditCardRepository.save(creditCard));
	}

	/*
	 * @Override public CreditCardDto updateCreditCardByCardNumber(long cardNumber,
	 * CreditCardDto creditCardDto) { CreditCard creditCard =
	 * creditCardRepository.findByCardNumber(cardNumber). orElseThrow(() -> new
	 * CardNumberNotFoundException(AppConstant.CARD_NUMBER_NOT_FOUND_MESSAGE
	 * +cardNumber));
	 * 
	 * 
	 * 
	 * creditCard.setId(creditCardDto.getId());
	 * creditCard.setCardNumber(creditCardDto.getCardNumber());
	 * creditCard.setHolderName(creditCardDto.getHolderName());
	 * creditCard.setCardType(creditCardDto.getCardType());
	 * creditCard.setAccountNo(creditCardDto.getAccountNo());
	 * creditCard.setBank(creditCardDto.getBank());
	 * creditCard.setBranchName(creditCardDto.getBranchName());
	 * creditCard.setCvv(creditCardDto.getCvv());
	 * creditCard.setDailyLimit(creditCardDto.getDailyLimit());
	 * creditCard.setBalance(creditCardDto.getBalance());
	 * creditCard.setExpireDate(creditCardDto.getExpireDate());
	 * creditCard.setStatus(creditCardDto.getStatus());
	 * 
	 * 
	 * User user = new User(); user.setId(creditCardDto.getUserDto().getId());
	 * user.setHolderName(creditCardDto.getUserDto().getHolderName());
	 * user.setAge(creditCardDto.getUserDto().getAge());
	 * user.setPhoneNumber(creditCardDto.getUserDto().getPhoneNumber());
	 * user.setPassword(creditCardDto.getUserDto().getPassword());
	 * user.setRole(creditCardDto.getUserDto().getRole());
	 * user.setEmail(creditCardDto.getUserDto().getEmail());
	 * user.setAddress(creditCardDto.getUserDto().getAddress());
	 * user.setCity(creditCardDto.getUserDto().getCity());
	 * user.setState(creditCardDto.getUserDto().getState());
	 * user.setCountry(creditCardDto.getUserDto().getCountry());
	 * user.setPincode(creditCardDto.getUserDto().getPincode());
	 * user.setCreatedAt(creditCardDto.getUserDto().getCreatedAt());
	 * 
	 * creditCard.setUser(user);
	 * 
	 * return convertToDto(creditCardRepository.save(creditCard)); }
	 */
	@Override
	public CreditCardDto getCreditCardByDailyLimit(double dailyLimit) {
		Optional<CreditCard> optCreditCard = creditCardRepository.findByDailyLimit(dailyLimit);
	     
		   if(optCreditCard.isPresent())
			   return convertToDto(optCreditCard.get());
		   else   
		      throw new InValidDailyLimitException(AppConstant.	INVALID_DAILY_LIMIT_MESSAGE+dailyLimit);
	}

	
	@Override
	public CreditCardDto activate(long cardNumber,CreditCardDto creditCardDto) {
		CreditCard creditCard = creditCardRepository.findByCardNumber(cardNumber);
	
		   if(creditCard.getStatus().equals("0")) {
			   
			  
			   creditCard.setStatus(creditCardDto.getStatus());
				
		   }
		   else
			   throw new CardStatusException(AppConstant.CARD_STATUS_MESSAGE +cardNumber);
			  
		   return convertToDto(creditCardRepository.save(creditCard));
	}

	@Override
	public CreditCardDto deactivate(long cardNumber,CreditCardDto creditCardDto) {
		CreditCard creditCard = creditCardRepository.findByCardNumber(cardNumber);
		
		   if(creditCard.getStatus().equals("1")) {
			   
			 
			   creditCard.setStatus(creditCardDto.getStatus());
				
		   }
		   else
			   throw new CardStatusException(AppConstant.CARD_STATUS_DEACTIVATE_MESSAGE +cardNumber);
			  
		   return convertToDto(creditCardRepository.save(creditCard));
	}

	@Override
	public void deleteCreditCardById(int id) {
		CreditCard creditCard = creditCardRepository.findById(id).
				orElseThrow(() -> new IdNotFoundException(AppConstant.NOT_FOUND_MESSAGE +id));
		
		creditCardRepository.delete(creditCard);
		
	}
	
	private CreditCardDto convertToDto(CreditCard creditCard)
	{
        
		CreditCardDto creditCardDto = new CreditCardDto();
		
		//Set<UserDto> userDtos = new HashSet<>();
		
		creditCardDto.setId(creditCard.getId());
		creditCardDto.setHolderName(creditCard.getHolderName());
		creditCardDto.setCardNumber(creditCard.getCardNumber());
		creditCardDto.setCardType(creditCard.getCardType());
		creditCardDto.setAccountNo(creditCard.getAccountNo());
		creditCardDto.setBank(creditCard.getBank());
		creditCardDto.setBranchName(creditCard.getBranchName());
		creditCardDto.setCvv(creditCard.getCvv());
		creditCardDto.setBalance(creditCard.getBalance());
		creditCardDto.setDailyLimit(creditCard.getDailyLimit());
		creditCardDto.setExpireDate(creditCard.getExpireDate());
		creditCardDto.setStatus(creditCard.getStatus());
		
		//Set<User> users = creditCard.getUsers();
		
		//for(User user : users) {
		
		UserDto userDto = new UserDto();
		userDto.setId(creditCard.getUser().getId());
		userDto.setHolderName(creditCard.getUser().getHolderName());
		userDto.setAge(creditCard.getUser().getAge());
		userDto.setPhoneNumber(creditCard.getUser().getPhoneNumber());
		userDto.setPassword(creditCard.getUser().getPassword());
		userDto.setRole(creditCard.getUser().getRole());
		userDto.setEmail(creditCard.getUser().getEmail());
		userDto.setAddress(creditCard.getUser().getAddress());
		userDto.setCity(creditCard.getUser().getCity());
		userDto.setState(creditCard.getUser().getState());
		userDto.setCountry(creditCard.getUser().getCountry());
		userDto.setPincode(creditCard.getUser().getPincode());
		userDto.setCreatedAt(creditCard.getUser().getCreatedAt());
	
		
	//	userDtos.add(userDto);
		//}
		
        creditCardDto.setUserDto(userDto);
		
		return creditCardDto;
	}
	
	private CreditCard convertToEntity(CreditCardDto creditCardDto)
	{
		CreditCard creditCard = new CreditCard();
		//Set<User> users = new HashSet<>();
		creditCard.setId(creditCardDto.getId());
		creditCard.setHolderName(creditCardDto.getHolderName());
		creditCard.setCardNumber(creditCardDto.getCardNumber());
		creditCard.setCardType(creditCardDto.getCardType());
		creditCard.setAccountNo(creditCardDto.getAccountNo());
		creditCard.setBank(creditCardDto.getBank());
		creditCard.setBranchName(creditCardDto.getBranchName());
		creditCard.setCvv(creditCardDto.getCvv());
		creditCard.setBalance(creditCardDto.getBalance());
		creditCard.setDailyLimit(creditCardDto.getDailyLimit());
		creditCard.setExpireDate(creditCardDto.getExpireDate());
		creditCard.setStatus(creditCardDto.getStatus());
		
		//Set<UserDto> userDtos = creditCardDto.getUserDto();
		
		  //for (UserDto userDto : userDtos) {
          
			 User user = new User();
	         user.setId(creditCardDto.getUserDto().getId());
	         user.setHolderName(creditCardDto.getUserDto().getHolderName());
	 		user.setAge(creditCardDto.getUserDto().getAge());
	 		user.setPhoneNumber(creditCardDto.getUserDto().getPhoneNumber());
	 		user.setPassword(creditCardDto.getUserDto().getPassword());
	 		user.setRole(creditCardDto.getUserDto().getRole());
	 		user.setEmail(creditCardDto.getUserDto().getEmail());
	 		user.setAddress(creditCardDto.getUserDto().getAddress());
	 		user.setCity(creditCardDto.getUserDto().getCity());
	 		user.setState(creditCardDto.getUserDto().getState());
	 		user.setCountry(creditCardDto.getUserDto().getCountry());
	 		user.setPincode(creditCardDto.getUserDto().getPincode());
	 		user.setCreatedAt(creditCardDto.getUserDto().getCreatedAt());
	 	
	         
	         //users.add(user);
		 // }

	        creditCard.setUser(user);
			
			return creditCard;
			
		}



	
		
	

	
	

}

package com.axis.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.CreditCardDto;
import com.axis.dto.UserDto;
import com.axis.exception.HolderNameNotFoundException;
import com.axis.exception.IdNotFoundException;
import com.axis.exception.InValidCityException;
import com.axis.exception.PhoneNumberNotFoundException;
import com.axis.model.CreditCard;
import com.axis.model.User;
import com.axis.repository.CreditCardRepository;
import com.axis.repository.UserRepository;
import com.axis.utility.AppConstant;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CreditCardRepository creditCardRepository;
	
	

	/*
	 * public UserServiceImpl(UserRepository userRepository, CreditCardRepository
	 * creditCardRepository) {
	 * 
	 * this.userRepository = userRepository; this.creditCardRepository =
	 * creditCardRepository; }
	 */

	@Override
	public UserDto addUser(UserDto userDto) {
		
		return convertToDto(userRepository.save(convertToEntity(userDto)));
	}

	@Override
	public List<UserDto> getAllUser() {
		
		List<User> users=	userRepository.findAll();
		
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		for(User user :users)
		{
			userDtos.add(convertToDto(user));
		}
			
			return userDtos;
	}

	@Override
	public UserDto getUserById(ObjectId id) {
		
		Optional<User> optUser = userRepository.findById(id);
	     
		   if(optUser.isPresent())
			   return convertToDto(optUser.get());
		   else   
		      throw new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
	}
	
	@Override
	public UserDto updateUserById(ObjectId id, UserDto userDto) {
		
		Optional<User> optUser = userRepository.findById(id);
	     
		   if(optUser.isPresent()) {
			   userDto.setId(optUser.get().getId());
			   return userRepository.save(userDto);
		   }
		   else   
		      throw new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
	}

	@Override
	public void deleteUserById(ObjectId id) {
		
		User user = userRepository.findById(id).
				orElseThrow(() -> new IdNotFoundException(AppConstant.NOT_FOUND_MESSAGE +id));
		
		userRepository.delete(user);
	}
	
	@Override
	public UserDto getUserByPhoneNumber(long phoneNumber) {
		Optional<User> optUser = userRepository.findByPhoneNumber(phoneNumber);
	     
		   if(optUser.isPresent())
			   return convertToDto(optUser.get());
		   else   
		      throw new PhoneNumberNotFoundException(AppConstant.PHONE_NUMBER_NOT_FOUND_MESSAGE +phoneNumber);
	}
	
	@Override
	public UserDto getUserByCity(String city) {
		User user = userRepository.findByCity(city)
				.orElseThrow(() -> new InValidCityException(AppConstant.CITY_NOT_FOUND_MESSAGE + city));

		return convertToDto(user);
	}

	@Override
	public UserDto getUserByHolderName(String holderName) {
		Optional<User> optUser = userRepository.findByHolderName(holderName);
	     
		   if(optUser.isPresent())
			   return convertToDto(optUser.get());
		   else   
		      throw new HolderNameNotFoundException(AppConstant.HOLDER_NAME_NOT_FOUND_MESSAGE +holderName);
	}

	@Override
	public UserDto updateUserByPhoneNumber(long phoneNumber, UserDto userDto) {
		User user =  userRepository.findByPhoneNumber(phoneNumber).
				orElseThrow(() -> new PhoneNumberNotFoundException(AppConstant.PHONE_NUMBER_NOT_FOUND_MESSAGE +phoneNumber +"to Update the User " ));
		
		//Set<CreditCard> creditCards = new HashSet<>();

		user.setId(userDto.getId());
		user.setHolderName(userDto.getHolderName());
		user.setAge(userDto.getAge());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setPassword(userDto.getPassword());
		user.setRole(userDto.getRole());
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setCity(userDto.getCity());
		user.setState(userDto.getState());
		user.setCountry(userDto.getCountry());
		user.setPincode(userDto.getPincode());
		user.setCreatedAt(userDto.getCreatedAt());
		

		//Set<CreditCardDto> creditCardDto = userDto.getCreditCardDto();
		  CreditCard creditCard = new CreditCard();
       // for (CreditCardDto creditCardDto : creditCardDto) {
		 creditCard.setId(userDto.getCreditCardDto().getId());
 		creditCard.setCardNumber(userDto.getCreditCardDto().getCardNumber());
 		creditCard.setHolderName(userDto.getCreditCardDto().getHolderName());
 		creditCard.setCardType(userDto.getCreditCardDto().getCardType());
 		creditCard.setCvv(userDto.getCreditCardDto().getCvv());
 		creditCard.setAccountNo(userDto.getCreditCardDto().getAccountNo());
 		creditCard.setDailyLimit(userDto.getCreditCardDto().getDailyLimit());
 		creditCard.setBank(userDto.getCreditCardDto().getBank());
 		creditCard.setBranchName(userDto.getCreditCardDto().getBranchName());
 		creditCard.setExpireDate(userDto.getCreditCardDto().getExpireDate());
 		creditCard.setStatus(userDto.getCreditCardDto().getStatus());
            // creditCard.setUser(user);
    		// }
        user.setCreditCard(creditCard);
        return convertToDto(userRepository.save(user));
	}

	
private UserDto convertToDto(User user) {
		
		UserDto userDto = new UserDto();
		
		//Set<CreditCardDto> creditCardDto = new HashSet<>();
		
		userDto.setId(user.getId());
		userDto.setHolderName(user.getHolderName());
		userDto.setAge(user.getAge());
		userDto.setPhoneNumber(user.getPhoneNumber());
		userDto.setPassword(user.getPassword());
		userDto.setRole(user.getRole());
		userDto.setEmail(user.getEmail());
		userDto.setAddress(user.getAddress());
		userDto.setCity(user.getCity());
		userDto.setState(user.getState());
		userDto.setCountry(user.getCountry());
		userDto.setPincode(user.getPincode());
		userDto.setCreatedAt(user.getCreatedAt());

		//Set<CreditCard> creditCard = user.getCreditCard();
		
		//for(CreditCard creditCard : creditCards) {
		CreditCardDto creditCardDto = new CreditCardDto();
		creditCardDto.setId(user.getCreditCard().getId());
		creditCardDto.setHolderName(user.getCreditCard().getHolderName());
		creditCardDto.setCardNumber(user.getCreditCard().getCardNumber());
		creditCardDto.setAccountNo(user.getCreditCard().getAccountNo());
		creditCardDto.setCardType(user.getCreditCard().getCardType());
		creditCardDto.setDailyLimit(user.getCreditCard().getDailyLimit());
		creditCardDto.setCvv(user.getCreditCard().getCvv());
		creditCardDto.setBalance(user.getCreditCard().getBalance());
		creditCardDto.setBank(user.getCreditCard().getBank());
		creditCardDto.setBranchName(user.getCreditCard().getBranchName());
		creditCardDto.setExpireDate(user.getCreditCard().getExpireDate());
		creditCardDto.setStatus(user.getCreditCard().getStatus());
		//creditCardDto.add(creditCardDto);
		//}
		
		userDto.setCreditCardDto(creditCardDto);
		
		return userDto;
	}
	
		
		private User convertToEntity(UserDto userDto) {
			
			User user = new User();
			//Set<CreditCard> creditCards = new HashSet<>();

			user.setId(userDto.getId());
			user.setHolderName(userDto.getHolderName());
			user.setPhoneNumber(userDto.getPhoneNumber());
			user.setPassword(userDto.getPassword());
			user.setAge(userDto.getAge());
			user.setEmail(userDto.getEmail());
			user.setRole(userDto.getRole());
			user.setAddress(userDto.getAddress());
			user.setCity(userDto.getCity());
			user.setState(userDto.getState());
			user.setCountry(userDto.getCountry());
			user.setCreatedAt(userDto.getCreatedAt());
			
			

		//	Set<CreditCardDto> creditCardDtos = userDto.getCreditCardDto();

	      //  for (CreditCardDto creditCardDto : creditCardDtos) {

	            CreditCard creditCard = new CreditCard();
	 
	            creditCard.setId(userDto.getCreditCardDto().getId());
	    		creditCard.setCardNumber(userDto.getCreditCardDto().getCardNumber());
	    		creditCard.setHolderName(userDto.getCreditCardDto().getHolderName());
	    		creditCard.setCardType(userDto.getCreditCardDto().getCardType());
	    		creditCard.setCvv(userDto.getCreditCardDto().getCvv());
	    		creditCard.setAccountNo(userDto.getCreditCardDto().getAccountNo());
	    		creditCard.setDailyLimit(userDto.getCreditCardDto().getDailyLimit());
	    		creditCard.setBank(userDto.getCreditCardDto().getBank());
	    		creditCard.setBranchName(userDto.getCreditCardDto().getBranchName());
	    		creditCard.setExpireDate(userDto.getCreditCardDto().getExpireDate());
	    		creditCard.setStatus(userDto.getCreditCardDto().getStatus());
	            
	        user.setCreditCard(creditCard);
			
			return user;
		}

		

		
		
		

	
}

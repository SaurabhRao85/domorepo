package com.axis.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.CreditCardDto;
import com.axis.service.CreditCardService;
import com.axis.utility.AppConstant;


@RestController
@RequestMapping("/api/CreditCard")
public class CreditCardController {

	@Autowired
	CreditCardService creditCardService;
	
	@PostMapping("/creditCard")
	public ResponseEntity<CreditCardDto> addUser(@RequestBody CreditCardDto creditCardDto)
	{
		return new ResponseEntity<CreditCardDto>(creditCardService.addCreditCard(creditCardDto), HttpStatus.OK);
	}
	
	@GetMapping("/creditCard")
	public ResponseEntity<List<CreditCardDto>> getAllCreditCard()
	{
		return new ResponseEntity<List<CreditCardDto>>(creditCardService.getAllCreditCard(), HttpStatus.OK);
	}
	
	
	@GetMapping("/creditCard/{id}")
	public ResponseEntity<CreditCardDto> getCreditCardById(@PathVariable  int id)
	{
		return new ResponseEntity<CreditCardDto>(creditCardService.getCreditCardById(id), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/creditCards/{dailyLimit}")
	public ResponseEntity<CreditCardDto> getCreditCardByDailyLimit(@PathVariable  double dailyLimit)
	{
		return new ResponseEntity<CreditCardDto>(creditCardService.getCreditCardByDailyLimit(dailyLimit), HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/creditCards/{id}")
	public ResponseEntity<CreditCardDto> updateCreditCardById(@PathVariable int id, @RequestBody CreditCardDto creditCardDto) {
		
		return new ResponseEntity<CreditCardDto>(creditCardService.updateCreditCardById(id, creditCardDto),HttpStatus.OK);
	}
	
	/*
	 * @PutMapping(value = "/creditCards/{cardNumber}") public
	 * ResponseEntity<CreditCardDto> updateCreditCardByCardNumber(@PathVariable
	 * String cardNumber, @RequestBody CreditCardDto creditCardDto) {
	 * 
	 * return new
	 * ResponseEntity<CreditCardDto>(creditCardService.updateCreditCardByCardNumber(
	 * cardNumber, creditCardDto),HttpStatus.OK); }
	 */
	
	@PutMapping(value = "/ardActivate/{cardNumber}")
	public ResponseEntity<CreditCardDto> activate(@PathVariable long cardNumber, @RequestBody CreditCardDto creditCardDto) {
		
		return new ResponseEntity<CreditCardDto>(creditCardService.activate(cardNumber, creditCardDto),HttpStatus.OK);
	}
	
	@PutMapping(value = "//{cardNumber}")
	public ResponseEntity<CreditCardDto> deactivate(@PathVariable long cardNumber, @RequestBody CreditCardDto creditCardDto) {
		
		return new ResponseEntity<CreditCardDto>(creditCardService.deactivate(cardNumber, creditCardDto),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/creditCards/{id}")
	public ResponseEntity<String> deleteCreditCardById(@PathVariable int id) {
		
		creditCardService.deleteCreditCardById(id);
		return new ResponseEntity<String>(AppConstant.DELETE_MESSAGE, HttpStatus.OK);
	}
}

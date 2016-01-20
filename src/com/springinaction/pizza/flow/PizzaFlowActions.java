package com.springinaction.pizza.flow;

import static org.apache.log4j.Logger.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.springinaction.pizza.domain.CashOrCheckPayment;
import com.springinaction.pizza.domain.CreditCardPayment;
import com.springinaction.pizza.domain.Customer;
import com.springinaction.pizza.domain.Order;
import com.springinaction.pizza.domain.Payment;
import com.springinaction.pizza.domain.PaymentDetails;
import com.springinaction.pizza.domain.PaymentType;

@Component
public class PizzaFlowActions {
	
	private static final Logger LOGGER = getLogger(PizzaFlowActions.class);

	public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException {
		LOGGER.info("look up customer by phone number");
		Customer customer = setupCustomer();
		if (customer != null) {
			return customer;
		} else {
			throw new CustomerNotFoundException();
		}
	}

	private Customer setupCustomer() {
		Customer cs = new Customer();
		cs.setAddress("guangDong province");
		cs.setCity("shantou");
		cs.setId(233);
		cs.setName("ding");
		cs.setPhoneNumber("13249554617");
		cs.setState("haojiang");
		cs.setZipCode("75075");
		return cs;
	}

	public void addCustomer(Customer customer) {
		LOGGER.warn("TODO: Flesh out the addCustomer() method.");
	}

	public Payment verifyPayment(PaymentDetails paymentDetails) {
		Payment payment = null;
		if (paymentDetails.getPaymentType() == PaymentType.CREDIT_CARD) {
			payment = new CreditCardPayment();
		} else {
			payment = new CashOrCheckPayment();
		}

		return payment;
	}

	public void saveOrder(Order order) {
		LOGGER.warn("TODO: Flesh out the saveOrder() method.");
	}

	public boolean checkDeliveryArea(String zipCode) {
		LOGGER.warn("TODO: Flesh out the checkDeliveryArea() method.");
		return "75075".equals(zipCode);
	}

}

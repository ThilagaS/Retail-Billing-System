package com.retail.billing.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.retail.billing.entity.ProductEntity;
import com.retail.billing.entity.UserEntity;
import com.retail.billing.model.Affiliate;
import com.retail.billing.model.BillingResponse;
import com.retail.billing.model.Customer;
import com.retail.billing.model.Employee;
import com.retail.billing.model.ItemsModel;
import com.retail.billing.repository.BillingRepository;
import com.retail.billing.repository.UserRepository;
import com.retail.billing.service.impl.RetailBillingServiceImpl;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)

public class BillingServiceTest {
    Customer newCustomer, oldCustomer;
    Employee employee;
    Affiliate affiliate;
    List<ItemsModel> items;
    List<ProductEntity> products;

    @InjectMocks
    RetailBillingServiceImpl billingService;
    @MockBean
   	UserRepository userRepository;
    @MockBean
    BillingRepository productRepository;
    @Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
     

    }

  
    @Test
    public void billCustomerTest() throws Exception{
    	
		Optional<UserEntity> user=getuserDetails("Customer", 5.0);
		List<ProductEntity> products=getProductsEntity();
		Mockito.when(userRepository.findByUserType("Customer")).thenReturn(user);
		
		Mockito.when(productRepository.findAll()).thenReturn(products);

    	RetailBillingServiceImpl billingServiceSpy = Mockito.spy(billingService);
		BillingResponse response=billingServiceSpy.payableAmount("Customer");  
    	Assert.assertEquals(response.getPayableamount(), (100.0 + 60.0) * 0.95);

    }

    @Test
    public void affiliatePayableAmountTest() throws Exception{
    	
		Optional<UserEntity> user=getuserDetails("Affiliate",0.0);
		List<ProductEntity> products=getProductsEntity();
		Mockito.when(userRepository.findByUserType("Affiliate")).thenReturn(user);
		
		Mockito.when(productRepository.findAll()).thenReturn(products);

    	RetailBillingServiceImpl billingServiceSpy = Mockito.spy(billingService);
		BillingResponse response=billingServiceSpy.payableAmount("Affiliate"); 
    	Assert.assertEquals(response.getPayableamount(), (100.0 + 60.0) * 0.95);



    }
    
    @Test
    public void employeeTest() throws Exception{
    	
		Optional<UserEntity> user=getuserDetails("employee",30.0);
		List<ProductEntity> products=getProductsEntity();
		Mockito.when(userRepository.findByUserType("employee")).thenReturn(user);
		
		Mockito.when(productRepository.findAll()).thenReturn(products);

    	RetailBillingServiceImpl billingServiceSpy = Mockito.spy(billingService);
		BillingResponse response=billingServiceSpy.payableAmount("employee"); 
    	Assert.assertEquals(response.getPayableamount(), (100.0 + 60.0) * 0.95);



    }
    private  List<ProductEntity> getProductsEntity() {

    	products = new ArrayList<ProductEntity>();
    	products.add(new ProductEntity("gi1", "milk", 10.0, "GROCERY"));
    	products.add(new ProductEntity("gi2", "butter", 20.0, "GROCERY"));
    	products.add(new ProductEntity("gi3", "rice", 30.0, "GROCERY"));
    	products.add(new ProductEntity("gi4", "sandwich", 40.0,"GROCERY"));
    	products.add(new ProductEntity("gi5", "skrit", 10.0, "CLOTHES"));
    	products.add(new ProductEntity("gi6", "phant", 20.0, "CLOTHES"));
    	products.add(new ProductEntity("gi7", "mobile", 30.0, "ELECTRONIC"));
		return products;
	}
    
	private Optional<UserEntity> getuserDetails(String userType,double discount) {
    	UserEntity entity=new UserEntity();
    	entity.setItemId("1");
    	entity.setUserType(userType);
    	entity.setDiscount(discount);
    	entity.setName("Test");
    	entity.setDateOfJoining("10/11/2017");
    	entity.setDateOfRegister("10/11/2017");
    	Optional<UserEntity> response = Optional.of(entity);
		return response;
    	
	}


}

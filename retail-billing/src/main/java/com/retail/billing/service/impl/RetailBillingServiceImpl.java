package com.retail.billing.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.billing.constants.Constants;
import com.retail.billing.entity.ProductEntity;
import com.retail.billing.entity.UserEntity;
import com.retail.billing.model.BillingResponse;
import com.retail.billing.model.ItemsModel;
import com.retail.billing.repository.BillingRepository;
import com.retail.billing.repository.UserRepository;
@Service
public class RetailBillingServiceImpl implements RetailBillingService{
	@Autowired
	BillingRepository repository;
	
	@Autowired
	UserRepository userRepository;
	/**
	 * 
	 * @return
	 */
    public List<ItemsModel> getProducts(){
        List<ProductEntity> groceryItems = repository.findAll();
        List<ItemsModel> grocery = new ArrayList<ItemsModel>();
        groceryItems.forEach(groceries -> {
        	ItemsModel model=new ItemsModel();
        	model.setItemType(groceries.getItemType());
        	model.setItemPrice(groceries.getItemPrice());
        	model.setProduct(groceries.getProduct());
        	grocery.add(model);
        });
        return grocery;
    }
    /**
     * 
     * @param items
     * @return
     */
    //find added cost of items in a list
    public double getProductsCost(List<ItemsModel> items){
        double addedCost = 0.0;
        for(ItemsModel item : items){
            addedCost += item.getItemPrice();
        }
        return addedCost;
    }
    /**
     *  payabale amount retrived based on the customer type
     */
	public  BillingResponse  payableAmount(String type) throws Exception {
			Optional<UserEntity> user=userRepository.findByUserType(type);
	        BillingResponse response=new BillingResponse();
			if(user.isPresent()) {
				  double payableAmount = 0.0;
				   List<ItemsModel>  iModel=getProducts();
			       payableAmount = getProductsCost(iModel);	       
			       payableAmount += getProductsCost(iModel.stream().filter(item->item.getItemType().equals(Constants.GROCERY)).collect(Collectors.toList())) * (100 -user.get().getDiscount()) / 100;
			       payableAmount = payableAmount * 0.95;
			       response.setPayableamount(payableAmount);
			       response.setUserType(type);
			}
			else {
				throw new Exception("User nt found");
			}
	       
	       return response;
	}
	
}

package com.asm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.asm.entity.Asset;
import com.asm.entity.Order;
import com.asm.entity.OrderItem;
import com.asm.entity.User;
import com.asm.entity.Warehouse;
import com.asm.repository.OrderItemRepository;

@SpringBootTest
public class OrderItemServiceTest {

	@InjectMocks
	private OrderItemService orderItemService = new OrderItemServiceImpl();

	@Mock
	private OrderItemRepository orderItemRepository;

    @Test
    public void testgetOrderItemById() {

        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseId(1);
        warehouse.setWarehouseLocations("Banglore");
        warehouse.setWarehouseName("Arshad's warehouse");



        Warehouse warehouse1 = new Warehouse();
        warehouse1.setWarehouseId(2);
        warehouse1.setWarehouseLocations("Hyderabad");
        warehouse1.setWarehouseName("bangs warehouse");



        User user = new User();
        user.setUserAddress("Banglore");
        user.setUserEmail("aaa@gmail.com");
        user.setUserMobile(756773836);
        user.setPassword("AAA12");
        user.setUserId(1);
        user.setUserName("AAA");

        OrderItem orderItem = new OrderItem();
        orderItem.setAssetId(1);
        orderItem.setItemQuantity(3);
        
        List<OrderItem> order = new ArrayList<>();

       Order order1 = new Order();
       order1.setFromWarehouseId(1);
       order1.setOrderDate(LocalDate.now());
       order1.setOrderItems(order);

       orderItem.setOrder(order1);
       order.add(orderItem);
       order1.setFromWarehouseId(1);
       order1.setToWarehouseId(2);
       order1.setUser(user);
       order1.setOrderId(1);
       
       List<Order> listOfOrder = new ArrayList<>();
       listOfOrder.add(order1);
       user.setOrder(listOfOrder);
       Asset asset=new Asset();
       asset.setAssetName("vidhya");
       asset.setAssetPrice(900.00);
       asset.setManufacturer("dfgfjh");
       asset.setAssetCategory("fgguj");
       asset.setAssetType("ahg");


      Optional<OrderItem> optionOrderItem=Optional.of(orderItem);

      when(orderItemRepository.findById(1)).thenReturn(optionOrderItem);

      OrderItem myOrderItem=orderItemService.getOrderItemById(1);

      assertEquals(1,myOrderItem.getAssetId());
      orderItemService.getOrderItemById(1);
      
   }
}
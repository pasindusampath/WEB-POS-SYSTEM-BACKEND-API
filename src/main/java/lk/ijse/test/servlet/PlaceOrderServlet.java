package lk.ijse.test.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import lk.ijse.test.dto.custom.ItemDTO;
import lk.ijse.test.dto.custom.OrderDto;
import lk.ijse.test.dto.custom.OrderItemDto;
import lk.ijse.test.dto.custom.ReceiveOrderDTO;
import lk.ijse.test.service.SuperService;
import lk.ijse.test.service.custom.OrderService;
import lk.ijse.test.service.util.ServiceFactory;
import lk.ijse.test.tm.CartTM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "placeOrder",urlPatterns = "/place")
public class PlaceOrderServlet extends HttpServlet {
    OrderService service = ServiceFactory.getInstance().getService(ServiceFactory.Type.ORDER);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader reader = req.getReader();
        StringBuilder builder = new StringBuilder();
        String data ;
        while ((data=reader.readLine())!=null){
            builder.append(data);
        }
        System.out.println(builder);
        ReceiveOrderDTO receiveOrderDTO = new Gson().fromJson(builder.toString(), ReceiveOrderDTO.class);
        System.out.println(receiveOrderDTO);
        OrderDto orderDto = new OrderDto(0, LocalDate.now(), 0,receiveOrderDTO.getCustomer());
        ArrayList<OrderItemDto> orderItems = new ArrayList<>();
        for (CartTM ob:receiveOrderDTO.getCartItems()) {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setItemCode(ob.getItemCode());
            itemDTO.setItemQty(ob.getItemQty());
            OrderItemDto orderItem = new OrderItemDto(0, ob.getItemQty(), orderDto, itemDTO);
            orderItems.add(orderItem);
        }
        service.add(orderDto,orderItems);
        //List<CartTM> yourList = new Gson().fromJson(builder.toString(), listType);
        //for (CartTM ob : yourList){
        //    System.out.println(ob);
        //}

    }
}

package lk.ijse.test.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import lk.ijse.test.dto.custom.ReceiveOrderDTO;
import lk.ijse.test.tm.CartTM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@WebServlet(name = "placeOrder",urlPatterns = "/place")
public class PlaceOrderServlet extends HttpServlet {
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

        //List<CartTM> yourList = new Gson().fromJson(builder.toString(), listType);
        //for (CartTM ob : yourList){
        //    System.out.println(ob);
        //}

    }
}

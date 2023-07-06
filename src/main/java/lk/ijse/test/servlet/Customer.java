package lk.ijse.test.servlet;

import com.google.gson.Gson;
import lk.ijse.test.dto.custom.CustomerDTO;
import lk.ijse.test.service.SuperService;
import lk.ijse.test.service.custom.CustomerService;
import lk.ijse.test.service.custom.impl.CustomerServiceImpl;
import lk.ijse.test.service.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Customer extends HttpServlet {
    CustomerService service = ServiceFactory.getInstance().getService(ServiceFactory.Type.CUSTOMER);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDTO customerDTO = getCustomer(req);
        System.out.println(customerDTO);
        CustomerDTO add = service.add(customerDTO);
        if (add!=null){
            resp.setStatus(HttpServletResponse.SC_OK);
            String s = new Gson().toJson(add);
            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            writer.print(s);
            writer.flush();
            return;
        }
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }


    public CustomerDTO getCustomer(HttpServletRequest req) throws IOException {
        BufferedReader reader = req.getReader();
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line=reader.readLine())!=null){
            builder.append(line);
        }
        Gson gson = new Gson();
        return gson.fromJson(builder.toString(),CustomerDTO.class);
    }


}

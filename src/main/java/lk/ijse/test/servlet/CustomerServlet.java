package lk.ijse.test.servlet;

import com.google.gson.Gson;
import lk.ijse.test.dto.custom.CustomerDTO;
import lk.ijse.test.service.SuperService;
import lk.ijse.test.service.custom.CustomerService;
import lk.ijse.test.service.custom.impl.CustomerServiceImpl;
import lk.ijse.test.service.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CustomerServlet extends HttpServlet {
    CustomerService service = ServiceFactory.getInstance().getService(ServiceFactory.Type.CUSTOMER);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if(type==null){
            CustomerDTO customerDTO = service.get(Integer.parseInt(req.getParameter("id")));
            if(customerDTO!=null){
                sendJsonToClient(resp,customerDTO);
                return;
            }
        }else {
            List<CustomerDTO> all = service.getAll();
            String s = new Gson().toJson(all);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.write(s);
            writer.flush();
            return;
        }
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDTO customerDTO = getCustomer(req);
        System.out.println(customerDTO);
        CustomerDTO add = service.add(customerDTO);
        if (add!=null){
            sendJsonToClient(resp,add);
            return;
        }
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDTO customer = getCustomer(req);
        CustomerDTO update = service.update(customer);
        if(update!=null){
            resp.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(service.delete(Integer.parseInt(req.getParameter("id")))){
            resp.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
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

    public void sendJsonToClient(HttpServletResponse resp,CustomerDTO data) throws IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        String s = new Gson().toJson(data);
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        writer.print(s);
        writer.flush();
    }
}

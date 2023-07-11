package lk.ijse.test.servlet;

import com.google.gson.Gson;
import lk.ijse.test.service.custom.CustomerService;
import lk.ijse.test.service.custom.OrderService;
import lk.ijse.test.service.util.ServiceFactory;
import lk.ijse.test.tm.ChartTM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "dash",urlPatterns = "/dashboard")
public class DashBoardServlet extends HttpServlet {
    OrderService ob = ServiceFactory.getInstance().getService(ServiceFactory.Type.ORDER);
    CustomerService customerService = ServiceFactory.getInstance().getService(ServiceFactory.Type.CUSTOMER);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("switch");
        if(type.equals("orderCount")){
            resp.setContentType("application/jason");
            PrintWriter writer = resp.getWriter();
            writer.write(new Gson().toJson(ob.getOrderCount()));
            writer.flush();

        }
        if(type.equals("customerCount")){
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(new Gson().toJson(customerService.getCustomerCount()));
            writer.flush();
        }
        if(type.equals("incomeData")){
            List<ChartTM> monthlyIncome = ob.getMonthlyIncome();
            String s = new Gson().toJson(monthlyIncome);
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(s);
            writer.flush();
        }
        if(type.equals("soldItems")){
            String data = new Gson().toJson(ob.getItemCountForDay());
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(data);
            writer.flush();
        }
    }
}

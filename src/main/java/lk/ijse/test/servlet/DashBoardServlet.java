package lk.ijse.test.servlet;

import com.google.gson.Gson;
import lk.ijse.test.service.custom.OrderService;
import lk.ijse.test.service.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "dash",urlPatterns = "/dashboard")
public class DashBoardServlet extends HttpServlet {
    OrderService ob = ServiceFactory.getInstance().getService(ServiceFactory.Type.ORDER);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("switch");
        if(type.equals("orderCount")){
            int orderCount = ob.getOrderCount();
            resp.setContentType("application/jason");
            PrintWriter writer = resp.getWriter();
            writer.write(new Gson().toJson(orderCount));
            writer.flush();

        }
    }
}

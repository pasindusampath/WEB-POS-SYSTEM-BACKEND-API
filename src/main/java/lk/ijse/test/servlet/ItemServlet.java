package lk.ijse.test.servlet;

import com.google.gson.Gson;
import lk.ijse.test.dto.custom.ItemDTO;
import lk.ijse.test.service.SuperService;
import lk.ijse.test.service.custom.ItemService;
import lk.ijse.test.service.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ItemServlet extends HttpServlet {
    ItemService service = ServiceFactory.getInstance().getService(ServiceFactory.Type.ITEM);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemDTO item = getItem(req);
        ItemDTO add = service.add(item);
        if(add!=null){
            sendToClients(resp,add);
            return;
        }
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemDTO itemDTO = service.get(Integer.parseInt(req.getParameter("id")));
        if(itemDTO!=null){
            sendToClients(resp,itemDTO);
        }else {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemDTO update = service.update(getItem(req));
        if(update!=null){
            sendToClients(resp,update);
        }else {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean delete = service.delete(Integer.parseInt(req.getParameter("id")));
        if(delete){
            resp.setStatus(HttpServletResponse.SC_OK);
        }else {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    public ItemDTO getItem(HttpServletRequest req) throws IOException {
        BufferedReader reader = req.getReader();
        StringBuilder builder = new StringBuilder();
        String data;
        while ((data=reader.readLine())!=null){
            builder.append(data);
        }
        Gson gson = new Gson();
        return gson.fromJson(builder.toString(),ItemDTO.class);
    }

    public void sendToClients(HttpServletResponse resp,ItemDTO item) throws IOException {
        Gson gson = new Gson();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write(gson.toJson(item));
        writer.flush();
    }

}

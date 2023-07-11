package lk.ijse.test.service.custom;

import lk.ijse.test.dto.custom.OrderDto;
import lk.ijse.test.dto.custom.OrderItemDto;
import lk.ijse.test.service.CrudService;
import lk.ijse.test.tm.ChartTM;
import lk.ijse.test.tm.LineChartTM;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;

public interface OrderService extends CrudService<OrderDto,Integer> {
    public boolean add(OrderDto order, List<OrderItemDto> items);
    public int getOrderCount();
    public List<ChartTM> getMonthlyIncome();
    public List<LineChartTM> getItemCountForDay();
}

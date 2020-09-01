package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities_enum.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;

	private List<OrderItem> item = new ArrayList<>();
	private Client client;

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItem() {
		return item;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem list) {
		item.add(list);
	}

	public void removeItem(OrderItem list) {
		item.remove(list);
	}

	public Double Total() {
		double sum = 0.0;
		for (OrderItem list : item) {
			sum += list.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sd = new StringBuilder();
		sd.append("\nOrder moment: ");
		sd.append(sdf.format(moment) + "\n");
		sd.append("Order Status: ");
		sd.append(status + "\n");
		sd.append(client);
		sd.append("\nOrder Items: ");
		for (OrderItem list : item) {
			sd.append(list + "\n");
		}
		sd.append("Total: $" + String.format("%.2f", Total()));

		return sd.toString();
	}

}
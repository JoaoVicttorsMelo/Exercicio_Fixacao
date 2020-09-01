package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities_enum.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter Cliente Data:");
		System.out.print("\nName: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date: ");
		Date date = sdf.parse(sc.next());
		Client client = new Client(name, email, date);
		System.out.print("\nEnter order data: \n");
		System.out.print("Status: ");
		String status = sc.next();
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		System.out.print("\nHow many items to this order? ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("\nEnter #" + i + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameItem = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			Product product = new Product(nameItem, price);
			OrderItem oi = new OrderItem(quantity, price, product);
			order.addItem(oi);
		}
		System.out.println(order);
		sc.close();
	}

}

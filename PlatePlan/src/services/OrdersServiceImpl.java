package services;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.postgresql.util.ByteBufferByteStreamWriter;

import database.DataBase;
import database.DataBaseFactory;
import database.SQLTables;
import dto.MenuItem;
import dto.Order;
import dto.Reservation;
import service_interfaces.AccountService;
import service_interfaces.MenuService;
import service_interfaces.OrdersService;
import service_interfaces.ReservationService;
import service_interfaces.ServerService;
import service_interfaces.TablesService;

public class OrdersServiceImpl implements OrdersService {
	private static OrdersService instance;

	private DataBase db;
	private ServerService serviceUtils;
	private TablesService tablesService;
	private AccountService accountService;
	private MenuService menuService;
	private ReservationService reservationService;

	private OrdersServiceImpl() {
	}

	@Override
	public void initializeDependency(AccountService accountService, TablesService tablesService,
			ServerService serviceUtils, ReservationService reservationService, MenuService menuService) {

		db = DataBaseFactory.getDatabase();
		this.accountService = accountService;
		this.serviceUtils = serviceUtils;
		this.reservationService = reservationService;
		this.tablesService = tablesService;
		this.menuService = menuService;
	}

	// Public static method to get the instance of the class
	public static OrdersService getInstance() {
		// Create the instance if it does not exist
		if (instance == null) {
			instance = new OrdersServiceImpl();
		}
		// Return the existing instance
		return instance;

	}

	@Override
	public List<Order> getAllOrders() {
		return db.getAllOrders();
	}

	@Override
	public boolean addOrder(Reservation reservation, MenuItem menuItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Order> getAllOrdersForReservation(Reservation reservation) {
		List<Order> orders = db.getAllOrders().stream().filter(obj -> obj.getReservation().equals(reservation.getId()))
				.collect(Collectors.toList());

		List<MenuItem> menuItems = menuService.getAllMenuItems(SQLTables.CUSTOMER_MENU_TABLE);
		for (Order order : orders) {
		    menuItems.removeIf(menuItem -> order.getItem().equalsIgnoreCase(menuItem.getName()));
		}

		
		for (MenuItem menuItem : menuItems) {
			Order tempOrder = new Order();
			tempOrder.setId(UUID.randomUUID().toString());
			tempOrder.setCustomer(reservation.getCustomerId());
			tempOrder.setDate(reservation.getDate());
			tempOrder.setPrice(menuItem.getPrice());
			tempOrder.setQuantity(0);
			tempOrder.setReservation(reservation.getId());
			tempOrder.setItem(menuItem.getName());

			orders.add(tempOrder);

		}
		return orders;

	}

	@Override
	public List<Order> getAllOrdersForDate(LocalDate date) {
		return db.getAllOrders().stream().filter(obj -> obj.getDate().equals(date)).collect(Collectors.toList());
	}

	@Override
	public boolean updateOrder(Order order) {
		return db.updateDataBaseEntry(order, SQLTables.ORDERS_TABLE);
		
	}

}

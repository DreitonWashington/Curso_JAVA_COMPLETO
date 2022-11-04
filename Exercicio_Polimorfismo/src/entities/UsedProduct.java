package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	
	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	
	protected Date manufactureDate;
	
	public UsedProduct() {
		super();
	}
	
	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public String getManufactureDate() {
		return fmt.format(manufactureDate);
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public final String priceTag() {
		return this.getName() + " (used) $" + String.format("%.2f", this.getPrice()) + 
				" (Manufacture date: " + this.getManufactureDate() + ")";
	}
	
	
}

package com.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// @Entity annotation specifies that the class is mapped to a database table.
@Entity
public class Model {

	// @Id annotation specifies the primary key of an entity.
	// @GeneratedValue provides the generation strategy specification for the
	// primary key values.
	@Id
	@GeneratedValue
	private int id;
	private int apple;
	private double orange;
	private double total;

	// Default constructor.
	public Model() {
	}

	// Parameterized constructor.
	public Model(int id, int apple, double orange, double total) {
		this.id = id;
		this.apple = apple;
		this.orange = orange;
		this.total = total;
	}

	// Getters.

	public double getOrange() {
		return orange;
	}

	public int getApple() {
		return apple;
	}

	public int getId() {
		return id;

	}

	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", apple=" + apple + ", orange=" + orange + ", total=" + total + "]";
	}

}
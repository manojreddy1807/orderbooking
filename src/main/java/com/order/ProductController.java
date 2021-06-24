package com.order;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	ModelService service;
	int count = 0;

	
	@PostMapping(value = "/order/offer/save")
	public String Offer(@RequestParam("appleCount") Integer appleCount,
			@RequestParam("orangeCount") Integer orangeCount) {
		count++;
		double  finalOrangeCount = 0;
		Double totalAppleCost = (0.6 * appleCount);
		Double totalOrangeCost = (0.25 * orangeCount);
		Double totalValue = totalAppleCost + totalOrangeCost;

		if(orangeCount%2!=0 && orangeCount>1) {
			finalOrangeCount=(orangeCount-1)*1.5;
		}
		
		else if(orangeCount>1){
			finalOrangeCount=orangeCount*1.5;
		}
		
		Model model = new Model(count, appleCount * 2, finalOrangeCount, totalValue);
		log.info("Storing order details in the database." + model);

		service.save(model);
		return "The total order summary of order ID "+count+" applying the offer  is \n"
				+ " The no of apples is (due to buy 1 get 1 offer)"+appleCount+"*2 =" + appleCount * 2+"\n"
				+ " The total cost of apple *0.6 =" + totalAppleCost +"\n\n"
				+ " The total no of oranges is (due to buy 2 get 3 offer)" + finalOrangeCount+"\n"
				+ " The total cost of oranges is " + orangeCount + "*0.25 =" + totalOrangeCost+"\n\n"
				+ " The total cost of Apple and oranges  is " + totalValue;

	}
	
	@PostMapping(value = "/order/save")
	public String save(@RequestParam("appleCount") Integer appleCount,
			@RequestParam("orangeCount") Integer orangeCount) {
		count++;

		Double totalAppleCost = (0.6 * appleCount);
		Double totalOrangeCost = (0.25 * orangeCount);
		Double totalValue = totalAppleCost + totalOrangeCost;

		Model model = new Model(count, appleCount,orangeCount, totalValue);
		log.info("Storing order details in the database." + model);

		service.save(model);
		return "The total order summary of order ID "+count+"  is \n"
				+ " The no of apples is "+appleCount+"\n"
				+ " The total cost of apples is "+appleCount+" *0.6 =" + totalAppleCost +"\n\n"
				+ " The total no of oranges is " + orangeCount+"\n"
				+ " The total cost of oranges is " + orangeCount + "*0.25 =" + totalOrangeCost+"\n\n"
				+ " The total cost of Apple and oranges  is " + totalValue;

	}

	
	// @GetMapping annotation handles the http get request matched with the given
	// uri.
	@GetMapping(value = "/order/getall")
	public ResponseEntity<List<Model>> getAll() {
		List<Model> models = service.getAll();
		log.info("Getting order details from the database." + models);

		return ResponseEntity.ok(models);
	}

	@GetMapping(value = "/order/getbyid")
	public ResponseEntity<Optional<Model>> getbyId(@RequestParam("id") Integer id) {
		Optional<Model> models = service.getbyId(id);
		log.info("Getting order details from the database by ID." + models);
		return ResponseEntity.ok(models);
	}


}

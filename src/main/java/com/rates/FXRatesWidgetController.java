package com.rates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rates.model.BuyCurrencyParam;
import com.rates.model.Result;
import com.rates.model.SellCurrencyParam;
import com.rates.service.FXRatesWidgetService;

@RestController
public class FXRatesWidgetController {
	
	@Autowired
	private FXRatesWidgetService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/buy-currency")
	public Result buyCurrency(@RequestBody BuyCurrencyParam requestBody) {
		return service.buyCurrency(requestBody);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/sell-currency")
	public Result sellCurrency(@RequestBody SellCurrencyParam requestBody) {
		return service.sellCurrency(requestBody);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/rates-offered")
	public String ratesOffered() {
		return service.getCurrencyRates().toString();
	}
}

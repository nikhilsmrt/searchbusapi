package com.altimetrik.bus.search.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.bus.search.bean.BusSearchInputParameter;
import com.altimetrik.bus.search.bean.BusSearchResult;
import com.altimetrik.bus.search.service.BusSerachService;

@RestController
public class BusSearchController {
	@Autowired
	private BusSerachService busSearchService;

	@PostMapping("/getAllBusDetails")
	public List<BusSearchResult> getAllBusDetails(
			@Validated @RequestBody BusSearchInputParameter busSearchInputParameter) {
		List<BusSearchResult> listBusSearchResult = busSearchService.getAllBus(busSearchInputParameter);
		listBusSearchResult.sort(Comparator.comparing(BusSearchResult::getPrice));
		return listBusSearchResult;
	}

}

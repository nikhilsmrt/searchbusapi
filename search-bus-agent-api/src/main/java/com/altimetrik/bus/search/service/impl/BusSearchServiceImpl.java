
package com.altimetrik.bus.search.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.altimetrik.bus.search.bean.BusSearchInputParameter;
import com.altimetrik.bus.search.bean.BusSearchResult;
import com.altimetrik.bus.search.service.BusSerachService;

@Service
public class BusSearchServiceImpl implements BusSerachService {

	@Override
	public List<BusSearchResult> getAllBus(BusSearchInputParameter busSearchInputParameter) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<BusSearchInputParameter> diamondBusdRequestEntity = new HttpEntity<>(busSearchInputParameter, requestHeaders);
		HttpEntity<BusSearchInputParameter> evergreenBusdRequestEntity = new HttpEntity<>(busSearchInputParameter, requestHeaders);
		ResponseEntity<List<BusSearchResult>> diamondBuslistResponseEntity = restTemplate.exchange(
				"http://localhost:8081/diamondBus/getAllBus", HttpMethod.POST, diamondBusdRequestEntity,
				new ParameterizedTypeReference<List<BusSearchResult>>() {
				});
		ResponseEntity<List<BusSearchResult>> evergreenBuslistResponseEntity = restTemplate.exchange(
				"http://localhost:8082/evergreenBus/getAllBus", HttpMethod.POST, evergreenBusdRequestEntity,
				new ParameterizedTypeReference<List<BusSearchResult>>() {
				});
		List<BusSearchResult> listDiamondBusSearchResults = diamondBuslistResponseEntity.getBody();
		List<BusSearchResult> listEvergreenBusSearchResults = evergreenBuslistResponseEntity.getBody();
		List<BusSearchResult> listTotalBusAvailable=new ArrayList<BusSearchResult>(listDiamondBusSearchResults);
		listTotalBusAvailable.addAll(listEvergreenBusSearchResults);
		return listTotalBusAvailable;
	}

}

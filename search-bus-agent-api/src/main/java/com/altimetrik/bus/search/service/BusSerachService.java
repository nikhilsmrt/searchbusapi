package com.altimetrik.bus.search.service;

import java.util.List;

import com.altimetrik.bus.search.bean.BusSearchInputParameter;
import com.altimetrik.bus.search.bean.BusSearchResult;

public interface BusSerachService {
public List<BusSearchResult> getAllBus(BusSearchInputParameter busSearchInputParameter);
}

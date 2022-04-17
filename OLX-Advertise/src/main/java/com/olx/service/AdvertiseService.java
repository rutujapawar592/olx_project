package com.olx.service;

import java.time.LocalDate;
import java.util.List;

import com.olx.dto.Advertise;

public interface AdvertiseService {

	public Advertise postAdvertise(Advertise adv);

//	public Advertise updateAdvertise(int categoryId, Advertise adv, String authToken);

	public Boolean deleteAdvertise(String authToken, Advertise adv);

	public List<Advertise> getAllAdvByUser();

	public List<Advertise> getAdvByUser();

	public Advertise SearchAdvByText(String searchText);

	public Advertise returnAdv(int id);

//	public List<Advertise> searchAdvertisesByFilterCriteria(String searchText, int categoryId, String postedBy,
//			String dateCondition, LocalDate onDate, LocalDate fromDate, LocalDate toDate, String sortedBy,
//			int startIndex, int records);
	List<Advertise> filterAdvertise(String searchText, Integer categoryId, String postedBy, String dateCondition,
			LocalDate onDate, LocalDate fromDate, LocalDate toDate, String sortedBy, int startIndex, int records);

	public Advertise createNewAdvertise(Advertise advertise, String authToken);

	public Advertise updateAdvertise(int categoryId, String authToken, Advertise adv);
}

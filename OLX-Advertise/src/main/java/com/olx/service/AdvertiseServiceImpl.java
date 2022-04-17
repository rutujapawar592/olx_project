package com.olx.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.Advertise;
import com.olx.entity.AdvertiseEntity;
import com.olx.exception.InvalidAuthTokenException;
import com.olx.repository.AdvertiseRepo;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	@Autowired
	EntityManager entityManager; // JPA

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	AdvertiseRepo advertiseRepo;

	@Autowired
	LoginServiceDelegate loginServiceDelegate;

//	@Override
//	public Stock createNewStock(Stock stock) {
//		StockEntity stockEntity = convertDTOIntoEntity(stock);
//		stockEntity = stockRepo.save(stockEntity);
//		return convertEntityIntoDTO(stockEntity);
//	}

	@Override
	public List<Advertise> getAllAdvByUser() {
		return null;
	}

	@Override
	public List<Advertise> getAdvByUser() {
		return null;
	}

//	@Override
//	public Advertise filterAdv(Advertise adv) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Advertise> filterAdvertise(String searchText, Integer categoryId, String postedBy, String dateCondition,
			LocalDate onDate, LocalDate fromDate, LocalDate toDate, String sortedBy, int startIndex, int records) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AdvertiseEntity> criteriaQuery = criteriaBuilder.createQuery(AdvertiseEntity.class);
		Root<AdvertiseEntity> root = criteriaQuery.from(AdvertiseEntity.class);

		Predicate predicateTitle = criteriaBuilder.and();
		Predicate predicateDescription = criteriaBuilder.and();
		Predicate predicateSearchText = criteriaBuilder.and();
		Predicate predicateCategory = criteriaBuilder.and();
		Predicate predicateDateConditionEquals = criteriaBuilder.and();
		Predicate predicateDateConditionGreateThan = criteriaBuilder.and();
		Predicate predicateDateConditionLessThan = criteriaBuilder.and();
		Predicate predicateDateConditionBetweenFromDate = criteriaBuilder.and();
		Predicate predicatePostedBy = criteriaBuilder.and();
		Predicate predicateDateCondition = criteriaBuilder.and();

		Predicate predicateFinal = criteriaBuilder.and();

		if (searchText != null && !"".equalsIgnoreCase(searchText)) {
			predicateTitle = criteriaBuilder.like(root.get("title"), "%" + searchText + "%");
			predicateDescription = criteriaBuilder.like(root.get("description"), "%" + searchText + "%");
			predicateSearchText = criteriaBuilder.or(predicateTitle, predicateDescription);
		}

		if (postedBy != null && !"".equalsIgnoreCase(postedBy)) {
			predicatePostedBy = criteriaBuilder.equal(root.get("username"), postedBy);
		}

		if (dateCondition != null && dateCondition.contains("equal")) {
			predicateDateConditionEquals = criteriaBuilder.equal(root.get("createdDate"), onDate);
		}

		if (dateCondition != null && dateCondition.contains("greatethan")) {
			predicateDateConditionGreateThan = criteriaBuilder.greaterThan(root.get("createdDate"), fromDate);
		}

		if (dateCondition != null && dateCondition.contains("lessthan")) {
			predicateDateConditionLessThan = criteriaBuilder.greaterThan(root.get("createdDate"), onDate);
		}

		if (dateCondition != null && dateCondition.contains("between")) {
			predicateDateConditionBetweenFromDate = criteriaBuilder.between(root.get("createdDate"), fromDate, toDate);
		}

		predicateDateCondition = criteriaBuilder.and(predicateDateConditionEquals, predicateDateConditionGreateThan,
				predicateDateConditionLessThan, predicateDateConditionBetweenFromDate);

		if (sortedBy != null && !sortedBy.equalsIgnoreCase("")) {
			// criteriaQuery.orderBy(criteriaBuilder);
		}

		if (categoryId != null) {
			predicateCategory = criteriaBuilder.equal(root.get("category"), categoryId);
		}

		predicateFinal = criteriaBuilder.and(predicateSearchText, predicateCategory, predicateDateCondition,
				predicatePostedBy);
		criteriaQuery.where(predicateFinal);
		TypedQuery<AdvertiseEntity> typedQuery = entityManager.createQuery(criteriaQuery);
		typedQuery.setFirstResult(startIndex);
		typedQuery.setMaxResults(records);
		List<AdvertiseEntity> advertiseEntityList = typedQuery.getResultList();
		return convertEntityListIntoDTOList(advertiseEntityList);
	}

	private List<Advertise> convertEntityListIntoDTOList(List<AdvertiseEntity> advertiseEntityList) {
		// return new StockEntity(stock.getId(), stock.getName(), stock.getMarket(),
		// stock.getPrice());
		List<Advertise> advertisesList = new ArrayList<>();
		for (AdvertiseEntity advertiseEntity : advertiseEntityList) {
			TypeMap<AdvertiseEntity, Advertise> typeMap = modelMapper.typeMap(AdvertiseEntity.class, Advertise.class);
			Advertise advertise = modelMapper.map(advertiseEntity, Advertise.class);
			advertisesList.add(advertise);
		}

		return advertisesList;
	}

//	private List<Advertise> convertEntityListIntoDTOList(List<AdvertiseEntity> advertiseEntityList) {
//		List<AdvertiseDTO> advertiseDtoList = new ArrayList<AdvertiseDTO>();
//		for(AdvertiseEntity advertiseEntity : advertiseEntities) {
//			AdvertiseDTO advertise = new AdvertiseDTO(advertiseEntity.getId,advertiseEntity.getTitle(), advertiseEntity., advertiseEntity);
//			advertiseDtoList.add(advertise);
//		}
//		return advertiseDtoList;
//	}

	@Override
	public Advertise returnAdv(int id) {
		return null;
	}

	@Override
	public Advertise SearchAdvByText(String searchText) {
		return null;
	}

//	@Override
//	public boolean deleteAdvertise(Advertise adv) {
//		return true;
//	}

//	@Override
//	public Advertise postAdvertise(Advertise adv) {
//		AdvertiseEntity advertiseEntity = convertDTOIntoEntity(adv);
//		advertiseEntity = advertiseRepo.save(advertiseEntity);
//		return convertEntityIntoDTO(advertiseEntity);
//	}

	@Override
	public Advertise createNewAdvertise(Advertise advertise, String authToken) {
		if (loginServiceDelegate.isTokenValid(authToken)) {
			AdvertiseEntity advertiseEntity = convertDTOIntoEntity(advertise);
			advertiseEntity = advertiseRepo.save(advertiseEntity);
			return convertEntityIntoDTO(advertiseEntity);
//			return advertise;
		} else {
			throw new InvalidAuthTokenException(authToken);
		}
	}

	private AdvertiseEntity convertDTOIntoEntity(Advertise adv) {
//		TypeMap<Stock, AdvertiseEntity> typeMap = modelMapper.typeMap(Stock.class, AdvertiseEntity.class);
//		typeMap.addMappings(mapper -> {
//			mapper.map(stockDto -> stockDto.getMarket(), StockEntity::setMarketname);
//		});
		AdvertiseEntity advertiseEntity = modelMapper.map(adv, AdvertiseEntity.class);
		return advertiseEntity;
	}

	private Advertise convertEntityIntoDTO(AdvertiseEntity advertiseEntity) {
//		TypeMap<StockEntity, Advertise> typeMap = modelMapper.typeMap(StockEntity.class, Stock.class);
//		typeMap.addMappings(mapper -> {
//			mapper.map(stockentity -> stockEntity.getMarketname(), Stock::setMarket);
//		});
		Advertise adv = modelMapper.map(advertiseEntity, Advertise.class);
		return adv;
	}

	@Override
	public Advertise postAdvertise(Advertise adv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Advertise updateAdvertise(int categoryId, String authToken, Advertise adv) {
		Optional<AdvertiseEntity> opAdvertiseEntity = advertiseRepo.findById(categoryId);
		if (opAdvertiseEntity.isPresent()) {
			AdvertiseEntity advertiseEntity = opAdvertiseEntity.get();
			advertiseEntity.setTitle(adv.getTitle());
			advertiseEntity.setDescription(adv.getDescription());
			advertiseEntity.setPrice(adv.getPrice());
			advertiseEntity.setCategoryId(adv.getCategoryId());
			advertiseEntity.setCategory(adv.getCategory());
			advertiseEntity.setCreatedDate(adv.getCreatedDate());
			advertiseEntity.setModifiedDate(adv.getCreatedDate());
			advertiseEntity.setActive(adv.getActive());
			advertiseEntity.setUsername(adv.getUsername());
			advertiseRepo.save(advertiseEntity);
		}
		return adv;
	}

	@Override
	public Boolean deleteAdvertise(String authToken, Advertise adv) {
		
		return null;
	}

}

package com.olx.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Advertise;
import com.olx.exception.FromDateMissingException;
import com.olx.exception.InvalidAdvertiseIdException;
import com.olx.exception.InvalidAuthTokenException;
import com.olx.exception.InvalidCategoryIdException;
import com.olx.exception.InvalidPageIdException;
import com.olx.exception.InvalidStatusIdException;
import com.olx.exception.OnDateMissingException;
import com.olx.exception.ToDateMissingException;
import com.olx.exception.UserNameDoesNotExistException;
import com.olx.service.AdvertiseService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/olx/advertise")
@CrossOrigin(origins = "*")
public class AdvertiseController {

	@Autowired
	AdvertiseService advertiseService;

	@ExceptionHandler(value = InvalidAuthTokenException.class) // Local Exception Handler
	public ResponseEntity<String> handleExceptionAuthToken(InvalidAuthTokenException exception) {
		return new ResponseEntity<String>(exception.toString(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidAdvertiseIdException.class) // Local Exception Handler
	public ResponseEntity<String> handleExceptionInvalidAdvId(InvalidAdvertiseIdException exception) {
		return new ResponseEntity<String>(exception.toString(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = UserNameDoesNotExistException.class) // Local Exception Handler
	public ResponseEntity<String> handleExceptionUserName(UserNameDoesNotExistException exception) {
		return new ResponseEntity<String>(exception.toString(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = OnDateMissingException.class) // Local Exception Handler
	public ResponseEntity<String> handleExceptionOnDate(OnDateMissingException exception) {
		return new ResponseEntity<String>(exception.toString(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = FromDateMissingException.class) // Local Exception Handler
	public ResponseEntity<String> handleExceptionFromDate(FromDateMissingException exception) {
		return new ResponseEntity<String>(exception.toString(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ToDateMissingException.class) // Local Exception Handler
	public ResponseEntity<String> handleExceptionToDate(ToDateMissingException exception) {
		return new ResponseEntity<String>(exception.toString(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidPageIdException.class) // Local Exception Handler
	public ResponseEntity<String> handleExceptionInvalidPageId(InvalidPageIdException exception) {
		return new ResponseEntity<String>(exception.toString(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidCategoryIdException.class) // Local Exception Handler
	public ResponseEntity<String> handleExceptionInvalidCatId(InvalidCategoryIdException exception) {
		return new ResponseEntity<String>(exception.toString(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidStatusIdException.class) // Local Exception Handler
	public ResponseEntity<String> handleExceptionStatusId(InvalidStatusIdException exception) {
		return new ResponseEntity<String>(exception.toString(), HttpStatus.BAD_REQUEST);
	}

//	@PostMapping(value = "", consumes = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
//					MediaType.APPLICATION_JSON_VALUE })
//	@ApiOperation(value = "Post Advertisement", notes = "This REST API is used to post advertisements")
//	public Advertise postAdvertise(@RequestHeader("auth-token") String authToken, Advertise adv) {
//		return advertiseService.postAdvertise(adv);
//	}

	@PostMapping(value = "/postAd", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Advertise> createNewAdvertise(@RequestBody Advertise advertise,
			@RequestHeader("Authorization") String authToken) {
		Advertise advertises = this.advertiseService.createNewAdvertise(advertise, authToken);
		return new ResponseEntity<Advertise>(advertise, HttpStatus.OK);
	}
	

	@PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Update Advertisement", notes = "This REST API is used to update advertisements")
	public ResponseEntity<Advertise> updateAdvertise(@PathVariable("id") int categoryId,
			@RequestHeader("Authorization") String authToken, Advertise adv) {
		Advertise advertise = this.advertiseService.updateAdvertise(categoryId, authToken, adv);
		return new ResponseEntity<Advertise>(adv, HttpStatus.OK);
	}

	@GetMapping(value = "/user/advertise", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Reads all Advertisements", notes = "This REST API returns all Advertisements")
	public List<Advertise> getAllAdvByUser(@RequestHeader("auth-token") String authToken) {
		return advertiseService.getAllAdvByUser();
	}

//	@DeleteMapping(value = "/user/logout")
//	@ApiOperation(value = "logs out  a user", notes = "logs out a user session")
//	public ResponseEntity<Boolean> logout(@RequestHeader("auth-token") String authToken) {
//		return new ResponseEntity<Boolean>(loginService.logout(authToken), HttpStatus.OK);
//	}

	@DeleteMapping(value = "/{advertiseId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Delete Advertisement", notes = "This REST API is used to delete advetisement")
	public ResponseEntity<Boolean> deleteAdvertise(@RequestHeader("Authorization") String authToken) {
		return new ResponseEntity<Boolean>(this.advertiseService.deleteAdvertise(null, null), HttpStatus.OK);
	}

	@GetMapping(value = "/search/filtercriteria", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Getting a List of Avertise by FilterCriteria", notes = "This Rest API will return List of Advertise by Filter Criteria")
	public List<Advertise> searchAdvertisesByFilterCriteria(
			@RequestParam(name = "searchText", required = false) String searchText,
			@RequestParam(name = "category", required = false) Integer categoryId,
			@RequestParam(name = "postedBy", required = false) String postedBy,
			@RequestParam(name = "dateCondition", required = false) String dateCondition,
			@RequestParam(name = "onDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate onDate,
			@RequestParam(name = "fromDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
			@RequestParam(name = "toDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
			@RequestParam(name = "sortedBy", required = false) String sortedBy,
			@RequestParam(name = "startIndex", defaultValue = "0") int startIndex,
			@RequestParam(name = "records", defaultValue = "10") int records) {
		return advertiseService.filterAdvertise(searchText, categoryId, postedBy, dateCondition, onDate, fromDate,
				toDate, sortedBy, startIndex, records);
	}

	@GetMapping(value = "/{advertiseId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Reads all Advertisements by ID", notes = "This REST API returns All Advertisements by ID")
	public Advertise returnAdv(@RequestHeader("auth-token") String authToken, int id) {
		return advertiseService.returnAdv(id);
	}

	@GetMapping(value = "/advertise/search", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Reads all Advertisements by Search", notes = "This REST API returns Advertisements by Search")
	public Advertise SearchAdvByText(@RequestHeader("auth-token") String authToken, String searchText) {
		return advertiseService.SearchAdvByText(searchText);
	}

}

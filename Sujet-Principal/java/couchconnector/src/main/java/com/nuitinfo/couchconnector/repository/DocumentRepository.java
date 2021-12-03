package com.nuitinfo.couchconnector.repository;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nuitinfo.couchconnector.models.CouchDBResponse;
import com.nuitinfo.couchconnector.models.Document;

@RestController
@RequestMapping("/admin")
public class DocumentRepository {

	@GetMapping(path="/nom")
	public List<Document> getDocumentByNom(@RequestParam String nom) throws IOException, UnirestException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<JsonNode> jsonResponse = Unirest.post("http://zolnieruck:adminPassword!@couchdb-zolnieruck.alwaysdata.net:5984/zolnieruck_couch/_find")
				  .header("Content-Type", "application/json")
				  .body("{\r\n    \"selector\": {\r\n        \"nom\": {\r\n            \"$regex\" : \"" + nom + "\"\r\n        }\r\n    }\r\n}")
				  .asJson();
		
		CouchDBResponse out = new ObjectMapper().readValue(new String(jsonResponse.getRawBody().readAllBytes()), new TypeReference<CouchDBResponse>(){});
		
		return out.getDocs() != null ? out.getDocs() : new ArrayList<>();
	}
	
	@GetMapping(path="/prenom")
	public List<Document> getDocumentByPrenom(@RequestParam String prenom) throws IOException, UnirestException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<JsonNode> jsonResponse = Unirest.post("http://zolnieruck:adminPassword!@couchdb-zolnieruck.alwaysdata.net:5984/zolnieruck_couch/_find")
				.header("Content-Type", "application/json")
				.body("{\r\n    \"selector\": {\r\n        \"prenom\": {\r\n            \"$regex\" : \"" + prenom + "\"\r\n        }\r\n    }\r\n}")
				.asJson();
		
		CouchDBResponse out = new ObjectMapper().readValue(new String(jsonResponse.getRawBody().readAllBytes()), new TypeReference<CouchDBResponse>(){});
		
		return out.getDocs() != null ? out.getDocs() : new ArrayList<>();
	}
}

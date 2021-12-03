package com.nuitinfo.couchconnector.repository;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nuitinfo.couchconnector.models.CouchDBResponse;
import com.nuitinfo.couchconnector.models.CounchDBResponsePut;
import com.nuitinfo.couchconnector.models.Document;

@RestController
@RequestMapping("/admin")
public class DocumentRepository {

	@CrossOrigin
	@GetMapping(path="/nom")
	public List<Document> getDocumentByNom(@RequestParam String nom) throws IOException, UnirestException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<JsonNode> jsonResponse = Unirest.post("http://zolnieruck:adminPassword!@couchdb-zolnieruck.alwaysdata.net:5984/zolnieruck_sauveteurs/_find")
				  .header("Content-Type", "application/json")
				  .body("{\r\n    \"selector\": {\r\n        \"nom\": {\r\n            \"$regex\" : \"" + nom + "\"\r\n        }\r\n    }\r\n}")
				  .asJson();
		
		CouchDBResponse out = new ObjectMapper().readValue(new String(jsonResponse.getRawBody().readAllBytes()), new TypeReference<CouchDBResponse>(){});
		
		return out.getDocs() != null ? out.getDocs() : new ArrayList<>();
	}
	
	@CrossOrigin
	@GetMapping(path="/prenom")
	public List<Document> getDocumentByPrenom(@RequestParam String prenom) throws IOException, UnirestException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<JsonNode> jsonResponse = Unirest.post("http://zolnieruck:adminPassword!@couchdb-zolnieruck.alwaysdata.net:5984/zolnieruck_sauveteurs/_find")
				.header("Content-Type", "application/json")
				.body("{\r\n    \"selector\": {\r\n        \"prenom\": {\r\n            \"$regex\" : \"" + prenom + "\"\r\n        }\r\n    }\r\n}")
				.asJson();
		
		CouchDBResponse out = new ObjectMapper().readValue(new String(jsonResponse.getRawBody().readAllBytes()), new TypeReference<CouchDBResponse>(){});
		
		return out.getDocs() != null ? out.getDocs() : new ArrayList<>();
	}

	@PutMapping(path = "/put")
	public CounchDBResponsePut saveDocument(@RequestBody Document document) throws IOException, UnirestException {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 20;
		Random random = new Random();

		String id = random.ints(leftLimit, rightLimit + 1)
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
		
		document.setId(id);
		
		Unirest.setTimeouts(0, 0);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(document);
		HttpResponse<String> jsonResponse = Unirest.put("http://zolnieruck:adminPassword!@185.31.40.67:5984/zolnieruck_sauveteurs/"+id)
				.header("Content-Type", "application/json")
				.body(json)
				.asString();

		return new ObjectMapper().readValue(new String(jsonResponse.getRawBody().readAllBytes()), new TypeReference<CounchDBResponsePut>(){});

	}
}

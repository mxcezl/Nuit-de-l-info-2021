package com.nuitinfo.couchconnector.models;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class CouchDBResponse {
	private List<Document> docs;
	private String bookmark;
	private String warning;
}

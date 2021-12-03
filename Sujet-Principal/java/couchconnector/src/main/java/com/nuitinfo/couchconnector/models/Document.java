package com.nuitinfo.couchconnector.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
@JsonIgnoreProperties(value = { "_id", "_rev" })
public class Document {
	
	private String _id;
	private String _rev;
	private String nom;
	private String prenom;
	private List<Content> content;
}

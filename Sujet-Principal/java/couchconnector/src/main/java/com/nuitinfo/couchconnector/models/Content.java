package com.nuitinfo.couchconnector.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class Content {
	private String titre;
	private String contenu;
}

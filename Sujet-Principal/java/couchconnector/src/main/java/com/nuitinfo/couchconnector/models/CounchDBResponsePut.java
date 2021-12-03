package com.nuitinfo.couchconnector.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
@JsonIgnoreProperties(value = { "id", "rev" })
public class CounchDBResponsePut {
    private String ok;
    private String id;
    private String rev;

}

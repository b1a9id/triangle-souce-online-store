package com.triangle.sauce.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest implements Serializable {

	private String email;

	private ContactType type;

	private String contact;
}

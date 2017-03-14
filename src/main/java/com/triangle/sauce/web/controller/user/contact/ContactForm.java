package com.triangle.sauce.web.controller.user.contact;

import com.triangle.sauce.core.model.ContactType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactForm implements Serializable {

	@NotNull
	@Email
	private String email;

	@NotNull
	private ContactType type;

	@NotNull
	private String content;
}

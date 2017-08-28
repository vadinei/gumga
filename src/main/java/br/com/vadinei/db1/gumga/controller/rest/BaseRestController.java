package br.com.vadinei.db1.gumga.controller.rest;

import java.io.Serializable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
 *         09:27:35
 */
@RestController
@RequestMapping( "/api/" )
public abstract class BaseRestController implements Serializable
{

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         09:30:13
	 */
	private static final long serialVersionUID = 5695273345659843733L;

}

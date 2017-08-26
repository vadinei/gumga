package br.com.vadinei.db1.gumga.controller.rest.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
 *         09:33:01
 */
@RequestMapping( "/api/v1/password-meter" )
public class PasswordMeterController extends BaseVersionController
{

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         09:28:00
	 */
	private static final long serialVersionUID = 672152255526210949L;

	@RequestMapping( "/" )
	String index()
	{
		return "Password Meter Rest Controller";
	}

	public static void main( final String[] args ) throws Exception
	{
		SpringApplication.run( PasswordMeterController.class, args );
	}

}

package br.com.vadinei.db1.gumga.controller.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.vadinei.db1.gumga.domain.model.PasswordMeterModel;
import br.com.vadinei.db1.gumga.domain.service.PasswordMeterService;
import br.com.vadinei.db1.gumga.sistema.util.JsonResponse;
import br.com.vadinei.db1.gumga.sistema.util.JsonResponseStatus;

/**
 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
 *         09:33:01
 */
@EnableAutoConfiguration
@RequestMapping( "/api/v1/password-meter" )
@ComponentScan( "br.com.vadinei.db1.gumga" )
public class PasswordMeterController extends BaseVersionController
{

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         09:28:00
	 */
	private static final long serialVersionUID = 672152255526210949L;

	@Autowired
	private PasswordMeterService passwordMeterService;

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         21:15:00
	 * @return String
	 */
	@RequestMapping( "/" )
	String index()
	{
		return "Password Meter Rest Controller";
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         21:15:06
	 * @param password
	 * @return JsonResponse
	 */
	@RequestMapping( value = "/check-password", method = RequestMethod.GET )
	public @ResponseBody JsonResponse checkPassword( @RequestParam( required = false ) final String password )
	{
		final JsonResponse response = new JsonResponse();

		try
		{
			final PasswordMeterModel model = this.passwordMeterService.checkPassword( password, 0 );

			response.addParameter( "model", model );
			response.setJsonResponseStatus( JsonResponseStatus.SUCCESS );
		}
		catch ( final Exception e )
		{
			response.setJsonResponseStatus( JsonResponseStatus.FAIL );
			response.setResult( e.getMessage() );
		}

		return response;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         21:21:28
	 * @param args
	 */
	public static void main( final String[] args )
	{
		SpringApplication.run( PasswordMeterController.class, args );
	}

}

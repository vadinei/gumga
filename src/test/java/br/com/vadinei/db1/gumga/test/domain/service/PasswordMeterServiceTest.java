/**
 * Todos os direitos reservados a José Vádinei Soares.
 */
package br.com.vadinei.db1.gumga.test.domain.service;

import org.junit.Test;

import br.com.vadinei.db1.gumga.domain.model.PasswordMeterModel;
import br.com.vadinei.db1.gumga.domain.service.PasswordMeterService;

/**
 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
 *         14:38:36
 */
public class PasswordMeterServiceTest
{

	private final PasswordMeterService service = new PasswordMeterService();

	@Test
	public void printCheckPassword()
	{
		final PasswordMeterModel model = this.service.checkPassword( "aaAaA12@", 8 );

		System.out.println( "-----------------------------------------------------" );
		System.out.print( "ADDITIONS:" );
		System.out.println( "\t\t\t\tCOUNT" + "\tBONUS" );
		System.out.println( "-----------------------------------------------------" );
		System.out.println( "" );

		System.out.print( "Number of Characters................:" );
		System.out.print( "\t" + model.getNumberCharacterCount() );
		System.out.println( "\t" + model.getNumberCharacterBonus() );

		System.out.print( "Uppercase Letters...................:" );
		System.out.print( "\t" + model.getUppercaseLetterCount() );
		System.out.println( "\t" + model.getUppercaseLetterBonus() );

		System.out.print( "Lowercase Letters...................:" );
		System.out.print( "\t" + model.getLowercaseLetterCount() );
		System.out.println( "\t" + model.getLowercaseLetterBonus() );

		System.out.print( "Numbers.............................:" );
		System.out.print( "\t" + model.getNumberCount() );
		System.out.println( "\t" + model.getNumberBonus() );

		System.out.print( "Symbols.............................:" );
		System.out.print( "\t" + model.getSymbolCount() );
		System.out.println( "\t" + model.getSymbolBonus() );

		System.out.println( "Middle Numbers or Symbols...........:" );
		System.out.println( "Requirements........................:" );
		System.out.println( "" );
		System.out.println( "-----------------------------------------------------" );
		System.out.print( "DEDUCATIONS:" );
		System.out.println( "\t\t\t\tCOUNT" + "\tBONUS" );
		System.out.println( "-----------------------------------------------------" );
		System.out.println( "" );
		System.out.println( "Letters Only........................:" );
		System.out.println( "Numbers Only........................:" );
		System.out.println( "Repeat Characters (Case Insensitive):" );
		System.out.println( "Consecutive Uppercase Letters.......:" );
		System.out.println( "Consecutive Lowercase Letters.......:" );
		System.out.println( "Consecutive Numbers.................:" );
		System.out.println( "Sequential Letters..................:" );
		System.out.println( "Sequential Numbers..................:" );
		System.out.println( "" );
	}

}

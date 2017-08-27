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

		// final PasswordMeterModel model = this.service.checkPassword( "aaAa",
		// 8 );

		// final PasswordMeterModel model = this.service.checkPassword( "1234",
		// 8 );

		// final PasswordMeterModel model = this.service.checkPassword( "aaaAA",
		// 8 );

		// final PasswordMeterModel model = this.service.checkPassword(
		// "Tururu2017", 8 );

		// final PasswordMeterModel model = this.service.checkPassword(
		// "abcde12345@#$%", 8 );

		System.out.println( "-----------------------------------------------------" );
		System.out.println( "PASSWORD.: " + model.getPassword() );
		System.out.println( "-----------------------------------------------------" );
		System.out.println( "" );
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

		System.out.print( "Middle Numbers or Symbols...........:" );
		System.out.print( "\t" + model.getMiddleNumberSymbolCount() );
		System.out.println( "\t" + model.getMiddleNumberSymbolBonus() );

		System.out.print( "Requirements........................:" );
		System.out.print( "\t" + model.getRequirementsCount() );
		System.out.println( "\t" + model.getRequirementsBonus() );
		System.out.println( "" );

		System.out.println( "-----------------------------------------------------" );
		System.out.print( "DEDUCTIONS:" );
		System.out.println( "\t\t\t\tCOUNT" + "\tBONUS" );
		System.out.println( "-----------------------------------------------------" );
		System.out.println( "" );

		System.out.print( "Letters Only........................:" );
		System.out.print( "\t" + model.getLettersOnlyCount() );
		System.out.println( "\t" + model.getLettersOnlyBonus() );

		System.out.print( "Numbers Only........................:" );
		System.out.print( "\t" + model.getNumbersOnlyCount() );
		System.out.println( "\t" + model.getNumbersOnlyBonus() );

		System.out.print( "Repeat Characters (Case Insensitive):" );
		System.out.print( "\t" + model.getRepeatCharactersCount() );
		System.out.println( "\t" + model.getRepeatCharactersBonus() );

		System.out.print( "Consecutive Uppercase Letters.......:" );
		System.out.print( "\t" + model.getConsecutiveUppercaseLetterCount() );
		System.out.println( "\t" + model.getConsecutiveUppercaseLetterBonus() );

		System.out.print( "Consecutive Lowercase Letters.......:" );
		System.out.print( "\t" + model.getConsecutiveLowercaseLetterCount() );
		System.out.println( "\t" + model.getConsecutiveLowercaseLetterBonus() );

		System.out.print( "Consecutive Numbers.................:" );
		System.out.print( "\t" + model.getConsecutiveNumbersCount() );
		System.out.println( "\t" + model.getConsecutiveNumbersBonus() );

		System.out.print( "Sequential Letters..................:" );
		System.out.print( "\t" + model.getSequentialLettersCount() );
		System.out.println( "\t" + model.getSequentialLettersBonus() );

		System.out.print( "Sequential Numbers..................:" );
		System.out.print( "\t" + model.getSequentialNumbersCount() );
		System.out.println( "\t" + model.getSequentialNumbersBonus() );

		System.out.print( "Sequential Symbols..................:" );
		System.out.print( "\t" + model.getSequentialSymbolsCount() );
		System.out.println( "\t" + model.getSequentialSymbolsBonus() );
		System.out.println( "" );
	}

}

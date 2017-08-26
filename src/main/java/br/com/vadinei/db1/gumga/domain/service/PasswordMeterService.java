package br.com.vadinei.db1.gumga.domain.service;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import br.com.vadinei.db1.gumga.domain.model.PasswordMeterModel;

/**
 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
 *         10:57:56
 */
@Component
public class PasswordMeterService implements Serializable
{

	private static final int CNS_ZERO = 0;

	private static final int CNS_ONE_POSITIVE = 1;

	private static final int CNS_ONE_NEGATIVE = -1;

	private static final int CNS_MULTIPLIER_FACTOR_2 = 2;

	private static final int CNS_MULTIPLIER_FACTOR_3 = 3;

	private static final int CNS_MULTIPLIER_FACTOR_4 = 4;

	private static final int CNS_MULTIPLIER_FACTOR_6 = 6;

	private static final String CNS_CHAR_ALPHA = "abcdefghijklmnopqrstuvwxyz";

	private static final String CNS_CHAR_NUMBER = "0123456789";

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         10:58:02
	 */
	private static final long serialVersionUID = 6354133538662598235L;

	public PasswordMeterModel checkPassword( final String password, int minPasswordLength )
	{
		final PasswordMeterModel model = new PasswordMeterModel();

		if ( ( password == null ) || ( password.length() == PasswordMeterService.CNS_ZERO ) )
		{
			return model;
		}

		if ( minPasswordLength < 4 )
		{
			minPasswordLength = 4;
		}

		final int passwordLength = password.length();
		model.setNumberCharacterCount( passwordLength );

		final int numberCharacterBonus = passwordLength * PasswordMeterService.CNS_MULTIPLIER_FACTOR_4;
		model.setNumberCharacterBonus( numberCharacterBonus );

		final String[] arrPasswordSplit = password.replaceAll( "\\s+", "" ).split( "\\s*" );

		if ( ( arrPasswordSplit != null ) && ( arrPasswordSplit.length > PasswordMeterService.CNS_ZERO ) )
		{
			int uppercaseLetterCount = PasswordMeterService.CNS_ZERO;
			int lowercaseLetterCount = PasswordMeterService.CNS_ZERO;
			int numberCount = PasswordMeterService.CNS_ZERO;
			int symbolCount = PasswordMeterService.CNS_ZERO;

			int uppercaseLetterAux = PasswordMeterService.CNS_ONE_NEGATIVE;
			int lowercaseLetterAux = PasswordMeterService.CNS_ONE_NEGATIVE;
			int numberAux = PasswordMeterService.CNS_ONE_NEGATIVE;
			int symbolAux = PasswordMeterService.CNS_ONE_NEGATIVE;

			int consecutiveUppercaseLetter = PasswordMeterService.CNS_ZERO;
			int consecutiveLowercaseLetter = PasswordMeterService.CNS_ZERO;
			int consecutiveLetter = PasswordMeterService.CNS_ZERO;
			int consecutiveNumber = PasswordMeterService.CNS_ZERO;
			int consecutiveSymbol = PasswordMeterService.CNS_ZERO;

			int replicateLetter = PasswordMeterService.CNS_ZERO;

			for ( int i = PasswordMeterService.CNS_ZERO; i < arrPasswordSplit.length; i++ )
			{
				final String item = arrPasswordSplit[ i ];

				// Upper Case Matches
				if ( item.matches( "[A-Z]" ) )
				{
					if ( uppercaseLetterAux != PasswordMeterService.CNS_ONE_NEGATIVE )
					{
						if ( ( uppercaseLetterAux + 1 ) == i )
						{
							consecutiveUppercaseLetter++;
							consecutiveLetter++;
						}
					}

					uppercaseLetterAux = i;
					uppercaseLetterCount++;
				}
				// Lower Case Matches
				else if ( item.matches( "[a-z]" ) )
				{
					if ( lowercaseLetterAux != PasswordMeterService.CNS_ONE_NEGATIVE )
					{
						if ( ( lowercaseLetterAux + 1 ) == i )
						{
							consecutiveLowercaseLetter++;
							consecutiveLetter++;
						}
					}

					lowercaseLetterAux = i;
					lowercaseLetterCount++;
				}
				// Number Matches
				else if ( item.matches( "[0-9]" ) )
				{
					if ( numberAux != PasswordMeterService.CNS_ONE_NEGATIVE )
					{
						if ( ( numberAux + 1 ) == i )
						{
							consecutiveNumber++;
							consecutiveLetter++;
						}
					}

					numberAux = i;
					numberCount++;
				}
				// Symbol Matches
				else if ( item.matches( "[^a-zA-Z0-9_]" ) )
				{
					if ( symbolAux != PasswordMeterService.CNS_ONE_NEGATIVE )
					{
						if ( ( symbolAux + 1 ) == i )
						{
							consecutiveSymbol++;
							consecutiveLetter++;
						}
					}

					symbolAux = i;
					symbolCount++;
				}

				// Check Duplicate
				for ( int j = PasswordMeterService.CNS_ZERO; j < arrPasswordSplit.length; j++ )
				{
					final String itemAux = arrPasswordSplit[ j ];

					if ( ( i != j ) && ( item.equalsIgnoreCase( itemAux ) ) )
					{
						replicateLetter++;
					}
				}

			}

			final int uppercaseLetterBonus = ( ( passwordLength - uppercaseLetterCount )
					* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
			model.setUppercaseLetterCount( uppercaseLetterCount );
			model.setUppercaseLetterBonus( uppercaseLetterBonus );

			final int lowercaseLetterBonus = ( ( passwordLength - lowercaseLetterCount )
					* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
			model.setLowercaseLetterCount( lowercaseLetterCount );
			model.setLowercaseLetterBonus( lowercaseLetterBonus );

			final int numberBonus = ( numberCount * PasswordMeterService.CNS_MULTIPLIER_FACTOR_4 );
			model.setNumberCount( numberCount );
			model.setNumberBonus( numberBonus );

			final int symbolBonus = ( symbolCount * PasswordMeterService.CNS_MULTIPLIER_FACTOR_6 );
			model.setSymbolCount( symbolCount );
			model.setSymbolBonus( symbolBonus );

		}

		return model;
	}

}

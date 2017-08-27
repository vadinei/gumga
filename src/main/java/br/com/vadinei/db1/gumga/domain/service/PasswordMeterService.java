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

	private static final double CNS_ZERO_DOUBLE = 0.0;

	private static final int CNS_ONE_POSITIVE = 1;

	private static final int CNS_ONE_NEGATIVE = -1;

	private static final int CNS_MULTIPLIER_FACTOR_2 = 2;

	private static final int CNS_MULTIPLIER_FACTOR_3 = 3;

	private static final int CNS_MULTIPLIER_FACTOR_4 = 4;

	private static final int CNS_MULTIPLIER_FACTOR_6 = 6;

	private static final String CNS_ARRAY_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	private static final String CNS_ARRAY_NUMBER = "01234567890";

	private static final String CNS_ARRAY_SYMBOL = ")!@#$%^&*()";

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         10:58:02
	 */
	private static final long serialVersionUID = 6354133538662598235L;

	/**
	 * Implementa as regras de negócios para o avaliador de senhas definidas no
	 * site: "http://www.passwordmeter.com/".
	 *
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         02:09:59
	 * @param password
	 * @param minPasswordLength
	 * @return PasswordMeterModel
	 */
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

		final String[] arrPasswordSplit = password.replaceAll( "\\s+", "" ).split( "\\s*" );

		if ( ( arrPasswordSplit != null ) && ( arrPasswordSplit.length > PasswordMeterService.CNS_ZERO ) )
		{
			int uppercaseLetterCount = PasswordMeterService.CNS_ZERO;
			int lowercaseLetterCount = PasswordMeterService.CNS_ZERO;
			int numberCount = PasswordMeterService.CNS_ZERO;
			int symbolCount = PasswordMeterService.CNS_ZERO;
			int middleNumberSymbolCount = PasswordMeterService.CNS_ZERO;

			int uppercaseLetterAux = PasswordMeterService.CNS_ONE_NEGATIVE;
			int lowercaseLetterAux = PasswordMeterService.CNS_ONE_NEGATIVE;
			int numberAux = PasswordMeterService.CNS_ONE_NEGATIVE;
			int symbolAux = PasswordMeterService.CNS_ONE_NEGATIVE;

			int consecutiveUppercaseLetterCount = PasswordMeterService.CNS_ZERO;
			int consecutiveLowercaseLetterCount = PasswordMeterService.CNS_ZERO;
			int consecutiveCharacterCount = PasswordMeterService.CNS_ZERO;
			int consecutiveNumberCount = PasswordMeterService.CNS_ZERO;
			int consecutiveSymbolCount = PasswordMeterService.CNS_ZERO;

			int replicateCharacter = PasswordMeterService.CNS_ZERO;
			int uniqueCharacter = PasswordMeterService.CNS_ZERO;

			double replicateIncrement = PasswordMeterService.CNS_ZERO_DOUBLE;

			int sequentialLettersCount = PasswordMeterService.CNS_ZERO;
			int sequentialNumbersCount = PasswordMeterService.CNS_ZERO;
			int sequentialSymbolsCount = PasswordMeterService.CNS_ZERO;
			int sequentialCharacterCount = PasswordMeterService.CNS_ZERO;

			final int arrPasswordSplitLength = arrPasswordSplit.length;

			for ( int i = PasswordMeterService.CNS_ZERO; i < arrPasswordSplitLength; i++ )
			{
				final String item = arrPasswordSplit[ i ];

				// Uppercase Matches
				if ( item.matches( "[A-Z]" ) )
				{
					if ( uppercaseLetterAux != PasswordMeterService.CNS_ONE_NEGATIVE )
					{
						if ( ( uppercaseLetterAux + 1 ) == i )
						{
							consecutiveUppercaseLetterCount++;
							consecutiveCharacterCount++;
						}
					}

					uppercaseLetterAux = i;
					uppercaseLetterCount++;
				}
				// Lowercase Matches
				else if ( item.matches( "[a-z]" ) )
				{
					if ( lowercaseLetterAux != PasswordMeterService.CNS_ONE_NEGATIVE )
					{
						if ( ( lowercaseLetterAux + 1 ) == i )
						{
							consecutiveLowercaseLetterCount++;
							consecutiveCharacterCount++;
						}
					}

					lowercaseLetterAux = i;
					lowercaseLetterCount++;
				}
				// Number Matches
				else if ( item.matches( "[0-9]" ) )
				{
					if ( ( i > 0 ) && ( i < ( arrPasswordSplitLength - 1 ) ) )
					{
						middleNumberSymbolCount++;
					}

					if ( numberAux != PasswordMeterService.CNS_ONE_NEGATIVE )
					{
						if ( ( numberAux + 1 ) == i )
						{
							consecutiveNumberCount++;
							consecutiveCharacterCount++;
						}
					}

					numberAux = i;
					numberCount++;
				}
				// Symbol Matches
				else if ( item.matches( "[^a-zA-Z0-9_]" ) )
				{
					if ( ( i > 0 ) && ( i < ( arrPasswordSplitLength - 1 ) ) )
					{
						middleNumberSymbolCount++;
					}

					if ( symbolAux != PasswordMeterService.CNS_ONE_NEGATIVE )
					{
						if ( ( symbolAux + 1 ) == i )
						{
							consecutiveSymbolCount++;
							consecutiveCharacterCount++;
						}
					}

					symbolAux = i;
					symbolCount++;
				}

				// Verificando replicações >> Letter, Number and Symbol
				boolean exists = Boolean.FALSE;

				for ( int j = PasswordMeterService.CNS_ZERO; j < arrPasswordSplitLength; j++ )
				{
					final String itemAux = arrPasswordSplit[ j ];

					if ( ( i != j ) && ( item.equals( itemAux ) ) )
					{
						exists = Boolean.TRUE;
						replicateIncrement += Math.abs( arrPasswordSplitLength / ( j - i ) );
					}
				}

				if ( exists )
				{
					replicateCharacter++;
					uniqueCharacter = ( arrPasswordSplitLength - replicateCharacter );
					replicateIncrement = ( ( uniqueCharacter > 0 ) ? Math.ceil( replicateIncrement / uniqueCharacter )
							: Math.ceil( replicateIncrement ) );
				}
			}

			// Verificando sequência de caracteres >> Letter
			final String passwordLowercase = password.toLowerCase();
			final int arrayAlphabetSequenceLength = ( PasswordMeterService.CNS_ARRAY_ALPHABET.length() - 3 );

			for ( int l = 0; l < arrayAlphabetSequenceLength; l++ )
			{
				final String forward = PasswordMeterService.CNS_ARRAY_ALPHABET.substring( l, ( l + 3 ) );

				final StringBuilder sbReverse = new StringBuilder( forward );
				final String reverse = sbReverse.reverse().toString();

				if ( passwordLowercase.contains( forward ) || passwordLowercase.contains( reverse ) )
				{
					sequentialLettersCount++;
					sequentialCharacterCount++;
				}
			}

			// Verificando sequência de caracteres >> Number
			final int arrayNumberSequenceLength = ( PasswordMeterService.CNS_ARRAY_NUMBER.length() - 3 );

			for ( int n = 0; n < arrayNumberSequenceLength; n++ )
			{
				final String forward = PasswordMeterService.CNS_ARRAY_NUMBER.substring( n, ( n + 3 ) );

				final StringBuilder sbReverse = new StringBuilder( forward );
				final String reverse = sbReverse.reverse().toString();

				if ( passwordLowercase.contains( forward ) || passwordLowercase.contains( reverse ) )
				{
					sequentialNumbersCount++;
					sequentialCharacterCount++;
				}
			}

			// Verificando sequência de caracteres >> Symbol
			final int arraySymbolSequenceLength = ( PasswordMeterService.CNS_ARRAY_SYMBOL.length() - 3 );

			for ( int s = 0; s < arraySymbolSequenceLength; s++ )
			{
				final String forward = PasswordMeterService.CNS_ARRAY_SYMBOL.substring( s, ( s + 3 ) );

				final StringBuilder sbReverse = new StringBuilder( forward );
				final String reverse = sbReverse.reverse().toString();

				if ( passwordLowercase.contains( forward ) || passwordLowercase.contains( reverse ) )
				{
					sequentialSymbolsCount++;
					sequentialCharacterCount++;
				}
			}

			// Definindo "Password"
			model.setPassword( password );

			// Definindo "Number of Characters"
			model.setNumberCharacterCount( passwordLength );

			final int numberCharacterBonus = passwordLength * PasswordMeterService.CNS_MULTIPLIER_FACTOR_4;
			model.setNumberCharacterBonus( numberCharacterBonus );

			// Definindo "Uppercase Letters"
			model.setUppercaseLetterCount( uppercaseLetterCount );
			if ( ( uppercaseLetterCount > 0 ) && ( uppercaseLetterCount < passwordLength ) )
			{
				final int uppercaseLetterBonus = ( ( passwordLength - uppercaseLetterCount )
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
				model.setUppercaseLetterBonus( uppercaseLetterBonus );
			}

			// Definindo "Lowercase Letters"
			model.setLowercaseLetterCount( lowercaseLetterCount );
			if ( ( lowercaseLetterCount > 0 ) && ( lowercaseLetterCount < passwordLength ) )
			{
				final int lowercaseLetterBonus = ( ( passwordLength - lowercaseLetterCount )
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
				model.setLowercaseLetterBonus( lowercaseLetterBonus );
			}

			// Definindo "Numbers"
			model.setNumberCount( numberCount );
			if ( ( numberCount > 0 ) && ( numberCount < passwordLength ) )
			{
				final int numberBonus = ( numberCount * PasswordMeterService.CNS_MULTIPLIER_FACTOR_4 );
				model.setNumberBonus( numberBonus );
			}

			// Definindo "Symbols"
			model.setSymbolCount( symbolCount );
			if ( symbolCount > 0 )
			{
				final int symbolBonus = ( symbolCount * PasswordMeterService.CNS_MULTIPLIER_FACTOR_6 );
				model.setSymbolBonus( symbolBonus );
			}

			// Definindo "Middle Numbers or Symbols"
			model.setMiddleNumberSymbolCount( middleNumberSymbolCount );
			if ( middleNumberSymbolCount > 0 )
			{
				final int middleNumberSymbolBonus = ( middleNumberSymbolCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
				model.setMiddleNumberSymbolBonus( middleNumberSymbolBonus );
			}

			// Definindo "Letters Only"
			if ( ( ( uppercaseLetterCount > 0 ) || ( lowercaseLetterCount > 0 ) )
					&& ( ( numberCount == 0 ) && ( symbolCount == 0 ) ) )
			{
				final int lettersOnlyCount = passwordLength;
				model.setLettersOnlyCount( lettersOnlyCount );
				model.setLettersOnlyBonus( lettersOnlyCount );
			}

			// Definindo "Numbers Only"
			if ( ( numberCount > 0 )
					&& ( ( uppercaseLetterCount == 0 ) && ( lowercaseLetterCount == 0 ) && ( symbolCount == 0 ) ) )
			{
				final int numbersOnlyCount = passwordLength;
				model.setNumbersOnlyCount( numbersOnlyCount );
				model.setNumbersOnlyBonus( numbersOnlyCount );
			}

			// Definindo "Repeat Characters (Case Insensitive)"
			model.setRepeatCharactersCount( replicateCharacter );
			if ( replicateCharacter > 0 )
			{
				final int repeatCharactersBonus = ( int ) replicateIncrement;
				model.setRepeatCharactersBonus( repeatCharactersBonus );
			}

			// Definindo "Consecutive Uppercase Letters"
			model.setConsecutiveUppercaseLetterCount( consecutiveUppercaseLetterCount );
			if ( consecutiveUppercaseLetterCount > 0 )
			{
				final int consecutiveUppercaseLetterBonus = ( consecutiveUppercaseLetterCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
				model.setConsecutiveUppercaseLetterBonus( consecutiveUppercaseLetterBonus );
			}

			// Definindo "Consecutive Lowercase Letters"
			model.setConsecutiveLowercaseLetterCount( consecutiveLowercaseLetterCount );
			if ( consecutiveLowercaseLetterCount > 0 )
			{
				final int consecutiveLowercaseLetterBonus = ( consecutiveLowercaseLetterCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
				model.setConsecutiveLowercaseLetterBonus( consecutiveLowercaseLetterBonus );
			}

			// Definindo "Consecutive Numbers"
			model.setConsecutiveNumbersCount( consecutiveNumberCount );
			if ( consecutiveNumberCount > 0 )
			{
				final int consecutiveNumbersBonus = ( consecutiveNumberCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
				model.setConsecutiveNumbersBonus( consecutiveNumbersBonus );
			}

			// Definindo "Sequential Letters (3+)"
			model.setSequentialLettersCount( sequentialLettersCount );
			if ( sequentialLettersCount > 0 )
			{
				final int sequentialLettersBonus = ( sequentialLettersCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_3 );
				model.setSequentialLettersBonus( sequentialLettersBonus );
			}

			// Definindo "Sequential Numbers (3+)"
			model.setSequentialNumbersCount( sequentialNumbersCount );
			if ( sequentialNumbersCount > 0 )
			{
				final int sequentialNumbersBonus = ( sequentialNumbersCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_3 );
				model.setSequentialNumbersBonus( sequentialNumbersBonus );
			}

			// Definindo "Sequential Symbols (3+)"
			model.setSequentialSymbolsCount( sequentialSymbolsCount );
			if ( sequentialSymbolsCount > 0 )
			{
				final int sequentialSymbolsBonus = ( sequentialSymbolsCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_3 );
				model.setSequentialSymbolsBonus( sequentialSymbolsBonus );
			}

		}

		return model;
	}

}

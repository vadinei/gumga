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
	 * @param minimumPasswordLength
	 * @return PasswordMeterModel
	 */
	@SuppressWarnings( "unused" )
	public PasswordMeterModel checkPassword( final String password, int minimumPasswordLength )
	{
		final PasswordMeterModel model = new PasswordMeterModel();

		if ( ( password == null ) || ( password.length() == PasswordMeterService.CNS_ZERO ) )
		{
			return model;
		}

		if ( minimumPasswordLength < 8 )
		{
			minimumPasswordLength = 8;
		}

		final int passwordLength = password.length();

		final String[] arrPasswordSplit = password.replaceAll( "\\s+", "" ).split( "\\s*" );

		if ( ( arrPasswordSplit != null ) && ( arrPasswordSplit.length > PasswordMeterService.CNS_ZERO ) )
		{
			final int arrPasswordSplitLength = arrPasswordSplit.length;

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
			int consecutiveNumberCount = PasswordMeterService.CNS_ZERO;
			int consecutiveSymbolCount = PasswordMeterService.CNS_ZERO; // Unused.
			int consecutiveCharacterCount = PasswordMeterService.CNS_ZERO; // Unused.

			int requirementsCount = PasswordMeterService.CNS_ZERO;
			int requirementsCharacter = PasswordMeterService.CNS_ZERO;

			int uniqueCharacter = PasswordMeterService.CNS_ZERO;
			int replicateCharacter = PasswordMeterService.CNS_ZERO;
			double replicateIncrement = PasswordMeterService.CNS_ZERO_DOUBLE;

			int sequentialLettersCount = PasswordMeterService.CNS_ZERO;
			int sequentialNumbersCount = PasswordMeterService.CNS_ZERO;
			int sequentialSymbolsCount = PasswordMeterService.CNS_ZERO;
			int sequentialCharacterCount = PasswordMeterService.CNS_ZERO; // Unused.

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
					if ( ( i > PasswordMeterService.CNS_ZERO ) && ( i < ( arrPasswordSplitLength - 1 ) ) )
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
					if ( ( i > PasswordMeterService.CNS_ZERO ) && ( i < ( arrPasswordSplitLength - 1 ) ) )
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
						replicateIncrement += Math.abs( ( ( double ) arrPasswordSplitLength ) / ( j - i ) );
					}
				}

				if ( exists )
				{
					replicateCharacter++;
					uniqueCharacter = ( arrPasswordSplitLength - replicateCharacter );
					replicateIncrement = ( uniqueCharacter != PasswordMeterService.CNS_ZERO )
							? Math.ceil( replicateIncrement / uniqueCharacter )
							: Math.ceil( replicateIncrement );
				}
			}

			// Verificando sequência de caracteres >> Letter
			final String passwordLowercase = password.toLowerCase();
			final int arrayAlphabetSequenceLength = ( PasswordMeterService.CNS_ARRAY_ALPHABET.length() - 3 );

			for ( int l = PasswordMeterService.CNS_ZERO; l < arrayAlphabetSequenceLength; l++ )
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

			for ( int n = PasswordMeterService.CNS_ZERO; n < arrayNumberSequenceLength; n++ )
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

			for ( int s = PasswordMeterService.CNS_ZERO; s < arraySymbolSequenceLength; s++ )
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
			if ( ( uppercaseLetterCount > PasswordMeterService.CNS_ZERO ) && ( uppercaseLetterCount < passwordLength ) )
			{
				final int uppercaseLetterBonus = ( ( passwordLength - uppercaseLetterCount )
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
				model.setUppercaseLetterBonus( uppercaseLetterBonus );
			}

			// Definindo "Lowercase Letters"
			model.setLowercaseLetterCount( lowercaseLetterCount );
			if ( ( lowercaseLetterCount > PasswordMeterService.CNS_ZERO ) && ( lowercaseLetterCount < passwordLength ) )
			{
				final int lowercaseLetterBonus = ( ( passwordLength - lowercaseLetterCount )
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
				model.setLowercaseLetterBonus( lowercaseLetterBonus );
			}

			// Definindo "Numbers"
			model.setNumberCount( numberCount );
			if ( ( numberCount > PasswordMeterService.CNS_ZERO ) && ( numberCount < passwordLength ) )
			{
				final int numberBonus = ( numberCount * PasswordMeterService.CNS_MULTIPLIER_FACTOR_4 );
				model.setNumberBonus( numberBonus );
			}

			// Definindo "Symbols"
			model.setSymbolCount( symbolCount );
			if ( symbolCount > PasswordMeterService.CNS_ZERO )
			{
				final int symbolBonus = ( symbolCount * PasswordMeterService.CNS_MULTIPLIER_FACTOR_6 );
				model.setSymbolBonus( symbolBonus );
			}

			// Definindo "Middle Numbers or Symbols"
			model.setMiddleNumberSymbolCount( middleNumberSymbolCount );
			if ( middleNumberSymbolCount > PasswordMeterService.CNS_ZERO )
			{
				final int middleNumberSymbolBonus = ( middleNumberSymbolCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
				model.setMiddleNumberSymbolBonus( middleNumberSymbolBonus );
			}

			// Definindo "Requirements"
			final int arrRequirements[] = new int[] { passwordLength, uppercaseLetterCount, lowercaseLetterCount,
					numberCount, symbolCount };
			final int arrRequirementsLength = arrRequirements.length;

			for ( int i = PasswordMeterService.CNS_ZERO; i < arrRequirementsLength; i++ )
			{
				final int requirementValue = arrRequirements[ i ];
				final int minimumValue = ( i == PasswordMeterService.CNS_ZERO ) ? ( minimumPasswordLength - 1 )
						: PasswordMeterService.CNS_ZERO;

				if ( ( requirementValue == ( minimumValue + 1 ) ) || ( requirementValue > ( minimumValue + 1 ) ) )
				{
					requirementsCharacter++;
				}
			}

			requirementsCount = requirementsCharacter;
			model.setRequirementsCount( requirementsCount );

			final int minimumRequirements = ( passwordLength >= minimumPasswordLength ) ? 3 : 4;

			if ( requirementsCount > minimumRequirements )
			{
				final int requirementsBonus = ( requirementsCount * PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
				model.setRequirementsBonus( requirementsBonus );
			}

			// Definindo "Letters Only"
			if ( ( ( uppercaseLetterCount > PasswordMeterService.CNS_ZERO )
					|| ( lowercaseLetterCount > PasswordMeterService.CNS_ZERO ) )
					&& ( ( numberCount == PasswordMeterService.CNS_ZERO )
							&& ( symbolCount == PasswordMeterService.CNS_ZERO ) ) )
			{
				final int lettersOnlyCount = passwordLength;
				model.setLettersOnlyCount( lettersOnlyCount );
				model.setLettersOnlyBonus( lettersOnlyCount );
			}

			// Definindo "Numbers Only"
			if ( ( numberCount > PasswordMeterService.CNS_ZERO )
					&& ( ( uppercaseLetterCount == PasswordMeterService.CNS_ZERO )
							&& ( lowercaseLetterCount == PasswordMeterService.CNS_ZERO )
							&& ( symbolCount == PasswordMeterService.CNS_ZERO ) ) )
			{
				final int numbersOnlyCount = passwordLength;
				model.setNumbersOnlyCount( numbersOnlyCount );
				model.setNumbersOnlyBonus( numbersOnlyCount );
			}

			// Definindo "Repeat Characters (Case Insensitive)"
			model.setRepeatCharactersCount( replicateCharacter );
			if ( replicateCharacter > PasswordMeterService.CNS_ZERO )
			{
				final int repeatCharactersBonus = ( int ) replicateIncrement;
				model.setRepeatCharactersBonus( repeatCharactersBonus );
			}

			// Definindo "Consecutive Uppercase Letters"
			model.setConsecutiveUppercaseLetterCount( consecutiveUppercaseLetterCount );
			if ( consecutiveUppercaseLetterCount > PasswordMeterService.CNS_ZERO )
			{
				final int consecutiveUppercaseLetterBonus = ( consecutiveUppercaseLetterCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
				model.setConsecutiveUppercaseLetterBonus( consecutiveUppercaseLetterBonus );
			}

			// Definindo "Consecutive Lowercase Letters"
			model.setConsecutiveLowercaseLetterCount( consecutiveLowercaseLetterCount );
			if ( consecutiveLowercaseLetterCount > PasswordMeterService.CNS_ZERO )
			{
				final int consecutiveLowercaseLetterBonus = ( consecutiveLowercaseLetterCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
				model.setConsecutiveLowercaseLetterBonus( consecutiveLowercaseLetterBonus );
			}

			// Definindo "Consecutive Numbers"
			model.setConsecutiveNumbersCount( consecutiveNumberCount );
			if ( consecutiveNumberCount > PasswordMeterService.CNS_ZERO )
			{
				final int consecutiveNumbersBonus = ( consecutiveNumberCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
				model.setConsecutiveNumbersBonus( consecutiveNumbersBonus );
			}

			// Definindo "Sequential Letters (3+)"
			model.setSequentialLettersCount( sequentialLettersCount );
			if ( sequentialLettersCount > PasswordMeterService.CNS_ZERO )
			{
				final int sequentialLettersBonus = ( sequentialLettersCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_3 );
				model.setSequentialLettersBonus( sequentialLettersBonus );
			}

			// Definindo "Sequential Numbers (3+)"
			model.setSequentialNumbersCount( sequentialNumbersCount );
			if ( sequentialNumbersCount > PasswordMeterService.CNS_ZERO )
			{
				final int sequentialNumbersBonus = ( sequentialNumbersCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_3 );
				model.setSequentialNumbersBonus( sequentialNumbersBonus );
			}

			// Definindo "Sequential Symbols (3+)"
			model.setSequentialSymbolsCount( sequentialSymbolsCount );
			if ( sequentialSymbolsCount > PasswordMeterService.CNS_ZERO )
			{
				final int sequentialSymbolsBonus = ( sequentialSymbolsCount
						* PasswordMeterService.CNS_MULTIPLIER_FACTOR_3 );
				model.setSequentialSymbolsBonus( sequentialSymbolsBonus );
			}

		}

		return model;
	}

}

package br.com.vadinei.db1.gumga.domain.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import br.com.vadinei.db1.gumga.domain.model.PasswordMeterModel;

/**
 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
 *         10:57:56
 */
@Service
public class PasswordMeterService implements Serializable
{

	public static final String CNS_COMPLEXITY_VERY_STRONG = "Muito Forte (Very Strong)";

	public static final String CNS_COMPLEXITY_STRONG = "Forte (Strong)";

	public static final String CNS_COMPLEXITY_GOOD = "Boa (Good)";

	public static final String CNS_COMPLEXITY_WEAK = "Fraca (Weak)";

	public static final String CNS_COMPLEXITY_VERY_WEAK = "Muito Fraca (Very Weak)";

	public static final String CNS_COMPLEXITY_TOO_SHORT = "Muito Curta (Too Short)";

	private static final int CNS_MINIMUM_REQUIREMENTS_4 = 4;

	private static final int CNS_MINIMUM_REQUIREMENTS_3 = 3;

	private static final int CNS_NUMBER_100 = 100;

	private static final int CNS_NUMBER_80 = 80;

	private static final int CNS_NUMBER_60 = 60;

	private static final int CNS_NUMBER_40 = 40;

	private static final int CNS_NUMBER_20 = 20;

	private static final int CNS_NUMBER_0 = 0;

	private static final double CNS_NUMBER_0_DOUBLE = 0.0;

	private static final int CNS_NUMBER_1_NEGATIVE = -1;

	private static final int CNS_MULTIPLIER_FACTOR_2 = 2;

	private static final int CNS_MULTIPLIER_FACTOR_3 = 3;

	private static final int CNS_MULTIPLIER_FACTOR_4 = 4;

	private static final int CNS_MULTIPLIER_FACTOR_6 = 6;

	private static final String CNS_ARRAY_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	private static final String CNS_ARRAY_NUMBER = "01234567890";

	private static final String CNS_ARRAY_SYMBOL = ")!@#$%^&*()";

	private static final int CNS_MINIMUM_PASSWORD_LENGTH_8 = 8;

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         10:58:02
	 */
	private static final long serialVersionUID = 6354133538662598235L;

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         15:05:25
	 * @param password
	 * @return PasswordMeterModel
	 */
	public PasswordMeterModel checkPassword( final String password )
	{
		final PasswordMeterModel result = checkPassword( password, PasswordMeterService.CNS_MINIMUM_PASSWORD_LENGTH_8 );
		return result;
	}

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

		// Definindo "Password", "Complexity" e "Score" Inicial.
		final String complexity = PasswordMeterService.CNS_COMPLEXITY_TOO_SHORT;
		model.setPassword( password );
		model.setComplexity( complexity );
		model.setScore( PasswordMeterService.CNS_NUMBER_0 );

		if ( ( password == null ) || ( password.length() == PasswordMeterService.CNS_NUMBER_0 ) )
		{
			return model;
		}

		if ( minimumPasswordLength < PasswordMeterService.CNS_MINIMUM_PASSWORD_LENGTH_8 )
		{
			minimumPasswordLength = PasswordMeterService.CNS_MINIMUM_PASSWORD_LENGTH_8;
		}

		final int passwordLength = password.length();

		final String[] arrPasswordSplit = password.replaceAll( "\\s+", "" ).split( "\\s*" );

		if ( ( arrPasswordSplit != null ) && ( arrPasswordSplit.length > PasswordMeterService.CNS_NUMBER_0 ) )
		{
			final int arrPasswordSplitLength = arrPasswordSplit.length;

			int uppercaseLetterCount = PasswordMeterService.CNS_NUMBER_0;
			int lowercaseLetterCount = PasswordMeterService.CNS_NUMBER_0;
			int numberCount = PasswordMeterService.CNS_NUMBER_0;
			int symbolCount = PasswordMeterService.CNS_NUMBER_0;
			int middleNumberSymbolCount = PasswordMeterService.CNS_NUMBER_0;

			int uppercaseLetterAux = PasswordMeterService.CNS_NUMBER_1_NEGATIVE;
			int lowercaseLetterAux = PasswordMeterService.CNS_NUMBER_1_NEGATIVE;
			int numberAux = PasswordMeterService.CNS_NUMBER_1_NEGATIVE;
			int symbolAux = PasswordMeterService.CNS_NUMBER_1_NEGATIVE;

			int consecutiveUppercaseLetterCount = PasswordMeterService.CNS_NUMBER_0;
			int consecutiveLowercaseLetterCount = PasswordMeterService.CNS_NUMBER_0;
			int consecutiveNumberCount = PasswordMeterService.CNS_NUMBER_0;
			int consecutiveSymbolCount = PasswordMeterService.CNS_NUMBER_0; // Unused.
			int consecutiveCharacterCount = PasswordMeterService.CNS_NUMBER_0; // Unused.

			final int requirementsCount = PasswordMeterService.CNS_NUMBER_0;
			final int requirementsCharacter = PasswordMeterService.CNS_NUMBER_0;

			int uniqueCharacter = PasswordMeterService.CNS_NUMBER_0;
			int replicateCharacter = PasswordMeterService.CNS_NUMBER_0;
			double replicateIncrement = PasswordMeterService.CNS_NUMBER_0_DOUBLE;

			int sequentialLettersCount = PasswordMeterService.CNS_NUMBER_0;
			int sequentialNumbersCount = PasswordMeterService.CNS_NUMBER_0;
			int sequentialSymbolsCount = PasswordMeterService.CNS_NUMBER_0;
			int sequentialCharacterCount = PasswordMeterService.CNS_NUMBER_0; // Unused.

			for ( int i = PasswordMeterService.CNS_NUMBER_0; i < arrPasswordSplitLength; i++ )
			{
				final String item = arrPasswordSplit[ i ];

				// Uppercase Matches
				if ( item.matches( "[A-Z]" ) )
				{
					if ( uppercaseLetterAux != PasswordMeterService.CNS_NUMBER_1_NEGATIVE )
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
					if ( lowercaseLetterAux != PasswordMeterService.CNS_NUMBER_1_NEGATIVE )
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
					if ( ( i > PasswordMeterService.CNS_NUMBER_0 ) && ( i < ( arrPasswordSplitLength - 1 ) ) )
					{
						middleNumberSymbolCount++;
					}

					if ( numberAux != PasswordMeterService.CNS_NUMBER_1_NEGATIVE )
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
					if ( ( i > PasswordMeterService.CNS_NUMBER_0 ) && ( i < ( arrPasswordSplitLength - 1 ) ) )
					{
						middleNumberSymbolCount++;
					}

					if ( symbolAux != PasswordMeterService.CNS_NUMBER_1_NEGATIVE )
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

				for ( int j = PasswordMeterService.CNS_NUMBER_0; j < arrPasswordSplitLength; j++ )
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
					replicateIncrement = ( uniqueCharacter != PasswordMeterService.CNS_NUMBER_0 )
							? Math.ceil( replicateIncrement / uniqueCharacter )
							: Math.ceil( replicateIncrement );
				}
			}

			// Verificando sequência de caracteres >> Letter
			final String passwordLowercase = password.toLowerCase();
			final int arrayAlphabetSequenceLength = ( PasswordMeterService.CNS_ARRAY_ALPHABET.length() - 3 );

			for ( int l = PasswordMeterService.CNS_NUMBER_0; l < arrayAlphabetSequenceLength; l++ )
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

			for ( int n = PasswordMeterService.CNS_NUMBER_0; n < arrayNumberSequenceLength; n++ )
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

			for ( int s = PasswordMeterService.CNS_NUMBER_0; s < arraySymbolSequenceLength; s++ )
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

			// Definindo "Number of Characters"
			setNumberCharacter( model, passwordLength );

			// Definindo "Uppercase Letters"
			setUppercaseLetter( model, passwordLength, uppercaseLetterCount );

			// Definindo "Lowercase Letters"
			setLowercaseLetter( model, passwordLength, lowercaseLetterCount );

			// Definindo "Numbers"
			setNumber( model, passwordLength, numberCount );

			// Definindo "Symbols"
			setSymbol( model, symbolCount );

			// Definindo "Middle Numbers or Symbols"
			setMiddleNumberSymbol( model, middleNumberSymbolCount );

			// Definindo "Requirements"
			setRequirements( model, minimumPasswordLength, passwordLength, uppercaseLetterCount, lowercaseLetterCount,
					numberCount, symbolCount, requirementsCharacter );

			// Definindo "Letters Only"
			setLettersOnly( model, passwordLength, uppercaseLetterCount, lowercaseLetterCount, numberCount,
					symbolCount );

			// Definindo "Numbers Only"
			setNumbersOnly( model, passwordLength, uppercaseLetterCount, lowercaseLetterCount, numberCount,
					symbolCount );

			// Definindo "Repeat Characters (Case Insensitive)"
			setRepeatCharacters( model, replicateCharacter, replicateIncrement );

			// Definindo "Consecutive Uppercase Letters"
			setConsecutiveUppercaseLetter( model, consecutiveUppercaseLetterCount );

			// Definindo "Consecutive Lowercase Letters"
			setConsecutiveLowercaseLetter( model, consecutiveLowercaseLetterCount );

			// Definindo "Consecutive Numbers"
			setConsecutiveNumbers( model, consecutiveNumberCount );

			// Definindo "Sequential Letters (3+)"
			setSequentialLetters( model, sequentialLettersCount );

			// Definindo "Sequential Numbers (3+)"
			setSequentialNumbers( model, sequentialNumbersCount );

			// Definindo "Sequential Symbols (3+)"
			setSequentialSymbols( model, sequentialSymbolsCount );

			// Definindo e obtendo o "Score" para "Additions"
			final int scoreAdditions = getScoreAdditions( model );

			// Definindo e obtendo o "Score" para "Deductions"
			final int scoreDeductions = getScoreDeductions( model );

			// Definindo e obtendo o "Score"
			final int score = getScore( model, scoreAdditions, scoreDeductions );

			// Definindo "Complexity"
			setComplexity( model, score );
		}

		return model;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:22:46
	 * @param model
	 * @param score
	 */
	private void setComplexity( final PasswordMeterModel model, final int score )
	{
		final String complexity = getComplexity( score );
		model.setComplexity( complexity );
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:15:19
	 * @param score
	 * @return Complexity
	 */
	private String getComplexity( final int score )
	{
		String result = null;

		if ( ( score >= PasswordMeterService.CNS_NUMBER_0 ) && ( score < PasswordMeterService.CNS_NUMBER_20 ) )
		{
			result = PasswordMeterService.CNS_COMPLEXITY_VERY_WEAK;
		}
		else if ( ( score >= PasswordMeterService.CNS_NUMBER_20 ) && ( score < PasswordMeterService.CNS_NUMBER_40 ) )
		{
			result = PasswordMeterService.CNS_COMPLEXITY_WEAK;
		}
		else if ( ( score >= PasswordMeterService.CNS_NUMBER_40 ) && ( score < PasswordMeterService.CNS_NUMBER_60 ) )
		{
			result = PasswordMeterService.CNS_COMPLEXITY_GOOD;
		}
		else if ( ( score >= PasswordMeterService.CNS_NUMBER_60 ) && ( score < PasswordMeterService.CNS_NUMBER_80 ) )
		{
			result = PasswordMeterService.CNS_COMPLEXITY_STRONG;
		}
		else if ( ( score >= PasswordMeterService.CNS_NUMBER_80 ) && ( score <= PasswordMeterService.CNS_NUMBER_100 ) )
		{
			result = PasswordMeterService.CNS_COMPLEXITY_VERY_STRONG;
		}

		return result;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:17:46
	 * @param model
	 * @param scoreAdditions
	 * @param scoreDeductions
	 * @return Score
	 */
	private int getScore( final PasswordMeterModel model, final int scoreAdditions, final int scoreDeductions )
	{
		int score = ( scoreAdditions - scoreDeductions );

		if ( score > PasswordMeterService.CNS_NUMBER_100 )
		{
			score = PasswordMeterService.CNS_NUMBER_100;
		}
		else if ( score < PasswordMeterService.CNS_NUMBER_0 )
		{
			score = PasswordMeterService.CNS_NUMBER_0;
		}

		model.setScore( score );
		return score;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:11:54
	 * @param model
	 * @return Score Deductions
	 */
	private int getScoreDeductions( final PasswordMeterModel model )
	{
		int result = 0;

		result += model.getLettersOnlyBonus();
		result += model.getNumbersOnlyBonus();
		result += model.getRepeatCharactersBonus();
		result += model.getConsecutiveUppercaseLetterBonus();
		result += model.getConsecutiveLowercaseLetterBonus();
		result += model.getConsecutiveNumbersBonus();
		result += model.getSequentialLettersBonus();
		result += model.getSequentialNumbersBonus();
		result += model.getSequentialSymbolsBonus();

		return result;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:09:53
	 * @param model
	 * @return Score Additions
	 */
	private int getScoreAdditions( final PasswordMeterModel model )
	{
		int result = 0;

		result += model.getNumberCharacterBonus();
		result += model.getUppercaseLetterBonus();
		result += model.getLowercaseLetterBonus();
		result += model.getNumberBonus();
		result += model.getSymbolBonus();
		result += model.getMiddleNumberSymbolBonus();
		result += model.getRequirementsBonus();

		return result;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:05:10
	 * @param model
	 * @param sequentialSymbolsCount
	 */
	private void setSequentialSymbols( final PasswordMeterModel model, final int sequentialSymbolsCount )
	{
		model.setSequentialSymbolsCount( sequentialSymbolsCount );
		if ( sequentialSymbolsCount > PasswordMeterService.CNS_NUMBER_0 )
		{
			final int sequentialSymbolsBonus = ( sequentialSymbolsCount
					* PasswordMeterService.CNS_MULTIPLIER_FACTOR_3 );
			model.setSequentialSymbolsBonus( sequentialSymbolsBonus );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:04:58
	 * @param model
	 * @param sequentialNumbersCount
	 */
	private void setSequentialNumbers( final PasswordMeterModel model, final int sequentialNumbersCount )
	{
		model.setSequentialNumbersCount( sequentialNumbersCount );
		if ( sequentialNumbersCount > PasswordMeterService.CNS_NUMBER_0 )
		{
			final int sequentialNumbersBonus = ( sequentialNumbersCount
					* PasswordMeterService.CNS_MULTIPLIER_FACTOR_3 );
			model.setSequentialNumbersBonus( sequentialNumbersBonus );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:04:44
	 * @param model
	 * @param sequentialLettersCount
	 */
	private void setSequentialLetters( final PasswordMeterModel model, final int sequentialLettersCount )
	{
		model.setSequentialLettersCount( sequentialLettersCount );
		if ( sequentialLettersCount > PasswordMeterService.CNS_NUMBER_0 )
		{
			final int sequentialLettersBonus = ( sequentialLettersCount
					* PasswordMeterService.CNS_MULTIPLIER_FACTOR_3 );
			model.setSequentialLettersBonus( sequentialLettersBonus );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:04:31
	 * @param model
	 * @param consecutiveNumberCount
	 */
	private void setConsecutiveNumbers( final PasswordMeterModel model, final int consecutiveNumberCount )
	{
		model.setConsecutiveNumbersCount( consecutiveNumberCount );
		if ( consecutiveNumberCount > PasswordMeterService.CNS_NUMBER_0 )
		{
			final int consecutiveNumbersBonus = ( consecutiveNumberCount
					* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
			model.setConsecutiveNumbersBonus( consecutiveNumbersBonus );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:04:14
	 * @param model
	 * @param consecutiveLowercaseLetterCount
	 */
	private void setConsecutiveLowercaseLetter( final PasswordMeterModel model,
			final int consecutiveLowercaseLetterCount )
	{
		model.setConsecutiveLowercaseLetterCount( consecutiveLowercaseLetterCount );
		if ( consecutiveLowercaseLetterCount > PasswordMeterService.CNS_NUMBER_0 )
		{
			final int consecutiveLowercaseLetterBonus = ( consecutiveLowercaseLetterCount
					* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
			model.setConsecutiveLowercaseLetterBonus( consecutiveLowercaseLetterBonus );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:03:45
	 * @param model
	 * @param consecutiveUppercaseLetterCount
	 */
	private void setConsecutiveUppercaseLetter( final PasswordMeterModel model,
			final int consecutiveUppercaseLetterCount )
	{
		model.setConsecutiveUppercaseLetterCount( consecutiveUppercaseLetterCount );
		if ( consecutiveUppercaseLetterCount > PasswordMeterService.CNS_NUMBER_0 )
		{
			final int consecutiveUppercaseLetterBonus = ( consecutiveUppercaseLetterCount
					* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
			model.setConsecutiveUppercaseLetterBonus( consecutiveUppercaseLetterBonus );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:03:29
	 * @param model
	 * @param replicateCharacter
	 * @param replicateIncrement
	 */
	private void setRepeatCharacters( final PasswordMeterModel model, final int replicateCharacter,
			final double replicateIncrement )
	{
		model.setRepeatCharactersCount( replicateCharacter );
		if ( replicateCharacter > PasswordMeterService.CNS_NUMBER_0 )
		{
			final int repeatCharactersBonus = ( int ) replicateIncrement;
			model.setRepeatCharactersBonus( repeatCharactersBonus );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:03:10
	 * @param model
	 * @param passwordLength
	 * @param uppercaseLetterCount
	 * @param lowercaseLetterCount
	 * @param numberCount
	 * @param symbolCount
	 */
	private void setNumbersOnly( final PasswordMeterModel model, final int passwordLength,
			final int uppercaseLetterCount, final int lowercaseLetterCount, final int numberCount,
			final int symbolCount )
	{
		if ( ( numberCount > PasswordMeterService.CNS_NUMBER_0 )
				&& ( ( uppercaseLetterCount == PasswordMeterService.CNS_NUMBER_0 )
						&& ( lowercaseLetterCount == PasswordMeterService.CNS_NUMBER_0 )
						&& ( symbolCount == PasswordMeterService.CNS_NUMBER_0 ) ) )
		{
			final int numbersOnlyCount = passwordLength;
			model.setNumbersOnlyCount( numbersOnlyCount );
			model.setNumbersOnlyBonus( numbersOnlyCount );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:02:42
	 * @param model
	 * @param passwordLength
	 * @param uppercaseLetterCount
	 * @param lowercaseLetterCount
	 * @param numberCount
	 * @param symbolCount
	 */
	private void setLettersOnly( final PasswordMeterModel model, final int passwordLength,
			final int uppercaseLetterCount, final int lowercaseLetterCount, final int numberCount,
			final int symbolCount )
	{
		if ( ( ( uppercaseLetterCount > PasswordMeterService.CNS_NUMBER_0 )
				|| ( lowercaseLetterCount > PasswordMeterService.CNS_NUMBER_0 ) )
				&& ( ( numberCount == PasswordMeterService.CNS_NUMBER_0 )
						&& ( symbolCount == PasswordMeterService.CNS_NUMBER_0 ) ) )
		{
			final int lettersOnlyCount = passwordLength;
			model.setLettersOnlyCount( lettersOnlyCount );
			model.setLettersOnlyBonus( lettersOnlyCount );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:02:15
	 * @param model
	 * @param minimumPasswordLength
	 * @param passwordLength
	 * @param uppercaseLetterCount
	 * @param lowercaseLetterCount
	 * @param numberCount
	 * @param symbolCount
	 * @param requirementsCharacter
	 */
	private void setRequirements( final PasswordMeterModel model, final int minimumPasswordLength,
			final int passwordLength, final int uppercaseLetterCount, final int lowercaseLetterCount,
			final int numberCount, final int symbolCount, int requirementsCharacter )
	{
		int requirementsCount;
		final int arrRequirements[] = new int[] { passwordLength, uppercaseLetterCount, lowercaseLetterCount,
				numberCount, symbolCount };
		final int arrRequirementsLength = arrRequirements.length;

		for ( int i = PasswordMeterService.CNS_NUMBER_0; i < arrRequirementsLength; i++ )
		{
			final int requirementValue = arrRequirements[ i ];
			final int minimumValue = ( i == PasswordMeterService.CNS_NUMBER_0 ) ? ( minimumPasswordLength - 1 )
					: PasswordMeterService.CNS_NUMBER_0;

			if ( ( requirementValue == ( minimumValue + 1 ) ) || ( requirementValue > ( minimumValue + 1 ) ) )
			{
				requirementsCharacter++;
			}
		}

		requirementsCount = requirementsCharacter;
		model.setRequirementsCount( requirementsCount );

		final int minimumRequirements = ( passwordLength >= minimumPasswordLength )
				? PasswordMeterService.CNS_MINIMUM_REQUIREMENTS_3
				: PasswordMeterService.CNS_MINIMUM_REQUIREMENTS_4;

		if ( requirementsCount > minimumRequirements )
		{
			final int requirementsBonus = ( requirementsCount * PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
			model.setRequirementsBonus( requirementsBonus );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:00:44
	 * @param model
	 * @param middleNumberSymbolCount
	 */
	private void setMiddleNumberSymbol( final PasswordMeterModel model, final int middleNumberSymbolCount )
	{
		model.setMiddleNumberSymbolCount( middleNumberSymbolCount );
		if ( middleNumberSymbolCount > PasswordMeterService.CNS_NUMBER_0 )
		{
			final int middleNumberSymbolBonus = ( middleNumberSymbolCount
					* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
			model.setMiddleNumberSymbolBonus( middleNumberSymbolBonus );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:00:33
	 * @param model
	 * @param symbolCount
	 */
	private void setSymbol( final PasswordMeterModel model, final int symbolCount )
	{
		model.setSymbolCount( symbolCount );
		if ( symbolCount > PasswordMeterService.CNS_NUMBER_0 )
		{
			final int symbolBonus = ( symbolCount * PasswordMeterService.CNS_MULTIPLIER_FACTOR_6 );
			model.setSymbolBonus( symbolBonus );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         01:00:05
	 * @param model
	 * @param passwordLength
	 * @param numberCount
	 */
	private void setNumber( final PasswordMeterModel model, final int passwordLength, final int numberCount )
	{
		model.setNumberCount( numberCount );
		if ( ( numberCount > PasswordMeterService.CNS_NUMBER_0 ) && ( numberCount < passwordLength ) )
		{
			final int numberBonus = ( numberCount * PasswordMeterService.CNS_MULTIPLIER_FACTOR_4 );
			model.setNumberBonus( numberBonus );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         00:59:49
	 * @param model
	 * @param passwordLength
	 * @param lowercaseLetterCount
	 */
	private void setLowercaseLetter( final PasswordMeterModel model, final int passwordLength,
			final int lowercaseLetterCount )
	{
		model.setLowercaseLetterCount( lowercaseLetterCount );
		if ( ( lowercaseLetterCount > PasswordMeterService.CNS_NUMBER_0 ) && ( lowercaseLetterCount < passwordLength ) )
		{
			final int lowercaseLetterBonus = ( ( passwordLength - lowercaseLetterCount )
					* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
			model.setLowercaseLetterBonus( lowercaseLetterBonus );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         00:59:22
	 * @param model
	 * @param passwordLength
	 * @param uppercaseLetterCount
	 */
	private void setUppercaseLetter( final PasswordMeterModel model, final int passwordLength,
			final int uppercaseLetterCount )
	{
		model.setUppercaseLetterCount( uppercaseLetterCount );
		if ( ( uppercaseLetterCount > PasswordMeterService.CNS_NUMBER_0 ) && ( uppercaseLetterCount < passwordLength ) )
		{
			final int uppercaseLetterBonus = ( ( passwordLength - uppercaseLetterCount )
					* PasswordMeterService.CNS_MULTIPLIER_FACTOR_2 );
			model.setUppercaseLetterBonus( uppercaseLetterBonus );
		}
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 28 de ago de 2017 -
	 *         00:58:30
	 * @param model
	 * @param passwordLength
	 */
	private void setNumberCharacter( final PasswordMeterModel model, final int passwordLength )
	{
		model.setNumberCharacterCount( passwordLength );
		final int numberCharacterBonus = passwordLength * PasswordMeterService.CNS_MULTIPLIER_FACTOR_4;
		model.setNumberCharacterBonus( numberCharacterBonus );
	}

}

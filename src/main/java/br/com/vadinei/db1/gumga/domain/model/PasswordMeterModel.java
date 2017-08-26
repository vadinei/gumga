package br.com.vadinei.db1.gumga.domain.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
 *         10:57:27
 */
@Component
public class PasswordMeterModel implements Serializable
{

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         10:57:34
	 */
	private static final long serialVersionUID = -4517617204770839229L;

	// Header
	private String password;
	private int score;
	private String complexity;

	// Additions
	private int numberCharacterCount;
	private int numberCharacterBonus;

	private int uppercaseLetterCount;
	private int uppercaseLetterBonus;

	private int lowercaseLetterCount;
	private int lowercaseLetterBonus;

	private int numberCount;
	private int numberBonus;

	private int symbolCount;
	private int symbolBonus;

	private int middleNumberSymbolCount;
	private int middleNumberSymbolBonus;

	private int requirementsCount;
	private int requirementsBonus;

	// Deductions
	private int lettersOnlyCount;
	private int lettersOnlyBonus;

	private int numbersOnlyCount;
	private int numbersOnlyBonus;

	private int repeatCharactersCount; // Case Insensitive
	private int repeatCharactersBonus; // Case Insensitive

	private int consecutiveUppercaseLetterCount;
	private int consecutiveUppercaseLetterBonus;

	private int consecutiveLowercaseLetterCount;
	private int consecutiveLowercaseLetterBonus;

	private int consecutiveNumbersCount;
	private int consecutiveNumbersBonus;

	private int sequentialLetterCount;
	private int sequentialLetterBonus;

	private int sequentialNumberCount;
	private int sequentialNumberBonus;

	/**
	 * Construtor da Classe.
	 *
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:41:02
	 */
	public PasswordMeterModel()
	{
		super();
	}

	/**
	 * Construtor da Classe.
	 *
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:41:24
	 * @param password
	 */
	public PasswordMeterModel( final String password )
	{
		this();
		this.password = password;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo password.
	 */
	public String getPassword()
	{
		return this.password;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param password
	 *            Define o atributo password.
	 */
	public void setPassword( final String password )
	{
		this.password = password;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo score.
	 */
	public int getScore()
	{
		return this.score;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param score
	 *            Define o atributo score.
	 */
	public void setScore( final int score )
	{
		this.score = score;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo complexity.
	 */
	public String getComplexity()
	{
		return this.complexity;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param complexity
	 *            Define o atributo complexity.
	 */
	public void setComplexity( final String complexity )
	{
		this.complexity = complexity;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo numberCharacterCount.
	 */
	public int getNumberCharacterCount()
	{
		return this.numberCharacterCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param numberCharacterCount
	 *            Define o atributo numberCharacterCount.
	 */
	public void setNumberCharacterCount( final int numberCharacterCount )
	{
		this.numberCharacterCount = numberCharacterCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo numberCharacterBonus.
	 */
	public int getNumberCharacterBonus()
	{
		return this.numberCharacterBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param numberCharacterBonus
	 *            Define o atributo numberCharacterBonus.
	 */
	public void setNumberCharacterBonus( final int numberCharacterBonus )
	{
		this.numberCharacterBonus = numberCharacterBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo uppercaseLetterCount.
	 */
	public int getUppercaseLetterCount()
	{
		return this.uppercaseLetterCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param uppercaseLetterCount
	 *            Define o atributo uppercaseLetterCount.
	 */
	public void setUppercaseLetterCount( final int uppercaseLetterCount )
	{
		this.uppercaseLetterCount = uppercaseLetterCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo uppercaseLetterBonus.
	 */
	public int getUppercaseLetterBonus()
	{
		return this.uppercaseLetterBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param uppercaseLetterBonus
	 *            Define o atributo uppercaseLetterBonus.
	 */
	public void setUppercaseLetterBonus( final int uppercaseLetterBonus )
	{
		this.uppercaseLetterBonus = uppercaseLetterBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo lowercaseLetterCount.
	 */
	public int getLowercaseLetterCount()
	{
		return this.lowercaseLetterCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param lowercaseLetterCount
	 *            Define o atributo lowercaseLetterCount.
	 */
	public void setLowercaseLetterCount( final int lowercaseLetterCount )
	{
		this.lowercaseLetterCount = lowercaseLetterCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo lowercaseLetterBonus.
	 */
	public int getLowercaseLetterBonus()
	{
		return this.lowercaseLetterBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param lowercaseLetterBonus
	 *            Define o atributo lowercaseLetterBonus.
	 */
	public void setLowercaseLetterBonus( final int lowercaseLetterBonus )
	{
		this.lowercaseLetterBonus = lowercaseLetterBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo numberCount.
	 */
	public int getNumberCount()
	{
		return this.numberCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param numberCount
	 *            Define o atributo numberCount.
	 */
	public void setNumberCount( final int numberCount )
	{
		this.numberCount = numberCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo numberBonus.
	 */
	public int getNumberBonus()
	{
		return this.numberBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param numberBonus
	 *            Define o atributo numberBonus.
	 */
	public void setNumberBonus( final int numberBonus )
	{
		this.numberBonus = numberBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo symbolCount.
	 */
	public int getSymbolCount()
	{
		return this.symbolCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param symbolCount
	 *            Define o atributo symbolCount.
	 */
	public void setSymbolCount( final int symbolCount )
	{
		this.symbolCount = symbolCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo symbolBonus.
	 */
	public int getSymbolBonus()
	{
		return this.symbolBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param symbolBonus
	 *            Define o atributo symbolBonus.
	 */
	public void setSymbolBonus( final int symbolBonus )
	{
		this.symbolBonus = symbolBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo middleNumberSymbolCount.
	 */
	public int getMiddleNumberSymbolCount()
	{
		return this.middleNumberSymbolCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param middleNumberSymbolCount
	 *            Define o atributo middleNumberSymbolCount.
	 */
	public void setMiddleNumberSymbolCount( final int middleNumberSymbolCount )
	{
		this.middleNumberSymbolCount = middleNumberSymbolCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo middleNumberSymbolBonus.
	 */
	public int getMiddleNumberSymbolBonus()
	{
		return this.middleNumberSymbolBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param middleNumberSymbolBonus
	 *            Define o atributo middleNumberSymbolBonus.
	 */
	public void setMiddleNumberSymbolBonus( final int middleNumberSymbolBonus )
	{
		this.middleNumberSymbolBonus = middleNumberSymbolBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo requirementsCount.
	 */
	public int getRequirementsCount()
	{
		return this.requirementsCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param requirementsCount
	 *            Define o atributo requirementsCount.
	 */
	public void setRequirementsCount( final int requirementsCount )
	{
		this.requirementsCount = requirementsCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo requirementsBonus.
	 */
	public int getRequirementsBonus()
	{
		return this.requirementsBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param requirementsBonus
	 *            Define o atributo requirementsBonus.
	 */
	public void setRequirementsBonus( final int requirementsBonus )
	{
		this.requirementsBonus = requirementsBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo lettersOnlyCount.
	 */
	public int getLettersOnlyCount()
	{
		return this.lettersOnlyCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param lettersOnlyCount
	 *            Define o atributo lettersOnlyCount.
	 */
	public void setLettersOnlyCount( final int lettersOnlyCount )
	{
		this.lettersOnlyCount = lettersOnlyCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo lettersOnlyBonus.
	 */
	public int getLettersOnlyBonus()
	{
		return this.lettersOnlyBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param lettersOnlyBonus
	 *            Define o atributo lettersOnlyBonus.
	 */
	public void setLettersOnlyBonus( final int lettersOnlyBonus )
	{
		this.lettersOnlyBonus = lettersOnlyBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo numbersOnlyCount.
	 */
	public int getNumbersOnlyCount()
	{
		return this.numbersOnlyCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param numbersOnlyCount
	 *            Define o atributo numbersOnlyCount.
	 */
	public void setNumbersOnlyCount( final int numbersOnlyCount )
	{
		this.numbersOnlyCount = numbersOnlyCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo numbersOnlyBonus.
	 */
	public int getNumbersOnlyBonus()
	{
		return this.numbersOnlyBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param numbersOnlyBonus
	 *            Define o atributo numbersOnlyBonus.
	 */
	public void setNumbersOnlyBonus( final int numbersOnlyBonus )
	{
		this.numbersOnlyBonus = numbersOnlyBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo repeatCharactersCount.
	 */
	public int getRepeatCharactersCount()
	{
		return this.repeatCharactersCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param repeatCharactersCount
	 *            Define o atributo repeatCharactersCount.
	 */
	public void setRepeatCharactersCount( final int repeatCharactersCount )
	{
		this.repeatCharactersCount = repeatCharactersCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo repeatCharactersBonus.
	 */
	public int getRepeatCharactersBonus()
	{
		return this.repeatCharactersBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param repeatCharactersBonus
	 *            Define o atributo repeatCharactersBonus.
	 */
	public void setRepeatCharactersBonus( final int repeatCharactersBonus )
	{
		this.repeatCharactersBonus = repeatCharactersBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo consecutiveUppercaseLetterCount.
	 */
	public int getConsecutiveUppercaseLetterCount()
	{
		return this.consecutiveUppercaseLetterCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param consecutiveUppercaseLetterCount
	 *            Define o atributo consecutiveUppercaseLetterCount.
	 */
	public void setConsecutiveUppercaseLetterCount( final int consecutiveUppercaseLetterCount )
	{
		this.consecutiveUppercaseLetterCount = consecutiveUppercaseLetterCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo consecutiveUppercaseLetterBonus.
	 */
	public int getConsecutiveUppercaseLetterBonus()
	{
		return this.consecutiveUppercaseLetterBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param consecutiveUppercaseLetterBonus
	 *            Define o atributo consecutiveUppercaseLetterBonus.
	 */
	public void setConsecutiveUppercaseLetterBonus( final int consecutiveUppercaseLetterBonus )
	{
		this.consecutiveUppercaseLetterBonus = consecutiveUppercaseLetterBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo consecutiveLowercaseLetterCount.
	 */
	public int getConsecutiveLowercaseLetterCount()
	{
		return this.consecutiveLowercaseLetterCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param consecutiveLowercaseLetterCount
	 *            Define o atributo consecutiveLowercaseLetterCount.
	 */
	public void setConsecutiveLowercaseLetterCount( final int consecutiveLowercaseLetterCount )
	{
		this.consecutiveLowercaseLetterCount = consecutiveLowercaseLetterCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo consecutiveLowercaseLetterBonus.
	 */
	public int getConsecutiveLowercaseLetterBonus()
	{
		return this.consecutiveLowercaseLetterBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param consecutiveLowercaseLetterBonus
	 *            Define o atributo consecutiveLowercaseLetterBonus.
	 */
	public void setConsecutiveLowercaseLetterBonus( final int consecutiveLowercaseLetterBonus )
	{
		this.consecutiveLowercaseLetterBonus = consecutiveLowercaseLetterBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo consecutiveNumbersCount.
	 */
	public int getConsecutiveNumbersCount()
	{
		return this.consecutiveNumbersCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param consecutiveNumbersCount
	 *            Define o atributo consecutiveNumbersCount.
	 */
	public void setConsecutiveNumbersCount( final int consecutiveNumbersCount )
	{
		this.consecutiveNumbersCount = consecutiveNumbersCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo consecutiveNumbersBonus.
	 */
	public int getConsecutiveNumbersBonus()
	{
		return this.consecutiveNumbersBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param consecutiveNumbersBonus
	 *            Define o atributo consecutiveNumbersBonus.
	 */
	public void setConsecutiveNumbersBonus( final int consecutiveNumbersBonus )
	{
		this.consecutiveNumbersBonus = consecutiveNumbersBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo sequentialLetterCount.
	 */
	public int getSequentialLetterCount()
	{
		return this.sequentialLetterCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param sequentialLetterCount
	 *            Define o atributo sequentialLetterCount.
	 */
	public void setSequentialLetterCount( final int sequentialLetterCount )
	{
		this.sequentialLetterCount = sequentialLetterCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo sequentialLetterBonus.
	 */
	public int getSequentialLetterBonus()
	{
		return this.sequentialLetterBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param sequentialLetterBonus
	 *            Define o atributo sequentialLetterBonus.
	 */
	public void setSequentialLetterBonus( final int sequentialLetterBonus )
	{
		this.sequentialLetterBonus = sequentialLetterBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo sequentialNumberCount.
	 */
	public int getSequentialNumberCount()
	{
		return this.sequentialNumberCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param sequentialNumberCount
	 *            Define o atributo sequentialNumberCount.
	 */
	public void setSequentialNumberCount( final int sequentialNumberCount )
	{
		this.sequentialNumberCount = sequentialNumberCount;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @return Retorna o atributo sequentialNumberBonus.
	 */
	public int getSequentialNumberBonus()
	{
		return this.sequentialNumberBonus;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 *         11:42:42
	 * @param sequentialNumberBonus
	 *            Define o atributo sequentialNumberBonus.
	 */
	public void setSequentialNumberBonus( final int sequentialNumberBonus )
	{
		this.sequentialNumberBonus = sequentialNumberBonus;
	}

	/*
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 * 11:43:11 (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = ( prime * result ) + ( ( this.complexity == null ) ? 0 : this.complexity.hashCode() );
		result = ( prime * result ) + this.consecutiveLowercaseLetterBonus;
		result = ( prime * result ) + this.consecutiveLowercaseLetterCount;
		result = ( prime * result ) + this.consecutiveNumbersBonus;
		result = ( prime * result ) + this.consecutiveNumbersCount;
		result = ( prime * result ) + this.consecutiveUppercaseLetterBonus;
		result = ( prime * result ) + this.consecutiveUppercaseLetterCount;
		result = ( prime * result ) + this.lettersOnlyBonus;
		result = ( prime * result ) + this.lettersOnlyCount;
		result = ( prime * result ) + this.lowercaseLetterBonus;
		result = ( prime * result ) + this.lowercaseLetterCount;
		result = ( prime * result ) + this.middleNumberSymbolBonus;
		result = ( prime * result ) + this.middleNumberSymbolCount;
		result = ( prime * result ) + this.numberBonus;
		result = ( prime * result ) + this.numberCharacterBonus;
		result = ( prime * result ) + this.numberCharacterCount;
		result = ( prime * result ) + this.numberCount;
		result = ( prime * result ) + this.numbersOnlyBonus;
		result = ( prime * result ) + this.numbersOnlyCount;
		result = ( prime * result ) + ( ( this.password == null ) ? 0 : this.password.hashCode() );
		result = ( prime * result ) + this.repeatCharactersBonus;
		result = ( prime * result ) + this.repeatCharactersCount;
		result = ( prime * result ) + this.requirementsBonus;
		result = ( prime * result ) + this.requirementsCount;
		result = ( prime * result ) + this.score;
		result = ( prime * result ) + this.sequentialLetterBonus;
		result = ( prime * result ) + this.sequentialLetterCount;
		result = ( prime * result ) + this.sequentialNumberBonus;
		result = ( prime * result ) + this.sequentialNumberCount;
		result = ( prime * result ) + this.symbolBonus;
		result = ( prime * result ) + this.symbolCount;
		result = ( prime * result ) + this.uppercaseLetterBonus;
		result = ( prime * result ) + this.uppercaseLetterCount;
		return result;
	}

	/*
	 * @author José Vádinei Soares (vadinei@hotmail.com) 26 de ago de 2017 -
	 * 11:43:11 (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( final Object obj )
	{
		if ( this == obj )
		{
			return true;
		}
		if ( obj == null )
		{
			return false;
		}
		if ( this.getClass() != obj.getClass() )
		{
			return false;
		}
		final PasswordMeterModel other = ( PasswordMeterModel ) obj;
		if ( this.complexity == null )
		{
			if ( other.complexity != null )
			{
				return false;
			}
		}
		else
			if ( !this.complexity.equals( other.complexity ) )
			{
				return false;
			}
		if ( this.consecutiveLowercaseLetterBonus != other.consecutiveLowercaseLetterBonus )
		{
			return false;
		}
		if ( this.consecutiveLowercaseLetterCount != other.consecutiveLowercaseLetterCount )
		{
			return false;
		}
		if ( this.consecutiveNumbersBonus != other.consecutiveNumbersBonus )
		{
			return false;
		}
		if ( this.consecutiveNumbersCount != other.consecutiveNumbersCount )
		{
			return false;
		}
		if ( this.consecutiveUppercaseLetterBonus != other.consecutiveUppercaseLetterBonus )
		{
			return false;
		}
		if ( this.consecutiveUppercaseLetterCount != other.consecutiveUppercaseLetterCount )
		{
			return false;
		}
		if ( this.lettersOnlyBonus != other.lettersOnlyBonus )
		{
			return false;
		}
		if ( this.lettersOnlyCount != other.lettersOnlyCount )
		{
			return false;
		}
		if ( this.lowercaseLetterBonus != other.lowercaseLetterBonus )
		{
			return false;
		}
		if ( this.lowercaseLetterCount != other.lowercaseLetterCount )
		{
			return false;
		}
		if ( this.middleNumberSymbolBonus != other.middleNumberSymbolBonus )
		{
			return false;
		}
		if ( this.middleNumberSymbolCount != other.middleNumberSymbolCount )
		{
			return false;
		}
		if ( this.numberBonus != other.numberBonus )
		{
			return false;
		}
		if ( this.numberCharacterBonus != other.numberCharacterBonus )
		{
			return false;
		}
		if ( this.numberCharacterCount != other.numberCharacterCount )
		{
			return false;
		}
		if ( this.numberCount != other.numberCount )
		{
			return false;
		}
		if ( this.numbersOnlyBonus != other.numbersOnlyBonus )
		{
			return false;
		}
		if ( this.numbersOnlyCount != other.numbersOnlyCount )
		{
			return false;
		}
		if ( this.password == null )
		{
			if ( other.password != null )
			{
				return false;
			}
		}
		else
			if ( !this.password.equals( other.password ) )
			{
				return false;
			}
		if ( this.repeatCharactersBonus != other.repeatCharactersBonus )
		{
			return false;
		}
		if ( this.repeatCharactersCount != other.repeatCharactersCount )
		{
			return false;
		}
		if ( this.requirementsBonus != other.requirementsBonus )
		{
			return false;
		}
		if ( this.requirementsCount != other.requirementsCount )
		{
			return false;
		}
		if ( this.score != other.score )
		{
			return false;
		}
		if ( this.sequentialLetterBonus != other.sequentialLetterBonus )
		{
			return false;
		}
		if ( this.sequentialLetterCount != other.sequentialLetterCount )
		{
			return false;
		}
		if ( this.sequentialNumberBonus != other.sequentialNumberBonus )
		{
			return false;
		}
		if ( this.sequentialNumberCount != other.sequentialNumberCount )
		{
			return false;
		}
		if ( this.symbolBonus != other.symbolBonus )
		{
			return false;
		}
		if ( this.symbolCount != other.symbolCount )
		{
			return false;
		}
		if ( this.uppercaseLetterBonus != other.uppercaseLetterBonus )
		{
			return false;
		}
		if ( this.uppercaseLetterCount != other.uppercaseLetterCount )
		{
			return false;
		}
		return true;
	}

}

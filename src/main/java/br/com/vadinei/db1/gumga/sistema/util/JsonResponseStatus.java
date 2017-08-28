package br.com.vadinei.db1.gumga.sistema.util;

import java.io.Serializable;

public enum JsonResponseStatus implements Serializable
{
	FAIL( 1, "FAIL" ), SUCCESS( 2, "SUCCESS" );

	private final int codigo;

	private final String descricao;

	/**
	 * Construtor da Classe.
	 *
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         20:59:44
	 * @param codigo
	 * @param descricao
	 */
	private JsonResponseStatus( final int codigo, final String descricao )
	{
		this.codigo = codigo;
		this.descricao = descricao;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         20:59:36
	 * @return Retorna o atributo codigo.
	 */
	public int getCodigo()
	{
		return this.codigo;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         20:59:36
	 * @return Retorna o atributo descricao.
	 */
	public String getDescricao()
	{
		return this.descricao;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         21:00:59
	 * @param value
	 * @return JsonResponseStatus
	 */
	public static JsonResponseStatus getEnumFromCodigo( final int value )
	{
		for ( final JsonResponseStatus tipo : JsonResponseStatus.values() )
		{
			if ( tipo.getCodigo() == value )
			{
				return tipo;
			}
		}

		return null;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         21:00:52
	 * @param value
	 * @return JsonResponseStatus
	 */
	public static JsonResponseStatus getEnumFromDescricao( final String value )
	{
		for ( final JsonResponseStatus tipo : JsonResponseStatus.values() )
		{
			if ( tipo.getDescricao().equals( value ) )
			{
				return tipo;
			}
		}

		return null;
	}

}

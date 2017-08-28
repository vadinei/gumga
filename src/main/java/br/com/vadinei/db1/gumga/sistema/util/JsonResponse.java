package br.com.vadinei.db1.gumga.sistema.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JsonResponse implements Serializable
{

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         20:41:39
	 */
	private static final long serialVersionUID = -2648355443601524169L;

	private String status;

	private Object result;

	/**
	 * Construtor da Classe.
	 *
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         20:42:18
	 */
	public JsonResponse()
	{
		super();
	}

	/**
	 * Construtor da Classe.
	 *
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         20:42:37
	 * @param status
	 */
	public JsonResponse( final String status )
	{
		this();
		this.status = status;
	}

	/**
	 * Construtor da Classe.
	 *
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         20:43:04
	 * @param status
	 * @param result
	 */
	public JsonResponse( final String status, final Object result )
	{
		this( status );
		this.result = result;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         20:43:54
	 * @return Retorna o atributo status.
	 */
	public String getStatus()
	{
		return this.status;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         20:43:54
	 * @param status
	 *            Define o atributo status.
	 */
	public void setStatus( final String status )
	{
		this.status = status;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         21:14:08
	 * @param jsonResponseStatus
	 */
	public void setJsonResponseStatus( final JsonResponseStatus jsonResponseStatus )
	{
		this.setStatus( jsonResponseStatus.getDescricao() );
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         20:43:54
	 * @return Retorna o atributo result.
	 */
	public Object getResult()
	{
		return this.result;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         20:43:54
	 * @param result
	 *            Define o atributo result.
	 */
	public void setResult( final Object result )
	{
		this.result = result;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         21:06:23
	 * @param key
	 * @param value
	 */
	@SuppressWarnings( "unchecked" )
	public void addParameter( final String key, final Object value )
	{
		if ( ( this.result == null ) || !( this.result instanceof HashMap ) )
		{
			this.clearParameters();
		}

		( ( HashMap< String, Object > ) this.result ).put( key, value );
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         21:06:26
	 * @return Map< String, Object >
	 */
	@JsonIgnore
	@SuppressWarnings( "unchecked" )
	public Map< String, Object > getParameters()
	{
		if ( ( this.result == null ) || !( this.result instanceof HashMap ) )
		{
			return new HashMap< String, Object >();
		}

		return ( Map< String, Object > ) this.result;
	}

	/**
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 *         21:06:38
	 */
	public void clearParameters()
	{
		this.setResult( new HashMap< String, Object >() );
	}

	/*
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 * 20:44:05 (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = ( prime * result ) + ( ( this.result == null ) ? 0 : this.result.hashCode() );
		result = ( prime * result ) + ( ( this.status == null ) ? 0 : this.status.hashCode() );
		return result;
	}

	/*
	 * @author José Vádinei Soares (vadinei@hotmail.com) 27 de ago de 2017 -
	 * 20:44:05 (non-Javadoc)
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
		final JsonResponse other = ( JsonResponse ) obj;
		if ( this.result == null )
		{
			if ( other.result != null )
			{
				return false;
			}
		}
		else if ( !this.result.equals( other.result ) )
		{
			return false;
		}
		if ( this.status == null )
		{
			if ( other.status != null )
			{
				return false;
			}
		}
		else if ( !this.status.equals( other.status ) )
		{
			return false;
		}
		return true;
	}

}

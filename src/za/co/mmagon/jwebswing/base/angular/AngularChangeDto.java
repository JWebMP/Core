package za.co.mmagon.jwebswing.base.angular;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.logger.LogFactory;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The angular change dto to apply
 *
 * @param <J>
 */
public class AngularChangeDto<J extends AngularChangeDto<J>> extends JavaScriptPart<J>
{

	private static final long serialVersionUID = 1L;
	private static Logger log = LogFactory.getLog("AngularChangeDto");
	@JsonProperty("old")
	private String oldProperty;
	@JsonProperty("new")
	private String newValue;

	/**
	 * Constructs a new angular change dto
	 */
	public AngularChangeDto()
	{
		//No config needed
	}

	/**
	 * The old and new property
	 *
	 * @param oldProperty
	 * @param newValue
	 */
	public AngularChangeDto(String oldProperty, String newValue)
	{
		this.oldProperty = oldProperty;
		this.newValue = newValue;
	}

	/**
	 * Returns the old value
	 *
	 * @return
	 */
	@Nullable
	public String getOldProperty()
	{
		return oldProperty;
	}

	/**
	 * Sets the new value
	 *
	 * @param oldProperty
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setOldProperty(String oldProperty)
	{
		this.oldProperty = oldProperty;
		return (J) this;
	}

	/**
	 * Returns the new value
	 *
	 * @return
	 */
	public String getNewValue()
	{
		return newValue;
	}

	/**
	 * Returns the new value
	 *
	 * @param newValue
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	public J setNewValue(String newValue)
	{
		this.newValue = newValue;
		return (J) this;
	}

	/**
	 * Returns the new value as the given object type
	 *
	 * @param type
	 * @param <T>
	 *
	 * @return
	 */
	public <T> Optional<T> asType(Class<T> type)
	{
		try
		{
			return Optional.ofNullable(GuiceContext.getInstance(ObjectMapper.class)
					                           .readValue(newValue.getBytes(), type));
		}
		catch (IOException e)
		{
			log.log(Level.SEVERE, "Unable to get angular change dto from value", e);
		}
		return Optional.empty();
	}
}

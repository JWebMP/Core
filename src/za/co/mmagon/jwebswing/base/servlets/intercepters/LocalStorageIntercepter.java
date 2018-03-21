package za.co.mmagon.jwebswing.base.servlets.intercepters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.servlet.RequestScoped;
import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.servlets.SessionStorageProperties;
import za.co.mmagon.jwebswing.interception.AjaxCallIntercepter;
import za.co.mmagon.jwebswing.interception.DataCallIntercepter;
import za.co.mmagon.logger.LogFactory;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.LOCAL_STORAGE_PARAMETER_KEY;
import static za.co.mmagon.jwebswing.utilities.StaticStrings.LOCAL_STORAGE_VARIABLE_KEY;

@SuppressWarnings("unused")
@RequestScoped
public class LocalStorageIntercepter
		implements DataCallIntercepter, AjaxCallIntercepter
{
	private static final Logger log = LogFactory.getLog("LocalStorageIntercepter");

	@Override
	public void intercept()
	{
		try
		{
			AjaxCall<?> call = GuiceContext.getInstance(AjaxCall.class);

			SessionStorageProperties<?> storageProperties = GuiceContext.getInstance(SessionStorageProperties.class);
			Map<String, String> localStorage = storageProperties.getLocalStorage();
			if (call.getVariable(LOCAL_STORAGE_VARIABLE_KEY) != null && !localStorage.containsKey(LOCAL_STORAGE_PARAMETER_KEY))
			{
				ObjectMapper mapper = GuiceContext.getInstance(ObjectMapper.class);
				log.finer("Local Storage key found");
				Map<String, String> result = mapper.readValue(call.getVariable(LOCAL_STORAGE_VARIABLE_KEY)
				                                                  .getVariableText(), new TypeReference<Map<String, String>>() {});
				localStorage.put(LOCAL_STORAGE_PARAMETER_KEY, result.get(LOCAL_STORAGE_PARAMETER_KEY));
			}
		}
		catch (Exception e)
		{
			log.log(Level.WARNING, "Unable to check for local storage key", e);
		}
	}

	@Override
	public Integer sortOrder()
	{
		return -50;
	}
}

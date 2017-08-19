package za.co.mmagon;

import com.google.inject.Singleton;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.servlets.JWebSwingServlet;

@Singleton
public class HelloWorldBasic extends JWebSwingServlet
{

	private static final long serialVersionUID = 1L;

	/**
	 * The page to be displayed.
	 *
	 * @return
	 */
	@Override
	public Page getPage()
	{
		Page p = new Page();
		p.getBody().add("Hello World");
		return p;
	}

	/**
	 * Relative path to context
	 *
	 * @return
	 */
	@Override
	public String getUrl()
	{
		return "/";
	}
}

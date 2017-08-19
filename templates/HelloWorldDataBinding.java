package za.co.mmagon;

import com.google.inject.Singleton;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponseReaction;
import za.co.mmagon.jwebswing.base.html.InputTextType;
import za.co.mmagon.jwebswing.base.html.Paragraph;
import za.co.mmagon.jwebswing.base.servlets.JWebSwingServlet;
import za.co.mmagon.jwebswing.events.blur.BlurAdapter;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
public class HelloWorldDataBinding extends JWebSwingServlet
{

	private static final long serialVersionUID = 1L;

	private static final String VARIABLE_NAME = "hWorld";

	/**
	 * The page to be displayed.
	 *
	 * @return
	 */
	@Override
	public Page getPage()
	{
		Page p = new Page();
		//Display any bound objects inside a simple paragraph
		Paragraph para = new Paragraph("Hello World ");
		para.addDto(VARIABLE_NAME, new HelloWorldDto()); //The DTO Object that is associated.
		para.bind(VARIABLE_NAME + ".helloWorldText"); //Variable name is bound as the DTO Name

		//Bind the input to the same variable (it will appear in the above paragraph)
		InputTextType input = new InputTextType();
		input.addAttribute("placeholder", "Type in here"); //Can also use .setPlaceholder
		input.bind(VARIABLE_NAME + ".helloWorldText"); //Bind for input capability

		//Add an event that will transport the bound data
		input.addEvent(new BlurAdapter(input)
		{
			@Override
			public void onBlur(AjaxCall call, AjaxResponse response)
			{
				try
				{
					//Retrieve the object variable from the call
					HelloWorldDto dtoIn = call.getVariable(VARIABLE_NAME).getDto(HelloWorldDto.class);
					//Add a basic message to show the server did receive the text
					response.addReaction(new AjaxResponseReaction("Text Received : " + dtoIn.getHelloWorldText()));

					//Change the text so we can see the dto going back to the server with whatever we give it
					dtoIn.setHelloWorldText("This is replacing the text come in with something else on the way out");
					//Send the dto on the next response out
					response.addDto(VARIABLE_NAME, dtoIn);
				}
				catch (IOException ex)
				{
					Logger.getLogger(HelloWorldDataBinding.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}.registerReturnVariableName(VARIABLE_NAME)); //Tell server to bring the variable back with the event

		p.getBody().add(para);
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

	class HelloWorldDto extends JavaScriptPart
	{

		private String helloWorldText = "Hello World DTO";

		public String getHelloWorldText()
		{
			return helloWorldText;
		}

		public void setHelloWorldText(String helloWorldText)
		{
			this.helloWorldText = helloWorldText;
		}
	}
}

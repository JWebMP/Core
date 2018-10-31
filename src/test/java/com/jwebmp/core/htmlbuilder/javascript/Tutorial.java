package com.jwebmp.core.htmlbuilder.javascript;

public class Tutorial
		extends JavaScriptPart<Tutorial>
{

	private Long id;

	private String title;

	private String language;

	public Tutorial(Long id, String title, String language)
	{
		this.id = id;
		this.title = title;
		this.language = language;
	}

	public String getUsedLanguage()
	{
		return language;
	}

	public Long getId()
	{
		return id;
	}

	public Tutorial setId(Long id)
	{
		this.id = id;
		return this;
	}

	public String getTitle()
	{
		return title;
	}

	public Tutorial setTitle(String title)
	{
		this.title = title;
		return this;
	}

	public String getLanguage()
	{
		return language;
	}

	public Tutorial setLanguage(String language)
	{
		this.language = language;
		return this;
	}
}

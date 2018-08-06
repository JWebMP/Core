package com.jwebmp.core.base.references;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavascriptReferenceTest
{

	@Test
	void setDefer()
	{
		JavascriptReference jr = new JavascriptReference("Name",1.0,"LocalReference/LocalRef.js");
		System.out.println(jr);
	}

	@Test
	void setAsync()
	{
	}

	@Test
	void getAdditionalOptions()
	{
	}
}

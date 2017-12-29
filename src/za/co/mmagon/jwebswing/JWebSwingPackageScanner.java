package za.co.mmagon.jwebswing;

import za.co.mmagon.guiceinjection.scanners.PackageContentsScanner;

import java.util.HashSet;
import java.util.Set;

public class JWebSwingPackageScanner implements PackageContentsScanner
{
	@Override
	public Set<String> searchFor()
	{
		Set<String> set = new HashSet<>();
		set.add("za.co.mmagon.jwebswing");
		return set;
	}
}

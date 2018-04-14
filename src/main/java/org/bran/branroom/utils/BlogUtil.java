package org.bran.branroom.utils;

public class BlogUtil {

	public static String removeTag(String source){
		String target=null;
		target=source.replaceAll(" ", "")
				.replaceAll("#", "")
				.replaceAll("\\*", "");
		
		return target;
	}
	
	public static String limitSize(String source,int size){
		String target=null;
		if(size>=source.length()){
			return source;
		}
		target=source.substring(0, size);
		return target;
	}
}

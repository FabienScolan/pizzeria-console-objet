package fr.pizzeria.utils;

import java.lang.reflect.Field;

public class StringUtils {

	public static String generateString(Object o){
		
		Class<?> c1 = o.getClass(); 
		Field[] attributes = c1.getDeclaredFields();
		String chaine = "";
		try {
			for (Field attr: attributes){
				attr.setAccessible(true);
				if (attr.isAnnotationPresent(ToString.class)){
					ToString annotation = attr.getAnnotation(ToString.class);
					boolean upperCase = annotation.toUpperCase();
					String separ = annotation.separateur();
					Object attrValue = attr.get(o);
					if (upperCase) attrValue = attrValue.toString().toUpperCase();
					chaine+= attrValue + separ;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return chaine;
		
	}
}

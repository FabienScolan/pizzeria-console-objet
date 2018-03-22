package fr.pizzeria.validator;

import java.lang.reflect.Field;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.utils.ToString;

public class Validator {

	public static void Check(Object o){
		Class<?> c1 = o.getClass(); 
		Field[] attributes = c1.getDeclaredFields();
		try {
			for (Field attr: attributes){
				attr.setAccessible(true);
				if (attr.isAnnotationPresent(ToString.class)){
					Rule annotation = attr.getAnnotation(Rule.class);
					Object attrValue = attr.get(o);
					if (attrValue instanceof Double){
						Double dbl=((Double) o);
						if (dbl<annotation.min()) throw new StockageException("Impossible de mettre un prix inférieur à 0€");
					}
				}
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}

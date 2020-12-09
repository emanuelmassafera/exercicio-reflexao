package br.inatel.cdg.annotation.reading;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//Nessa classe você deverá implementar a sua solução
//Adicionalmente você também deverá criar
//a anotação NumberToSum como parte da solução

public class AnnotationReader<T> {
	
	private Class<?> clazz; 
	private int sum;

	public AnnotationReader(Class<?> clazz) {
		this.clazz = clazz;
		this.sum = 0;
	}

	public void readAnnotations() {
		for (Field field : clazz.getDeclaredFields()) {
			if(field.isAnnotationPresent(NumberToSum.class)) {
				try {
					this.sum += field.getAnnotation(NumberToSum.class).number();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		for (Method method : clazz.getDeclaredMethods()) {
			if(method.isAnnotationPresent(NumberToSum.class)) {
				try {
					this.sum += method.getAnnotation(NumberToSum.class).number();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getTotalSum() {
		return this.sum;
	}
}

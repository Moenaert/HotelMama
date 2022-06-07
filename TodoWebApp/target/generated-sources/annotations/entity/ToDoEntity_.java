package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ToDoEntity.class)
public abstract class ToDoEntity_ {

	public static volatile SingularAttribute<ToDoEntity, String> description;
	public static volatile SingularAttribute<ToDoEntity, Integer> toDoId;

	public static final String DESCRIPTION = "description";
	public static final String TO_DO_ID = "toDoId";

}


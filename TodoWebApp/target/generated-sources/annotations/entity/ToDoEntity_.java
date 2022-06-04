package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ToDoEntity.class)
public abstract class ToDoEntity_ {

	public static volatile CollectionAttribute<ToDoEntity, MtMJoinTableEntity> mtMJoinTablesById;
	public static volatile SingularAttribute<ToDoEntity, String> description;
	public static volatile SingularAttribute<ToDoEntity, Integer> id;

	public static final String MT_MJOIN_TABLES_BY_ID = "mtMJoinTablesById";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}


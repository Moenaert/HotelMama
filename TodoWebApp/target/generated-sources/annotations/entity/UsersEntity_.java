package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UsersEntity.class)
public abstract class UsersEntity_ {

	public static volatile SingularAttribute<UsersEntity, String> name;
	public static volatile SingularAttribute<UsersEntity, Integer> id;
	public static volatile SingularAttribute<UsersEntity, Integer> supervisorId;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String SUPERVISOR_ID = "supervisorId";

}

